package com.ua.sutty.crud.service;

import com.ua.sutty.crud.form.UserForm;
import com.ua.sutty.crud.model.User;

import java.util.List;

public interface UsersService {

    void signUp(UserForm userForm);

    List<User> findAll();

    User findOne(Long userId);
}
