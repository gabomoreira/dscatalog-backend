package com.gabosm.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabosm.dscatalog.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
