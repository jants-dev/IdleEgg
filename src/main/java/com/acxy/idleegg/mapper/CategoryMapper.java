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
     * 查询栏目
     *
     * @param params 条件
     * @return
     */
    List<Category> selectList();


    Category selectById();
}