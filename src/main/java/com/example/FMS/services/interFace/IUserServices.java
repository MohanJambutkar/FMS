package com.example.FMS.services.interFace;

import com.example.FMS.dto.users.User;
import com.example.FMS.models.UserAddressModel;
import com.example.FMS.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface IUserServices {
    long createUser(UserModel userModel);
    long createUserAddress(UserAddressModel userAddressModel);
    long updateUser(UserModel userModel, long userId);
    long updateUserAddress(UserAddressModel userAddressModel, long addressId);

    long removeUser(UserModel userModel, long userId);
    List<User> getAllUsers();
    List<User> getUsersByCity(String city);
    User getUsersById(long userId);
    List<UserAddressModel> getUserAddressById(long userId);

    Optional<User> signIn(String name, String pass);
}
