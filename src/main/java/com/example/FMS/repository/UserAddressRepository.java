package com.example.FMS.repository;

import com.example.FMS.dto.users.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRepository extends JpaRepository<Address,Long> {

}
