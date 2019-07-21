package com.springimplant.entities;

import com.springimplant.interfaces.Cheat;

public class ScienceCheat implements Cheat
{
	@Override
	public void cheating() {
		System.out.println("I am cheating in Science");
	}
}
