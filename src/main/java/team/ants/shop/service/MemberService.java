package team.ants.shop.service;

import cn.jants.common.bean.Page;
import cn.jants.common.bean.PageConditions;
import team.ants.shop.entity.Member;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2018-04-09
 */
public interface MemberService {

    /**
     * 查询会员分页
     *
     * @param pageConditions 分页对象
     * @return
     */
    Page queryPage(PageConditions pageConditions);


    /**
     * 查询会员信息
     *
     * @param id 会员id
     * @return
     */
    Member queryById(String id);

    /**
     * 保存会员
     *
     * @param member
     * @return
     */
    Long save(Member member);


    /**
     * 修改会员信息
     *
     * @param member
     * @return
     */
    Integer updateById(Member member);


    /**
     * 删除会员信息
     *
     * @param id 会员id
     * @return
     */
    Integer deleteById(String id);
}
