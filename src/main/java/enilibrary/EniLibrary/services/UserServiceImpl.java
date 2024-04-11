package enilibrary.EniLibrary.services;

import enilibrary.EniLibrary.entities.Filee;
import enilibrary.EniLibrary.entities.Role;
import enilibrary.EniLibrary.entities.User;
import enilibrary.EniLibrary.repositories.IRoleRepository;
import enilibrary.EniLibrary.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class UserServiceImpl implements InterUserService {

    @Autowired
    IUserRepository userRep;

    @Autowired
    IRoleRepository roleRep;

    @Autowired
    FileServiceImpl fileserv;

    @Override
    public User addUser(User user) {
        // TODO Auto-generated method stub
        return userRep.save(user);
    }

    @Override
    public List<User> addListUser(List<User> listuser) {
        // TODO Auto-generated method stub
        return userRep.saveAll(listuser);
    }


    @Override
    public User updateUser(User user, Long iduser) {
        // TODO Auto-generated method stub

        User usr= userRep.findById(iduser).get();

        usr.setFname(user.getFname());
        usr.setLname(user.getLname());

        return userRep.save(usr);
    }

    @Override
    public String deleteuser(Long iduser) {
        // TODO Auto-generated method stub

        String ch="";

        userRep.deleteById(iduser);
        ch="user successfuly deleted !!";
        return ch;
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return userRep.findAll();
    }

    @Override
    public List<User> getListUsersStartWSC(String ch) {
        // TODO Auto-generated method stub
        return userRep.getUsersStartWSC(ch);
    }

    @Override
    public User findByUsername(String username) {
        // TODO Auto-generated method stub
        return userRep.findByUsername(username);
    }

    @Override
    public User adduserRole(Long iduser, Long idrole) {
        // TODO Auto-generated method stub

        User user =userRep.findById(iduser).get();
        Role role = roleRep.findById(idrole).get();

        user.addRole(role);
        return userRep.save(user);
    }
    @Override
    public List<Long> listiduserfromidrole() {
        // TODO Auto-generated method stub
        return userRep.listiduserfromidrole();
    }

    @Override
    public List<Long> listiduserfromidrole(Long idrole) {
        // TODO Auto-generated method stub
        return userRep.listiduserfromidrole(idrole);
    }

    @Override
    public List<User> listuserfromidrole(Long idrole) {
        // TODO Auto-generated method stub
        return userRep.listuserfromidrole(idrole);
    }

    @Override
    public User addUserFile(Long iduser, MultipartFile file) throws IOException {
        // TODO Auto-generated method stub

        User user = userRep.findById(iduser).get();

        Filee f = fileserv.addfile(file);
        f.setUser(user);

        //user.setFile(f);

        return userRep.save(user);
    }


}
