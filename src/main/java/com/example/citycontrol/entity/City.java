package com.example.citycontrol.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "CityIdSeq", sequenceName = "CITY_ID_SEQ", allocationSize = 1)
public class City
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CityIdSeq")
	@JsonProperty("id")
	private Long id;

	@Column(unique = true, nullable = false)
	@JsonProperty("ibge")
	private Long ibge;

	@Column(nullable = false)
	@JsonProperty("uf")
	private String uf;

	@Column(nullable = false)
	@JsonProperty("name")
	private String name;

	@Column(nullable = false)
	@JsonProperty("longitude")
	private Long longitude;

	@Column(nullable = false)
	@JsonProperty("latitude")
	private Long latitude;

	@Column(nullable = false)
	@JsonProperty("region")
	private String region;

	public City()
	{
	}

	public City(Long ibge, String uf, String name, Long longitude, Long latitude, String region)
	{
		this.ibge = ibge;
		this.uf = uf;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.region = region;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getIbge()
	{
		return ibge;
	}

	public void setIbge(Long ibge)
	{
		this.ibge = ibge;
	}

	public String getUf()
	{
		return uf;
	}

	public void setUf(String uf)
	{
		this.uf = uf;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Long getLongitude()
	{
		return longitude;
	}

	public void setLongitude(Long longitude)
	{
		this.longitude = longitude;
	}

	public Long getLatitude()
	{
		return latitude;
	}

	public void setLatitude(Long latitude)
	{
		this.latitude = latitude;
	}

	public String getRegion()
	{
		return region;
	}

	public void setRegion(String region)
	{
		this.region = region;
	}
}
