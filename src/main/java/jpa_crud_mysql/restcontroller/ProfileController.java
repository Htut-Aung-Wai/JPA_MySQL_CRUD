package jpa_crud_mysql.restcontroller;

import jpa_crud_mysql.profile_test.DevService;
import jpa_crud_mysql.profile_test.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProfileController {

    private final DevService devService;
    private final ProdService prodService;

    @Autowired
    public ProfileController(DevService devService, ProdService prodService) {
        this.devService = devService;
        this.prodService = prodService;
    }

    @GetMapping("/service-info")
    public String getServiceInfo() {
        // Depending on the active profile, this will return the service info
        if (devService != null) {
            return devService.getServiceInfo();  // If dev profile is active
        } else if (prodService != null) {
            return prodService.getServiceInfo();  // If prod profile is active
        } else {
            return "No active profile!";
        }
    }
}
