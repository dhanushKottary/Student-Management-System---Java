package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<Student> students;
	public static void main(String[] args) {
		
		System.out.println("************* Student Management System ***************");
        System.out.println("***************  Welcome ******************************");
        
        //Take input from the terminal
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.println("You entered: "+studentName);
        System.out.println("Enter student age: ");
        int age = scanner.nextInt();
        System.out.println("The student age you entered is "+age);


	}
	
	public static Student findStudentById(String studentId) {
		
		Student result = null;
		try {
		result = students.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
		                 .findFirst()
		                 .orElseThrow(() -> new RuntimeException("No student found with id: "+studentId));
		}
		catch (RuntimeException e) {
			System.err.println("No student found with id: "+studentId);
		}
		return result;
	}
	
	public static void showStudentList(List<Student> studentList) {
		studentList.stream().forEach(student -> student.printStudentInfo());
	}
	
	public static void sortByName() {
		Comparator<Student> comparator = (o1, o2) -> o1.getName().compareTo(o2.getName()); //Below commented code can be reduced to this
				
//				new Comparator<Student>() {
//			
//			@Override
//			public int compare(Student o1, Student o2) {
//				// TODO Auto-generated method stub
//				return o1.getName().compareTo(o2.getName());
//			}
//		};
		
		Collections.sort(students, comparator);
		showStudentList(students);
	}

}
