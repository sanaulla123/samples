package info.sanaulla.sample;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DBConfiguration {
	
	@Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .generateUniqueName(false)
            .setName("testdb")
            .setType(EmbeddedDatabaseType.H2)
            .addDefaultScripts()
            .setScriptEncoding("UTF-8")
            .ignoreFailedDrops(true)
            .build();
    }
	
	@Bean
	public NamedParameterJdbcTemplate namedParamJdbcTemplate() {
		NamedParameterJdbcTemplate namedParamJdbcTemplate = 
				new NamedParameterJdbcTemplate(dataSource());
		return namedParamJdbcTemplate;
	}
}