package com.springimplant.entities;

public class Pupil {
	
	private Cheating cheat;
	
	public Cheating getCheat() {
		return cheat;
	}

	public void setCheat(Cheating cheat) {
		this.cheat = cheat;
	}

	public void startCheating()
	{
		cheat.mathCheat();
	}
	
	@Override
	public String toString() {
		return "Pupil [cheat=" + cheat + "]";
	}

}
