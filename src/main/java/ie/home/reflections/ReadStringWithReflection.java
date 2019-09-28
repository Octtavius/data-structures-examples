package ie.home.reflections;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ReadStringWithReflection {
	// Program to convert string to a char array using Reflection
	public static void main(String[] args) {
		String s = "Java";

		Field field = null;
		try {
			field = String.class.getDeclaredField("value");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		field.setAccessible(true);

		char[] chars = new char[0];
		try {
			chars = (char[]) field.get(s);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		System.out.print(Arrays.toString(chars));
	}
}
