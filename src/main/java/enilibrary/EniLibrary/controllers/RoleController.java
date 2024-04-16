package enilibrary.EniLibrary.controllers;

import enilibrary.EniLibrary.entities.Role;
import enilibrary.EniLibrary.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    RoleService roleserv ;
    @PostMapping("/addRole")
    public Role addRole(@RequestBody Role r)
    {
        return roleserv.addRole(r);
    }

}