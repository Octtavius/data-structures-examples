package ie.home.reflections;

import java.lang.reflect.Method;

import ie.home.data.RoomObject;

public class ReflectionExample {

	public static void main(String[] args) {
		Method[] methods = RoomObject.class.getMethods();

		for(Method method : methods){
		    System.out.println("method = " + method.getName());
		}
	}
}
