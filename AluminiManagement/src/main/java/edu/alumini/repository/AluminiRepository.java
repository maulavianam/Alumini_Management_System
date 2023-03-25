package edu.alumini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumini.entity.Alumini;

public interface AluminiRepository extends JpaRepository<Alumini, Integer> 
{
	//We use custom boot search methods
	
	List<Alumini> findByNameContaining(String name);
	List<Alumini> findByYear(String year); 
	



}
