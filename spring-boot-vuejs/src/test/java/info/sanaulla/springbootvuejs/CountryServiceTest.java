package info.sanaulla.springbootvuejs;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import info.sanaulla.service.CountryService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CountryServiceTest {

	@Autowired CountryService countryService;
	
	@Test
	public void test_getCountriesAsCustomMap(){
		List<Map<String, String>> countries = countryService.getCountriesAsCustomMap();
		System.out.println(countries.get(0));
	}
	
	@Test
	public void test_getCountriesSortedByLanguages(){
		List<String> countries = countryService.getCountriesSortedByLanguages();
		System.out.println(countries);
	}
}
