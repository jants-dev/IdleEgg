package com.acxy.idleegg.controller;

import cn.jants.common.annotation.action.Controller;
import cn.jants.common.annotation.action.GET;
import cn.jants.common.annotation.action.Param;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.bean.PageConditions;
import cn.jants.restful.render.Json;
import com.acxy.idleegg.business.CategoryBusiness;

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
     * 查询会员分页
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
}
