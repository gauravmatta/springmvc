package com.springimplant.connectionpooling.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Setting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "springimplant")
@Setting(shards = 2)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private int age;
}
