package com.acxy.idleegg.controller;

import cn.jants.common.annotation.action.*;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.bean.PageConditions;
import cn.jants.restful.render.Json;
import com.acxy.idleegg.business.CategoryBusiness;
import com.acxy.idleegg.entity.Category;

import java.util.Map;

/**
 * 栏目分类控制器
 *
 * @author MrShun
 * @version 1.0
 */
@Controller("category")
public class CategoryController {

    @Autowired
    private CategoryBusiness categoryBusiness;

    /**
     * 查询栏目分页
     *
     * @param index 当前页数
     * @param size  每页大小
     * @return
     */
    @GET("/page")
    public Map page(@Param Integer index, @Param Integer size, String keywords) {
        PageConditions pageConditions = new PageConditions(index, size);
        pageConditions.put("keywords", keywords);
        return Json.success(categoryBusiness.queryCategoryPage(pageConditions));
    }

    /**
     * 查询栏目信息
     *
     * @param catId
     * @return
     */
    @GET("/query/{catId}")
    public Map query(@PathVariable Long catId) {
        Category category = categoryBusiness.queryCategory(catId);
        return Json.success(category);
    }


    /**
     * 创建栏目信息
     *
     * @param category
     * @return
     */
    @POST("/create")
    public Map create(Category category) {
        Long returnKey = categoryBusiness.saveCategory(category);
        return Json.success(returnKey);
    }


    /**
     * 修改栏目信息
     *
     * @param catId
     * @param category
     * @return
     */
    @PUT("/update/{catId}")
    public Map update(@PathVariable String catId, Category category) {
        Integer count = categoryBusiness.updateCategory(category);
        return Json.success(count);
    }


    /**
     * 删除栏目
     *
     * @param catId
     * @return
     */
    @DELETE("/delete/{openId}")
    public Map delete(@PathVariable Long catId) {
        Integer count = categoryBusiness.deleteCategory(catId);
        return Json.success(count);
    }
}
