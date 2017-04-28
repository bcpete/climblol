package com.example.models.data;

import com.example.models.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Brady on 4/18/17.
 */
@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
