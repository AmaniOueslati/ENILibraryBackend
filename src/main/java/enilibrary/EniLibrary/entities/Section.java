package enilibrary.EniLibrary.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

//import javax.persistence.*;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Section {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String sectionName;
    private Long enrollementcount;
    @OneToMany( cascade = CascadeType.PERSIST)
    @JoinTable(name = "section_semester",
            joinColumns = {@JoinColumn(name = "section_id")},
            inverseJoinColumns = {@JoinColumn(name = "semester_id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"section_id", "semester_id"})})
    private List<Semester> semesters = new ArrayList<>();

   /* public Section(String sectionName, Long enrollementcount, List<Semester> semesters) {
        this.sectionName = sectionName;
        this.enrollementcount = enrollementcount;
        this.semesters = semesters;
    }*/

}
