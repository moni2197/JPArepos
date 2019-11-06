package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity

public class Student implements Serializable{
	@Id
	@Column(name="Roll_no")
	private int rollNumber;
	@Column(name="student_name")
	private String studentName;
	@Column(name="avg_score")
	private double avgScore;
	
	public Student()
	{
		
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", studentName=" + studentName + ", avgScore=" + avgScore + "]";
	}

	public Student(int rollNumber, String studentName, double avgScore) {
		super();
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.avgScore = avgScore;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}
	
	
}
