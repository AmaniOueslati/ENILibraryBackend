package enilibrary.EniLibrary.services;


import enilibrary.EniLibrary.entities.Doc;
import enilibrary.EniLibrary.entities.Semester;
import enilibrary.EniLibrary.entities.Subject;
import enilibrary.EniLibrary.exception.SemesterNotFoundException;
import enilibrary.EniLibrary.exception.SubjectNotFoundException;
import enilibrary.EniLibrary.repositories.DocRepository;
import enilibrary.EniLibrary.repositories.SubjectRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SubjectServiceImpl implements SubjectService {

@Autowired
private SubjectRepository subjectRepository ;
private DocRepository docRepository;


    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);

    }

    @Override
    public void associateDoctoSubject(Integer idD, Long idSub) throws SubjectNotFoundException {
        Optional<Subject> subjectOptional = subjectRepository.findById(idSub);
        if (subjectOptional.isPresent()) {
            Subject subject = subjectOptional.get();

            // Check if the document is already associated with the subject
            boolean isAssociated = subject.getResources().stream()
                    .anyMatch(doc -> doc.getId().equals(idD));

            if (!isAssociated) {
                Optional<Doc> docOptional = docRepository.findById(idD);
                if (docOptional.isPresent()) {
                    Doc doc = docOptional.get();
                    subject.getResources().add(doc); // Add the document to the subject's resources
                    subjectRepository.save(subject);
                }
            } else {
                // Document is already associated with the subject
                throw new IllegalStateException("Document is already associated with the subject");
            }
        } else {
            throw new SubjectNotFoundException("Subject Not Found");
        }
    }



    @Override
    public List<Subject> allSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public List<Doc> allRessourcesFromSubject(Long idSub) {
        Optional<Subject> subjectOptional = subjectRepository.findById(idSub);
        if (subjectOptional.isPresent()) {
            Subject subject = subjectOptional.get();
            return subject.getResources();

        }


        return null;
    }
}
