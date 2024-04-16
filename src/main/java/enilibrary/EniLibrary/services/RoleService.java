package enilibrary.EniLibrary.services;

import enilibrary.EniLibrary.entities.Role;
import enilibrary.EniLibrary.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService {

    @Autowired
    IRoleRepository roleRep;

    public Role addRole(Role r) {
        // TODO Auto-generated method stub
        return roleRep.save(r);
    }
}
