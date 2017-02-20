package com.yiwen.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yiwen.common.service.CrudService;
import com.yiwen.service.mapper.SysDicFieldsDao;
import com.yiwen.service.model.SysDicFields;

/***
 * 
 * @author szhao
 *
 */
@Service
@Transactional(readOnly = false)
public class SysDicFieldsService extends CrudService<SysDicFieldsDao, SysDicFields> {
	
	@Autowired
	private SysDicFieldsDao sysDicFieldsDao;
	

}
