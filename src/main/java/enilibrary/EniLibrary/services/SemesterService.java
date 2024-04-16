package enilibrary.EniLibrary.services;

import enilibrary.EniLibrary.entities.Semester;
import enilibrary.EniLibrary.entities.Subject;
import enilibrary.EniLibrary.exception.SemesterNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SemesterService  {
  //  public Semester saveSemester(Long id , String type , Long idSec) throws SemesterNotFoundException;
    public Semester saveSemester(Semester semester);
    public void deleteSemester(Long id);
    public void associateSubjectToSemester(Long idSub , Long idSem) throws SemesterNotFoundException;

    public List<Semester> allSemester();
    public List<Subject> subjectOfsemester(Long id);

}
