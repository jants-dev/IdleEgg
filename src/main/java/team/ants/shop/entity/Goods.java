package team.ants.shop.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
* 商品(goods)
*
* @author liushun
* @version 1.0.0 2018-03-13
*/
public class Goods implements Serializable {

    /** 商品ID */
    private Long id;

    /** 商品的唯一货号 */
    private String goodsSn;

    /** 商品名称 */
    private String goodsName;

    /** 商品分类 */
    private Long catId;

    /**  */
    private String beMall;

    /** 商品名称显示样式 */
    private String style;

    /** 商品点击次数 */
    private Integer hits;

    /** 库存数 */
    private Integer goodsNum;

    /** 商品单位 */
    private String goodsWeight;

    /** 市场售价 */
    private BigDecimal shopPrice;

    /** 促销价 */
    private BigDecimal promotePrice;

    /** 促销价开始时间 */
    private Date promoteStartDate;

    /**  */
    private Date promoteEndDate;

    /** 预设商品报警数 */
    private Integer warnNum;

    /** 商品简单描述 */
    private String goodsBrief;

    /** 商品详情 */
    private String goodsDesc;

    /** 商品封面图 */
    private String goodsThumb;

    /** 多张属性图片 */
    private String goodsImgs;

    /** 是否显示该商品；0，否；1，是 */
    private Integer isShow;

    /** 商品排序 */
    private Integer sortOrder;

    /** 商品类型；0，默认；1，最新； 2，推荐；3、热门；4、促销 */
    private Integer goodsType;

    /** 商品添加时间 */
    private Date createTime;

    /** 最后更新时间 */
    private Date lastUpdate;

	public Goods(){}

    public Goods(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }


    public String getGoodsSn(){
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn){
        this.goodsSn = goodsSn;
    }


    public String getGoodsName(){
        return goodsName;
    }

    public void setGoodsName(String goodsName){
        this.goodsName = goodsName;
    }


    public Long getCatId(){
        return catId;
    }

    public void setCatId(Long catId){
        this.catId = catId;
    }


    public String getBeMall(){
        return beMall;
    }

    public void setBeMall(String beMall){
        this.beMall = beMall;
    }


    public String getStyle(){
        return style;
    }

    public void setStyle(String style){
        this.style = style;
    }


    public Integer getHits(){
        return hits;
    }

    public void setHits(Integer hits){
        this.hits = hits;
    }


    public Integer getGoodsNum(){
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum){
        this.goodsNum = goodsNum;
    }


    public String getGoodsWeight(){
        return goodsWeight;
    }

    public void setGoodsWeight(String goodsWeight){
        this.goodsWeight = goodsWeight;
    }


    public BigDecimal getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(BigDecimal shopPrice) {
        this.shopPrice = shopPrice;
    }

    public BigDecimal getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(BigDecimal promotePrice) {
        this.promotePrice = promotePrice;
    }

    public Date getPromoteStartDate(){
        return promoteStartDate;
    }

    public void setPromoteStartDate(Date promoteStartDate){
        this.promoteStartDate = promoteStartDate;
    }


    public Date getPromoteEndDate(){
        return promoteEndDate;
    }

    public void setPromoteEndDate(Date promoteEndDate){
        this.promoteEndDate = promoteEndDate;
    }


    public Integer getWarnNum(){
        return warnNum;
    }

    public void setWarnNum(Integer warnNum){
        this.warnNum = warnNum;
    }


    public String getGoodsBrief(){
        return goodsBrief;
    }

    public void setGoodsBrief(String goodsBrief){
        this.goodsBrief = goodsBrief;
    }


    public String getGoodsDesc(){
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc){
        this.goodsDesc = goodsDesc;
    }


    public String getGoodsThumb(){
        return goodsThumb;
    }

    public void setGoodsThumb(String goodsThumb){
        this.goodsThumb = goodsThumb;
    }


    public String getGoodsImgs(){
        return goodsImgs;
    }

    public void setGoodsImgs(String goodsImgs){
        this.goodsImgs = goodsImgs;
    }


    public Integer getIsShow(){
        return isShow;
    }

    public void setIsShow(Integer isShow){
        this.isShow = isShow;
    }


    public Integer getSortOrder(){
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder){
        this.sortOrder = sortOrder;
    }


    public Integer getGoodsType(){
        return goodsType;
    }

    public void setGoodsType(Integer goodsType){
        this.goodsType = goodsType;
    }


    public Date getCreateTime(){
        return createTime;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }


    public Date getLastUpdate(){
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate){
        this.lastUpdate = lastUpdate;
    }



}