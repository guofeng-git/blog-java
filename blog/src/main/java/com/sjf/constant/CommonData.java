package com.sjf.constant;

import java.io.Serializable;

/**
 * rest 服务外部请求对象
 * 
 */
public class CommonData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/** 交易代码 **/
    private String txncode;
   
    /** 交易流水号 **/
	private String txnseq;
	
	private String txndate;
	
	private String txntime;
	
	private String data;
	
	private String userid;
	
	private String idno;
	
	private String name;
	
	private String idtype;
	
	private String phone;
	
	private String sex;
	
	private String password;
	
	private String image;
	
	private String image_name;
	
	//Storage
	private String articleId;
	
	private String title;
	
	private String topic;
	
	private String createTime;
	
	private String updateTime;
	
	private String createUser;
	
	private String classify;
	
	private String content;
	 /** 交易应答码 **/
    private String responsecode;
    /** 交易应答描述 **/
    private String responsedesc;

	public String getTxncode() {
		return txncode;
	}

	public void setTxncode(String txncode) {
		this.txncode = txncode;
	}

	public String getTxnseq() {
		return txnseq;
	}

	public void setTxnseq(String txnseq) {
		this.txnseq = txnseq;
	}

	public String getTxndate() {
		return txndate;
	}

	public void setTxndate(String txndate) {
		this.txndate = txndate;
	}

	public String getTxntime() {
		return txntime;
	}

	public void setTxntime(String txntime) {
		this.txntime = txntime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getResponsecode() {
		return responsecode;
	}

	public void setResponsecode(String responsecode) {
		this.responsecode = responsecode;
	}

	public String getResponsedesc() {
		return responsedesc;
	}

	public void setResponsedesc(String responsedesc) {
		this.responsedesc = responsedesc;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
}
