package com.example.models.data;

import com.example.models.Server;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Brady on 4/18/17.
 */
@Repository
@Transactional
public interface ServerDao extends CrudRepository<Server, Integer>{
}
