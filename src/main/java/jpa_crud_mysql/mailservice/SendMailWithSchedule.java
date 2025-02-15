package jpa_crud_mysql.mailservice;

import jakarta.mail.internet.MimeMessage;
import jpa_crud_mysql.Response.Response;
import jpa_crud_mysql.dto.EmailDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SendMailWithSchedule {

    @Value("${spring.mail.username}")
    private String senderMail;

    private final JavaMailSender javamailsender;



    public SendMailWithSchedule(JavaMailSender javamailsender) {
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

        @Scheduled(cron = "0 13 11 * * *")
        public Response sendMailWithSchedule ()
        {
            try

            {

                MimeMessage mimeMessage = javamailsender.createMimeMessage();
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
                mimeMessageHelper.setFrom("email@htutaungwai.info");
                mimeMessageHelper.setTo("htutaungwai000@gmail.com");
                mimeMessageHelper.setSubject("Hello this is schedule test");
                mimeMessageHelper.setText("Schedule test mail", false);
                javamailsender.send(mimeMessage);

                return new Response("Success", null);

            }
            catch(Exception e)
            {
                return new Response("Failed of "+e.getMessage(), null);
            }

        }






}
