package team.ants.egg.service.business;

import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.bean.Page;
import cn.jants.common.bean.PageConditions;
import cn.jants.plugin.sqlmap.Paging;
import team.ants.egg.entity.Goods;
import team.ants.egg.mapper.GoodsMapper;

import java.util.List;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2018-03-13
 */
public class GoodsBusiness {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 查询会员分页
     *
     * @param pageConditions 分页对象
     * @return
     */
    public Page queryGoodsPage(PageConditions pageConditions) {
        Paging.startPage(pageConditions.getPageNum(), pageConditions.getPageSize());
        List<Goods> gs = goodsMapper.selectList();
        Page page = new Page(gs);
        return page;
    }
}
