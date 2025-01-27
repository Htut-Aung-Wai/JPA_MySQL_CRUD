package jpa_crud_mysql.repository;


import jpa_crud_mysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JPA_interface extends JpaRepository<User, Long> {

}
