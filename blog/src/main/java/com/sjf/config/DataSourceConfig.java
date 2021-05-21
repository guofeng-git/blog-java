package com.sjf.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据库配置
 * 
 * @author guofeng
 *
 */
@Configuration
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionTemplateRef = "sqlSessionTemplate")
public class DataSourceConfig {

	static final String PACKAGE = "com.sjf.dao";

	private static final String MAPPER_LOCATION = "classpath:conf/mybatis/mapper/mysql/*.xml";

	@Value("${datasource.druid.filters}")
	private String filters;
	@Value("${datasource.druid.url}")
	private String url;
	@Value("${datasource.druid.username}")
	private String username;
	@Value("${datasource.druid.password}")
	private String password;
	@Value("${datasource.druid.driverClassName}")
	private String driverClassName;
	@Value("${datasource.druid.initialSize}")
	private int initialSize;
	@Value("${datasource.druid.minIdle}")
	private int minIdle;
	@Value("${datasource.druid.maxActive}")
	private int maxActive;
	@Value("${datasource.druid.maxWait}")
	private long maxWait;
	@Value("${datasource.druid.timeBetweenEvictionRunsMillis}")
	private long timeBetweenEvictionRunsMillis;
	@Value("${datasource.druid.minEvictableIdleTimeMillis}")
	private long minEvictableIdleTimeMillis;
	@Value("${datasource.druid.validationQuery}")
	private String validationQuery;
	@Value("${datasource.druid.testWhileIdle}")
	private boolean testWhileIdle;
	@Value("${datasource.druid.testOnBorrow}")
	private boolean testOnBorrow;
	@Value("${datasource.druid.testOnReturn}")
	private boolean testOnReturn;
	@Value("${datasource.druid.poolPreparedStatements}")
	private boolean poolPreparedStatements;
	@Value("${datasource.druid.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;

	@Bean(name = "DataSource")
	@ConfigurationProperties(prefix = "datasource.druid")
	public DataSource dataSource() throws SQLException {

		DruidDataSource druid = new DruidDataSource();

		// 监控统计拦截的filters
		druid.setFilters(filters);

		// 配置基本属性
		druid.setDriverClassName(driverClassName);
		druid.setUsername(username);
		druid.setPassword(password);
		druid.setUrl(url);

		// 初始化时建立物理连接的个数
		druid.setInitialSize(initialSize);
		// 最大连接池数量
		druid.setMaxActive(maxActive);
		// 最小连接池数量
		druid.setMinIdle(minIdle);
		// 获取连接时最大等待时间，单位毫秒。
		druid.setMaxWait(maxWait);
		// 间隔多久进行一次检测，检测需要关闭的空闲连接
		druid.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		// 一个连接在池中最小生存的时间
		druid.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		// 用来检测连接是否有效的sql
		druid.setValidationQuery(validationQuery);
		// 建议配置为true，不影响性能，并且保证安全性。
		druid.setTestWhileIdle(testWhileIdle);
		// 申请连接时执行validationQuery检测连接是否有效
		druid.setTestOnBorrow(testOnBorrow);
		druid.setTestOnReturn(testOnReturn);
		// 是否缓存preparedStatement，也就是PSCache，oracle设为true，mysql设为false。分库分表较多推荐设置为false
		druid.setPoolPreparedStatements(poolPreparedStatements);
		// 打开PSCache时，指定每个连接上PSCache的大小
		druid.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);

		return druid;
	}

	@Bean(name = "TransactionManager")
	public DataSourceTransactionManager accTransactionManager() throws SQLException {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean(name = "SqlSessionFactory")
	public SqlSessionFactory SqlSessionFactory(@Qualifier("DataSource") DataSource dataSource) throws Exception {

		final SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceConfig.MAPPER_LOCATION));
		return bean.getObject();
	}

	@Bean(name = "sqlSessionTemplate")
	public SqlSessionTemplate SqlSessionTemplate(@Qualifier("SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
