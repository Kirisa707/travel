package com.jswl.travel.pojo;

import java.util.List;

public class Route {
		// 3
	private int	rid ;
	private String	rname;
	private double	price;
	private String	routeIntroduce ;
	private String	rflag ;
	private String	rdate ;
	private String	isThemeTour; 
	private int	count ;  // 计数    count  这个字段用来记录点击多少次
	private int 	cid; 
	private String	rimage; 
	private int	sid ;
	private String	sourceId;
	// 所属分类
	private Category category;
	// 卖家表  2
	private Seller   seller;
	// 图片集合   1
	private List<RouteImg>  routeImgs;
	
	
	
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public List<RouteImg> getRouteImgs() {
		return routeImgs;
	}
	public void setRouteImgs(List<RouteImg> routeImgs) {
		this.routeImgs = routeImgs;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRouteIntroduce() {
		return routeIntroduce;
	}
	public void setRouteIntroduce(String routeIntroduce) {
		this.routeIntroduce = routeIntroduce;
	}
	public String getRflag() {
		return rflag;
	}
	public void setRflag(String rflag) {
		this.rflag = rflag;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getIsThemeTour() {
		return isThemeTour;
	}
	public void setIsThemeTour(String isThemeTour) {
		this.isThemeTour = isThemeTour;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getRimage() {
		return rimage;
	}
	public void setRimage(String rimage) {
		this.rimage = rimage;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	} 
	
	
	
	
	
	

}
