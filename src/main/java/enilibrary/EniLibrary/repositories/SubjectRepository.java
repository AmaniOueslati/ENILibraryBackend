package enilibrary.EniLibrary.repositories;

import enilibrary.EniLibrary.entities.Section;
import enilibrary.EniLibrary.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
