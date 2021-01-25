package com.example.citycontrol.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityFilterData implements FilterData
{
	@JsonProperty("ibge")
	private Long ibge;

	@JsonProperty("uf")
	private String uf;

	@JsonProperty("name")
	private String name;

	@JsonProperty("nameLike")
	private String nameLike;

	@JsonProperty("region")
	private String region;

	public CityFilterData()
	{
	}

	@Override
	public String getParams()
	{
		StringBuilder builder = new StringBuilder("1 = 1 ");

		if (ibge != null)
		{
			builder.append(" AND ibge = ").append(ibge);
		}
		if (uf != null && !uf.isBlank())
		{
			builder.append(" AND uf LIKE '").append(uf).append("'");
		}
		if (name != null && !name.isBlank())
		{
			builder.append(" AND name LIKE '").append(name).append("'");
		}
		if (nameLike != null && !nameLike.isBlank())
		{
			builder.append(" AND name LIKE '%").append(nameLike).append("%'");
		}
		if (region != null && !region.isBlank())
		{
			builder.append(" AND region LIKE '").append(region).append("'");
		}

		return builder.toString();
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

	public String getNameLike()
	{
		return nameLike;
	}

	public void setNameLike(String nameLike)
	{
		this.nameLike = nameLike;
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
