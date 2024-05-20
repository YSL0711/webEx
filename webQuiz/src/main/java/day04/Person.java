package day04;

import lombok.Data;

@Data
public class Person {

	String name;
	String age;
	String job;
	
	public void print() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("job : " + job);
	}
	
}
