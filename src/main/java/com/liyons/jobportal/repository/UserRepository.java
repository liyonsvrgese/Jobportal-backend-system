package com.liyons.jobportal.repository;

import com.liyons.jobportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //Can add custom queries here if needed
}
