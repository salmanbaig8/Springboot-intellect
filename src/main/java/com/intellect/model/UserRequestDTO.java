package com.intellect.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor 
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString @EqualsAndHashCode
public class UserRequestDTO {

	private String id;
	private String fName;
	private String lName;
	private String email;
	private Integer pinCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	private Date birthDate;
	private Boolean isActive;
		
}
