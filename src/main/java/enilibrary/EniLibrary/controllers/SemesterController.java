package enilibrary.EniLibrary.controllers;

import enilibrary.EniLibrary.entities.Semester;
import enilibrary.EniLibrary.entities.Subject;
import enilibrary.EniLibrary.exception.SemesterNotFoundException;
import enilibrary.EniLibrary.services.SemesterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/semesters")
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @PostMapping
    public Semester saveSemester(@RequestBody Semester semester) {
        return semesterService.saveSemester(semester);
    }

    @DeleteMapping("/{id}")
    public void deleteSemester(@PathVariable Long id) {
        semesterService.deleteSemester(id);
    }

    @PostMapping("/{idSem}/subjects/{idSub}")
    public void associateSubjectToSemester(@PathVariable Long idSub, @PathVariable Long idSem) throws SemesterNotFoundException {
        semesterService.associateSubjectToSemester(idSub, idSem);
    }

    @GetMapping("/{id}/subjects")
    public List<Subject> getSubjectsOfSemester(@PathVariable Long id) {
        return semesterService.subjectOfsemester(id);
    }

    @GetMapping
    public List<Semester> getAllSemester(){
        return  semesterService.allSemester();
    }
}
