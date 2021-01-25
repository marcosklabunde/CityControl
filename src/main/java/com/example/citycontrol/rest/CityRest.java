package com.example.citycontrol.rest;

import com.example.citycontrol.entity.City;
import com.example.citycontrol.filter.CityFilterData;
import com.example.citycontrol.service.CityService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:8081"})
@RequestMapping("rest/cities")
@RestController
public class CityRest
{
	private CityService cityService;

	@Autowired
	public CityRest(CityService cityService)
	{
		this.cityService = cityService;
	}

	@PostMapping
	public void addCity(@RequestBody City city)
	{
		cityService.addCity(city);
	}

	@PutMapping
	public void updateCity(@RequestBody City city)
	{
		cityService.updateCity(city);
	}

	@DeleteMapping("{id}")
	public void removeCity(@PathVariable("id") Long id)
	{
		cityService.removeCity(id);
	}

	@GetMapping("{id}")
	public City getCity(@PathVariable("id") Long id)
	{
		return cityService.getCity(id);
	}

	@GetMapping
	public Collection<City> getAllCities()
	{
		return cityService.getAllCities();
	}

	@PutMapping("filter")
	public Collection<City> getCitiesByFilter(@RequestBody CityFilterData filterData)
	{
		return cityService.getCitiesByFilter(filterData);
	}
}
