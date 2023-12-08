package hccs.edu.studentlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StudentController {
    @GetMapping("/students")
    public List<Student>  students() throws IOException {
        return readData();
    }

    @GetMapping("/name/{name}")
    public Student student(@PathVariable String name) throws IOException{
        System.out.println("search student by name : " + name);
        List<Student> students =readData();
        for(Student student : students){
            if(student.getName().equalsIgnoreCase(name)){
                System.out.println("Found student "+ name);
                return student;
            }
        }
        System.out.println("No student found by that name " + name);
        return null;
    }

    @GetMapping("/student")
    public Student student(@RequestParam( name = "gpa") double gpa,
        @RequestParam(name = "gender") String gender) throws IOException {
        System.out.println("Search student by gpa : " + gpa +"gender" + gender);
        List<Student> students = readData();
        for(Student student : students) {
            if(student.getGpa() == gpa && student.getGender().equalsIgnoreCase(gender)){
                System.out.println("found student"+student);
                return student;
            }
        }
        System.out.println("No student has been found for" + gpa);
        return null;
    }
    

public List<Student> readData() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/student.txt");
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            List<Student> studentList = new ArrayList<>();

            String header = bufferedReader.readLine();
            String line = bufferedReader.readLine();

            while (line != null) {
                Student student = new Student(header, 0, line);
                studentList.add(student);
                line = bufferedReader.readLine();
                
            }
            return studentList;
        }
    }
}
