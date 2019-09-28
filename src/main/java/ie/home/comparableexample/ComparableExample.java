package ie.home.comparableexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student(101, "John", 23));
		students.add(new Student(106, "Emma", 27));
		students.add(new Student(104, "Stephen", 21));
		
		Collections.sort(students);
		
		for (Student student : students) {
			System.out.println(student.getRollNo() + " " + student.getName() + " " + student.getAge());
		}
	}
}
