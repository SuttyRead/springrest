package com.ua.sutty.crud.service;

import com.ua.sutty.crud.form.LoginForm;
import com.ua.sutty.crud.transfer.TokenDTO;

public interface LoginService {

    TokenDTO login(LoginForm loginForm);

}
