package enilibrary.EniLibrary.services;

import enilibrary.EniLibrary.entities.FeedBack;
import enilibrary.EniLibrary.entities.Role;
import enilibrary.EniLibrary.entities.User;
import enilibrary.EniLibrary.repositories.FeedBackRepository;
import enilibrary.EniLibrary.repositories.IRoleRepository;
import enilibrary.EniLibrary.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import enilibrary.EniLibrary.exception.FeedbackNotFoundException;



import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements InterUserService {

    @Autowired
    IUserRepository userRep;

    @Autowired
    IRoleRepository roleRep;
   /********************************** START KHEDEMTY *********************************************/
   @Autowired
   private FeedBackRepository feedBackRepository;

    public User saveUser(User user) {
        return userRep.save(user);
    }

    public void associateFeedbackToUser(Long idfeed, Long iduser) throws FeedbackNotFoundException { // Correction du nom de l'exception
        Optional<User> userOptional = userRep.findById(iduser);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Optional<FeedBack> feedBackOptional = feedBackRepository.findById(idfeed);
            if (feedBackOptional.isPresent()) {
                FeedBack feedBack = feedBackOptional.get();
                user.getFeedBacks().add(feedBack);
                userRep.save(user);
            } else {
                throw new FeedbackNotFoundException("Feedback not found with id: " + idfeed); // Correction du message de l'exception
            }
        } else {
            throw new FeedbackNotFoundException("User not found with id: " + iduser); // Correction du message de l'exception
        }
    }

    public List<FeedBack> FeedbacksOfUser(Long id) {
        Optional<User> userOptional = userRep.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getFeedBacks();
        } else {
            throw new FeedbackNotFoundException("User not found with id: " + id); // Correction du message de l'exception
        }
    }



































    /*************************************  END KHEDEMTY *********************************/
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

        User usr = userRep.findById(iduser).get();

        usr.setFname(user.getFname());
        usr.setLname(user.getLname());

        return userRep.save(usr);
    }

    @Override
    public String deleteuser(Long iduser) {
        // TODO Auto-generated method stub

        String ch = "";

        userRep.deleteById(iduser);
        ch = "user successfuly deleted !!";
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


// Utilisation de findByUsername qui renvoie un Optional<User>
        Optional<User> userOptional = userRep.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            return userOptional.get();

            // Faire quelque chose avec l'utilisateur trouvé
        } else {
            return null;
        }


    }

    @Override
    public User adduserRole(Long iduser, Long idrole) {
        // TODO Auto-generated method stub

        User user = userRep.findById(iduser).get();
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

}