package com.yiwen.service.mapper;


import org.mybatis.spring.annotation.MapperScan;

import com.yiwen.common.persistence.CrudDao;
import com.yiwen.common.persistence.MyBatisDao;
import com.yiwen.service.model.SysDicTables;

/**
 * DAO接口
 * @author szhao
 * @version 2017-02-18
 */
@MyBatisDao
@MapperScan
public interface SysDicTablesDao extends CrudDao<SysDicTables> {

	
}