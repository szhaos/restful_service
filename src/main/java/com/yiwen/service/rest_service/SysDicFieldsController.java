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
import com.yiwen.service.model.SysDicFields;
import com.yiwen.service.service.SysDicFieldsService;


@Autowire
@Path("sysdicfields")
public class SysDicFieldsController  extends BaseController {
	
	@Autowired
	private SysDicFieldsService	sysDicFieldsService;

	/**
	 * 主键查询,查询详情
	 * 测试地址：http://localhost:8080/api/v1/sysdicfields/r_sysdicfields/1
	 * @param id
	 * @return
	 */
	@GET
	@Path("/r_sysdicfields/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String r_sysdicfields(@PathParam("id") String id){
		
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			SysDicFields sysDicFields=sysDicFieldsService.get(id);
			map.put("code", 0);
			map.put("message", "successful");
			map.put("data", sysDicFields);
			
		} catch (Exception e) {
			map.put("code", -1);
			map.put("message", "unsuccessful");
		}
		return tojson(map);
	}
	
	
	/**
	 * 条件查询,查询符合条件的集合
	 * 测试地址：http://localhost:8080/api/v1/sysdicfields/r_sysdicfields_list?sysDicTableId=1
	 * @param sysDicTableId
	 * @param name
	 * @param value
	 * @return
	 */
	@GET
	@Path("/r_sysdicfields_list")
	@Produces(MediaType.TEXT_PLAIN)
	public String r_sysdicfields_list(
			@QueryParam("sysDicTableId") String sysDicTableId,
			@QueryParam("name") String name,
			@QueryParam("value") String value){
		
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			SysDicFields sysDicFields=new SysDicFields();
			sysDicFields.setSysDicTableId(sysDicTableId);
			sysDicFields.setName(name);
			sysDicFields.setValue(value);
			List<SysDicFields> list= sysDicFieldsService.findList(sysDicFields);
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
