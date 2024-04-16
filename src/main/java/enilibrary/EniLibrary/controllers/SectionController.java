package enilibrary.EniLibrary.controllers;

import enilibrary.EniLibrary.entities.Section;
import enilibrary.EniLibrary.entities.Semester;
import enilibrary.EniLibrary.exception.SectionNotFoundException;
import enilibrary.EniLibrary.services.SectionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @PostMapping
    public Section saveSection(@RequestBody Section section) {
        return  sectionService.saveSection(section);
    }

    @GetMapping
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    @DeleteMapping("/{id}")
    public void deleteSection(@PathVariable(name="id") Long id) {
        sectionService.deleteSection(id);
    }

    @GetMapping("/{id}/semesters")
    public List<Semester> getSemestersOfSection(@PathVariable(name="id") Long id) {
        return sectionService.getSemestersofSection(id);
    }
}
