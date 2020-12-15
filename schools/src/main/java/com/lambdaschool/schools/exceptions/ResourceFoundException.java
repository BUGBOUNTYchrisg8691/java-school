package com.lambdaschool.schools.exceptions;

public class ResourceFoundException extends RuntimeException
{
	public ResourceFoundException(String message)
	{
		super("Resource found: Exception from Schools App: " + message);
	}
}
