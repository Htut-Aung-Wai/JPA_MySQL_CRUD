package com.example.JPA_MySQL_CRUD.Restcontroller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.JPA_MySQL_CRUD.Service.indexOutput;
import com.example.JPA_MySQL_CRUD.Entity.User;

import java.util.List;

@RestController
@RequestMapping("/index")
public class mappingOutput {
    private final indexOutput io;

    public mappingOutput(indexOutput io){


        this.io=io;
    }

    @PostMapping
    public User indexSave(User user)
    {

            return io.indexSave(user);
    }

    @GetMapping
    public List<User> indexoutput()
    {
        return io.get();
    }



}
