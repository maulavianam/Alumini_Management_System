package edu.alumini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.alumini.dto.AluminiDTO;
import edu.alumini.entity.Alumini;
import edu.alumini.service.AluminiService;


@RestController
@RequestMapping("/api")
public class AluminiController 
{
	@Autowired
	private AluminiService aluminiService;
	
	
	// Getting all existing alumini
	@GetMapping("/studs")
	public ResponseEntity<List<Alumini>> fetchAllAlumini()
	{
		List<Alumini> alumini=aluminiService.getAllAlumini();
		return ResponseEntity.ok(alumini);
	}
	
	
	// Adding new student
	@PostMapping("/stud")
	public ResponseEntity<Alumini> createAlumini(@RequestBody @Valid AluminiDTO a)
	{
		Alumini al = aluminiService.createAlumini(a);
		return new ResponseEntity<>(al, HttpStatus.CREATED);
		
	}
	
	
	//updating student information
	@PutMapping("/stud/{id}")
	public ResponseEntity<Alumini> updateAlumini(@PathVariable("id") int id, @RequestBody AluminiDTO aluminiDTO)
	{
		aluminiService.updateAlumini(id, aluminiDTO);
		return ResponseEntity.ok().body(aluminiService.updateAlumini(id, aluminiDTO));
	}
	
	
	//display student by id
	@GetMapping("/stud/{id}")
	public ResponseEntity<Alumini> getAllAluminiById(@PathVariable int id)
	{
		return ResponseEntity.ok().body(aluminiService.getAllAluminiById(id));
	}
	
	
	//display a student by name
	@GetMapping("/stname")
	public ResponseEntity<List<Alumini>> getStudentByStd_Name(@RequestParam(required = false) String name)
	{
		List<Alumini> alumini=aluminiService.findByNameContaining(name);
		return ResponseEntity.ok(alumini);
	}
	
	
	//display a student by graduation year
	@GetMapping("/styear")
	public ResponseEntity<List<Alumini>> findByGraduationYear(@RequestParam(required = false) String year)
	{
		List<Alumini> alumini=aluminiService.findByGraduationYear(year);
		return ResponseEntity.ok(alumini);
	}
	
	
	//deleting a student record by id
	@DeleteMapping("/stud/{id}")
	public ResponseEntity<Alumini> deleteAlumini(@PathVariable int id)
	{
		aluminiService.deleteAlumini(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}











