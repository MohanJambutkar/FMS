package com.example.FMS.services;

import com.example.FMS.dto.users.Address;
import com.example.FMS.dto.users.User;
import com.example.FMS.exceptions.CustomExceptions;
import com.example.FMS.models.UserAddressModel;
import com.example.FMS.models.UserModel;
import com.example.FMS.repository.UserAddressRepository;
import com.example.FMS.repository.UserRepository;
import com.example.FMS.services.interFace.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class UserServices implements IUserServices {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserAddressRepository userAddressRepository;
    @Override
    public long createUser(UserModel userModel) {
        try {
            User user = new User();
            user.setUserName(userModel.getName());
            user.setUserPassword(userModel.getPassword());
            user.setUserEmail(userModel.getUserEmail());
            user.setUserAge(userModel.getUserAge());
            user.setUserPhone(userModel.getUserPhone());
            user.setCreatedAt(new Date());
            return userRepository.save(user).getUserId();
        }
        catch (Exception e)
        {
            throw new CustomExceptions("Error Storing User Data");
        }
    }

    @Override
    public long createUserAddress(UserAddressModel userAddressModel) {
        try {
            Address address = new Address();
            address.setLandmark(userAddressModel.getLandmark());
            address.setLine(userAddressModel.getLandmark());
            address.setCity(userAddressModel.getCity());
            address.setState(userAddressModel.getState());
            address.setPincode(userAddressModel.getPincode());
            address.setCreatedAt(new Date());
            return userAddressRepository.save(address).getAddressId();
        }
        catch (Exception e)
        {
            throw new CustomExceptions("Error Storing User Data");
        }
    }

    @Override
    public long updateUser(UserModel userModel, long userId) {
        try {
            User user = new User();
            user.setUserId(userId);
            user.setUserName(userModel.getName());
            user.setUserPassword(userModel.getPassword());
            user.setUserEmail(userModel.getUserEmail());
            user.setUserAge(userModel.getUserAge());
            user.setUserPhone(userModel.getUserPhone());
            user.setModifiedAt(new Date());
            return userRepository.save(user).getUserId();
        }
        catch (Exception e)
        {
            throw new CustomExceptions("Error Updating User Data");
        }
    }

    @Override
    public long updateUserAddress(UserAddressModel userAddressModel, long addressId) {
        try {
            Address address = new Address();
           address.setAddressId(addressId);
            address.setLandmark(userAddressModel.getLandmark());
            address.setLine(userAddressModel.getLandmark());
            address.setCity(userAddressModel.getCity());
            address.setState(userAddressModel.getState());
            address.setPincode(userAddressModel.getPincode());
            address.setCreatedAt(new Date());
            return userAddressRepository.save(address).getAddressId();
        }
        catch (Exception e)
        {
            throw new CustomExceptions("Error Up  dating User Data");
        }
    }

    @Override
    public long removeUser(UserModel userModel, long userId) {
        userRepository.deleteById(userId);
        return userId;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public List<User> getUsersByCity(String city) {
        return userRepository.getUserByCity(city);
    }

    @Override
    public User getUsersById(long userId) {
        return userRepository.findById(userId).orElseThrow(()->new CustomExceptions("User Data Not Found"));
    }

    @Override
    public List<UserAddressModel> getUserAddressById(long userId) {
        return (List<UserAddressModel>) userAddressRepository.findById(userId).orElseThrow(()-> new CustomExceptions("User Data Not Found"));
    }

    @Override
    public Optional<User> signIn(String name, String pass) {
        return Optional.ofNullable(userRepository.findByUserNameAndUserPassword(name, pass).orElseThrow(() -> new CustomExceptions("User Not Found")));
    }

}
