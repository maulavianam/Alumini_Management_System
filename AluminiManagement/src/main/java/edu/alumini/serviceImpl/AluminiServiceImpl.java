package edu.alumini.serviceImpl;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.alumini.dto.AluminiDTO;
import edu.alumini.entity.Alumini;
import edu.alumini.exception.UserNotFoundException;
//import edu.alumini.exception.UserNotFoundException;
import edu.alumini.repository.AluminiRepository;
import edu.alumini.service.AluminiService;


@Service
public class AluminiServiceImpl implements AluminiService 
{
	@Autowired
	private AluminiRepository aluminiRepository;

	@Override
	public List<Alumini> getAllAlumini() 
	{
		return aluminiRepository.findAll();
	}

	@Override
	public Alumini createAlumini(AluminiDTO aluminiDTO) 
	{
		Alumini alumini =Alumini.builder().name(aluminiDTO.getName()).phone(aluminiDTO.getPhone()).email(aluminiDTO.getEmail())
				.year(aluminiDTO.getYear()).address(aluminiDTO.getAddress()).build();
		
		return aluminiRepository.save(alumini);
		
	}

	@Override
	public Alumini updateAlumini(int id, AluminiDTO aluminiDTO)  
	{
		Optional <Alumini> adata= aluminiRepository.findById(id);
		if (adata.isPresent())
		{
			Alumini _alumini =aluminiRepository.findById(id).get();
			_alumini.setName(aluminiDTO.getName());
			_alumini.setPhone(aluminiDTO.getPhone());
			_alumini.setEmail(aluminiDTO.getEmail());
			_alumini.setYear(aluminiDTO.getYear());
			_alumini.setAddress(aluminiDTO.getAddress());
			
			return aluminiRepository.save(_alumini);
		}	
		else throw new UserNotFoundException("The User with Id "+id+" not found");
	}

	@Override
	public Alumini getAllAluminiById(int id) 
	{
		return aluminiRepository.findById(id).orElseThrow(() -> new UserNotFoundException("The User with Id "+id+" not found"));
	}

	@Override
	public List<Alumini> findByNameContaining(String name) throws UserNotFoundException
	{
		if(aluminiRepository.findByNameContaining(name).isEmpty())
			throw new UserNotFoundException("The User with name "+name+" not found");
		else
		return aluminiRepository.findByNameContaining(name);
		
	}

	@Override
	public List<Alumini> findByGraduationYear(String year) 
	{
		if(aluminiRepository.findByYear(year).isEmpty())
			throw new UserNotFoundException("The User with the GraduationYear "+year+" not found");
		else
		return aluminiRepository.findByYear(year);
	}

	@Override
	public String deleteAlumini(int id)
	{
		aluminiRepository.deleteById(id);
		return "The student with ID "+id+" has been deleted successfully..";
	}

}
