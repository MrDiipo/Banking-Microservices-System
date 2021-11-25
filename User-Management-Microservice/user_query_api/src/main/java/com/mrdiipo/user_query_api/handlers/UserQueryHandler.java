package com.mrdiipo.user_query_api.handlers;

import com.mrdiipo.user_query_api.dto.UserLookUpResponse;
import com.mrdiipo.user_query_api.queries.FindAllUsersQuery;
import com.mrdiipo.user_query_api.queries.FindUserByIdQuery;
import com.mrdiipo.user_query_api.queries.SearchUsersQuery;

public interface UserQueryHandler {
    UserLookUpResponse getUserById(FindUserByIdQuery query);
    UserLookUpResponse searchUsers(SearchUsersQuery query);
    UserLookUpResponse getAllUsers(FindAllUsersQuery query);
}
