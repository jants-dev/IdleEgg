package team.ants.shop.service;

import cn.jants.common.bean.JsonMap;
import team.ants.shop.entity.Category;

import java.util.List;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2018-04-09
 */
public interface CategoryService {

    /**
     * 查询栏目列表
     *
     * @param params
     * @return
     */
    List<Category> queryList(JsonMap params);

    /**
     * 查询所有栏目
     *
     * @return
     */
    List<JsonMap> queryTree();


    /**
     * 查询栏目信息
     *
     * @param catId 栏目Id
     * @return
     */
    Category queryById(Long catId);


    /**
     * 保存栏目
     *
     * @param category 栏目
     * @return
     */
    Long save(Category category);


    /**
     * 修改栏目信息
     *
     * @param category 栏目
     * @return
     */
    Integer updateById(Category category);


    /**
     * 删除栏目信息
     *
     * @param catId 栏目Id
     * @return
     */
    Integer deleteById(Long catId);
}
