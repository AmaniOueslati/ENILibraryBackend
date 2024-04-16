package enilibrary.EniLibrary.controllers;

import enilibrary.EniLibrary.entities.Doc;
import enilibrary.EniLibrary.entities.Subject;
import enilibrary.EniLibrary.exception.SemesterNotFoundException;
import enilibrary.EniLibrary.exception.SubjectNotFoundException;
import enilibrary.EniLibrary.services.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public Subject saveSubject(@RequestBody Subject subject) {
        return subjectService.saveSubject(subject);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
    }

    @PostMapping("/{idSub}/docs/{idD}")
    public void associateDocToSubject(@PathVariable Integer idD, @PathVariable Long idSub) throws SubjectNotFoundException, SemesterNotFoundException {
        subjectService.associateDoctoSubject(idD, idSub);
    }

    @GetMapping("/{idSub}/docs")
    public List<Doc> getAllRessourcesFromSubject(@PathVariable Long idSub) {
        return subjectService.allRessourcesFromSubject(idSub);
    }

    @GetMapping
    public List<Subject> getAllSubject(){
        return  subjectService.allSubjects();
    }
}
