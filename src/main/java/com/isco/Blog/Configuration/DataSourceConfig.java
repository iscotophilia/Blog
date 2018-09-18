package com.isco.Blog.Configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.isco.Blog.DataSource.DynamicDataSource;

import redis.clients.jedis.JedisPoolConfig;

/**
 * @author sazhijie
 * 2018/9/4
 * 配置mysql的数据源，
 * 使用主从同步
 *
 */
@Configuration
public class DataSourceConfig {
	
	@Value("${spring.datasource.type}")
	private Class < ? extends DataSource> dataSourceType;
	
	@Bean(name = "dataSource")
	public DataSource initDataSource() {
		DynamicDataSource dataSource = new DynamicDataSource();
		Map<Object, Object> map = new HashMap<>();
		map.put("db_master", initMasterDataSource());
		map.put("db_slave", initSlaveDataSource());
		dataSource.setTargetDataSources(map);
		dataSource.setDefaultTargetDataSource(initMasterDataSource());
		return dataSource;
	}
	
	//主数据库配置
	@Bean(name = "masterDataSource")
	@ConfigurationProperties(prefix="datasource.master")
	public DataSource initMasterDataSource() {
		return DataSourceBuilder.create().type(dataSourceType).build();
	}

	//从数据酷配置
	@Bean(name = "slaveDataSource")
	@ConfigurationProperties(prefix="datasource.slave")
	public DataSource initSlaveDataSource() {
		return DataSourceBuilder.create().type(dataSourceType).build();
	}
	
	@Bean
    public DataSourceTransactionManagerAutoConfiguration txManager() {
        return new DataSourceTransactionManagerAutoConfiguration();
    }
	
	@Bean 
	@Autowired
	PlatformTransactionManager initPlamTransaction(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
