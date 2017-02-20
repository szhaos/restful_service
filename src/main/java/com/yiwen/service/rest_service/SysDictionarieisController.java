package com.yiwen.service.rest_service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.jersey.api.spring.Autowire;
import com.yiwen.common.persistence.BaseController;
import com.yiwen.service.model.SysDictionaries;
import com.yiwen.service.service.SysDictionariesService;


@Autowire
@Path("sysdictionaries")
public class SysDictionarieisController  extends BaseController {
	
	@Autowired
	private SysDictionariesService sysDictionariesService;
	

	/**
	 * 主键查询,查询详情
	 * 测试地址：http://localhost:8080/api/v1/sysdictionaries/r_sysdictionaries/1
	 * @param id
	 * @return
	 */
	@GET
	@Path("/r_sysdictionaries/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String r_sysdictionaries(@PathParam("id") String id){
		
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			SysDictionaries sysDictionaries=sysDictionariesService.get(id);
			map.put("code", 0);
			map.put("message", "successful");
			map.put("data", sysDictionaries);
			
		} catch (Exception e) {
			map.put("code", -1);
			map.put("message", "unsuccessful");
		}
		return tojson(map);
	}
	
	
	/**
	 * 条件查询,查询符合条件的集合
	 * 测试地址：http://localhost:8080/api/v1/sysdictionaries/r_sysdictionaries_list?table_name=goods&field_name=category
	 * @param table_name
	 * @param field_name
	 * @return
	 */
	@GET
	@Path("/r_sysdictionaries_list")
	@Produces(MediaType.TEXT_PLAIN)
	public String r_sysdictionaries_list(
			@QueryParam("table_name") String table_name,
			@QueryParam("field_name") String field_name,
			@QueryParam("key") Integer key){
		
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			SysDictionaries sysDictionaries=new SysDictionaries();
			sysDictionaries.setTableName(table_name);
			sysDictionaries.setFieldName(field_name);
			sysDictionaries.setKey(key);
			List<SysDictionaries> list=sysDictionariesService.findList(sysDictionaries);
			map.put("code", 0);
			map.put("message", "successful");
			map.put("data", list);
			
		} catch (Exception e) {
			map.put("code", -1);
			map.put("message", "unsuccessful");
		}
		return tojson(map);
	}

	
}
