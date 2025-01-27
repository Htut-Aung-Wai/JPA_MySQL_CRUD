package jpa_crud_mysql.service;


import jpa_crud_mysql.entity.User;
import jpa_crud_mysql.repository.JPA_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OutputViewerService {

    @Autowired
    private final JPA_interface jpaInterface;

    public OutputViewerService(JPA_interface jpaInterface) {
        this.jpaInterface = jpaInterface;
    }

    //save
    public void indexSave(User user) {
        jpaInterface.save(user);
    }

    //getAll
    public List<User> get() {
        return jpaInterface.findAll();
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
    public void deleteUser(Long id) {
        jpaInterface.deleteById(id);
    }


}
