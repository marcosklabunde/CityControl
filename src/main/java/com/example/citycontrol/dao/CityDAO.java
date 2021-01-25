package com.example.citycontrol.dao;

import com.example.citycontrol.entity.City;
import com.example.citycontrol.filter.FilterData;
import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;

public interface CityDAO
{
	boolean insert(City city);

	@Transactional
	default boolean insert(List<City> cities)
	{
		try
		{
			cities.forEach(this::insert);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}

	City find(Long id);

	Collection<City> findAll();

	boolean update(City city);

	boolean delete(Long id);

	Collection<City> findListByFilter(FilterData filter);

	Collection<Object[]> countByGroup(String propName);
}
