package net.BasicSpringApp.Gipost.controller;

import net.BasicSpringApp.Gipost.entity.Group;
import net.BasicSpringApp.Gipost.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.BasicSpringApp.Gipost.entity.Student;
import net.BasicSpringApp.Gipost.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {
	
	private StudentService studentService;
	private GroupService groupService;

	public StudentController(StudentService studentService, GroupService groupService) {
		super();
		this.studentService = studentService;
		this.groupService = groupService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		model.addAttribute("groups", groupService.getAllGroups());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		List<Group> groups = groupService.getAllGroups();
		model.addAttribute("groups", groups);
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "create_student";
		}
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		List<Group> groups = groupService.getAllGroups();
		model.addAttribute("groups", groups);
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {

		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setGroup(student.getGroup());
		
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
}
