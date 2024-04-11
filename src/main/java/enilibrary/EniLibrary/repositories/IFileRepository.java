package enilibrary.EniLibrary.repositories;

import enilibrary.EniLibrary.entities.Filee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileRepository extends JpaRepository<Filee, Long> {

}
