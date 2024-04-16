package enilibrary.EniLibrary.controllers;

import java.io.IOException;
import java.util.List;

import enilibrary.EniLibrary.entities.User;
import enilibrary.EniLibrary.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController

public class UserController {

    @Autowired
    UserServiceImpl userServ;

    //@RequestMapping(method = RequestMethod.GET, value = "/test/{name}")

    @GetMapping(value = "/test/{name}")
    public String test (@PathVariable String name)
    {
        return "Bonjour !!!"+name;
    }

    @PostMapping(value = "/adduser")
    public User addUser(@RequestBody User user)
    {
        return userServ.addUser(user);
    }

    @PostMapping(value = "/addListUser")
    public List<User> addListUser(@RequestBody List<User> listUser)
    {
        return userServ.addListUser(listUser);
    }



    @PostMapping(value = "/updateuser/{iduser}")
    public User updateuser(@RequestBody User user,@PathVariable("iduser") Long iduser)
    {
        return userServ.updateUser(user, iduser);
    }
    @DeleteMapping(value = "/deleteuser/{iduser}")
    public String deleteuser(@PathVariable Long iduser)
    {
        return userServ.deleteuser(iduser) ;
    }

    @GetMapping(value = "/getallusers")
    public List<User> getAllusers()
    {
        return userServ.getAllUsers() ;
    }

    @GetMapping(value = "/getuserStartWSC/{ch}")
    public List<User> getuserStartWSC(@PathVariable String ch)
    {
        return userServ.getListUsersStartWSC(ch);
    }

    @GetMapping(value = "/getuserFromUN/{ch}")
    public User getuserFromUN(@PathVariable String ch)
    {
        return userServ.findByUsername(ch);
    }

    @PostMapping(value = "/addUserRole/{iduser}/{idrole}")
    public User addUserRole(@PathVariable Long iduser, @PathVariable Long idrole)
    {
        return userServ.adduserRole(iduser, idrole);
    }

    @GetMapping(value = "/getiduserfridrole")
    public List<Long> getiduserfridrole()
    {
        return userServ.listiduserfromidrole();
    }

    @GetMapping(value = "/getiduserfridrole/{idrole}")
    public List<Long> getiduserfridrole(@PathVariable Long idrole)
    {
        return userServ.listiduserfromidrole(idrole);
    }
    @GetMapping(value = "/getuserfridrole/{idrole}")
    public List<User> getuserfridrole(@PathVariable Long idrole)
    {
        return userServ.listuserfromidrole(idrole);
    }

    @PostMapping(value = "/adduserfile/{iduser}")
    public User adduserfile(@PathVariable Long iduser,@RequestParam("file") MultipartFile file) throws IOException
    {
        return userServ.addUserFile(iduser, file);
    }
}
