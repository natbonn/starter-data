package gr.aueb.cf.starter_data.runner;

import gr.aueb.cf.starter_data.model.Teacher;
import gr.aueb.cf.starter_data.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherRunner implements CommandLineRunner {

    private final TeacherRepository teacherRepository;

//    @Autowired
//    public TeacherRunner(TeacherRepository teacherRepository) {
//        this.teacherRepository = teacherRepository;
//    }

    @Override
    public void run(String... args) throws Exception {

        Teacher teacher1 = new Teacher();
        teacher1.setFirstname("John");
        teacher1.setLastname("Papadopoulos");
        teacher1.setActive(true);
        teacherRepository.save(teacher1);        // κανει insert ή update αναλογα αν υπαρχει η οχι

        Teacher teacher2 = new Teacher();
        teacher1.setFirstname("Alice");
        teacher1.setLastname("Ioannou");
        teacher1.setActive(true);
        teacherRepository.save(teacher2);

        Teacher teacher3 = new Teacher();
        teacher1.setFirstname("Bob");
        teacher1.setLastname("Giannoutsos");
        teacher1.setActive(false);
        teacherRepository.save(teacher3);
    }
}
