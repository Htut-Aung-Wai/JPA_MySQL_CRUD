package jpa_crud_mysql.service;


import jpa_crud_mysql.Response.Response;
import jpa_crud_mysql.dto.CreateUser;
import jpa_crud_mysql.entity.UserDatabaseConnect;
import jpa_crud_mysql.repository.JPA_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private final JPA_interface jpaInterface;
    private final CreateUser createUser;

    @Autowired
    private final MessageSource messageSource;
    private Response response;
    String success="";

    // Usage of local for i18n
    Locale locale = new Locale("my");


    public UserService(JPA_interface jpaInterface, CreateUser user,MessageSource messageSource) {
        this.jpaInterface = jpaInterface;
        this.createUser = user;
        this.messageSource=messageSource;
        success = messageSource.getMessage("success", null, locale);

    }





    //This is the CRUD operation.
    //save
    public void indexSave(CreateUser user) {
        UserDatabaseConnect userDatabaseConnect = new UserDatabaseConnect(user.getId(), user.getName(), user.getAge());

        jpaInterface.save(userDatabaseConnect);
    }

    //getAll
    public Response get() {

         // Usage of local for i18n
        //String success = messageSource.getMessage("success", null, locale);
        return new Response(success, jpaInterface.findAll());
    }

    public Optional<UserDatabaseConnect> getUserById(Long id) {

        if(jpaInterface.findById(id).isPresent())
            return jpaInterface.findById(id);
        else throw new IllegalArgumentException("Not found!!");
    }

    // Update
    public UserDatabaseConnect updateUser(Long id, CreateUser userDetails) {
        UserDatabaseConnect user = jpaInterface.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        return jpaInterface.save(user);
    }

    // Delete
    public Response deleteUser(Long id) {
        jpaInterface.deleteById(id);
        return new Response(success, null);
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
