package team.ants.egg.entity;


import java.io.Serializable;

/**
 * 栏目分类(category)
 *
 * @author liushun
 * @version 1.0.0 2018-02-06
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
     * 父菜单
     */
    private Long parentId;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 栏目图
     */
    private String icon;

    /**
     * 连接URL
     */
    private String linkUrl;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 栏目统计
     */
    private Long hits;

    /**
     * SEO描述
     */
    private String description;

    /**
     * 状态; 0/隐藏 1显示
     */
    private Integer isView;

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


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }


    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getIsView() {
        return isView;
    }

    public void setIsView(Integer isView) {
        this.isView = isView;
    }


}