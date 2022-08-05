package com.hai.mapper;

import com.hai.modle.Template;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author Ghai-th
 * @date 2022/8/5 11:46
 */

public interface TemplateMapper {
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
    int insert(Template record);

    int insertOrUpdate(Template record);

    int insertOrUpdateSelective(Template record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Template record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Template selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Template record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Template record);

    int updateBatch(List<Template> list);

    int updateBatchSelective(List<Template> list);

    int batchInsert(@Param("list") List<Template> list);

    List<Template> selectAll();


}
