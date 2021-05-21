package com.sjf.form;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/**
 * 用户信息表实体类
 * 综合前置系统使用INTERNET类型的终端进行内部传输密钥管理
 * @author guofeng
 *对应数据库表userinfo
 */
@Alias("userinfo")
public class UserInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    private String userid;

    private String name;

    private String sex;

    private String avanda;

    private String id_no;

    private String id_type;
    
	private String password;
	
	private String phone;

	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAvanda() {
		return avanda;
	}

	public void setAvanda(String avanda) {
		this.avanda = avanda;
	}



	public String getId_no() {
		return id_no;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

 

   
}