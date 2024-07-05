package com.kl.jwt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kl.jwt.entities.UserRole;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

    List<UserRole> findByName(String name);
}
