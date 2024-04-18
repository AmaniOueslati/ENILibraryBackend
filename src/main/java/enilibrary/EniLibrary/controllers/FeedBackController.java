package enilibrary.EniLibrary.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import enilibrary.EniLibrary.entities.FeedBack;
import enilibrary.EniLibrary.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/feedback")
public class FeedBackController {

    private final FeedBackService feedBackService;

    @PostMapping
    public ResponseEntity<FeedBack> createFeedback(@RequestBody FeedBack feedback) {
        return ResponseEntity.ok(feedBackService.addFeedback(feedback));
    }

    @GetMapping
    public ResponseEntity<List<FeedBack>> getAllFeedback() {
        return ResponseEntity.ok(feedBackService.getAllFeedback());
    }


}