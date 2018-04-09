package team.ants.shop.service.impl;

import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.annotation.service.Service;
import cn.jants.common.bean.Page;
import cn.jants.common.bean.PageConditions;
import cn.jants.plugin.sqlmap.Paging;
import team.ants.shop.entity.Goods;
import team.ants.shop.mapper.GoodsMapper;
import team.ants.shop.service.GoodsService;

import java.util.List;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2018-03-13
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Page queryPage(PageConditions pageConditions) {
        Paging.startPage(pageConditions.getPageNum(), pageConditions.getPageSize());
        List<Goods> gs = goodsMapper.selectList();
        Page page = new Page(gs);
        return page;
    }
}
