package ie.home.comparableexample;

public class Student implements Comparable<Student>{

	private int rollNo;
	private String name;
	private int age;
	
	public Student( int rollNo, String name, int age) {
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Student otherStudent) {
		if (age == otherStudent.age) {
			return 0;
		} else if (age > otherStudent.age) {
			return 1;
		} else {			
			return -1;
		}
	}

	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	
}
