package com.example.citycontrol;

import com.example.citycontrol.service.CityService;
import java.io.File;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CityControlApplication
{
	@Autowired
	private CityService cityService;

	public static void main(String[] args)
	{
		SpringApplication.run(CityControlApplication.class, args);
	}

	@PostConstruct
	private void start()
	{
		cityService.importCsv(new File("./data/cidades_desafio_tecnico.csv"));
	}
}
