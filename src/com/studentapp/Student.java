package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	
	private String name;
	private int age;
	private String studentId;
	private List<String> courses;
	
	public Student(String name, int age, String studentId) {
		super();
		if(validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			this.courses = new ArrayList<>();
		}
		
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getStudentId() {
		return studentId;
	}



	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}



	public List<String> getCourses() {
		return courses;
	}



	public void setCourses(List<String> courses) {
		this.courses = courses;
	}



	public void enrollCourse(String course) {
		if(courses == null) {
			
		}
		else if(validateCourseName(course) ) {
			if(!courses.contains(course)) {
				courses.add(course);
				System.out.println("Student is enrolled to course "+course+" successfully");
			}
			else {
				System.err.println("Student is already enrolled to the course: "+course);
		    }
		}
		
		
	}
	
	public void printStudentInfo() {
		
		System.out.println("Student Details: ");
		System.out.println("Student name: "+this.name);
		System.out.println("Student age: "+this.age);
		System.out.println("Student ID: "+this.studentId);
		System.out.println("List of courses enrolled: "+ this.courses);
		System.out.println();
	}
	
	
	//Validation methods
	public boolean validateAge(int age) {
		
		if(age >=19 && age<=35) {
			return true;
		}
		else {
			System.err.println("Student age is invalid!! Student age needs to be between 19 and 35");
			return false;
		}
	}
	
	public boolean validateName(String name) {
		String regEx = "^[a-zA-z\\s]+$";
		Pattern namePattern = Pattern.compile(regEx);
		Matcher nameMatcher = namePattern.matcher(name);
		
		if(nameMatcher.matches()) {
			return true;
		}
		else {
			System.err.println("Invalid name!!! Please enter alphabets only");
			return false;
		}
	}
	
	
	public boolean validateStudentId(String studentId) {
		String studentIdRegex = "^S-[0-9]+";
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
		if(studentIdMatcher.matches()) {
			return true;
		}
		else {
			System.err.println("Invalid studentId!!! Use the format S-1234");
			return false;
		}
	}
	
	public boolean validateCourseName(String course) {
		
		if(course.equalsIgnoreCase("JAVA") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DEVOPS")) {
			return true;
		}
		else {
			System.err.println("Invalid course!!! Please choose courses from the list - [JAVA, DSA, DEVOPS]");
			return false;
		}
	}

}
