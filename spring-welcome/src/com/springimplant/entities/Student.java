package com.springimplant.entities;

import com.springimplant.interfaces.Cheat;

public class Student {

	private int id;
	private String studentName;
	private Cheating cheat;
	private Cheat cheatingInterface;

	public Cheating getCheat() {
		return cheat;
	}

	public void setCheat(Cheating cheat) {
		this.cheat = cheat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void cheating()
	{
		cheat.mathCheat();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + "]";
	}

	public Cheat getCheatingInterface() {
		return cheatingInterface;
	}

	public void setCheatingInterface(Cheat cheatingInterface) {
		this.cheatingInterface = cheatingInterface;
	}
	
}
