package com.example.FMS.repository;

import com.example.FMS.dto.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u")
    List<User>  getAllUsers();

    Optional<User> findByUserNameAndUserPassword(String name, String password);

    @Query(value = "SELECT u.* FROM users u, address ua where ua.city=?1 and ua.user_id=u.id", nativeQuery = true)
     List<User>  getUserByCity(String city);
}
