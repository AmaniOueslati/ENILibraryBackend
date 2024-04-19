package enilibrary.EniLibrary.services;
import enilibrary.EniLibrary.entities.FeedBack;
import java.util.List;

public interface FeedBackService {

    FeedBack saveFeedBack(FeedBack feedback);
    public List<FeedBack> AllFeedBacks() ;
    FeedBack getFeedBackById(Long id);
    FeedBack updateFeedBack(FeedBack feedback, Long id);
    void deleteFeedBack(Long id);

    //FeedBack addFeedback(Long userId, FeedBack feedback);
    //FeedBack addFeedback(FeedBack feedback);

   // List<FeedBack> getAllFeedback();

// If you want to add more methods for specific queries:
// List<FeedBack> getFeedbackByStudentName(String studentName);

// List<FeedBack> getFeedbackByRating(int rating);
}
