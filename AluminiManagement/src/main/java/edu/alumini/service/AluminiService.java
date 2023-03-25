package edu.alumini.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.alumini.dto.AluminiDTO;
import edu.alumini.entity.Alumini;

@Component
public interface AluminiService 
{//Interface method are implicitly public but class methods are not implicitly public
	
	//Get all record
	List<Alumini> getAllAlumini();
	
	//create new Alumni using aluminiDTO
	Alumini createAlumini(AluminiDTO aluminiDTO);
	
	//update Alumni information using ID
	Alumini updateAlumini(int id, AluminiDTO aluminiDTO);

	//display a particular Alumni info using ID
	Alumini getAllAluminiById(int id);
	
	//display a particular Alumni info using name
	List<Alumini> findByNameContaining(String name);
	
	//display a particular Alumni info using graduation year
	List<Alumini> findByGraduationYear(String year);
	
	//delete Alumni using ID 
	String deleteAlumini(int id );
	
}
