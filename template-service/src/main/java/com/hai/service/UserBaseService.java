package com.hai.service;

import java.util.List;

import com.hai.modle.UserBase;

/**
 * @author Ghai-th
 * @date 2022/8/5 17:24
 */

public interface UserBaseService {


    int deleteByPrimaryKey(Long id);

    int insert(UserBase record);

    int insertOrUpdate(UserBase record);

    int insertOrUpdateSelective(UserBase record);

    int insertSelective(UserBase record);

    UserBase selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserBase record);

    int updateByPrimaryKey(UserBase record);

    int updateBatch(List<UserBase> list);

    int updateBatchSelective(List<UserBase> list);

    int batchInsert(List<UserBase> list);

    UserBase selectByCode(String code);
}
