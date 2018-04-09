package team.ants.shop.service.impl;

import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.annotation.service.Service;
import cn.jants.common.bean.JsonMap;
import team.ants.shop.entity.Category;
import team.ants.shop.mapper.CategoryMapper;
import team.ants.shop.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2018-02-05
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<Category> queryList(JsonMap params) {
        List<Category> categories = categoryMapper.selectList(params);
        return categories;
    }

    @Override
    public List<JsonMap> queryTree() {
        List<JsonMap> result = new ArrayList<>();
        List<Category> categories = categoryMapper.selectList(null);
        //迭代分类
        for (Category category : categories) {
            JsonMap map = JsonMap.newJsonMap();
            Long id = category.getCatId();
            map.put("id", id);
            map.put("name", category.getCatName());
            Long pId = category.getParentId();
            map.put("pId", pId);
            map.put("isSys", category.getIsSys());
            map.put("model", category.getModel());
            result.add(map);
        }
        return result;
    }


    @Override
    public Category queryById(Long catId) {
        Category category = categoryMapper.selectById(catId);
        return category;
    }

    @Override
    public Long save(Category category) {
        Long returnKey = categoryMapper.insert(category);
        return returnKey;
    }

    @Override
    public Integer updateById(Category category) {
        Integer result = categoryMapper.updateById(category);
        return result;
    }


    @Override
    public Integer deleteById(Long catId) {
        Integer result = categoryMapper.deleteById(catId);
        return result;
    }

}
