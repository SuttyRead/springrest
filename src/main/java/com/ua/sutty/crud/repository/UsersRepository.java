package com.ua.sutty.crud.repository;

import com.ua.sutty.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 18.04.2018
 * UsersRepository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Transactional
public interface UsersRepository extends JpaRepository<User, Long> {
    User getUserById(Long id);
    Optional<User> findOneByLogin(String login);

}
