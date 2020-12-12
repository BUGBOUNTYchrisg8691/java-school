package com.lambdaschool.schools.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorDetail
{
	private String title;
	private int status;
	private Date timestamp;
	private String devMessage;
	private List<ValidationError> validationErrors = new ArrayList<>();
	
	public ErrorDetail()
	{
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public int getStatus()
	{
		return status;
	}
	
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	public Date getTimestamp()
	{
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp)
	{
		this.timestamp = timestamp;
	}
	
	public String getDevMessage()
	{
		return devMessage;
	}
	
	public void setDevMessage(String devMessage)
	{
		this.devMessage = devMessage;
	}
	
	public List<ValidationError> getValidationErrors()
	{
		return validationErrors;
	}
	
	public void setValidationErrors(List<ValidationError> validationErrors)
	{
		this.validationErrors = validationErrors;
	}
}
