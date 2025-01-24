package com.example.JPA_MySQL_CRUD.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private String Id;
    @Column
    private String name;


    public String getId(){
        return this.Id;
    }

    public void setId(String id){
        this.Id=id;
    }

    public String getName()
    {
        return this.name;

    }
    public void setName(String name)
    {
        this.name=name;
    }




}
