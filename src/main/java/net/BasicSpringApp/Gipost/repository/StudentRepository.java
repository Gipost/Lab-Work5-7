package net.BasicSpringApp.Gipost.repository;

import net.BasicSpringApp.Gipost.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
