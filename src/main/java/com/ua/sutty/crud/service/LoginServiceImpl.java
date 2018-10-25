package com.ua.sutty.crud.service;

import com.ua.sutty.crud.form.LoginForm;
import com.ua.sutty.crud.model.Token;
import com.ua.sutty.crud.model.User;
import com.ua.sutty.crud.repository.TokensRepository;
import com.ua.sutty.crud.repository.UsersRepository;
import com.ua.sutty.crud.transfer.TokenDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public TokenDTO login(LoginForm loginForm) {
        Optional<User> userCandidate = usersRepository.findOneByLogin(loginForm.getLogin());

        if (userCandidate.isPresent()){
            User user = userCandidate.get();

            if (passwordEncoder.matches(loginForm.getLogin(), user.getHashPassword())){
                Token token = Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();

                tokensRepository.save(token);
                return TokenDTO.from(token);
            }
        } throw new IllegalArgumentException("User not found");

    }
}
