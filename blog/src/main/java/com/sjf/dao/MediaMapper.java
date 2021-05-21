package com.sjf.dao;
import org.springframework.stereotype.Repository;

import com.sjf.form.Media;

@Repository
public interface MediaMapper {
	
	int deleteByPrimaryKey(String userid);

    int insert(Media record);

    int insertSelective(Media record);

    Media selectByPrimaryKey(String userid);
    
    Media selectAll(Object object);

    int updateByPrimaryKeySelective(Media record);

    int updateByPrimaryKey(Media record);
}
