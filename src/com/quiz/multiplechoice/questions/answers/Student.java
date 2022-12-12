package com.quiz.multiplechoice.questions.answers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Student {

	public void getStudentDetails(String name, int score, String grade) {
		ConnectionStud st = new ConnectionStud();
		try {

			Connection con = st.getConnectionDetails();
			PreparedStatement ps = con
					.prepareStatement("insert into studentquiz (stud_name,stud_score,stud_grade) values (?,?,?)");
			ps.setString(1, name);
			ps.setInt(2, score);
			ps.setString(3, grade);
			int rs = ps.executeUpdate();

			// while(rs.next()) {
			// PreparedStatement ps1=con.prepareStatement("insert into studentquiz
			// (stud_name,stud_score,stud_grade) values (?,?,?)");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Student s = new Student();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name =");
		String name = sc.next();
		System.out.println("Enter score =");
		int score = sc.nextInt();
		System.out.println("Enter grade =");
		String grade = sc.next();
		s.getStudentDetails(name, score, grade);
	}
}
