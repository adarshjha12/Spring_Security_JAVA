package com.springDataJpa.learning.repositories;

import com.springDataJpa.learning.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
