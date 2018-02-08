package team.ants.egg.entity;


import java.io.Serializable;

/**
 * 用户(member)
 *
 * @author liushun
 * @version 1.0.0 2018-02-02
 */
public class Member implements Serializable {

    /**
     * 会员ID
     */
    private Long id;

    /**
     * 平台对外openid
     */
    private String openId;

    /**
     * 账号
     */
    private String account;

    /**
     * 会员昵称
     */
    private String nickName;

    /**
     * 性别: 0/女 1/男
     */
    private Integer sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 会员电话
     */
    private String tel;

    /**
     * 会员邮箱
     */
    private String email;

    /**
     * 会员生日
     */
    private String birthday;

    /**
     * 会员是否锁定:0/正常 1/锁定
     */
    private Integer isLock;

    /**
     * 用户等级
     */
    private Integer type;

    /**
     * 注册日期
     */
    private java.util.Date createTime;

    public Member() {
    }

    public Member(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }


}