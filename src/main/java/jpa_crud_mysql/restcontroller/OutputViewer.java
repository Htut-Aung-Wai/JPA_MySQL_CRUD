package jpa_crud_mysql.restcontroller;


import jpa_crud_mysql.Response.Response;
import jpa_crud_mysql.entity.User;
import jpa_crud_mysql.service.OutputViewerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index")
public class OutputViewer {

    private final OutputViewerService io;

    private Response response;


    public OutputViewer(OutputViewerService io) {


        this.io = io;
    }

    //save user
    @PostMapping
    public Response indexSave(@RequestBody User user) {

        io.indexSave(user);
        return new Response("Success", null);

    }

    //get all user
    @GetMapping()
    public Response indexOutput() {
        return new Response("Success", io.get());
    }

    //Find user with id
    @GetMapping("/{id}")
    public Response getUserById(@PathVariable Long id) {
        return new Response("Success", io.getUserById(id));
    }

    //Update
    @PutMapping("/{id}")
    public Response updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return new Response("Success", io.updateUser(id, userDetails));
    }

    //Delete
    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable Long id) {
        return new Response("Success", null);

    }
}
