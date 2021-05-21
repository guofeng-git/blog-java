package com.sjf.dao ;

import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * 
 * @ClassName:     SequenceMapper
 * @Description:   取数据库序列号的接口类
 * @author:        GuoFeng
 * @date:          2020年12月20日 下午15:36:47
 *
 */
@Repository
public interface SequenceMapper{
	public String findNextValue(Map<String, Object> parameterMap) throws Exception;
	
	public String selectSyssesq(Map<String, Object> parameterMap) throws Exception;
}
