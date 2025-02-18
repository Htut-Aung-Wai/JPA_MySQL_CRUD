package jpa_crud_mysql.repository;

import jpa_crud_mysql.entity.ExcelImport;
import jpa_crud_mysql.entity.UserDatabaseConnect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcelImportJpa extends JpaRepository<ExcelImport, Long> {

    @Query(value = "SELECT * FROM excel", nativeQuery = true)
    List<ExcelImport> exportExcelJpa();
}
