package ie.home.collections.sets;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		
		LocalDateTime ten = LocalDateTime.parse("2019-10-28T10:30:00");
		
		LocalDateTime eleven= LocalDateTime.parse("2019-10-28T11:30:00");
		
		Employee tenOclockEmployee = new Employee(101, "Octavian", ten);
		Employee elevenOclockEmployee = new Employee(102, "Nicolae", eleven);
		
		Set<Employee> employees = new TreeSet<Employee>();
		
//		tenOclockEmployee.compareTo(elevenOclockEmployee);
		
		employees.add(elevenOclockEmployee);
		employees.add(tenOclockEmployee);
		
		for (Employee employee : employees) {
			System.out.println(employee.name);
		}
	}
}
