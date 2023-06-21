package com.project.bloodbankmanagememnt.repository;

import com.project.bloodbankmanagememnt.model.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdminsRepository extends JpaRepository<Admins,String> {

    Optional<Admins> findByUsername(@Param("username") String username);


    boolean existsByUsername(String username);
}

