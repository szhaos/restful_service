package com.yiwen.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yiwen.common.service.CrudService;
import com.yiwen.service.mapper.SysDictionariesDao;
import com.yiwen.service.model.SysDictionaries;

/***
 * 
 * @author szhao
 *
 */
@Service
@Transactional(readOnly = false)
public class SysDictionariesService extends CrudService<SysDictionariesDao, SysDictionaries> {
	
	@Autowired
	private SysDictionariesDao dao;
	

}
