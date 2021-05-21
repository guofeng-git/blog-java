package com.sjf.dao;

import org.springframework.stereotype.Repository;

import com.sjf.form.UserInfo;

/**
 * 
 *
 */
@Repository
public interface UserInfoMapper {
    int deleteByPrimaryKey(String userid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String userid);
    
    UserInfo selectAll(Object object);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}