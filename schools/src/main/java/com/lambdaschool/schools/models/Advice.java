package com.lambdaschool.schools.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Advice
{
	private int total_results;
	private String query;
	private List<Slip> slips = new ArrayList<>();
	
	public int getTotal_results()
	{
		return total_results;
	}
	
	public void setTotal_results(int total_results)
	{
		this.total_results = total_results;
	}
	
	public String getQuery()
	{
		return query;
	}
	
	public void setQuery(String query)
	{
		this.query = query;
	}
	
	public List<Slip> getSlips()
	{
		return slips;
	}
	
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
