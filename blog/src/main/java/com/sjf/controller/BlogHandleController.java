package com.sjf.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sjf.constant.CommonData;
import com.sjf.constant.CommonDataResp;
import com.sjf.service.BlogService;


@RestController
@CrossOrigin
public class BlogHandleController extends BaseController{
	
	private static Logger logger = LoggerFactory.getLogger(BlogHandleController.class);
	@Autowired
	protected BlogService blogService;
	
	@RequestMapping("/register")
	public String register(@RequestBody String jsonStr) {
		logger.info("register jsonStr: {}", jsonStr);
		Map<String, Object> map = new HashMap<String, Object>();
		CommonDataResp resp = new CommonDataResp();
		String returnJsonStr = "";
		try {
//			// 转换请求参数
			JSONObject jsonObj = JSONObject.parseObject(jsonStr, JSONObject.class);
			CommonData req = JSON.toJavaObject(jsonObj, CommonData.class);
			resp = blogService.register(req);
			map.put("data", resp.getData());
			map.put("result", "0000");
			map.put("resultdesc", "成功");
		} catch (Exception e) {
			resp = commonLogEx(e);
		}
		returnJsonStr = JSON.toJSONString(map, SerializerFeature.PrettyFormat);
		logger.info("register返回的json串:" + returnJsonStr);
		return returnJsonStr;
	}
	
	@RequestMapping("/login")
	public String login(@RequestBody String jsonStr) {
		logger.info("register jsonStr: {}", jsonStr);
		Map<String, Object> map = new HashMap<String, Object>();
		CommonDataResp resp = new CommonDataResp();
		String returnJsonStr = "";
		try {
//			// 转换请求参数
			JSONObject jsonObj = JSONObject.parseObject(jsonStr, JSONObject.class);
			CommonData req = JSON.toJavaObject(jsonObj, CommonData.class);
			resp = blogService.login(req);
			map.put("data", resp.getData());
			map.put("result", "0000");
			map.put("resultdesc", "成功");
		} catch (Exception e) {
			resp = commonLogEx(e);
		}
		returnJsonStr = JSON.toJSONString(map, SerializerFeature.PrettyFormat);
		logger.info("login返回的json串:" + returnJsonStr);
		return returnJsonStr;
	}
	
	@RequestMapping("/uploadImage")
	public String uploadImage(@RequestBody String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		CommonDataResp resp = new CommonDataResp();
		String returnJsonStr = "";
		try {
			// 转换请求参数
			JSONObject jsonObj = JSONObject.parseObject(jsonStr, JSONObject.class);
			CommonData req = JSON.toJavaObject(jsonObj, CommonData.class);
			resp = blogService.uploadImage(req);
			map.put("data", resp.getData());
			map.put("result", "0000");
			map.put("resultdesc", "成功");
		} catch (Exception e) {
			resp = commonLogEx(e);
		} 
		returnJsonStr = JSON.toJSONString(map, SerializerFeature.PrettyFormat);
		logger.info("uploadImage返回的json串:" + returnJsonStr);
		return returnJsonStr;
	} 
	
	@RequestMapping("/articleStorage")
	public String articleStorage(@RequestBody String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		CommonDataResp resp = new CommonDataResp();
		String returnJsonStr = "";
		try {
			// 转换请求参数
			JSONObject jsonObj = JSONObject.parseObject(jsonStr, JSONObject.class);
			CommonData req = JSON.toJavaObject(jsonObj, CommonData.class);
			
			map.put("data", resp.getData());
			map.put("result", "0000");
			map.put("resultdesc", "成功");
		}catch (Exception e) {
			resp = commonLogEx(e);
		} 
		returnJsonStr = JSON.toJSONString(map, SerializerFeature.PrettyFormat);
		logger.info("articleStorage返回的json串:" + returnJsonStr);
		return returnJsonStr;
		
	}
}
