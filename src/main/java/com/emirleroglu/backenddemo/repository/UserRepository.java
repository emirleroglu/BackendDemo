package com.emirleroglu.backenddemo.repository;

import com.emirleroglu.backenddemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


}
