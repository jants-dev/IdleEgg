package com.acxy.idleegg.mapper;

import cn.jants.plugin.sqlmap.annotation.Mapper;
import com.acxy.idleegg.entity.Category;

import java.util.List;
import java.util.Map;


/**
 * @author liushun
 * @version 1.0.0 2018-02-05
 */
@Mapper
public interface CategoryMapper {

    /**
     * 查询栏目分页
     *
     * @param params 条件
     * @return
     */
    List<Category> selectList(Map params);

    /**
     * 查询栏目
     *
     * @param catId 栏目Id
     * @return
     */
    Category selectById(Long catId);

    /**
     * 新增栏目
     *
     * @param category 栏目
     * @return
     */
    Long insert(Category category);



    /**
     * 修改栏目
     *
     * @param category 栏目
     * @return
     */
    Integer updateById(Category category);


    /**
     * 删除栏目
     *
     * @param catId 栏目Id
     * @return
     */
    Integer deleteById(Long catId);
}