package com.emirleroglu.backenddemo.services;

import com.emirleroglu.backenddemo.models.User;
import com.emirleroglu.backenddemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserRepository myUserRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    List<User> myList = new ArrayList<>();

    public List<User> getUserList() {
        try {
            List<User> userList = new ArrayList<User>();

            myUserRepository.findAll().forEach(userList::add);


            return userList;
        } catch (Exception e) {
            return null;
        }


    }

    public User addUser(User user) {

        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            User tempUser = myUserRepository.save(user);
            return tempUser;


        } catch (Exception e) {
            return null;

        }


    }

    public User getUserById(Long id) {
        Optional<User> userData = myUserRepository.findById(id);
        if (userData.isPresent()) {
            return userData.get();
        } else {
            return null;
        }

    }

    public ResponseEntity<User> deleteUserById(Long id) {
        try {
            myUserRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }


   public void login (User user) {


   }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
