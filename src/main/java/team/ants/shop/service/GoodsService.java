package team.ants.shop.service;

import cn.jants.common.bean.Page;
import cn.jants.common.bean.PageConditions;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2018-04-09
 */
public interface GoodsService {

    /**
     * 查询会员分页
     *
     * @param pageConditions 分页对象
     * @return
     */
    Page queryPage(PageConditions pageConditions);
}
