package team.ants.egg.service.business;

import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.annotation.service.Service;
import cn.jants.common.bean.JsonMap;
import cn.jants.common.bean.Page;
import cn.jants.common.bean.PageConditions;
import cn.jants.plugin.sqlmap.Paging;
import team.ants.egg.entity.Category;
import team.ants.egg.mapper.CategoryMapper;

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

    public JsonMap queryCategoryTree(Long pid){
        return null;
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
