package com.example.models.data;

import com.example.models.User;
import com.example.models.UserType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Brady on 4/18/17.
 */
@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
    User findByUsernameIgnoreCase(String username);


    List<User> findByuserType(UserType userType);
}
