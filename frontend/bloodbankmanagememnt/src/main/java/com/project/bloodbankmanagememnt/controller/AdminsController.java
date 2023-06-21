package com.project.bloodbankmanagememnt.controller;

import com.project.bloodbankmanagememnt.exception.UserNotFoundException;
import com.project.bloodbankmanagememnt.model.Admins;
import com.project.bloodbankmanagememnt.repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AdminsController {
    @Autowired
    public AdminsRepository adminsRepository;

    @PostMapping("/addadmin")
    Admins newadmins(@RequestBody Admins newAdmins) {

        return adminsRepository.save(newAdmins);
    }

    @GetMapping("/getadmins")
    List<Admins> getAdmins() {
        return adminsRepository.findAll();
    }

    @PutMapping("/Update/{username}")
    Admins updateAdmins(@RequestBody Admins newAdmins, @PathVariable String username){
        return adminsRepository.findByUsername(username).map(admins-> {
            admins.setPassword(newAdmins.getPassword());
            return adminsRepository.save(admins);
        }).orElseThrow(() -> new UserNotFoundException(username));
    }


    @DeleteMapping("/remove/{username}")
    String deleteadmins(@PathVariable String username) {
        if (!adminsRepository.existsByUsername(username)) {
            throw new UserNotFoundException(username);
        }
        adminsRepository.deleteById(username);
        return "Admin with username" + username + "has been deleted.";
}

}
