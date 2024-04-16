package enilibrary.EniLibrary.services;

import enilibrary.EniLibrary.entities.Section;
import enilibrary.EniLibrary.entities.Semester;
import enilibrary.EniLibrary.exception.SectionNotFoundException;
import enilibrary.EniLibrary.repositories.SectionRepository;
import enilibrary.EniLibrary.repositories.SemesterRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class SectionServiceImp implements  SectionService{

    @Autowired
    private SectionRepository sectionRepository;
    private SemesterRepository semesterRepository;

    @Override
    public Section saveSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public void deleteSection(Long ids) {
        sectionRepository.deleteById(ids);
    }

    @Override
    public void addSemesterToSection(Long idSec, Long idSem) {

    }

    @Override
    public void associateSemesterToSectionByID(long idSem, Long idSec) throws SectionNotFoundException {

        Optional<Section> sectionOptional = sectionRepository.findById(idSec);
        if(sectionOptional.isPresent()){
            Section section=sectionOptional.get();
            Optional<Semester> semesterOptional= semesterRepository.findById(idSem);

            if(semesterOptional.isPresent()){

                List<Semester> semesterList=section.getSemesters();
                Semester semester=semesterOptional.get();
                semesterList.add(semester);
                section.setSemesters(semesterList);
                sectionRepository.save(section);

            }

        }else {
            throw new SectionNotFoundException("Section not found with id: ");

        }

    }

    @Override
    public void updateSectionName(Long id, String newName) throws SectionNotFoundException {

        Optional<Section> sectionOptional = sectionRepository.findById(id);

        if (sectionOptional.isPresent()) {
            Section section = sectionOptional.get();

            section.setSectionName(newName);

            sectionRepository.save(section);
        } else {

            throw new SectionNotFoundException("Section not found with id: " + id);
        }
    }

    @Override
    public List<Section> getAllSections() {
        return sectionRepository.findAll();

    }

    @Override
    public List<Semester> getSemestersofSection(Long id) {
        Optional<Section> sectionOptional = sectionRepository.findById(id);
        if (sectionOptional.isPresent()) {
            Section section= sectionOptional.get();
            return section.getSemesters();

        }

      return Collections.emptyList();
    }
    }



















 /*   private SemesterRepository semesterRepository;
    @Override
    public Section saveSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public List<Section> getAllSections() {
      List<Section> Allsections=sectionRepository.findAll();
      return  Allsections;
    }

    @Override
    public void deleteSemesterFromSection(Long idSec, Long idSem) throws SemesterNotFoundException, SectionNotFoundException {

        Optional<Section> sectionOptional = sectionRepository.findById(idSec);

        if (sectionOptional.isPresent()) {
            Section section = sectionOptional.get();

            Optional<Semester> semesterOptional = section.getSemesters().stream()
                    .filter(semester -> semester.getId().equals(idSem))
                    .findFirst();

            if (semesterOptional.isPresent()) {

                section.getSemesters().remove(semesterOptional.get());

                sectionRepository.save(section);
            } else {

                throw new SemesterNotFoundException("Semester not found with id: " + idSem + " in section with id: " + idSec);
            }
        } else {

            throw new SectionNotFoundException("Section not found with id: " + idSec);
        }
    }




    @Override
    public void deleteSection(Long idS) {
        sectionRepository.deleteById(idS);


    }

    @Override
    public void addSemesterToSection(Long idS, Semester semester) throws SectionNotFoundException {
        Optional<Section> sectionOptional = sectionRepository.findById(idS);
        if(sectionOptional.isPresent()){
            Section section=sectionOptional.get();
            List<Semester> semesterList=section.getSemesters();
            semesterList.add(semester);
            section.setSemesters(semesterList);
            sectionRepository.save(section);
        }else {
          throw new SectionNotFoundException("Section not found with id: " + idS);

        }



    }

    @Override
    public void associateSemesterToSectionByID(long idSem, Long idSec) throws SectionNotFoundException {

        Optional<Section> sectionOptional = sectionRepository.findById(idSec);
        if(sectionOptional.isPresent()){
            Section section=sectionOptional.get();
           Optional<Semester> semesterOptional= semesterRepository.findById(idSem);

            if(semesterOptional.isPresent()){

                List<Semester> semesterList=section.getSemesters();
                Semester semester=semesterOptional.get();
                semesterList.add(semester);
                section.setSemesters(semesterList);
                sectionRepository.save(section);

        }

        }else {
            throw new SectionNotFoundException("Section not found with id: ");

        }

    }

    @Override
    public void updateSectionName(Long id, String newName) throws SectionNotFoundException {

        Optional<Section> sectionOptional = sectionRepository.findById(id);

        if (sectionOptional.isPresent()) {
            Section section = sectionOptional.get();

            section.setSectionName(newName);

            sectionRepository.save(section);
        } else {
            
            throw new SectionNotFoundException("Section not found with id: " + id);
        }
    }*/


