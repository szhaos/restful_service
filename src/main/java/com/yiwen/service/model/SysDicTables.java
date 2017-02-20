package com.yiwen.service.model;

import com.yiwen.common.persistence.DataEntity;

public class SysDicTables extends DataEntity<SysDicTables> {

	/**
	 * Sys_Dic_Table 存储系统模块名和对应表名。
	 * 例如：1-商品管理-goods
	 */
	private static final long serialVersionUID = 1278959222348719905L;

	private String name;
	    
	private String value;
	    
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
