package com.lambdaschool.schools.services;

import com.lambdaschool.schools.exceptions.ResourceNotFoundException;
import com.lambdaschool.schools.models.Instructor;
import com.lambdaschool.schools.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "instructorService")
public class InstructorServiceImpl implements InstructorService
{
	@Autowired
	InstructorRepository instructrepos;
	
	@Override public Instructor findInstructorById(long id)
	{
		return instructrepos.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor " + id + " not found"));
	}
}
