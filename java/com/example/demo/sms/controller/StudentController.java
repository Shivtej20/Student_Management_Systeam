package com.example.demo.sms.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.sms.entity.Student;
import com.example.demo.sms.service.StudentService;

@Controller
@Validated
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	@GetMapping("/students")
	public String listStudents(@Valid Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
		
	}
	@GetMapping("/students/new")
	public String createStudentForm(@Valid Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	@PostMapping("/students")
	public String saveStudents(@Valid @ModelAttribute("student")Student student ) {
		studentService.saveStudent(student);
		return "redirect:/students";
		
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@Valid @PathVariable Long id ,Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@Valid @PathVariable Long id, @ModelAttribute("student")Student student, Model model){
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
		
	}
	@GetMapping("/students/{id}")
	public String deleteStudent( @PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
		
	}
	
}
