package com.mrdiipo.user_query_api.handlers;

import com.mrdiipo.user_query_api.dto.UserLookUpResponse;
import com.mrdiipo.user_query_api.queries.FindAllUsersQuery;
import com.mrdiipo.user_query_api.queries.FindUserByIdQuery;
import com.mrdiipo.user_query_api.queries.SearchUsersQuery;
import com.mrdiipo.user_query_api.repositories.UserRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQueryHandlerImpl implements UserQueryHandler{

    private final UserRepository userRepository;

    @Autowired
    public UserQueryHandlerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryHandler
    @Override
    public UserLookUpResponse getUserById(FindUserByIdQuery query) {
        return null;
    }

    @QueryHandler
    @Override
    public UserLookUpResponse searchUsers(SearchUsersQuery query) {
        return null;
    }

    @QueryHandler
    @Override
    public UserLookUpResponse getAllUsers(FindAllUsersQuery query) {
        return null;
    }
}
