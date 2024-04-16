package enilibrary.EniLibrary.repositories;

import enilibrary.EniLibrary.entities.Section;
import enilibrary.EniLibrary.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long>{
}
