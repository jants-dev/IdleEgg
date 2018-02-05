package com.acxy.idleegg.controller;

import cn.jants.common.annotation.action.*;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.annotation.service.Tx;
import cn.jants.common.bean.JsonMap;
import cn.jants.common.bean.Page;
import cn.jants.common.exception.TipException;
import cn.jants.plugin.sqlmap.Paging;
import cn.jants.restful.render.Json;
import com.acxy.idleegg.entity.Member;
import com.acxy.idleegg.mapper.MemberMapper;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 会员 控制器
 *
 * @author MrShun
 * @version 1.0
 */
@Controller("member")
public class MemberController {

    @Autowired
    private MemberMapper memberMapper;

    /**
     * 查询会员分页
     *
     * @param index 当前页数
     * @param size  每页大小
     * @return
     */
    @GET("/page")
    public Map page(@Param Integer index, @Param Integer size) {
        Paging.startPage(index, size);
        List<Member> members = memberMapper.selectList();
        Page page = new Page(members);
        return Json.success(page);
    }

    /**
     * 查询会员信息
     *
     * @param openId
     * @return
     */
    @GET("/query/{openId}")
    public Map query(@PathVariable String openId) {
        Member member = memberMapper.selectByOpenId(openId);
        //其他扩展属性也就是所谓的DTO
        JsonMap jsonMap = new JsonMap(member);
        jsonMap.put("pos", "java");
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
        member.setOpenId(UUID.randomUUID().toString());
        Long returnKey = memberMapper.insert(member);
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
        Integer count = memberMapper.updateByOpenId(member);
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
        Integer count = memberMapper.deleteByOpenId(openId);
        return Json.success(count);
    }

    /**
     * 测试事务回滚机制, 数据库格式InnoDB
     *
     * @param openId
     * @return
     */
    @DELETE("/tx/{openId}")
    @Tx
    public Map tx(@PathVariable String openId) {
        Integer count = memberMapper.deleteByOpenId(openId);
        throw new TipException("测试事务回滚机制...");
    }
}
