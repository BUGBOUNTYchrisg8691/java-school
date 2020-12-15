package com.lambdaschool.schools.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Error detail.
 */
public class ErrorDetail
{
	private String title;
	private int status;
	private String detail;
	private Date timestamp;
	private String developerMessage;
	private List<ValidationError> errors = new ArrayList<>();
	
	/**
	 * Instantiates a new Error detail.
	 */
	public ErrorDetail()
	{
	}
	
	/**
	 * Gets title.
	 *
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Sets title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/**
	 * Gets status.
	 *
	 * @return the status
	 */
	public int getStatus()
	{
		return status;
	}
	
	/**
	 * Sets status.
	 *
	 * @param status the status
	 */
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	/**
	 * Gets detail.
	 *
	 * @return the detail
	 */
	public String getDetail()
	{
		return detail;
	}
	
	/**
	 * Sets detail.
	 *
	 * @param detail the detail
	 */
	public void setDetail(String detail)
	{
		this.detail = detail;
	}
	
	/**
	 * Gets timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp()
	{
		return timestamp;
	}
	
	/**
	 * Sets timestamp.
	 *
	 * @param timestamp the timestamp
	 */
	public void setTimestamp(Date timestamp)
	{
		this.timestamp = timestamp;
	}
	
	/**
	 * Gets developer message.
	 *
	 * @return the developer message
	 */
	public String getDeveloperMessage()
	{
		return developerMessage;
	}
	
	/**
	 * Sets developer message.
	 *
	 * @param developerMessage the developer message
	 */
	public void setDeveloperMessage(String developerMessage)
	{
		this.developerMessage = developerMessage;
	}
	
	/**
	 * Gets errors.
	 *
	 * @return the errors
	 */
	public List<ValidationError> getErrors()
	{
		return errors;
	}
	
	/**
	 * Sets errors.
	 *
	 * @param errors the errors
	 */
	public void setErrors(List<ValidationError> errors)
	{
		this.errors = errors;
	}
}
