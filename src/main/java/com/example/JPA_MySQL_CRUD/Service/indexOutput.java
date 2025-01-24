package com.example.JPA_MySQL_CRUD.Service;


import com.example.JPA_MySQL_CRUD.Entity.Create;
import com.example.JPA_MySQL_CRUD.Repository.JPA_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class indexOutput {


    private final JPA_interface jpaInterface;

    @Autowired
    public indexOutput(JPA_interface jpaInterface) {
        this.jpaInterface = jpaInterface;
    }

    public void indexSave(Create create)
    {
        jpaInterface.save(create);
    }

    public Create get(String id) {
        return jpaInterface.findById(id).orElse(null);
    }











}
