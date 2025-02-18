package jpa_crud_mysql.restcontroller;

import jpa_crud_mysql.Response.Response;
import jpa_crud_mysql.exceltesting.ExcelImportService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/excel")
public class ExcelImportController {

    private final ExcelImportService excelImportService;

    public ExcelImportController(ExcelImportService excelImportService)
    {
        this.excelImportService = excelImportService;
    }

    @PostMapping
    public Response importExcel(@RequestParam MultipartFile file) throws IOException {
        return excelImportService.importExcelData(file);
    }

    @GetMapping
    public Response exportExcel() throws IOException {
        return excelImportService.exportExcel();
    }


}
