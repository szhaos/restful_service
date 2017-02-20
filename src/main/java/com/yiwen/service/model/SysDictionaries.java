package com.yiwen.service.model;

import com.yiwen.common.persistence.DataEntity;

public class SysDictionaries extends DataEntity<SysDictionaries> {

	/**
	 * TableName存使用该字典表的表名，
	 * FieldName存使用该字典表的表中对应的列名，
	 * Key和Value分别对应字典的键和值。
	 * 例如：供应商表中的供应商分类在该表中TableName值为Supplier，FieldName值为CategoryID。例如：1-goods-category-1-生活用品-1
	 */
	private static final long serialVersionUID = 7209097716885093431L;

	private String tableName;
	    
	private String fieldName;
	    
	private Integer key;
	    
	private String value;
	    
	private Integer sequence;
	

    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getFieldName() {
        return fieldName;
    }
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    public Integer getKey() {
        return key;
    }
    public void setKey(Integer key) {
        this.key = key;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Integer getSequence() {
        return sequence;
    }
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
    
}
