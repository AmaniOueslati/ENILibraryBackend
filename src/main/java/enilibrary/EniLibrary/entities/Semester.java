package enilibrary.EniLibrary.entities;

import enilibrary.EniLibrary.Enum.SemesterType;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String SemesterName;
    @OneToMany( cascade = CascadeType.PERSIST)
    @JoinTable(name = "semester_subject",
            joinColumns = {@JoinColumn(name = "subject_id")},
            inverseJoinColumns = {@JoinColumn(name = "semester_id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"subject_id", "semester_id"})})
    private List<Subject> subjects;

 /*   public Semester(String s, List<Subject> subject1) {
        this.SemesterName=s;
        this.subjects=subject1;
    }*/
}