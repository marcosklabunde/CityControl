package com.example.citycontrol.dao.impl;

import com.example.citycontrol.dao.CityDAO;
import com.example.citycontrol.entity.City;
import com.example.citycontrol.filter.FilterData;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("defaultCityDao")
public class CityDAOImpl implements CityDAO
{
	private EntityManager em;

	@Autowired
	public CityDAOImpl(EntityManager em)
	{
		this.em = em;
	}

	@Override
	@Transactional
	public boolean insert(City city)
	{
		try
		{
			em.persist(city);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public City find(Long id)
	{
		return em.find(City.class, id);
	}

	@Override
	public Collection<City> findAll()
	{
		return em.createQuery("SELECT ct FROM City ct", City.class).getResultList();
	}

	@Override
	@Transactional
	public boolean update(City city)
	{
		try
		{
			em.merge(city);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	@Transactional
	public boolean delete(Long id)
	{
		try
		{
			City city = find(id);
			em.remove(city);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public Collection<City> findListByFilter(FilterData filter)
	{
		return em.createQuery("SELECT ct FROM City ct WHERE " + filter.getParams(), City.class)
			.getResultList();
	}

	@Override
	public Collection<Object[]> countByGroup(String propName)
	{
		return em.createQuery(
			"SELECT " + propName + ", count(" + propName + ") FROM City GROUP BY " + propName)
			.getResultList();
	}
}
