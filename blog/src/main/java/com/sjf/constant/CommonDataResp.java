package com.sjf.constant;

import java.io.Serializable;

/**
 * 报文返回对象(公用)
 * 
 */
public class CommonDataResp implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /** 交易代码 **/
    private String txncode;
   
    /** 交易流水号 **/
	private String txnseq;
	
	private String txndate;
	
	private String txntime;
		
	private String data;
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

	
	
	
}
