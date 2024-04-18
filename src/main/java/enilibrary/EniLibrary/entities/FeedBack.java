package enilibrary.EniLibrary.entities;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

    @Entity
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class FeedBack implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String studentName; // Assuming you want to capture the student's name

        @Column(nullable = false, length = 500)
        private String message; // Feedback message from the student

        @Column(nullable = false)
        private int rating; // Rating field
        @CreationTimestamp
        private Date createdAt;

        @UpdateTimestamp
        private Date modifiedAt;

    }
