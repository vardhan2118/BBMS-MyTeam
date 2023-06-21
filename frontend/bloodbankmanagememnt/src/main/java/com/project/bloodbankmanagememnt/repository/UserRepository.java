package com.project.bloodbankmanagememnt.repository;

import com.project.bloodbankmanagememnt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT u FROM User u WHERE u.bloodgroup = :bloodgroup")
    Optional<User> findUserByBloodgroup(@Param("bloodgroup") String bloodgroup);

    Optional<Object> findByBloodgroup(String bloodgroup);
}
