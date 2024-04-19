package enilibrary.EniLibrary.repositories;
import enilibrary.EniLibrary.entities.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {

}