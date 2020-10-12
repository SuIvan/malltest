package cn.com.mall.orm.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"cn.com.mall.orm.mbg.mapper","cn.com.mall.orm.dao"})
public class MyBatisConfig {
}