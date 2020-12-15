package com.lambdaschool.schools.controllers;

import com.lambdaschool.schools.models.Advice;
import com.lambdaschool.schools.models.Instructor;
import com.lambdaschool.schools.models.Slip;
import com.lambdaschool.schools.services.HelperFunctions;
import com.lambdaschool.schools.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Instructor controller.
 */
@RestController
@RequestMapping("/instructors")
public class InstructorController
{
	/**
	 * The Instructor service.
	 */
	@Autowired
	InstructorService instructorService;
	
	/**
	 * The Helper functions.
	 */
	@Autowired
	HelperFunctions helperFunctions;
	
	/**
	 * Gets instructor by id.
	 *
	 * @param id         the id
	 * @param searchTerm the search term
	 * @return the instructor by id
	 */
	@GetMapping(value = "/instructor/{id}/advice/{searchTerm}", produces = "application/json")
	public ResponseEntity<?> getInstructorById(@PathVariable long id, @PathVariable String searchTerm)
	{
		Instructor instructor = instructorService.findInstructorById(id);
		List<Slip> slips = helperFunctions.getAdvicePerInstructor(searchTerm).getSlips();
		
		if (slips.size() > 0)
		{
			instructor.setAdvice(slips.get(0).getAdvice());
		}
		
		return new ResponseEntity<>(instructor, null, HttpStatus.OK);
	}
}
