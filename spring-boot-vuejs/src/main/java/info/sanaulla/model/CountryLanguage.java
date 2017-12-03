package info.sanaulla.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class CountryLanguage implements Serializable{

	@Id
	@ManyToOne
	private Country country;
	@Id
	private String language;
	
	private Boolean isofficial;
	private Double percentage;
}
