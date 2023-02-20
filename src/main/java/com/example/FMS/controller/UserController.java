package com.example.FMS.controller;

import com.example.FMS.models.CredentialModel;
import com.example.FMS.models.ResponseModel;
import com.example.FMS.models.UserModel;
import com.example.FMS.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServices userServices;

    @PostMapping("/create")
    public ResponseModel createUsers(@Valid @RequestBody UserModel userModel){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(userServices.createUser(userModel));
        res.message="User Data Found";
        res.responseCode= HttpStatus.CREATED.value();
        return res;
    }
    @PostMapping("/SignIn")
    public ResponseModel SignIn(@Valid @RequestBody CredentialModel credentialModel){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(userServices.signIn(credentialModel.getName(), credentialModel.getPassword()));
        res.message="User Credential Found";
        res.responseCode=HttpStatus.FOUND.value();
        return res;
    }
    @PutMapping("/UpdateUser/{userId}")
    public ResponseModel updateUser(@Valid @RequestBody UserModel userModel,@PathVariable long userId){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(userServices.updateUser(userModel, userId));
        res.message="User Updated";
        res.responseCode=HttpStatus.CREATED.value();
        return res;
    }
   @GetMapping("/getUsers")
    public ResponseModel getAllUsers(){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(userServices.getAllUsers());
        res.message="Data Found";
        res.responseCode=HttpStatus.FOUND.value();
        return res;
   }
   @GetMapping("/getByCity/{City}")
    public  ResponseModel getUserByCity(@PathVariable String city){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(userServices.getUsersByCity(city));
        res.message= "User Data Found";
        res.responseCode=HttpStatus.FOUND.value();
        return res;
   }
}
