package team.ants.egg.controller.api;

import cn.jants.common.annotation.action.*;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.bean.JsonMap;
import cn.jants.restful.render.Json;
import team.ants.egg.entity.Category;
import team.ants.egg.service.business.CategoryBusiness;

import java.util.Map;

/**
 * 栏目分类控制器
 *
 * @author MrShun
 * @version 1.0
 */
@Controller("category")
public class CategoryApi {

    @Autowired
    private CategoryBusiness categoryBusiness;

    /**
     * 查询栏目列表
     *
     * @return
     * @Param pid 父菜单Id
     */
    @GET("/list")
    public Map list(Long pid) {
        JsonMap params = JsonMap.newJsonMap();
        params.put("parentId", pid);
        return Json.success(categoryBusiness.queryCategoryList(params));
    }

    /**
     * 获取菜单数
     *
     * @param pid
     * @return
     */
    @GET("/tree")
    public Map tree(Long pid) {
        return Json.success(categoryBusiness.queryCategoryTree(pid));
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
