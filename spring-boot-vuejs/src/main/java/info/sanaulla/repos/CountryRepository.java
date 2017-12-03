package info.sanaulla.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import info.sanaulla.model.Country;

public interface CountryRepository extends JpaRepository<Country, String>{

}
