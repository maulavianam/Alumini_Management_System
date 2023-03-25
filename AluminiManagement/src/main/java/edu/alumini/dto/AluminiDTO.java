package edu.alumini.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AluminiDTO 
{
	@NotBlank(message = "Invalid name: Empty name")
	@NotNull(message = "Invalid name: Name is NULL")
	@Size(min = 4, max = 35, message = "Invalid name; Must be of 4-30 characters")
	private String name;
	
	@NotBlank(message = "Invalid Phone Number: Empty Number")
	@NotNull(message = "Invalid Phone Number: number is NULL")
	@Pattern(regexp = "^\\d{10}$", message = "Invalid Phone Number")
	private String phone;
	
	@Email(message = "Invalid Email")
	private String email;
	
	@NotBlank(message = "Invalid year: Empty year")
	@NotNull(message = "Invalid year: Year is NULL")
	private String year;
	
	@NotBlank(message = "Invalid address: Empty address")
	@NotNull(message = "Invalid address: Address is NULL")
	@Size(min = 5, max = 100, message = "Invalid adddress; Must be of 4-99 characters")
	private String address;

	
	

}
