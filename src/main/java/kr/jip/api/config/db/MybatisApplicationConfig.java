package kr.jip.api.config.db;

import kr.jip.api.config.db.annotation.JipDB;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "kr.jip.api", annotationClass = JipDB.class, sqlSessionFactoryRef = "jipSqlSessionFactory")
public class MybatisApplicationConfig {
	@Bean("jipSqlSessionFactory")
	public SqlSessionFactory jipSqlSessionFactory(@Qualifier("jipDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setTypeAliasesPackage("kr.jip.api.model");
		sessionFactoryBean.setConfigLocation(pathResolver.getResource("classpath:mybatis/MybatisConfiguration.xml"));
//		sessionFactoryBean.setMapperLocations(pathResolver.getResources("classpath:**/*Mapper.xml"));
		sessionFactoryBean.setVfs(SpringBootVFS.class);
		return sessionFactoryBean.getObject();
	}

}
