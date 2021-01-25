package com.example.citycontrol.util;

import com.example.citycontrol.entity.City;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil
{
	private static final String COLUMN_SEPARATOR = ";";

	public static List<City> parseCities(File csv)
	{
		List<City> cities = new ArrayList<>();

		try
		{
			String row;
			FileReader fileReader = new FileReader(csv);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((row = bufferedReader.readLine()) != null)
			{
				String[] col = row.split(COLUMN_SEPARATOR);

				if (col[0].equalsIgnoreCase("ibge"))
					continue;

				cities.add(new City(Long.parseLong(col[0]), col[1], col[2],
					Long.parseLong(col[3].replaceAll("\\.", "")),
					Long.parseLong(col[4].replaceAll("\\.", "")), col[5]));
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return cities;
	}
}
