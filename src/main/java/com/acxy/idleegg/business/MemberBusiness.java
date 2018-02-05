package com.acxy.idleegg.business;

import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.annotation.service.Service;
import cn.jants.common.bean.Page;
import cn.jants.common.bean.PageConditions;
import cn.jants.plugin.sqlmap.Paging;
import com.acxy.idleegg.entity.Member;
import com.acxy.idleegg.mapper.MemberMapper;

import java.util.List;
import java.util.UUID;

/**
 * 用户业务
 *
 * @author MrShun
 * @version 1.0
 */
@Service
public class MemberBusiness {

    @Autowired
    private MemberMapper memberMapper;

    /**
     * 查询会员分页
     *
     * @param pageConditions 分页对象
     * @return
     */
    public Page queryMemberPage(PageConditions pageConditions) {
        Paging.startPage(pageConditions.getPageNum(), pageConditions.getPageSize());
        List<Member> members = memberMapper.selectList();
        Page page = new Page(members);
        return page;
    }

    /**
     * 查询会员信息
     *
     * @param openId 会员openId
     * @return
     */
    public Member queryMember(String openId) {
        Member member = memberMapper.selectByOpenId(openId);
        return member;
    }

    /**
     * 保存会员
     *
     * @param member
     * @return
     */
    public Long saveMember(Member member) {
        member.setOpenId(UUID.randomUUID().toString());
        Long returnKey = memberMapper.insert(member);
        return returnKey;
    }

    /**
     * 修改会员信息
     *
     * @param member
     */
    public Integer updateMember(Member member) {
        Integer result = memberMapper.updateByOpenId(member);
        return result;
    }


    /**
     * 删除会员信息
     *
     * @param openId 会员openId
     */
    public Integer deleteMember(String openId) {
        Integer result = memberMapper.deleteByOpenId(openId);
        return result;
    }
}
