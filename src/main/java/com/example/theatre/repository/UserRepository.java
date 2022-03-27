package com.example.theatre.repository;

import com.example.theatre.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/*
 * @author Shicheng Fang
 *
 * JPA Repository for the User entity.
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}