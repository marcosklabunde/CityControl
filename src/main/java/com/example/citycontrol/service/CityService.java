package com.example.citycontrol.service;

import com.example.citycontrol.entity.City;
import com.example.citycontrol.filter.CityFilterData;
import java.io.File;
import java.util.Collection;

public interface CityService
{
	boolean addCity(City city);

	boolean removeCity(Long id);

	boolean updateCity(City city);

	City getCity(Long id);

	Collection<City> getAllCities();

	Collection<City> getCitiesByFilter(CityFilterData filterData);

	void importCsv(File file);

	Collection<Object[]> countCitiesByGroup(String propName);
}
