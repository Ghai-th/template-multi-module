package com.hai.mapper;

import com.hai.modle.UserBase;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author Ghai-th
 * @date 2022/8/5 17:24
 */

public interface UserBaseMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(UserBase record);

    int insertOrUpdate(UserBase record);

    int insertOrUpdateSelective(UserBase record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserBase record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    UserBase selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserBase record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserBase record);

    int updateBatch(List<UserBase> list);

    int updateBatchSelective(List<UserBase> list);

    int batchInsert(@Param("list") List<UserBase> list);

    UserBase selectByCode(@Param("code")String code);


}
