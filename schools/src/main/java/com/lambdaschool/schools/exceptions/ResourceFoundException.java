package com.lambdaschool.schools.exceptions;

/**
 * The type Resource found exception.
 */
public class ResourceFoundException extends RuntimeException
{
	/**
	 * Instantiates a new Resource found exception.
	 *
	 * @param message the message
	 */
	public ResourceFoundException(String message)
	{
		super("Resource found: Exception from Schools App: " + message);
	}
}
