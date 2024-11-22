package com.abhi.student.controllers;

import com.abhi.student.DTO.StudentDTO;
import com.abhi.student.DTO.StudentMarkDTO;
import com.abhi.student.entities.Student;
import com.abhi.student.entities.StudentMarks;
import com.abhi.student.services.StudentService;
import com.abhi.student.services.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studentProfile")
public class StudentController {

    @Autowired
    private StudentServiceImplementation studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudent(@PathVariable("id") int id){
        return this.studentService.getStudent(id);
    }

    @GetMapping("studentName/{name}")
    public  List<Student> getStudentByName(@PathVariable("name") String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("/student_mark/{id}")
    public StudentMarks getMArk(@PathVariable("id") int id){
        return this.studentService.getMark(id);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return this.studentService.addStudent(student);
    }

    @PostMapping("/mark/{id}")
    public Student addMark(@PathVariable("id") int id, @RequestBody StudentMarkDTO studentMarkDTO){
       return this.studentService.addMark(id,studentMarkDTO);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent (@PathVariable("id") int id){
         studentService.deleteStudent(id);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int id){
         return this.studentService.updateStudent(student,id);
    }

    @PutMapping("/studentsByLocation/{id}")
    public Student updateStudentByLocation(@RequestBody StudentDTO studentDTO, @PathVariable("id") int id){
        return this.studentService.updateStudentByLocation(studentDTO,id);
    }

}
