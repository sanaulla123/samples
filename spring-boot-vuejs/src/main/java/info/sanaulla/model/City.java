package info.sanaulla.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class City {

	@Id
	private Integer id;
	private String name;
	
	/*@ManyToOne
	@JoinColumn(name = "countrycode")*/
	//private Country country;
	private String countrycode;
	
	private String district;
	private Integer population;
}
