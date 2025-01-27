package jpa_crud_mysql.restcontroller;


import jpa_crud_mysql.entity.User;
import jpa_crud_mysql.service.OutputViewerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/index")
public class OutputViewer {

    private final OutputViewerService io;


    public OutputViewer(OutputViewerService io) {


        this.io = io;
    }

    @PostMapping
    public void indexSave(@RequestBody User user) {

        io.indexSave(user);
    }

    @GetMapping()
    public List<User> indexOutput() {
        return io.get();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return io.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return io.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        io.deleteUser(id);
    }
}
