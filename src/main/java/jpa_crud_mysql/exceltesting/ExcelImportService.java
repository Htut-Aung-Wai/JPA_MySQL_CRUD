package jpa_crud_mysql.exceltesting;

import jakarta.transaction.Transactional;
import jpa_crud_mysql.Response.Response;
import jpa_crud_mysql.entity.ExcelImport;
import jpa_crud_mysql.repository.ExcelImportJpa;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelImportService {

    private final ExcelImportJpa excelImportJpa;

    public ExcelImportService(ExcelImportJpa excelImportJpa)
    {
        this.excelImportJpa = excelImportJpa;
    }

    @Transactional
    public Response importExcelData(MultipartFile file) throws IOException {
        try (InputStream is = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // skip header row

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if(row.getCell(0)==null) {
                    break;

                }
                    String name = row.getCell(0).getStringCellValue();
                    String content = row.getCell(1).getStringCellValue();
                    String description = row.getCell(2).getStringCellValue();
                    //int salary = (int) row.getCell(2).getNumericCellValue();


                    ExcelImport excel = new ExcelImport();
                    excel.setName(name);
                    excel.setContent(content);
                    excel.setDescription(description);

                    excelImportJpa.save(excel);


            }
            return new Response("success",null);
        }
        catch (Exception e)
        {
           // return new Response("failed of "+e.getMessage(),null);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    public Response exportExcel() throws IOException
    {
        try {
            List<ExcelImport> exportExcel=excelImportJpa.exportExcelJpa();
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("export");
            Iterator<Row> rowIterator = sheet.iterator();

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Name");
            headerRow.createCell(1).setCellValue("Content");
            headerRow.createCell(2).setCellValue("Description");


            int rowNum = 1;
            for(ExcelImport excelImport:exportExcel)
            {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(excelImport.getName());
                row.createCell(1).setCellValue(excelImport.getContent());
                row.createCell(2).setCellValue(excelImport.getDescription());
            }

            // Write the output to a ByteArrayOutputStream
            try (FileOutputStream fileOut = new FileOutputStream("//home//htut-aung-wai//Desktop//excel_test//exportExcelFile.xlsx")) {
                workbook.write(fileOut);
            } finally {
                workbook.close();
            }


            return new Response("success",null);

        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }

    }





}
