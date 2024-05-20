package day04;

import lombok.Data;

@Data
public class Rabbit {

	String name;
	String age;
	
	public void print() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
	}
	
}
