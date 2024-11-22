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
public interface StudentService {


    public abstract List<Student> getAllStudents();

    public abstract Optional<Student> getStudent(int id);

    public abstract StudentMarks getMark(int id);

    public abstract List<Student> getStudentByName(String name);

    public abstract Student addStudent(Student student);


//    POST Requests

    public abstract Student addMark(int id, StudentMarkDTO studentMarkDTO);

//  DELETE

    public abstract void deleteStudent(int id);

    //    UPDATE
    public abstract Student updateStudent(Student student, int id);

    public abstract Student updateStudentByLocation(StudentDTO studentDTO, int id);
}
