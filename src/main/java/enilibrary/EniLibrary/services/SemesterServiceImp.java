package enilibrary.EniLibrary.services;

import enilibrary.EniLibrary.entities.Section;
import enilibrary.EniLibrary.entities.Semester;
import enilibrary.EniLibrary.entities.Subject;
import enilibrary.EniLibrary.exception.SectionNotFoundException;
import enilibrary.EniLibrary.exception.SemesterNotFoundException;
import enilibrary.EniLibrary.repositories.SectionRepository;
import enilibrary.EniLibrary.repositories.SemesterRepository;
import enilibrary.EniLibrary.repositories.SubjectRepository;
<<<<<<< HEAD
import javax.persistence.*;
=======

>>>>>>> youssef
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class SemesterServiceImp implements SemesterService {
    @Autowired
    private SemesterRepository semesterRepository;
    private SubjectRepository subjectRepository;


    @Override
    public Semester saveSemester(Semester semester) {
        return semesterRepository.save(semester);
    }


    @Override
    public void deleteSemester(Long id) {
        semesterRepository.deleteById(id);
    }

    @Override
    public void associateSubjectToSemester(Long idSub, Long idSem) throws SemesterNotFoundException {
        Optional<Semester> semesterOptional = semesterRepository.findById(idSem);
        if(semesterOptional.isPresent()){
            Semester semester=semesterOptional.get();
            Optional<Subject> subjectOptional= subjectRepository.findById(idSub);
            if(subjectOptional.isPresent()){

                List<Subject> subjectList=semester.getSubjects();
                Subject subject=subjectOptional.get();
                subjectList.add(subject);
                semester.setSubjects(subjectList);
                semesterRepository.save(semester);

            }

        }else {
            throw new SemesterNotFoundException("semester Not Found");

        }


    }

    @Override
    public List<Semester> allSemester() {
        return semesterRepository.findAll();
    }

    @Override
    public List<Subject> subjectOfsemester(Long id) {
        Optional<Semester> semesterOptional = semesterRepository.findById(id);
        if (semesterOptional.isPresent()) {
            Semester semester = semesterOptional.get();
            return semester.getSubjects();

        }

        return null;
    }
    }















/*    @Override
    public Semester saveSemester(Long id, String type, Long idSec) throws SemesterNotFoundException {
        Optional<Section> sectionOption=sectionRepository.findById(idSec);
        if(sectionOption.isPresent()){
            Section section=sectionOption.get();
            Semester semester=new Semester();
            semester.setId(id);
            semester.setType(type);
            semester.setSection(section);
           return semesterRepository.save(semester);

        }
        else {
            throw new SemesterNotFoundException("cant create semester");
        }

    }*/



