package cst438hw2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import cst438hw2.domain.*;

@Service
public class CityService {
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private WeatherService weatherService;
	
	public CityInfo getCityInfo(String cityName) {
     //  TODO  your code goes here
		
		City city;
		Country country;
		TempAndTime temp;
		TempAndTime time;
		
		List<City> cities = cityRepository.findByName(cityName);
		
		if (cities.size() == 0) {
			return null;
		}
		city = cities.get(0);
		country = countryRepository.findByCode(city.getCountryCode());
		temp = weatherService.getTempAndTime(cityName);
		time = weatherService.getTempAndTime(cityName);
		
		/**
		 * The temp needs to convert from Kelvin to Fahrenheit
		 * The time needs to convert to local time
		 */
		CityInfo cityInfo = new CityInfo(city.getId(), city.getName(), city.getCountryCode(), 
				country.getName(), city.getDistrict(), city.getPopulation(),
				temp.temp, time.timeToString());
		
		return cityInfo;
     }
}
