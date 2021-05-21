package com.sjf.dao;
import org.springframework.stereotype.Repository;

import com.sjf.form.Media;
import com.sjf.form.Storage;

@Repository
public interface StorageMapper {
	
	int deleteByPrimaryKey(String articleId);

    int insert(Storage record);

    int insertSelective(Storage record);

    Media selectByPrimaryKey(String articleId);
    
    Media selectAll(Object object);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
}
