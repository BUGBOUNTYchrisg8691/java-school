package com.lambdaschool.schools.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Slip
{
	private int id;
	private String advice;
	private Date date;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getAdvice()
	{
		return advice;
	}
	
	public void setAdvice(String advice)
	{
		this.advice = advice;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public void setDate(Date date)
	{
		this.date = date;
	}
	
	@Override public String toString()
	{
		return "Slip{" +
				"id=" + id +
				", advice='" + advice + '\'' +
				", date=" + date +
				'}';
	}
}
