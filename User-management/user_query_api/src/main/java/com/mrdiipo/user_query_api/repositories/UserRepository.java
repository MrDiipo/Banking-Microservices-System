package com.mrdiipo.user_query_api.repositories;

import com.mrdiipo.user_core.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
