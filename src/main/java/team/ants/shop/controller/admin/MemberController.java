package team.ants.shop.controller.admin;

import cn.jants.common.annotation.action.*;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.bean.PageConditions;
import cn.jants.common.utils.StrUtil;
import cn.jants.restful.render.Json;
import team.ants.shop.entity.Member;
import team.ants.shop.service.MemberService;
import team.ants.shop.service.impl.MemberServiceImpl;

import java.util.Map;

/**
 * 会员 控制器
 *
 * @author MrShun
 * @version 1.0
 */
@Controller("member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 查询会员分页
     *
     * @param index 当前页数
     * @param size  每页大小
     * @return
     */
    @GET("/page")
    public Map page(@Param Integer index, @Param Integer size, String keywords) {
        PageConditions pageConditions = new PageConditions(index, size);
        if(StrUtil.notBlank(keywords)) {
            pageConditions.put("keywords", keywords);
        }
        return Json.success(memberService.queryPage(pageConditions));
    }

    /**
     * 查询会员信息
     *
     * @param id
     * @return
     */
    @GET("/query/{id}")
    public Map query(@PathVariable String id) {
        Member member = memberService.queryById(id);
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
        Long returnKey = memberService.save(member);
        return Json.success(returnKey);
    }


    /**
     * 修改会员信息
     *
     * @param id
     * @param member
     * @return
     */
    @POST("/update/{id}")
    public Map update(@PathVariable Long id, Member member) {
        member.setId(id);
        Integer count = memberService.updateById(member);
        return Json.success(count);
    }


    /**
     * 删除会员
     *
     * @param id
     * @return
     */
    @POST("/delete/{id}")
    public Map delete(@PathVariable String id) {
        Integer count = memberService.deleteById(id);
        return Json.success(count);
    }
}
