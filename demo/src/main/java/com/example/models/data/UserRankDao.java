package com.example.models.data;

import com.example.models.UserRank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Brady on 4/24/17.
 */
@Repository
@Transactional
public interface UserRankDao extends CrudRepository<UserRank, Integer>{
}
