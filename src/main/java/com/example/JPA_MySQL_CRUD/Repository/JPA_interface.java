package com.example.JPA_MySQL_CRUD.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.JPA_MySQL_CRUD.Entity.User;

@Repository
public interface JPA_interface extends JpaRepository<User,String>{


}
