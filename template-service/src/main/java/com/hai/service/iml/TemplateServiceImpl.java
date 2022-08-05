package com.hai.service.iml;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hai.modle.Template;
import java.util.List;
import com.hai.mapper.TemplateMapper;
import com.hai.service.TemplateService;
/**
 * @author Ghai-th
 * @date 2022/8/5 11:46
 */

@Service
public class TemplateServiceImpl implements TemplateService{

    @Resource
    private TemplateMapper templateMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return templateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Template record) {
        return templateMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Template record) {
        return templateMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Template record) {
        return templateMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Template record) {
        return templateMapper.insertSelective(record);
    }

    @Override
    public Template selectByPrimaryKey(Long id) {
        return templateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Template record) {
        return templateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Template record) {
        return templateMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Template> list) {
        return templateMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Template> list) {
        return templateMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Template> list) {
        return templateMapper.batchInsert(list);
    }

    public List<Template> selectAll() {
        return templateMapper.selectAll();
    }
}
