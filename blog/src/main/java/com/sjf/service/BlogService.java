package com.sjf.service;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.sjf.constant.CommonData;
import com.sjf.constant.CommonDataResp;
import com.sjf.constant.Constant;
import com.sjf.controller.BaseController;
import com.sjf.dao.MediaMapper;
import com.sjf.dao.StorageMapper;
import com.sjf.dao.UserInfoMapper;
import com.sjf.form.Media;
import com.sjf.form.Storage;
import com.sjf.form.UserInfo;
import com.sjf.util.AESUtil;
import com.sjf.util.DateFormatUtil;
import com.sjf.util.UuidUtil;

import sun.misc.BASE64Decoder;

@Service
public class BlogService extends BaseController {
	
	@Autowired
	protected PropertyInfoService propertyInfo;
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private MediaMapper mediaMapper;
	
	@Autowired
	private StorageMapper storageMapper;
	private static Logger logger = LoggerFactory.getLogger(BlogService.class);

	// 用户注册
	public CommonDataResp register(CommonData param) throws Exception {
		CommonDataResp resp = new CommonDataResp();
		//用户名密码非空校验
		if("".equals(param.getName())) {
			resp.setResponsecode(Constant.RSP_CODE_02.getCode());
			resp.setResponsedesc(Constant.RSP_CODE_02.getName());
		}
		if("".equals(param.getPassword())) {
			resp.setResponsecode(Constant.RSP_CODE_03.getCode());
			resp.setResponsedesc(Constant.RSP_CODE_03.getName());
		}
		//将请求中的信息入库
		UserInfo userinfo = new UserInfo();
		String userid = param.getUserid();
		userinfo.setUserid(userid);
		userinfo.setId_no(param.getIdno());
		userinfo.setName(param.getName());
		userinfo.setId_type(param.getIdtype());
		userinfo.setPhone(param.getPhone());
		userinfo.setSex(param.getSex());
		String password = AESUtil.encode(AESUtil.AES_KEY, param.getPassword());
		userinfo.setPassword(password);
		//入库
		userInfoMapper.insert(userinfo);
		resp.setData(gson.toJson(userinfo));
		return resp;
	}
	
	// 用户登陆
	public CommonDataResp login(CommonData param) throws Exception {
		CommonDataResp resp = new CommonDataResp();
		//用户名密码非空校验
		if("".equals(param.getName())) {
			resp.setResponsecode(Constant.RSP_CODE_02.getCode());
			resp.setResponsedesc(Constant.RSP_CODE_02.getName());
		}
		if("".equals(param.getPassword())) {
			resp.setResponsecode(Constant.RSP_CODE_03.getCode());
			resp.setResponsedesc(Constant.RSP_CODE_03.getName());
		}
		//查询用户注册信息
		UserInfo userinfo = new UserInfo();
		userinfo.setName(param.getName());
		userinfo = userInfoMapper.selectAll(userinfo);
		
		if(null == userinfo) {
			//用户未注册
			resp.setResponsecode(Constant.RSP_CODE_04.getCode());
			resp.setResponsedesc(Constant.RSP_CODE_04.getName());
		}
		resp.setData(gson.toJson(userinfo));
		return resp;
	}
	
	// 图片(头像)上传
	public CommonDataResp uploadImage(CommonData param) throws Exception {
		String data = param.getData();
		// param = gson.fromJson(txninfo, CommonData.class);
		com.alibaba.fastjson.JSONObject jsonObj = com.alibaba.fastjson.JSONObject.parseObject(data,
				com.alibaba.fastjson.JSONObject.class);
		param = JSON.toJavaObject(jsonObj, CommonData.class);
		CommonDataResp resp = new CommonDataResp();
		// 将base64编码转成图片
	    String imgBase64 = param.getImage();
	    // String imgBase64 = "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";
	    imgBase64 =  imgBase64.split(",")[1];
	    BASE64Decoder decoder = new BASE64Decoder();  
	    try {
	       byte[] b = decoder.decodeBuffer(imgBase64);  
	       for(int i=0;i<b.length;++i)  
	          {  
	              if(b[i]<0)  
	               {//调整异常数据  
		               b[i]+=256;  
		           }  
	          }  
	         //生成jpeg图片 ，并上传至服务器指定路径
	         //后续改为服务器路径
	             
	         //  String imgFilePath = "E:\\app\\image\\"+param.getImage_name();//新生成的图片  
	         String imgFilePath = propertyInfo.getImgurl()+param.getImage_name();//新生成的图片  
	         logger.debug("图片上传路径:"+imgFilePath);
	         OutputStream out = new FileOutputStream(imgFilePath);      
	         out.write(b);  
	         out.flush();  
	         out.close();  
	         //将图片路径保存至数据库
	         Media media = new Media();
	         media.setUserid(param.getUserid());
	         media.setUrl(imgFilePath);
	         media.setImageName(param.getImage_name());
	         mediaMapper.insert(media);
	         resp.setData(gson.toJson(media));
	        } catch (Exception e){  
	            logger.debug(e.getMessage()); 
	            
	        } 
			return resp;
		}
	//文章数据存储
	public CommonDataResp articleStorage(CommonData param) throws Exception {
		
		CommonDataResp resp = new CommonDataResp();
		try {
		Storage ms = new Storage();
		
		ms.setArticleId(UuidUtil.get32UUID());
		
		ms.setTitle(param.getTitle());
		
		ms.setTopic(param.getTopic());
		
		ms.setClassify(param.getClassify());
		
		ms.setCreateTime(DateFormatUtil.getCurrentTime());
		
		ms.setCreateUser(param.getCreateUser());
		
		storageMapper.insert(ms);
		
		resp.setData(gson.toJson(ms)); 
		} catch (Exception e){  
            logger.debug(e.getMessage()); 
            
        } 
		
		return resp;
		
	}
}
