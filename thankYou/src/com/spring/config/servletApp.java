package com.spring.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.database.boardMapper;

@Configuration

@EnableWebMvc

@ComponentScan("com.spring.controller")
@ComponentScan("com.spring.dao")
@ComponentScan("com.spring.service")

@PropertySource("WEB-INF/properties/db.properties")
public class servletApp implements WebMvcConfigurer{

	//프로퍼티로부터 주입받는 작업
	@Value("oracle.jdbc.OracleDriver")
	private String db_classname;
	@Value("jdbc:oracle:thin:@localhost:1521:xe")
	private String db_url;
	@Value("sys as sysdba")
	private String db_username;
	@Value("sakura37")
	private String db_password;
	
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	//BasicDataSource -> DB 접속 정보 관리
		@Bean
		public BasicDataSource dataSource() {
			BasicDataSource source=new BasicDataSource();
			source.setDriverClassName(db_classname);
			source.setUrl(db_url);
			source.setUsername(db_username);
			source.setPassword(db_password);
			return source;
		}
		//DB 연결, SQL 실행에 대한 객체, BasicDataSource 참조해서 mybatis와 db서버 연동
		@Bean
		public SqlSessionFactory factory(BasicDataSource source) throws Exception{
			SqlSessionFactoryBean fac=new SqlSessionFactoryBean();
			fac.setDataSource(source);
			SqlSessionFactory sqf=fac.getObject();
			return sqf;
		}
		
		//쿼리문 실행 위한 객체
		@Bean
		public MapperFactoryBean<boardMapper> mba(SqlSessionFactory factory) throws Exception{
			MapperFactoryBean<boardMapper> fac=new MapperFactoryBean<boardMapper>(boardMapper.class);
			fac.setSqlSessionFactory(factory);
			return fac;
		}
	
	
}
