package com.acxy.idleegg.business;

import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.annotation.service.Service;
import cn.jants.common.bean.Page;
import cn.jants.common.bean.PageConditions;
import cn.jants.plugin.sqlmap.Paging;
import com.acxy.idleegg.entity.Category;
import com.acxy.idleegg.mapper.CategoryMapper;

import java.util.List;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2018-02-05
 */
@Service
public class CategoryBusiness {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询栏目分类分页
     *
     * @param pageConditions 分页对象
     * @return
     */
    public Page queryCategoryPage(PageConditions pageConditions) {
        Paging.startPage(pageConditions.getPageNum(), pageConditions.getPageSize());
        List<Category> categories = categoryMapper.selectList();
        return new Page(categories);
    }
}
