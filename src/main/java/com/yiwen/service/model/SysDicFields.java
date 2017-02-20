package com.yiwen.service.model;

import com.yiwen.common.persistence.DataEntity;


public class SysDicFields extends DataEntity<SysDicFields> {
	    
	/**
	 * Sys_Dic_Field 存储系统模块中涉及键值对关系的字段的字段名和字段中文名及其所属模块的ID。
	 * 例如：1-1-商品分类-category，2-1-商品品牌-brand
	 */
	private static final long serialVersionUID = 8304102229152339429L;

	private String sysDicTableId;
	    
	private String name;
	    
	private String value;
	    
	

    public String getSysDicTableId() {
        return sysDicTableId;
    }
    public void setSysDicTableId(String sysDicTableId) {
        this.sysDicTableId = sysDicTableId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    
}
