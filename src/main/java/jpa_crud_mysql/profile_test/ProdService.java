package jpa_crud_mysql.profile_test;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdService {
    public String getServiceInfo() {
        return "Prod Service: Production environment is active!";
    }

}
