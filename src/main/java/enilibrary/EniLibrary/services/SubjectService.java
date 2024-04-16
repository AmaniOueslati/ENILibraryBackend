package enilibrary.EniLibrary.services;

import enilibrary.EniLibrary.entities.Doc;
import enilibrary.EniLibrary.entities.Section;
import enilibrary.EniLibrary.entities.Subject;
import enilibrary.EniLibrary.exception.SemesterNotFoundException;
import enilibrary.EniLibrary.exception.SubjectNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectService {

    public Subject saveSubject(Subject subject);
    public void deleteSubject(Long id);
    public void associateDoctoSubject(Integer idD , Long idSub) throws SemesterNotFoundException, SubjectNotFoundException;

    public List<Subject> allSubjects();
    public List<Doc> allRessourcesFromSubject(Long idSub);
}
