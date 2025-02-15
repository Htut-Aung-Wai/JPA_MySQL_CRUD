package jpa_crud_mysql.mailservice;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jpa_crud_mysql.Response.Response;
import jpa_crud_mysql.dto.EmailDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendMaiWithSchedule {

    @Value("${spring.mail.username}")
    private String senderMail;

    private final JavaMailSender javamailsender;



    public SendMaiWithSchedule(JavaMailSender javamailsender) {
        this.javamailsender = javamailsender;
    }



        public Response sendMail (EmailDto emailDto)
        {
            try

            {

            MimeMessage mimeMessage = javamailsender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMessageHelper.setFrom("email@htutaungwai.info");
            mimeMessageHelper.setTo(emailDto.getToMail());
            mimeMessageHelper.setSubject(emailDto.getSubject());
            mimeMessageHelper.setText(emailDto.getContent(), false);
            javamailsender.send(mimeMessage);

            return new Response("Success", null);

            }
            catch(Exception e)
            {
                return new Response("Failed of "+e.getMessage(), null);
            }

    }






}
