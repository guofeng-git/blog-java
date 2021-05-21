package com.sjf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.sjf.constant.CommonData;
import com.sjf.constant.CommonDataResp;
import com.sjf.constant.Constant;
import com.sjf.exception.BusinessException;


/**
 * 
 * @author GuoFeng
 * @createDate 2020-12-30 09:32:45 基本公共服务类
 */

public class BaseController {

	private static Logger logger = LoggerFactory.getLogger(BaseController.class);

	protected static Gson gson = new Gson();


	/**
	 * 验证日志
	 * 
	 * @Title: commonLog
	 * @Description:
	 * @param param
	 */
	public void commonLog(CommonData param) {
		logger.info("----------交易代码：" + param.getTxncode());
		logger.info("---------交易流水：" + param.getTxnseq());
		logger.info("----------交易日期：" + param.getTxndate());
		logger.info("-------------------请求部分参数结束----------------");
	}

	/**
	 * 异常日志
	 * 
	 * @Title: commonLogEx
	 * @Description:
	 * @param e
	 * @param param
	 */
	public void commonLogEx(Exception e, CommonData param) {
		if (e instanceof BusinessException) {
			logger.error("ErrorCode: " + ((BusinessException) e).getErrorCode() + " | ErrorDesc:"
					+ ((BusinessException) e).getErrorMsg());
			param.setResponsecode(((BusinessException) e).getErrorCode());
			param.setResponsedesc(((BusinessException) e).getErrorMsg());
		} else {
			logger.error("Error:", e);
			param.setResponsecode(Constant.RSP_CODE_96.getCode());
			param.setResponsedesc(Constant.RSP_CODE_96.getName());
		}
		logger.info(e.getMessage());
	}

	/**
	 * 异常日志
	 * 
	 * @Title: commonLogEx
	 * @Description:
	 * @param e
	 * @param param
	 */
	public CommonDataResp commonLogEx(Exception e) {
		CommonDataResp resp = new CommonDataResp();
		if (e instanceof BusinessException) {
			logger.error("ErrorCode: " + ((BusinessException) e).getErrorCode() + " | ErrorDesc:"
					+ ((BusinessException) e).getErrorMsg());
			resp.setResponsecode(((BusinessException) e).getErrorCode());
			resp.setResponsedesc(((BusinessException) e).getErrorMsg());
		} else {
			logger.error("Error:", e);
			resp.setResponsecode(Constant.RSP_CODE_96.getCode());
			resp.setResponsedesc(Constant.RSP_CODE_96.getName());
		}
		return resp;
	}
}
