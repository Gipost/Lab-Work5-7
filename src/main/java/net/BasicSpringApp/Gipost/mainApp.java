package net.BasicSpringApp.Gipost;

import net.BasicSpringApp.Gipost.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.BasicSpringApp.Gipost.repository.StudentRepository;

@SpringBootApplication
public class mainApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(mainApp.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private GroupRepository groupRepository;

	@Override
	public void run(String... args) throws Exception {
		//Group group1 = new Group("IST-119");
		//groupRepository.save(group1);
		//Student student1 = new Student("Bogdan", "Vasilenko", "Dest123@mail.ru", group1);
		//studentRepository.save(student1);

		//Student student2 = new Student("Alexnadr", "Ratnikov", "sanjay@gmail.com", group1);
		//studentRepository.save(student2);
		//var students = studentRepository.findAll();
		//System.out.println("Список студентов: ");
		//for (Student student : students) {

			//System.out.println("Студент : " + student.getFirstName() + " " + student.getLastName());
			//System.out.println("Группа : " + student.getGroup().getName() + " Почта :" + student.getEmail());

		//}
	}
}

