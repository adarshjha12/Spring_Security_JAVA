package com.springDataJpa.learning.controllers;


import com.springDataJpa.learning.DTO.CreateUserDto;
import com.springDataJpa.learning.DTO.UserDto;
import com.springDataJpa.learning.apiResponse.ApiResponse;
import com.springDataJpa.learning.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("hello")
    public ResponseEntity<ApiResponse<Void>> healthCheck (){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.of(200, "All Runnnig smooth", null)
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserDto>> createUser (@RequestBody CreateUserDto createUserDto) {
            UserDto user =  userService.createUser(createUserDto);

            return ResponseEntity.status(HttpStatus.CREATED).body(
                    ApiResponse.of(201, "User Created Successfully", user)
            );
    }

    @GetMapping("user/{id}")
    public ResponseEntity<ApiResponse<UserDto>> getUserById (@PathVariable Long id){

        UserDto user = userService.getUserByID(id);

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.of(200, "User Fetched Successfully", user));

    } @GetMapping("users/all")
    public ResponseEntity<ApiResponse<List<UserDto>>> getAllUsers (){

        List<UserDto> user = userService.getAllUsers();

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.of(200, "All Users Fetched Successfully", user));
    }



   @PutMapping("user/{id}")
   public ResponseEntity<ApiResponse<UserDto>> updateUser(@PathVariable Long id, @RequestBody CreateUserDto updateUSerDto){
       UserDto user = userService.updateUser(id, updateUSerDto);

       return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.of(200, "User Updated Successfully", user));

   }

   @DeleteMapping("user/{id}")
   public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id){
       userService.deleteUser(id);

       return ResponseEntity.ok(ApiResponse.of(200, "User Deleted Successfully", null));

   }
}
