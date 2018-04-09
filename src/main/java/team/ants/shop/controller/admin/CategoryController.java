package team.ants.shop.controller.admin;

import cn.jants.common.annotation.action.Controller;
import cn.jants.common.annotation.action.GET;
import cn.jants.common.annotation.action.POST;
import cn.jants.common.annotation.action.PathVariable;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.bean.JsonMap;
import cn.jants.restful.render.Json;
import team.ants.shop.entity.Category;
import team.ants.shop.service.CategoryService;

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
    private CategoryService categoryService;

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
        return Json.success(categoryService.queryList(params));
    }

    /**
     * 获取菜单数
     *
     * @return
     */
    @GET("/tree")
    public Map tree() {
        return Json.success(categoryService.queryTree());
    }

    /**
     * 查询栏目信息
     *
     * @param catId
     * @return
     */
    @GET("/query/{catId}")
    public Map query(@PathVariable Long catId) {
        Category category = categoryService.queryById(catId);
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
        Long returnKey = categoryService.save(category);
        return Json.success(returnKey);
    }


    /**
     * 修改栏目信息
     *
     * @param category
     * @return
     */
    @POST("/update")
    public Map update(Category category) {
        Integer count = categoryService.updateById(category);
        return Json.success(count);
    }


    /**
     * 删除栏目
     *
     * @param catId
     * @return
     */
    @POST("/delete/{catId}")
    public Map delete(@PathVariable Long catId) {
        Integer count = categoryService.deleteById(catId);
        return Json.success(count);
    }
}
