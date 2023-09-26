package com.springimplant.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
	private int subjectId;
	private String subjectName;
	private List<Book> books;
}
