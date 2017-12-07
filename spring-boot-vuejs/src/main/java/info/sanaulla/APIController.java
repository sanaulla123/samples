package info.sanaulla;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.sanaulla.model.Country;
import info.sanaulla.repos.CountryRepository;
import info.sanaulla.service.CountryService;

@RestController
@RequestMapping("/api")
public class APIController {
	
	@Autowired CountryRepository countryRepo;
	@Autowired CountryService countryService;
	
	@GetMapping("/countries")
	public Page<Country> getCountries(Pageable pageable, 
		@RequestParam(name="search", required=false, defaultValue="") String search,
		@RequestParam(name="continent", required=false, defaultValue="") String continent,
		@RequestParam(name="region", required=false, defaultValue="") String region){

		Map<String, Object> params = new HashMap<>();
		params.put("search", search);
		params.put("continent", continent);
		params.put("region", region);
		Integer totalElements = countryService.getCountriesCount(params);
		List<Country> content = countryService.getCountries(params, pageable);
		Page<Country> page = new PageImpl<Country>(content, pageable, totalElements);
		
		return page;
	}
}
