package com.emirleroglu.backenddemo.repository;

import com.emirleroglu.backenddemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {

}
