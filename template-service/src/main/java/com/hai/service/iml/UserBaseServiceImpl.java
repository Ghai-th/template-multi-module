package com.hai.service.iml;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hai.mapper.UserBaseMapper;
import java.util.List;
import com.hai.modle.UserBase;
import com.hai.service.UserBaseService;
/**
 * @author Ghai-th
 * @date 2022/8/5 17:24
 */

@Service
public class UserBaseServiceImpl implements UserBaseService{

    @Resource
    private UserBaseMapper userBaseMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userBaseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserBase record) {
        return userBaseMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserBase record) {
        return userBaseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserBase record) {
        return userBaseMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserBase record) {
        return userBaseMapper.insertSelective(record);
    }

    @Override
    public UserBase selectByPrimaryKey(Long id) {
        return userBaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserBase record) {
        return userBaseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserBase record) {
        return userBaseMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<UserBase> list) {
        return userBaseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UserBase> list) {
        return userBaseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UserBase> list) {
        return userBaseMapper.batchInsert(list);
    }


    @Override
    public UserBase selectByCode(String code) {
        return userBaseMapper.selectByCode(code);
    }
}
