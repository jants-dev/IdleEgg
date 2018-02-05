package com.acxy.idleegg.mapper;


import cn.jants.plugin.sqlmap.annotation.Mapper;
import com.acxy.idleegg.entity.Member;

import java.util.List;

/**
 * @author liushun
 * @version 1.0.0
 * @Date 2018-02-02
 */
@Mapper
public interface MemberMapper {

    /**
     * 查询会员列表
     *
     * @return
     */
    List<Member> selectList();

    /**
     * 根据openId查询用户信息
     *
     * @param openId 用户openId
     * @return
     */
    Member selectByOpenId(String openId);


    /**
     * 新增会员数据
     *
     * @param member 实体对象
     * @return
     */
    Long insert(Member member);

    /**
     * 修改会员信息
     *
     * @param member 实体对象
     * @return
     */
    Integer updateByOpenId(Member member);

    /**
     * 删除会员信
     *
     * @param openId
     * @return
     */
    Integer deleteByOpenId(String openId);
}