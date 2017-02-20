package com.yiwen.common.persistence;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识MyBatis的DAO,方便{@link org.mybatis.spring.mapper.MapperScannerConfigurer}的扫描。 
 * @author szhao
 * @version 2017-2-18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyBatisDao {
	
}