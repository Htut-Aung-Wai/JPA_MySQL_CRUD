package jpa_crud_mysql.repository;


import jpa_crud_mysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JPA_interface extends JpaRepository<User, Long> {

    boolean existsByName(String name);

    boolean existsByNameAndAge(String name, int age);

    List<User> findByName(String name);

    List<User> findByNameAndAge(String name, int age);

    // Custom query using @Query: Native SQL query for users by email
    @Query(value = "SELECT * FROM user WHERE name = :name", nativeQuery = true)
    List<User> findUsersByNameNative(@Param("name") String name);

    @Query(value = "SELECT * FROM user WHERE name = :name AND age=:age", nativeQuery = true)
    List<User> findUsersByNameAndAgeNative(@Param("name") String name, @Param("age") int age);


}
