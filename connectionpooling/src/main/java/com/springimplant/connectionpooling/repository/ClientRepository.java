package com.springimplant.connectionpooling.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.springimplant.connectionpooling.documents.Client;

public interface ClientRepository extends ElasticsearchRepository<Client, String> {

	List<Client> findByFirstName(String firstname);

}
