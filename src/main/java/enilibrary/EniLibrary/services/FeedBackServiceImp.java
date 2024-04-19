package enilibrary.EniLibrary.services;

import enilibrary.EniLibrary.entities.FeedBack;
import enilibrary.EniLibrary.entities.Role;
import enilibrary.EniLibrary.entities.Semester;
import enilibrary.EniLibrary.entities.User;
import enilibrary.EniLibrary.repositories.FeedBackRepository;
import enilibrary.EniLibrary.repositories.IUserRepository;
import enilibrary.EniLibrary.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import enilibrary.EniLibrary.exception.FeedbackNotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class FeedBackServiceImp implements FeedBackService{
   /* @Autowired
    private FeedBackRepository feedBackRepository;

    @Autowired
    private IUserRepository userRepository; // Assuming you also need UserRepository

    @Override
    public List<FeedBack> getAllFeedback() {
        return feedBackRepository.findAll();
    }

    @Override
    public FeedBack addFeedback(Long userId, FeedBack feedback) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            feedback.setUser(user);
            return feedBackRepository.save(feedback);
        } else {
            throw new EntityNotFoundException("User not found with id: " + userId);
        }
    }*/
   /*@Autowired
    private  FeedBackRepository feedBackRepository;
    @Autowired
    private  IUserRepository userRepository;

    @Override
    public FeedBack saveFeedBack(FeedBack feedback, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        feedback.setUser(user);
        return feedBackRepository.save(feedback);
    }

    @Override
    public List<FeedBack> getAllFeedBacks() {
        return feedBackRepository.findAll();
    }

    @Override
    public FeedBack getFeedBackById(Long id) {
        return feedBackRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Feedback not found with id: " + id));
    }

    @Override
    public FeedBack updateFeedBack(FeedBack feedback, Long id) {
        FeedBack existingFeedback = feedBackRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Feedback not found with id: " + id));
        existingFeedback.setMessage(feedback.getMessage());
        existingFeedback.setRating(feedback.getRating());
        return feedBackRepository.save(existingFeedback);
    }

    @Override
    public void deleteFeedBack(Long id) {
        if (!feedBackRepository.existsById(id)) {
            throw new EntityNotFoundException("Feedback not found with id: " + id);
        }
        feedBackRepository.deleteById(id);
    }*/


    /************************************ nkhedemty ********************************/
    /*****************************************************************************/
    @Autowired
    private FeedBackRepository feedBackRepository;


  /*  public FeedBack addfeed(FeedBack f) {
        // TODO Auto-generated method stub
        return feedBackRepository.save(f);
    }*/


    @Override
    public FeedBack saveFeedBack(FeedBack feedback) {
        return feedBackRepository.save(feedback);
    }

    @Override
    public List<FeedBack> AllFeedBacks() {
        return feedBackRepository.findAll();
    }
    @Override
    public FeedBack getFeedBackById(Long id) {
        return feedBackRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Feedback not found with id: " + id));
    }

    @Override
    public FeedBack updateFeedBack(FeedBack feedback, Long id) {
        FeedBack existingFeedback = feedBackRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Feedback not found with id: " + id));
        existingFeedback.setMessage(feedback.getMessage());
        existingFeedback.setRating(feedback.getRating());
        return feedBackRepository.save(existingFeedback);
    }

    @Override
    public void deleteFeedBack(Long id) {
        if (!feedBackRepository.existsById(id)) {
            throw new EntityNotFoundException("Feedback not found with id: " + id);
        }
        feedBackRepository.deleteById(id);
    }
}
