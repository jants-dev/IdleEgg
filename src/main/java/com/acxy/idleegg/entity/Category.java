package com.acxy.idleegg.entity;


import java.io.Serializable;

/**
 * 栏目分类(category)
 *
 * @author liushun
 * @version 1.0.0 2018-02-05
 */
public class Category implements Serializable {

    /**
     * 分类ID
     */
    private Long catId;

    /**
     * 分类名称
     */
    private String catName;

    /**
     * 0/外链1/内置/2/单页
     */
    private Integer type;

    /**
     * 样式
     */
    private String style;

    /**
     * 分类目录
     */
    private String catDir;

    /**
     * 连接URL
     */
    private String linkUrl;

    /**
     * 级别
     */
    private Integer level;

    /**
     * 父类
     */
    private Long parentId;

    /**
     * 0/隐藏1/显示
     */
    private Integer nav;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 模板
     */
    private String template;

    /**
     * 栏目统计
     */
    private Long count;

    /**
     * 内容模型
     */
    private String module;

    /**
     * SEO标题
     */
    private String seoTitle;

    /**
     * SEO关键词
     */
    private String seoKeywords;

    /**
     * SEO描述
     */
    private String seoDescription;

    /**
     * 栏目图
     */
    private String thumb;

    /**
     * 简介
     */
    private String introduce;

    /**
     * 区域
     */
    private Integer areaid;

    /**
     * IP
     */
    private String ip;

    /**
     * 状态
     */
    private Integer status;

    public Category() {
    }

    public Category(Long catId) {
        this.catId = catId;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }


    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }


    public String getCatDir() {
        return catDir;
    }

    public void setCatDir(String catDir) {
        this.catDir = catDir;
    }


    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    public Integer getNav() {
        return nav;
    }

    public void setNav(Integer nav) {
        this.nav = nav;
    }


    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }


    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }


    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }


    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }


    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }


    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }


    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }


    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }


    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}