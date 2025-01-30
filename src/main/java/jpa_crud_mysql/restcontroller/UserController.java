package jpa_crud_mysql.restcontroller;


import jpa_crud_mysql.Response.Response;
import jpa_crud_mysql.dto.CreateUser;
import jpa_crud_mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/index")
public class UserController {

    private final UserService userService;
    private final CreateUser createUser;
    private Response response;

    //for i18n test
    @Autowired
    private MessageSource messageSource;


    public UserController(UserService io, CreateUser createUser) {


        this.userService = io;
        this.createUser = createUser;
    }

    //This is the CRUD operation.
    //save user
    @PostMapping
    public Response indexSave(@RequestBody CreateUser user) {

        userService.indexSave(user);
        return new Response("Success", null);

    }

    //get all user
    @GetMapping()
    public Response indexOutput() {
        return userService.get();
    }

    //Find user with id
    @GetMapping("/{id}")
    public Response getUserById(@PathVariable Long id) {
        return new Response("Success", userService.getUserById(id));
    }

    //Update
    @PutMapping("/{id}")
    public Response updateUser(@PathVariable Long id, @RequestBody CreateUser userDetails) {
        return new Response("Success", userService.updateUser(id, userDetails));
    }

    //Delete
    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable Long id) {
        return new Response("Success", null);

    }

    //The rest are usage of Derived Method and Query Method using JPA.
    //byName
    @GetMapping("/name/{name}")
    public Response getUsersByEmail(@PathVariable String name) {
        return userService.findByName(name);

    }

    //byNameAndAge
    @GetMapping("/name/{name}/age/{age}")
    public Response getUsersByNameAndAge(@PathVariable String name, @PathVariable int age) {
        return userService.getUsersByNameAndAge(name, age);
    }

    //Custom Sql Query
    //byName
    @GetMapping("/native/{name}")
    public Response getUsersByNameNativeQuery(@PathVariable String name) {
        return userService.findUsersByNameNative(name);
    }

    //byNameAndAge
    @GetMapping("/native/{name}/{age}")
    public Response getUsersByNameAndAgeNativeQuery(@PathVariable String name, @PathVariable int age) {
        return userService.findUsersByNameAndAgeNative(name, age);
    }

    //For i18n test
    @GetMapping("/greet")
    public String greet(@RequestParam(value = "lang", defaultValue = "en") String lang) {
        Locale locale = new Locale(lang);  // Get locale based on the lang parameter
        String greeting = messageSource.getMessage("greeting", null, locale);
        String welcome = messageSource.getMessage("welcome", null, locale);
        return greeting + "! " + welcome;
    }

}