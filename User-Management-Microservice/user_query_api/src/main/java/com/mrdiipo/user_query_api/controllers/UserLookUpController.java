package com.mrdiipo.user_query_api.controllers;

import com.mrdiipo.user_query_api.dto.UserLookUpResponse;
import com.mrdiipo.user_query_api.queries.FindAllUsersQuery;
import com.mrdiipo.user_query_api.queries.FindUserByIdQuery;
import com.mrdiipo.user_query_api.queries.SearchUsersQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("DuplicatedCode")
@RestController
@RequestMapping(path = "/api/v1/userLookup")
public class UserLookUpController {

    private final QueryGateway queryGateway;

    @Autowired
    public UserLookUpController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(path = "/")
    @PreAuthorize("hasAuthority('READ_PRIVILEDGE')")
    public ResponseEntity<UserLookUpResponse> getAllUsers(){
     try{

         var query = new FindAllUsersQuery();
         var response = queryGateway.query(query, ResponseTypes.instanceOf(UserLookUpResponse.class)).join();

         if (response == null || response.getUsers() == null){
             return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
         }

         return new ResponseEntity<>(response, HttpStatus.OK);
     } catch (Exception e){
         var safeErrorMessage = "Failed to complete get all users request";
         System.out.println(e.getMessage());
         return new ResponseEntity<>(new UserLookUpResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
     }
    }

    @GetMapping(path = "/byId/{id}")
    @PreAuthorize("hasAuthority('READ_PRIVILEDGE')")
    public ResponseEntity<UserLookUpResponse> getUserById(@PathVariable("id") String id){
        try{

            var query = new FindUserByIdQuery(id);
            var response = queryGateway.query(query, ResponseTypes.instanceOf(UserLookUpResponse.class)).join();

            if (response == null || response.getUsers() == null){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            var safeErrorMessage = "Failed to complete get user ID request";
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new UserLookUpResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/byFilter/{filter}")
    @PreAuthorize("hasAuthority('READ_PRIVILEDGE')")
    public ResponseEntity<UserLookUpResponse> getUserByFilter(@PathVariable("filter") String filter){
        try{

            var query = new SearchUsersQuery(filter);
            var response = queryGateway.query(query, ResponseTypes.instanceOf(UserLookUpResponse.class)).join();

            if (response == null || response.getUsers() == null){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            var safeErrorMessage = "Failed to complete your search request";
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new UserLookUpResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
