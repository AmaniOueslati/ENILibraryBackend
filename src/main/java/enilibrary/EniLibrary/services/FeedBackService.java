package enilibrary.EniLibrary.services;
import enilibrary.EniLibrary.entities.FeedBack;
import java.util.List;

public interface FeedBackService {

    FeedBack addFeedback(FeedBack feedback);

    List<FeedBack> getAllFeedback();

// If you want to add more methods for specific queries:
// List<FeedBack> getFeedbackByStudentName(String studentName);

// List<FeedBack> getFeedbackByRating(int rating);
}
