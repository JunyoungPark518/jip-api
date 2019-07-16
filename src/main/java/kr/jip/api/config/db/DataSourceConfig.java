package kr.jip.api.config.db;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
	
	@Bean("jipDataSource")
	@Primary
	@ConfigurationProperties(prefix = "datasource.db-jip")
	public DataSource applicationDataSource() {
		return DataSourceBuilder.create().build();
	}

}