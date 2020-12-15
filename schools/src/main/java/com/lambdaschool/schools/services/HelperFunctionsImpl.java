package com.lambdaschool.schools.services;

import com.lambdaschool.schools.models.Advice;
import com.lambdaschool.schools.models.ValidationError;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Helper functions.
 */
@Service(value = "helperFunctions")
public class HelperFunctionsImpl implements HelperFunctions
{
	@Override public List<ValidationError> getConstraintViolation(Throwable cause)
	{
		while (cause != null && !(cause instanceof ConstraintViolationException || cause instanceof MethodArgumentNotValidException))
		{
			cause = cause.getCause();
			
		}
		
		List<ValidationError> veList = new ArrayList<>();
		
		if (cause != null)
		{
			if (cause instanceof ConstraintViolationException)
			{
				ConstraintViolationException ex = (ConstraintViolationException) cause;
				ValidationError newVe = new ValidationError();
				newVe.setCode(ex.getMessage());
				newVe.setMessage(ex.getConstraintName());
				veList.add(newVe);
			} else
			{
				if (cause instanceof MethodArgumentNotValidException)
				{
					MethodArgumentNotValidException ex = (MethodArgumentNotValidException) cause;
					List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
					for (FieldError err : fieldErrors)
					{
						ValidationError newVe = new ValidationError();
						newVe.setCode(err.getField());
						newVe.setMessage(err.getDefaultMessage());
						veList.add(newVe);
					}
				} else
				{
					System.out.println("We have an error in helper functions");
				}
			}
		}
		return veList;
	}
	
	@Override public Advice getAdvicePerInstructor(String searchTerm)
	{
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter conv = new MappingJackson2HttpMessageConverter();
		conv.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		restTemplate.getMessageConverters().add(conv);
		
		String reqUrl = "https://api.adviceslip.com/advice/search/" + searchTerm;
		ParameterizedTypeReference<Advice> respType = new ParameterizedTypeReference<Advice>() {};
		
		ResponseEntity<Advice> respEntity = restTemplate.exchange(reqUrl, HttpMethod.GET, null, respType);
		
		Advice theAdvice = respEntity.getBody();
		
		return theAdvice;
	}
}
