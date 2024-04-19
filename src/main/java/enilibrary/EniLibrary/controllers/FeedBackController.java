package enilibrary.EniLibrary.controllers;

import enilibrary.EniLibrary.entities.Role;
import enilibrary.EniLibrary.entities.Semester;
import enilibrary.EniLibrary.services.FeedBackService;
import enilibrary.EniLibrary.services.FeedBackServiceImp;
import enilibrary.EniLibrary.services.RoleService;
import enilibrary.EniLibrary.services.SemesterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import enilibrary.EniLibrary.entities.FeedBack;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/feedback")
public class FeedBackController {
/*
    private final FeedBackService feedBackService;

    @Autowired
    public FeedBackController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<FeedBack> createFeedback(@PathVariable Long userId, @Valid @RequestBody FeedBack feedback) {
        FeedBack createdFeedback = feedBackService.saveFeedBack(userId, feedback);
        return ResponseEntity.ok(createdFeedback);
    }

    @GetMapping
    public ResponseEntity<List<FeedBack>> getAllFeedbacks() {
        List<FeedBack> feedbacks = feedBackService.getAllFeedBacks();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedBack> getFeedbackById(@PathVariable Long id) {
        FeedBack feedback = feedBackService.getFeedBackById(id);
        return ResponseEntity.ok(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedBack> updateFeedback(@PathVariable Long id, @Valid @RequestBody FeedBack feedback) {
        FeedBack updatedFeedback = feedBackService.updateFeedBack(id, feedback);
        return ResponseEntity.ok(updatedFeedback);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long id) {
        feedBackService.deleteFeedBack(id);
        return ResponseEntity.ok("Feedback successfully deleted.");
    }
}*/
/*@Autowired
    private  FeedBackService feedBackService;

    @Autowired
    public FeedBackController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    @GetMapping
    public ResponseEntity<List<FeedBack>> getAllFeedBacks() {
        List<FeedBack> feedbacks = feedBackService.getAllFeedBacks();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedBack> getFeedBackById(@PathVariable Long id) {
        FeedBack feedback = feedBackService.getFeedBackById(id);
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<FeedBack> addFeedBack(@RequestBody FeedBack feedback) {
        FeedBack newFeedback = feedBackService.saveFeedBack(feedback);
        return new ResponseEntity<>(newFeedback, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FeedBack> updateFeedBack(@PathVariable Long id, @RequestBody FeedBack feedback) {
        FeedBack updatedFeedback = feedBackService.updateFeedBack(feedback, id);
        return new ResponseEntity<>(updatedFeedback, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFeedBack(@PathVariable Long id) {
        feedBackService.deleteFeedBack(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
@Autowired
FeedBackServiceImp feedser ;
@PostMapping("/addfeedback")
public FeedBack saveFeedBack(@RequestBody FeedBack f)
{
    return feedser.saveFeedBack(f);
}
    @GetMapping
    public List<FeedBack> getAllFeedBacks(){
        return  feedser.AllFeedBacks();
    }

}













  /*  @Autowired
    private  FeedBackService feedBackService;

    @GetMapping
    public ResponseEntity<List<FeedBack>> getAllFeedback() {
        List<FeedBack> feedbacks = feedBackService.getAllFeedback();
        return ResponseEntity.ok(feedbacks);
    }


    @Autowired
    private SemesterService semesterService;

    @PostMapping
    public FeedBack createFeedback(@RequestBody FeedBack feedback) {
        return FeedBackService.createFeedback(feedback);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> createFeedback(@PathVariable Long userId, @Valid @RequestBody FeedBack feedback) {
        try {
            FeedBack savedFeedback = feedBackService.addFeedback(userId, feedback);
            return ResponseEntity.ok(savedFeedback);
        } catch (Exception e) {
            // Log the exception here: e.g., log.error("Error creating feedback: ", e);
            // Respond with a generic error message
            return ResponseEntity.badRequest().body("Error creating feedback: " + e.getMessage());
        }
    }
}*/