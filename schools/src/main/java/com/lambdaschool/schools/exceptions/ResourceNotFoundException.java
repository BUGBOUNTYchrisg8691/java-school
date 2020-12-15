package com.lambdaschool.schools.exceptions;

public class ResourceNotFoundException extends RuntimeException
{
	public ResourceNotFoundException(String message)
	{
		super("Resource Not Found: Exception from Schools app: " + message);
	}
}
