package com.yiwen.common.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;
import com.yiwen.common.utils.PropertiesLoader;

/**
 * 全局配置类
 * @author szhao
 * @version 2017-02-18
 */
public class Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = Maps.newHashMap();
	
	public static final String SIGNTOKEN = "QFZX";
	
	public static final Integer XINSHOUBIAOTYPE = 3;
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader propertiesLoader = new PropertiesLoader("config.properties");
	
	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}
	
	/**
	 * 获取配置
	 * @see ${fns:getConfig('adminPath')}
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = propertiesLoader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}
	
	/////////////////////////////////////////////////////////
	
	/**
	 * 获取管理端根路径
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}
	
	/**
	 * 获取URL后缀
	 */
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}
	
	/**
	 * 在修改系统用户和角色时是否同步到Activiti
	 */
	public static Boolean isSynActivitiIndetity() {
		String dm = getConfig("activiti.isSynActivitiIndetity");
		return "true".equals(dm) || "1".equals(dm);
	}
	
	/////////////////////////////////////////////////////////
	
	// 显示/隐藏
	public static final String SHOW = "1";
	public static final String HIDE = "0";

	// 是/否
	public static final String YES = "1";
	public static final String NO = "0";
	
	// 对/错
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	
	public static final String USERFILES_BASE_URL = "/userfiles/";

	/**
	 * 页面获取常量
	 * @see ${fns:getConst('YES')}
	 */
	public static Object getConst(String field) {
		try {
			return Global.class.getField(field).get(null);
		} catch (Exception e) {
			// 异常代表无配置，这里什么也不做
		}
		return null;
	}

	public static Map<String,String> INVEST_ERROR_MAP = new HashMap<String, String>();
	static{
		INVEST_ERROR_MAP.put("001", "投资时,用户信息不存在");
		INVEST_ERROR_MAP.put("002", "投资金额不可为空");
		INVEST_ERROR_MAP.put("003", "投资金额不符合要求");
		INVEST_ERROR_MAP.put("005", "用户开户信息有误");
		INVEST_ERROR_MAP.put("006", "账户金额不足");
		INVEST_ERROR_MAP.put("007", "债权已失效,请您重新选择");
		INVEST_ERROR_MAP.put("008", "债权状态为空");
		INVEST_ERROR_MAP.put("009", "债权已满标");
		INVEST_ERROR_MAP.put("010", "投资金额必须大于最低起投金额");
		INVEST_ERROR_MAP.put("011", "投资金额必须是100的整数倍");
		INVEST_ERROR_MAP.put("013", "债权可投金额不足");
		INVEST_ERROR_MAP.put("014", "出借人与借款人不能为同一人");
		INVEST_ERROR_MAP.put("000", "成功");
	}
	public static Map<String,String> RECHARGE_ERROR_MAP = new HashMap<String, String>();
	static{
		RECHARGE_ERROR_MAP.put("001", "请输入规定范围的金额");
		RECHARGE_ERROR_MAP.put("002", "金额错误");
		RECHARGE_ERROR_MAP.put("000", "成功");
	}
	public static Map<String,String> WITHDRAW_ERROR_MAP = new HashMap<String, String>();
	static{
		WITHDRAW_ERROR_MAP.put("001", "账户余额不足");
		WITHDRAW_ERROR_MAP.put("002", "请输入规定范围的金额");
		WITHDRAW_ERROR_MAP.put("000", "成功");
	}
	public static Map<String,String> UPDATEPWD_ERROR_MAP = new HashMap<String, String>();
	static{
		UPDATEPWD_ERROR_MAP.put("001", "两次密码输入不一致");
		UPDATEPWD_ERROR_MAP.put("002", "原密码不正确");
		UPDATEPWD_ERROR_MAP.put("003", "密码不能为空");
		UPDATEPWD_ERROR_MAP.put("004", "新密码与原密码不能一致");
		UPDATEPWD_ERROR_MAP.put("000", "成功");
	}
}
