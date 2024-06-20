package com.abhi.student;

import com.abhi.student.dao.StudentRepository;
import com.abhi.student.dao.Studentdao;
import com.abhi.student.entities.Student;
import com.abhi.student.entities.StudentMarks;
import com.abhi.student.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@SpringBootApplication
public class StudentApplication implements CommandLineRunner {

	@Autowired
	private Studentdao studentdao;

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		this.studentdao.createTable();

//		this.studentdao.insertData("Abhisek", "Berhampur");

		Student student = new Student();
		StudentMarks studentMarks = new StudentMarks();


//		student.setName("Abhisek");
//		student.setCity("BMCK");
//		student.setCourse("BCA");
//		studentMarks.setOracle_marks(66);
//		studentMarks.setEnglish_marks(60);
//		studentMarks.setJava_marks(40);
//		studentMarks.setMath_marks(50);
//		studentMarks.setMath_marks(80);
////		student.setStudentMarks(studentMarks);
//		studentMarks.setStudent(student);
//
//		studentRepository.save(student);

//		Student student1 = studentRepository.findById(352).get();
//		StudentMarks studentMarks1 = student1.getStudentMarks();
//		System.out.println(studentMarks1.getEnglish_marks());


	}

	@Autowired
	private StudentRepository studentRepository;
}
