package com.abhi.student.services;

import com.abhi.student.DTO.StudentDTO;
import com.abhi.student.DTO.StudentMarkDTO;
import com.abhi.student.dao.StudentRepository;
import com.abhi.student.entities.Student;
import com.abhi.student.entities.StudentMarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudent(int id) {
        return this.studentRepository.findById(id);
    }

    @Override
    public StudentMarks getMark(int id) {
        Optional<Student> s = this.studentRepository.findById(id);
        if (s.isPresent()){
            Student student = s.get();
            return student.getStudentMarks();
        }
        else {
            throw new RuntimeException("Student not found with id " + id);
        }
    }

    @Override
    public List<Student> getStudentByName(String name) {
       return studentRepository.findByName(name);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student addMark(int id, StudentMarkDTO studentMarkDTO) {
        Optional<Student> s= this.studentRepository.findById(id);
        if (s.isPresent()) {
            Student student = s.get();
            StudentMarks studentMarks = new StudentMarks();
            studentMarks.setOracle_marks(studentMarkDTO.getOracle_marks());
            studentMarks.setMath_marks(studentMarkDTO.getMath_marks());
            studentMarks.setJava_marks(studentMarkDTO.getJava_marks());
            studentMarkDTO.setEnglish_marks(studentMarkDTO.getEnglish_marks());
            student.setStudentMarks(studentMarks);
            studentMarks.setStudent(student);
            return studentRepository.save(student);
        }
        else {
            throw new RuntimeException("Student not found with id " + id);
        }
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student, int id) {
        student.setId(id);
        return this.studentRepository.save(student);
    }

    @Override
    public Student updateStudentByLocation(StudentDTO studentDTO, int id) {
        Optional<Student> s= this.studentRepository.findById(id);
        if (s.isPresent()) {
            Student student = s.get();
            student.setOldCity(student.getCity());
            student.setName(studentDTO.getName());
            student.setCity(studentDTO.getCity());
            return studentRepository.save(student);
        }
        else {
            throw new RuntimeException("Student not found with id " + id);
        }
    }

//    public abstract List<Student> getAllStudents() {
//        return this.studentRepository.findAll();
//    }
//
//    public abstract Optional<Student> getStudent(int id) {
//        return null;
//    }
//
//    public StudentMarks getMark(int id) {
//        Optional<Student> s = this.studentRepository.findById(id);
//        if (s.isPresent()){
//            Student student = s.get();
//            return student.getStudentMarks();
//        }
//        else {
//            throw new RuntimeException("Student not found with id " + id);
//        }
//    }
//
//    public List<Student> getStudentByName(String name) {
//        return studentRepository.findByName(name);
//    }
//
//    public  Student addStudent(Student student){
//        return studentRepository.save(student);
//    }
//
//
////    POST Requests
//
//    public Student addMark(int id, StudentMarkDTO studentMarkDTO) {
//        Optional<Student> s= this.studentRepository.findById(id);
//        if (s.isPresent()) {
//            Student student = s.get();
//            StudentMarks studentMarks = new StudentMarks();
//            studentMarks.setOracle_marks(studentMarkDTO.getOracle_marks());
//            studentMarks.setMath_marks(studentMarkDTO.getMath_marks());
//            studentMarks.setJava_marks(studentMarkDTO.getJava_marks());
//            studentMarkDTO.setEnglish_marks(studentMarkDTO.getEnglish_marks());
//            student.setStudentMarks(studentMarks);
//            studentMarks.setStudent(student);
//            return studentRepository.save(student);
//        }
//        else {
//            throw new RuntimeException("Student not found with id " + id);
//        }
//    }
//
////  DELETE
//
//    public void deleteStudent(int id){
//        studentRepository.deleteById(id);
//    }
//
//    //    UPDATE
//    public Student updateStudent(Student student, int id) {
//        student.setId(id);
//        return this.studentRepository.save(student);
//    }
//
//    public Student updateStudentByLocation(StudentDTO studentDTO, int id) {
//        Optional<Student> s= this.studentRepository.findById(id);
//        if (s.isPresent()) {
//            Student student = s.get();
//            student.setOldCity(student.getCity());
//            student.setName(studentDTO.getName());
//            student.setCity(studentDTO.getCity());
//            return studentRepository.save(student);
//        }
//        else {
//            throw new RuntimeException("Student not found with id " + id);
//        }
//    }
}
