package com.lambdaschool.schools.models;

/**
 * The type Validation error.
 */
public class ValidationError
{
	private String code;
	private String message;
	
	/**
	 * Instantiates a new Validation error.
	 */
	public ValidationError()
	{
	}
	
	/**
	 * Instantiates a new Validation error.
	 *
	 * @param code    the code
	 * @param message the message
	 */
	public ValidationError(String code, String message)
	{
		this.code = code;
		this.message = message;
	}
	
	/**
	 * Gets code.
	 *
	 * @return the code
	 */
	public String getCode()
	{
		return code;
	}
	
	/**
	 * Sets code.
	 *
	 * @param code the code
	 */
	public void setCode(String code)
	{
		this.code = code;
	}
	
	/**
	 * Gets message.
	 *
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}
	
	/**
	 * Sets message.
	 *
	 * @param message the message
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}
}
