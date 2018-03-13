package team.ants.egg.controller.admin;

import cn.jants.common.annotation.action.Controller;
import cn.jants.common.annotation.action.GET;
import cn.jants.common.annotation.action.Param;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.bean.PageConditions;
import cn.jants.restful.render.Json;
import team.ants.egg.service.business.GoodsBusiness;

import java.util.Map;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2018-03-13
 */
@Controller("goods")
public class GoodsController {

    @Autowired
    private GoodsBusiness goodsBusiness;

    /**
     * 查询会员分页
     *
     * @param index 当前页数
     * @param size  每页大小
     * @return
     */
    @GET("/page")
    public Map page(@Param Integer index, @Param Integer size) {
        PageConditions pageConditions = new PageConditions(index, size);
        return Json.success(goodsBusiness.queryGoodsPage(pageConditions));
    }
}
