package enilibrary.EniLibrary.entities;

import lombok.*;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
/*@Table(name = "subject_resources", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"subject_id", "resources_id"})
})*/
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Subjectname;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "subject_resources",
            joinColumns = {@JoinColumn(name = "subject_id")},
            inverseJoinColumns = {@JoinColumn(name = "doc_id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"subject_id", "doc_id"})})
    private List<Doc> resources;
   /* public Subject(String subjectName, List<Doc> resources) {
        this.Subjectname = subjectName;
        this.resources = resources;
    }*/

}