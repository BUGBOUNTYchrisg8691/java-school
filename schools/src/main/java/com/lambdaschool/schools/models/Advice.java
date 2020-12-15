package com.lambdaschool.schools.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Advice.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Advice
{
	private int total_results;
	private String query;
	private List<Slip> slips = new ArrayList<>();
	
	/**
	 * Gets total results.
	 *
	 * @return the total results
	 */
	public int getTotal_results()
	{
		return total_results;
	}
	
	/**
	 * Sets total results.
	 *
	 * @param total_results the total results
	 */
	public void setTotal_results(int total_results)
	{
		this.total_results = total_results;
	}
	
	/**
	 * Gets query.
	 *
	 * @return the query
	 */
	public String getQuery()
	{
		return query;
	}
	
	/**
	 * Sets query.
	 *
	 * @param query the query
	 */
	public void setQuery(String query)
	{
		this.query = query;
	}
	
	/**
	 * Gets slips.
	 *
	 * @return the slips
	 */
	public List<Slip> getSlips()
	{
		return slips;
	}
	
	/**
	 * Sets slips.
	 *
	 * @param slips the slips
	 */
	public void setSlips(List<Slip> slips)
	{
		this.slips = slips;
	}
	
	@Override public String toString()
	{
		return "Advice{" +
				"total_results=" + total_results +
				", query='" + query + '\'' +
				", slips=" + slips +
				'}';
	}
}
