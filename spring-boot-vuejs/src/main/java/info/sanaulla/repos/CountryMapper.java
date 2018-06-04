package info.sanaulla.repos;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import info.sanaulla.model.Country;

@Mapper
public interface CountryMapper{

	@Select("SELECT DISTINCT continent FROM country ORDER BY 1")
	public List<String> getContinents();
	
	@Select("SELECT DISTINCT region FROM country ORDER BY 1")
	public List<String> getRegions();
	
	public List<Country> getCountries(Map<String, Object> params, RowBounds bounds);
	
	public Integer getCountriesCount(Map<String, Object> params);
	
	public List<Map<String, String>> getCountriesAsCustomMap();
	
	public List<String> getCountriesSortedByLanguages();
}
