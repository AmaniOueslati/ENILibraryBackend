package enilibrary.EniLibrary.entities;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Filee implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfile;
    private String titlefile;
    private String typefile;

    @Column(length = 400000000)
    private byte[] taillefile;


    @OneToOne
    private User user;

    public Filee(String titlefile, String typefile, byte[] taillefile) {
        super();
        this.titlefile = titlefile;
        this.typefile = typefile;
        this.taillefile = taillefile;
    }


}

