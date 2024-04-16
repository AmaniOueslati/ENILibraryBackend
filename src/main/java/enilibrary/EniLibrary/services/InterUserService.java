package enilibrary.EniLibrary.services;


import enilibrary.EniLibrary.entities.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface InterUserService {

    public User addUser(User user);

    public List<User> addListUser(List<User> listuser );


    public User updateUser(User user, Long iduser);

    public String deleteuser(Long iduser);

    public List<User> getAllUsers();

    public List<User> getListUsersStartWSC(String ch);

    public User findByUsername(String username);

    public User adduserRole(Long iduser, Long idrole);

    public List<Long> listiduserfromidrole();

    public List<Long> listiduserfromidrole(Long idrole);

    public List<User> listuserfromidrole(Long idrole);



}
