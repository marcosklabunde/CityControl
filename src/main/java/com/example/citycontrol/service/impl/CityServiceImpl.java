package com.example.citycontrol.service.impl;

import com.example.citycontrol.dao.CityDAO;
import com.example.citycontrol.entity.City;
import com.example.citycontrol.filter.CityFilterData;
import com.example.citycontrol.service.CityService;
import com.example.citycontrol.util.CSVUtil;
import java.io.File;
import java.util.Collection;
import javax.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService
{
	private final CityDAO cityDAO;

	@Autowired
	public CityServiceImpl(@Qualifier("defaultCityDao") CityDAO cityDAO)
	{
		this.cityDAO = cityDAO;
	}

	@Override
	public boolean addCity(City city)
	{
		validateUniqueNameAndUf(city);
		return cityDAO.insert(city);
	}

	@Override
	public boolean removeCity(Long id)
	{
		return cityDAO.delete(id);
	}

	@Override
	public boolean updateCity(City city)
	{
		validateUniqueNameAndUf(city);
		return cityDAO.update(city);
	}

	@Override
	public City getCity(Long id)
	{
		return cityDAO.find(id);
	}

	@Override
	public Collection<City> getAllCities()
	{
		return cityDAO.findAll();
	}

	@Override
	public Collection<City> getCitiesByFilter(CityFilterData filterData)
	{
		return cityDAO.findListByFilter(filterData);
	}

	@Override
	public void importCsv(File csv)
	{
		cityDAO.insert(CSVUtil.parseCities(csv));
	}

	private void validateUniqueNameAndUf(City city)
	{
		CityFilterData filterData = new CityFilterData();
		filterData.setName(city.getName());
		filterData.setUf(city.getUf());

		if (!getCitiesByFilter(filterData).isEmpty())
			throw new PersistenceException("Já existe uma cidade cadastrada com o mesmo nome e UF!");
	}

	@Override
	public Collection<Object[]> countCitiesByGroup(String propName)
	{
		return cityDAO.countByGroup(propName);
	}
}
