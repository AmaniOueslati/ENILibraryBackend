package enilibrary.EniLibrary.repositories;
import enilibrary.EniLibrary.entities.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Integer> {

        List<FeedBack> findByStudentName(String studentName);



        List<FeedBack> findByRatingGreaterThanEqual(int rating);

        // Add this method to find feedback by a partial match to the message
        List<FeedBack> findByMessageContainingIgnoreCase(String message);


        /* List<FeedBack> findBySubjectId(Long subjectId);*/
}
