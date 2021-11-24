package com.mrdiipo.user_query_api.repositories;

import com.mrdiipo.user_core.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{'$or' : [{'firstname' : {$regex :?0, $options: '1'}}, {'lastname' : {$regex :?0, $options: '1'}}, {'emailAddress' : {$regex :?0, $options: '1'}}, {'account.username' : {$regex :?0, $options: '1'}]}")
    List<User> findByFilterRegex(String filter);
}
