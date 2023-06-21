package com.project.bloodbankmanagememnt.controller;

import com.project.bloodbankmanagememnt.exception.UserNotFoundException;
import com.project.bloodbankmanagememnt.model.User;
import com.project.bloodbankmanagememnt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000/")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/adduser")
    User newuser(@RequestBody User newUser) {

        return userRepository.save(newUser);
    }

    @GetMapping("/getUsers")
    List<User> getUser() {
        return userRepository.findAll();
    }

    @PutMapping("/update/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setAge(newUser.getAge());
            user.setGender(newUser.getGender());
            user.setBloodgroup(newUser.getBloodgroup());
            user.setQuantity(newUser.getQuantity());
            user.setContact_no(newUser.getContact_no());
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id));
    }


    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id" + id + "has been deleted.";
    }


    @GetMapping("/finduser/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id)

                .orElseThrow(()->new UserNotFoundException(id));
    }
    @GetMapping("/findbloodgroup/{bloodgroup}")
    User getUserByBloodgroup(@PathVariable String bloodgroup){
        return (User) userRepository.findByBloodgroup(bloodgroup)

                .orElseThrow(()->new UserNotFoundException(bloodgroup));
    }
}