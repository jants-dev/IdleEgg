package team.ants.shop.mapper;


import cn.jants.plugin.sqlmap.annotation.Mapper;
import team.ants.shop.entity.Member;

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
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return
     */
    Member selectById(String id);


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
    Integer updateById(Member member);

    /**
     * 删除会员信
     *
     * @param id
     * @return
     */
    Integer deleteById(String id);
}