package jpa_crud_mysql.service;


import jpa_crud_mysql.Response.Response;
import jpa_crud_mysql.entity.User;
import jpa_crud_mysql.repository.JPA_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class OutputViewerService {

    @Autowired
    private final JPA_interface jpaInterface;

    private Response response;

    public OutputViewerService(JPA_interface jpaInterface) {
        this.jpaInterface = jpaInterface;
    }

    //save
    public void indexSave(User user) {
        jpaInterface.save(user);
    }

    //getAll
    public Response get() {
        return new Response("Success", jpaInterface.findAll());
    }

    public Optional<User> getUserById(Long id) {
        return jpaInterface.findById(id);
    }

    // Update
    public User updateUser(Long id, User userDetails) {
        User user = jpaInterface.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        return jpaInterface.save(user);
    }

    // Delete
    public Response deleteUser(Long id) {
        jpaInterface.deleteById(id);
        return new Response("Success", null);
    }


    //The rest are usage of Dervied Method and Query Method using JPA.
    //byName
    public Response findByName(String name) {
        if (jpaInterface.existsByName(name))
            return new Response("Success", jpaInterface.findByName(name));
        else return new Response("Not Found!!", jpaInterface.findByName(name));
    }

    //byNameAndAge
    public Response getUsersByNameAndAge(String name, int age) {
        if (jpaInterface.existsByNameAndAge(name, age))
            return new Response("Success", jpaInterface.findByNameAndAge(name, age));
        else return new Response("Not Found!!", jpaInterface.findByNameAndAge(name, age));

    }

    //Custom Sql Query
    //byName
    public Response findUsersByNameNative(String name) {
        if (jpaInterface.existsByName(name))
            return new Response("Success", jpaInterface.findUsersByNameNative(name));
        else return new Response("Not Found!!", jpaInterface.findUsersByNameNative(name));

    }

    //byNameAndAge
    public Response findUsersByNameAndAgeNative(String name, int age) {
        if (jpaInterface.existsByNameAndAge(name, age))
            return new Response("Success", jpaInterface.findUsersByNameAndAgeNative(name, age));
        else return new Response("Not Found!!", jpaInterface.findUsersByNameAndAgeNative(name, age));

    }

}
