package com.yiwen.common.persistence;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 数据Entity类
 * @author szhao
 * @version 2017-02-18
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	
	private String ver;
	private String token;
	private String t;
	private String client;
	
	
	private String remark;
    
	private Integer createdUser;
	    
	private Integer updateUser;
	    
	private Date deletedAt;
	    
	private Integer deletedUser;
	    
	private Date createdAt;
	    
	private Date updatedAt;
	
	public DataEntity() {
		super();
	}
	
	public DataEntity(String id) {
		super(id);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
	
	public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getCreatedUser() {
        return createdUser;
    }
    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }
    public Integer getUpdateUser() {
        return updateUser;
    }
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }
    public Date getDeletedAt() {
        return deletedAt;
    }
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
    public Integer getDeletedUser() {
        return deletedUser;
    }
    public void setDeletedUser(Integer deletedUser) {
        this.deletedUser = deletedUser;
    }
    public String getCreatedAt() {
		return createdAt!=null?new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createdAt):"";
	}
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public String getUpdatedAt() {
        return updatedAt!=null?new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(updatedAt):"";
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
	
}
