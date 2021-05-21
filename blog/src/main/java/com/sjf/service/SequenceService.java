package com.sjf.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.sjf.dao.SequenceMapper;

/**
 * 
 * @ClassName:     SequenceService
 * @Description:   取数据库序列号的服务类
 * @author:        GuoFeng
 * @date:          2020年12月30日 下午15:39:54
 *
 */
@Repository
public class SequenceService{
	@Autowired
	private SequenceMapper sequenceMapper;
	
	public String findNextValue(String sName) throws Exception{
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("sName", sName);
		parameterMap.put("sValue", "");
		String sValue = sequenceMapper.findNextValue(parameterMap);
		if(StringUtils.isEmpty(sValue)){
			sValue = (String)parameterMap.get("sValue");
		}
		return sValue;
	}
}
