package jpa_crud_mysql.restcontroller;


import jpa_crud_mysql.Response.Response;
import jpa_crud_mysql.dto.EmailDto;
import jpa_crud_mysql.mailservice.SendMaiWithSchedule;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailSendController {

    private final SendMaiWithSchedule sendMaiWithSchedule;

    public MailSendController(SendMaiWithSchedule sendMaiWithSchedule) {
        this.sendMaiWithSchedule = sendMaiWithSchedule;
    }

    @PostMapping
    public Response sendMail(@RequestBody EmailDto emailDto)
    {
        return sendMaiWithSchedule.sendMail(emailDto);
    }
}
