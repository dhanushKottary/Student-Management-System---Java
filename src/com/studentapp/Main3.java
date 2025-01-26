package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main3 {

	private static List<Student> students;
	public static void main(String[] args) {
		
		System.out.println("************* Student Management System ***************");
        System.out.println("***************  Welcome ******************************");
        
        students = new ArrayList<Student>();
        
        Student student1 = new Student("Rohit Sharma", 19, "S-2025001");
        student1.enrollCourse("DevOps");
        student1.enrollCourse("Java");
        
        Student student2 = new Student("Virat Kohli", 22, "S-2025010");
        student2.enrollCourse("DSA");
        student2.enrollCourse("Java");
        
        Student student3 = new Student("M S Dhoni", 35, "S-2025007");
        student3.enrollCourse("DevOps");
        student3.enrollCourse("DSA");
        
        Student student4 = new Student("Ajinkya Rahane", 30, "S-2025045");
        student4.enrollCourse("DSA");
        
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        
//        showStudentList(students);
//        
//        try {
//        Student result = findStudentById("S-2025007");
//        result.printStudentInfo();
//        }
//        catch (NullPointerException e) {
//        	System.err.println("Result of findStudentById is null");
//        }
        
        sortByName();
        showStudentList(students);



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
