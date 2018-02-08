package team.ants.egg.service.business;

import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.annotation.service.Service;
import cn.jants.common.bean.JsonMap;
import cn.jants.common.bean.Page;
import cn.jants.common.bean.PageConditions;
import cn.jants.common.utils.StrUtil;
import cn.jants.plugin.sqlmap.Paging;
import team.ants.egg.entity.Category;
import team.ants.egg.mapper.CategoryMapper;

import java.util.ArrayList;
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
        List<Category> categories = categoryMapper.selectList(pageConditions.getConditions());
        return new Page(categories);
    }

    /**
     * 查询栏目列表
     *
     * @return
     */
    public List<Category> queryCategoryList(JsonMap params) {
        List<Category> categories = categoryMapper.selectList(params);
        return categories;
    }

    public List<JsonMap> queryCategoryTree(){
        JsonMap params = JsonMap.newJsonMap();
        params.put("parentId", 0);
        List<JsonMap> result = new ArrayList<>();
        iterTree(params, result);
        return result;
    }

    private void iterTree(JsonMap params, List<JsonMap> result){
        List<Category> categories = categoryMapper.selectList(params);
        //迭代分类
        for(Category category: categories){
            JsonMap map = JsonMap.newJsonMap();
            Long id = category.getCatId();
            map.put("id", id);
            map.put("name", category.getCatName());
            Long catId = category.getCatId();
            if(category.getParentId() == null){
                map.put("isParent", true);
                map.put("children", new ArrayList<>());
            }else{
                map.put("isParent", false);
                params.put("parentId", catId);
                iterTree(params, result);
            }
            result.add(map);
        }
    }

    /**
     * 查询栏目信息
     *
     * @param catId 栏目Id
     * @return
     */
    public Category queryCategory(Long catId) {
        Category category = categoryMapper.selectById(catId);
        return category;
    }

    /**
     * 保存栏目
     *
     * @param category 栏目
     * @return
     */
    public Long saveCategory(Category category) {
        Long returnKey = categoryMapper.insert(category);
        return returnKey;
    }

    /**
     * 修改栏目信息
     *
     * @param category 栏目
     */
    public Integer updateCategory(Category category) {
        Integer result = categoryMapper.updateById(category);
        return result;
    }


    /**
     * 删除栏目信息
     *
     * @param catId 栏目Id
     */
    public Integer deleteCategory(Long catId) {
        Integer result = categoryMapper.deleteById(catId);
        return result;
    }

}
