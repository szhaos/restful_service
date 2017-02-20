package com.yiwen.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yiwen.common.persistence.CrudDao;
import com.yiwen.common.persistence.DataEntity;
import com.yiwen.common.persistence.Page;

/**
 * Service基类
 * @author szhao
 * @version 2017-02-18
 */
@Transactional(readOnly = true)
public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity<T>> extends BaseService {
	
	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;
	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id) {
		try {
			return dao.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
	}
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T get(T entity) {
		try {
			return dao.get(entity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
	}
	
	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) {
		try {
			return dao.findList(entity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param entity
	 * @return
	 */
	public Page<T> findPage(Page<T> page, T entity) {
		try {
			entity.setPage(page);
			page.setList(dao.findList(entity));
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
	}

	/**
	 * 删除数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void delete(T entity) {
		try{
			dao.delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}

}
