package enilibrary.EniLibrary;

import enilibrary.EniLibrary.Enum.DocumentCategory;
import enilibrary.EniLibrary.entities.Doc;
import enilibrary.EniLibrary.entities.Section;
import enilibrary.EniLibrary.entities.Semester;
import enilibrary.EniLibrary.entities.Subject;
import enilibrary.EniLibrary.repositories.DocRepository;
import enilibrary.EniLibrary.repositories.SectionRepository;
import enilibrary.EniLibrary.repositories.SemesterRepository;
import enilibrary.EniLibrary.repositories.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class EniLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EniLibraryApplication.class, args);


	}


	@Bean
	public CommandLineRunner loadData(SectionRepository sectionRepository, DocRepository docRepository, SemesterRepository semesterRepository, SubjectRepository subjectRepository) {
		return args -> {

			Doc doc1 = new Doc("Document 1", "PDF", DocumentCategory.COURS, new byte[]{});
			Doc doc2 = new Doc("Document 2", "Word", DocumentCategory.TD, new byte[]{});


			Subject subject1 = new Subject();
			subject1.setSubjectname("tla");
			subject1.setResources(Collections.singletonList(doc1));

			Subject subject2 = new Subject();
			subject2.setSubjectname("SGBD");
			subject2.setResources(Collections.singletonList(doc2));


			Semester semester1 = new Semester();
			semester1.setSemesterName("Semester 1");
			semester1.setSubjects(Collections.singletonList(subject1));

			Semester semester2 = new Semester();
			semester2.setSemesterName("Semester 2");
			semester2.setSubjects(Collections.singletonList(subject2));;


			Section section1 = new Section();
			section1.setSectionName("Informatique");
			section1.setEnrollementcount(85L);
			section1.setSemesters(Arrays.asList( semester2));

			Section section2 = new Section();
			section2.setSectionName("Mecatronique");
			section2.setEnrollementcount(55L);
			section2.setSemesters(Arrays.asList(semester1));


			sectionRepository.saveAll(Arrays.asList(section1, section2));
		};
	}


}
