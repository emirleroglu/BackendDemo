package com.emirleroglu.backenddemo.services;

import com.emirleroglu.backenddemo.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class UserServiceImpl implements UserService {
    List<User> myList = new ArrayList<>();
    public List<User> getUserList () {
        return myList;


    }

    public void addUser (User user) {
        myList.add(user);
    }

}
