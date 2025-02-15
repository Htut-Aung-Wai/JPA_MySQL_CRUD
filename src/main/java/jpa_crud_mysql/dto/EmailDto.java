package jpa_crud_mysql.dto;

import lombok.Data;

@Data
public class EmailDto {

    private String subject;
    private String toMail;
    private String content;
    private String password;

}
