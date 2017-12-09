package info.sanaulla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String code;
	private String name;
	private String continent;
	private String region;
	
	private Double surfacearea;
	/*
	 *  indepyear smallint,
    population integer NOT NULL,
    lifeexpectancy real,
    gnp numeric(10,2),
    gnpold numeric(10,2),
    localname text NOT NULL,
    governmentform text NOT NULL,
    headofstate text,
    capital integer,
	 */
	private Integer indepyear;
	private Integer population;
	
	@Column(name="lifeexpectancy")
	private Double lifeExpectancy;
	
	@OneToOne()
	@JoinColumn(name = "capital" )
	private City capital;
	
}
