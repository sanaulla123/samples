package info.sanaulla.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import info.sanaulla.model.Country;

public interface CountryRepository extends JpaRepository<Country, String>{
	public Page<Country> findByNameContainingOrderByCode(String name, Pageable pageable);
	
}
