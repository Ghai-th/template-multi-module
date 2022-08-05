package com.hai.service;

import com.hai.modle.Template;

import java.util.List;

/**
 * @author Ghai-th
 * @date 2022/8/5 11:46
 */

public interface TemplateService {


    int deleteByPrimaryKey(Long id);

    int insert(Template record);

    int insertOrUpdate(Template record);

    int insertOrUpdateSelective(Template record);

    int insertSelective(Template record);

    Template selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);

    int updateBatch(List<Template> list);

    int updateBatchSelective(List<Template> list);

    int batchInsert(List<Template> list);

    List<Template> selectAll();

}
