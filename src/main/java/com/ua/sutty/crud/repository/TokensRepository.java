package com.ua.sutty.crud.repository;

import com.ua.sutty.crud.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokensRepository extends JpaRepository<Token, Long> {

    Optional<Token> findOneByValue(String value);

}
