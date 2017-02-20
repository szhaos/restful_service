package com.yiwen.service.rest_service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.jersey.api.spring.Autowire;
import com.yiwen.common.persistence.BaseController;
import com.yiwen.common.persistence.Page;
import com.yiwen.service.model.SysDicTables;
import com.yiwen.service.service.SysDicTablesService;


@Autowire
@Path("sysdictables")
public class SysDicTablesController  extends BaseController {
	
	@Autowired
	private SysDicTablesService	sysDicTablesService;
	
	@Context
	HttpServletRequest request;
	 
	@Context
	HttpServletResponse response;

	/**
	 * 主键查询,查询详情
	 * 测试地址：http://localhost:8080/api/v1/sysdictables/r_sysdictables/1
	 * @param id
	 * @return
	 */
	@GET
	@Path("/r_sysdictables/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String r_sysdictionaries(@PathParam("id") String id){
		
		SysDicTables sysDicTables=sysDicTablesService.get(id);
		return tojson(sysDicTables);
	}
	
	
	/**
	 * 条件查询,查询符合条件的集合
	 * 测试地址：http://localhost:8080/api/v1/sysdictables/r_sysdictables_list?value=category
	 * @param name
	 * @param value
	 * @return
	 */
	@GET
	@Path("/r_sysdictables_list")
	@Produces(MediaType.TEXT_PLAIN)
	public String r_sysdictables_list(
			@QueryParam("name") String name,
			@QueryParam("value") String value){
		
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			SysDicTables sysDicTables=new SysDicTables();
			sysDicTables.setName(name);
			sysDicTables.setValue(value);
			List<SysDicTables> list=sysDicTablesService.findList(sysDicTables);
			map.put("code", 0);
			map.put("message", "successful");
			map.put("data", list);
			
		} catch (Exception e) {
			map.put("code", -1);
			map.put("message", "unsuccessful");
		}
		return tojson(map);
	}
	
	
	/**
	 * 条件查询	分页查询
	 * 测试地址：http://localhost:8080/api/v1/sysdictables/rp_sysdictables_list?pageNo=5&pageSize=10
	 * @param name
	 * @param value
	 * @return
	 */
	@GET
	@Path("/rp_sysdictables_list")
	@Produces(MediaType.TEXT_PLAIN)
	public String rp_sysdictables_list(
			@QueryParam("name") String name,
			@QueryParam("value") String value,
			@QueryParam("pageNo") Integer pageNo,
			@QueryParam("pageSize") Integer pageSize){
		
		SysDicTables sysDicTables=new SysDicTables();
		sysDicTables.setName(name);
		sysDicTables.setValue(value);
		Page<SysDicTables> page=new Page<SysDicTables>(request, response);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page = sysDicTablesService.findPage(new Page<SysDicTables>(request, response), sysDicTables);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("data", page);
		return tojson(map);
	}

	
}
