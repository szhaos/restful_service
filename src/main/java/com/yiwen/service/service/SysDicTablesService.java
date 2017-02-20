package com.yiwen.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yiwen.common.service.CrudService;
import com.yiwen.service.mapper.SysDicTablesDao;
import com.yiwen.service.model.SysDicTables;

/***
 * 
 * @author szhao
 *
 */
@Service
@Transactional(readOnly = false)
public class SysDicTablesService extends CrudService<SysDicTablesDao, SysDicTables> {
	
	@Autowired
	private SysDicTablesDao sysDicTablesDao;
	

}
