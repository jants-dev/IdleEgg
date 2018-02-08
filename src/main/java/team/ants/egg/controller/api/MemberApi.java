package team.ants.egg.controller.api;

import cn.jants.common.annotation.action.*;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.bean.PageConditions;
import cn.jants.restful.render.Json;
import team.ants.egg.service.business.MemberBusiness;
import team.ants.egg.entity.Member;

import java.util.Map;

/**
 * 会员 控制器
 *
 * @author MrShun
 * @version 1.0
 */
@Controller("member")
public class MemberApi {

    @Autowired
    private MemberBusiness memberBusiness;

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
        return Json.success(memberBusiness.queryMemberPage(pageConditions));
    }

    /**
     * 查询会员信息
     *
     * @param openId
     * @return
     */
    @GET("/query/{openId}")
    public Map query(@PathVariable String openId) {
        Member member = memberBusiness.queryMember(openId);
        return Json.success(member);
    }


    /**
     * 添加会员信息
     *
     * @param member
     * @return
     */
    @POST("/add")
    public Map add(Member member) {
        Long returnKey = memberBusiness.saveMember(member);
        return Json.success(returnKey);
    }


    /**
     * 修改会员信息
     *
     * @param openId
     * @param member
     * @return
     */
    @PUT("/update/{openId}")
    public Map update(@PathVariable String openId, Member member) {
        member.setOpenId(openId);
        Integer count = memberBusiness.updateMember(member);
        return Json.success(count);
    }


    /**
     * 删除会员
     *
     * @param openId
     * @return
     */
    @DELETE("/delete/{openId}")
    public Map delete(@PathVariable String openId) {
        Integer count = memberBusiness.deleteMember(openId);
        return Json.success(count);
    }
}
