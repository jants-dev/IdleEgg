package team.ants.shop.service.impl;

import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.annotation.service.Service;
import cn.jants.common.bean.Page;
import cn.jants.common.bean.PageConditions;
import cn.jants.plugin.sqlmap.Paging;
import team.ants.shop.entity.Member;
import team.ants.shop.mapper.MemberMapper;
import team.ants.shop.service.MemberService;

import java.util.List;
import java.util.UUID;

/**
 * 用户业务
 *
 * @author MrShun
 * @version 1.0
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Page queryPage(PageConditions pageConditions) {
        Paging.startPage(pageConditions.getPageNum(), pageConditions.getPageSize());
        List<Member> members = memberMapper.selectList();
        Page page = new Page(members);
        return page;
    }

    @Override
    public Member queryById(String id) {
        Member member = memberMapper.selectById(id);
        return member;
    }

    @Override
    public Long save(Member member) {
        member.setOpenId(UUID.randomUUID().toString());
        Long returnKey = memberMapper.insert(member);
        return returnKey;
    }

    @Override
    public Integer updateById(Member member) {
        Integer result = memberMapper.updateById(member);
        return result;
    }


    @Override
    public Integer deleteById(String id) {
        Integer result = memberMapper.deleteById(id);
        return result;
    }
}
