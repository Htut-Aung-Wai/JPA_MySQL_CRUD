package jpa_crud_mysql.profile_test;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevService {

    public String getServiceInfo() {
        return "Dev Service: Development environment is active!";
    }
}
