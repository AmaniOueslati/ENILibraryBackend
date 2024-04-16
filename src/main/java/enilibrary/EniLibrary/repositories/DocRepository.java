package enilibrary.EniLibrary.repositories;

import enilibrary.EniLibrary.Enum.DocumentCategory;
import enilibrary.EniLibrary.entities.Doc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocRepository  extends JpaRepository<Doc,Integer> {

    List<Doc> findAllByDocumentCategory(DocumentCategory documentCategory);
}
