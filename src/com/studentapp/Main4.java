package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main4 {

	private static List<Student> students;
	private static Scanner scanner;
	public static void main(String[] args) {
		
		System.out.println("************* Student Management System ***************");
        
        
        students = new ArrayList<Student>();
        
        while(true) {
        System.out.println("***************  Welcome ******************************");
        System.out.println("Please select an option....");
        System.out.println("1. Register a student");
        System.out.println("2. Find student with student ID");
        System.out.println("3. List all student information");
        System.out.println("4. List student information in sorted order");
        System.out.println("5. Exit");
        
        scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        
        switch (option) {
		case 1:
			enrollStudent(scanner);
			break;
		case 2:
			findStudentById(scanner);
			break;
		case 3:
			listAllStudentInfo();
			break;
		case 4:
			sortByName();
			break;
		case 5:
			exit();
			break;		
		default:
			System.out.println("Invalid Option!! Please select a number 1 and 5");
			break;
		}
        }

	}
	


	private static void exit() {
		System.out.println("================ Closing Student Management App ==========");
		System.out.println("Closing...............");
		System.exit(0);
		
	}



	private static void findStudentById(Scanner scanner) {
		System.out.println("Enter the student ID: ");
		String studentId = scanner.next();
		try {
		Student result = findStudentById(studentId);
		result.printStudentInfo();
		}catch (NullPointerException e) {
			
		}
		
	}

	private static void enrollStudent(Scanner scanner) {
        System.out.println("Enter student name: ");
        scanner.nextLine();
        String studentName = scanner.nextLine();
        
        System.out.println("Enter student age: ");
        int studentAge = scanner.nextInt();
        
        System.out.println("Enter student ID:  ");
        String studentId = scanner.next();
        
        Student newStudent = new Student(studentName, studentAge, studentId);
        students.add(newStudent);
        
        System.out.println("Student added successfully to the LMS");
        
        while(true) {
	        System.out.println("Choose the course you want to enroll to: [java, DSA, devOps]  or Type 'done' to exit");
	        String courseName = scanner.next();
	        if(courseName.equalsIgnoreCase("done")) {
	        	break;
	        }
	        newStudent.enrollCourse(courseName);
        
        }
        newStudent.printStudentInfo();
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
	
	public static void listAllStudentInfo() {
		if(students.size() > 0) {
		System.out.println("============= List of all student details ================");
		students.stream().forEach(student -> student.printStudentInfo());
		}
		else {
			System.err.println("Student list is empty!! No records found!!");
		}
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
		listAllStudentInfo();
	}
	
	
	

}
