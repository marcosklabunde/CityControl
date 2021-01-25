package com.example.citycontrol.rest;

import com.example.citycontrol.service.CityService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:8081"})
@RequestMapping("rest/report")
@RestController
public class ReportRest
{
	private CityService cityService;

	@Autowired
	public ReportRest(CityService cityService)
	{
		this.cityService = cityService;
	}

	@GetMapping("{propName}")
	public Collection<Object[]> countCitiesByGroup(@PathVariable String propName)
	{
		return cityService.countCitiesByGroup(propName);
	}
}
