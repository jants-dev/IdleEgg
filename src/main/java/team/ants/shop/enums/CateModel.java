package team.ants.shop.enums;

/**
 * 分类模型
 *
 * @author MrShun
 * @version 1.0
 * @Date 2018-03-24
 */
public enum CateModel {

    Goods(0, "商品"),
    Service(1, "服务"),
    Advertise(2, "招聘"),
    Post(3, "帖子"),
    Article(4, "资讯");

    private Integer index;

    private String desc;

    CateModel(Integer index, String desc) {
        this.index = index;
        this.desc = desc;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
