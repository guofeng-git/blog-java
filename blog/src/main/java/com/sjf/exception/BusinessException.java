package com.sjf.exception;

/**
 * 自定义异常类
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMsg;

	public BusinessException(String errorCode) {
		this.errorCode = errorCode;
	}

	public BusinessException(String errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}
}