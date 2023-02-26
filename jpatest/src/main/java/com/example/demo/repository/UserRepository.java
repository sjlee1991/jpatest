package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findFirst2ByUsernameLikeOrderByIDDesc(String name);
}
