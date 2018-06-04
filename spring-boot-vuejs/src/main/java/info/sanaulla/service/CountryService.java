package info.sanaulla.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import info.sanaulla.model.Country;
import info.sanaulla.repos.CountryMapper;
import info.sanaulla.repos.CountryRepository;

@Service
public class CountryService {
	@Autowired CountryRepository countryRepo;
	@Autowired CountryMapper countryMapper;
	
	public List<String> getContinents(){
		return countryMapper.getContinents();
	}
	
	public List<String> getRegions(){
		return countryMapper.getRegions();
	}
	
	public List<Country> getCountries(Map<String, Object> params, Pageable pageable){
		return countryMapper.getCountries(params,  new RowBounds(pageable.getOffset(), pageable.getPageSize()));
	}
	
	public Integer getCountriesCount(Map<String, Object> params){
		return countryMapper.getCountriesCount(params);
	}
	
	public List<Map<String, String>> getCountriesAsCustomMap(){
		return countryMapper.getCountriesAsCustomMap();
	}
	
	public List<String> getCountriesSortedByLanguages(){
		return countryMapper.getCountriesSortedByLanguages();
	}
}
