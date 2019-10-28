package ie.home.collections.sets;

import java.time.LocalDateTime;

public class Employee implements Comparable<Employee>{

	public int id;
	public String name;
	public LocalDateTime time;
	public Employee(int id, String name, LocalDateTime time) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
	}
	@Override
	public int compareTo(Employee passedObject) {
		System.out.println(this.time.isAfter(passedObject.time));
		if (this.time.isAfter(passedObject.time)) {
			return 1;
		} else {
			
			return -1; 
		}
		
	}
	
	
}
