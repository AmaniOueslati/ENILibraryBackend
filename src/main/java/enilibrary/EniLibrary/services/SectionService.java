package enilibrary.EniLibrary.services;

import enilibrary.EniLibrary.entities.Section;
import enilibrary.EniLibrary.entities.Semester;
import enilibrary.EniLibrary.exception.SectionNotFoundException;
import enilibrary.EniLibrary.exception.SemesterNotFoundException;
import enilibrary.EniLibrary.repositories.SectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SectionService {

    public Section saveSection(Section section);
    public void deleteSection(Long ids);
    public void addSemesterToSection(Long idSec , Long idSem);

    void associateSemesterToSectionByID(long idSem, Long idSec) throws SectionNotFoundException;

    public void updateSectionName(Long idSec , String newName) throws SectionNotFoundException;
    public List<Section> getAllSections();
    public List<Semester> getSemestersofSection(Long id);




























/*    public Section saveSection(Section section);
    public List<Section> getAllSections();
    public void deleteSemesterFromSection(Long idSec , Long idSem) throws SemesterNotFoundException, SectionNotFoundException;


    public void deleteSection(Long idS);
     public void addSemesterToSection(Long idS, Semester semester) throws SectionNotFoundException;
     public void associateSemesterToSectionByID(long idSem , Long idSec) throws SectionNotFoundException;
     public void updateSectionName(Long id , String newName) throws SectionNotFoundException*/;
}
