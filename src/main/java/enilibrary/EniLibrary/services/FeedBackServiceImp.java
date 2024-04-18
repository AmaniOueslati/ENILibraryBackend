package enilibrary.EniLibrary.services;

import enilibrary.EniLibrary.entities.FeedBack;
import enilibrary.EniLibrary.repositories.FeedBackRepository;
import enilibrary.EniLibrary.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedBackServiceImp implements FeedBackService{
    @Autowired
    private FeedBackRepository feedBackRepository;

    @Override
    public FeedBack addFeedback(FeedBack feedback) {
        return feedBackRepository.save(feedback);
    }

    @Override
    public List<FeedBack> getAllFeedback() {
        return feedBackRepository.findAll();
    }
}
