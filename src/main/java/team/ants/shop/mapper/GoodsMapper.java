package team.ants.shop.mapper;

import cn.jants.plugin.sqlmap.annotation.Mapper;
import team.ants.shop.entity.Goods;

import java.util.List;


/**
 * @author liushun
 * @version 1.0.0 2018-03-13
 */
@Mapper
public interface GoodsMapper {

    /**
     * 查询商品列表
     *
     * @return
     */
    List<Goods> selectList();
}