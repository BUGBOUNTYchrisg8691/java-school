package com.lambdaschool.schools.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * The type Slip.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Slip
{
	private int id;
	private String advice;
	private Date date;
	
	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
	/**
	 * Gets advice.
	 *
	 * @return the advice
	 */
	public String getAdvice()
	{
		return advice;
	}
	
	/**
	 * Sets advice.
	 *
	 * @param advice the advice
	 */
	public void setAdvice(String advice)
	{
		this.advice = advice;
	}
	
	/**
	 * Gets date.
	 *
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}
	
	/**
	 * Sets date.
	 *
	 * @param date the date
	 */
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
