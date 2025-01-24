package com.example.JPA_MySQL_CRUD.Service;


import com.example.JPA_MySQL_CRUD.Entity.User;
import com.example.JPA_MySQL_CRUD.Repository.JPA_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class indexOutput {


    private final JPA_interface jpaInterface;

    @Autowired
    public indexOutput(JPA_interface jpaInterface) {
        this.jpaInterface = jpaInterface;
    }

    public User indexSave(User user)
    {
        return jpaInterface.save(user);
    }

    public List<User> get()
    {
        return jpaInterface.findAll();
    }











}
