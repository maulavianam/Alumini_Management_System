package edu.alumini.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="aluminitable")
public class Alumini 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sId")
	private Integer id;
	
	@Column(name="sName", length = 30)
	private String name;
	
	@Column(name="sPhoneNo", length = 20)
	private String phone;
	
	@Column(name="sEmail", length = 50)
	private String email;
	
	@Column(name="sGradutionYear", length = 20)
	private String year;

	@Column(name="sAddress", length = 100)
	private String address;

	public Alumini(String name, String phone, String email, String year, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.year = year;
		this.address = address;
	}


	
	
		
	

}
