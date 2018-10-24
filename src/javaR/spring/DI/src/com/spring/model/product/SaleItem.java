package com.spring.model.product;

public class SaleItem {

	Computer item;
	int cnt;
	long price;
	
	public SaleItem(){}

	public SaleItem(Computer item, int cnt, long price) {
		super();
		this.item = item;
		this.cnt = cnt;
		this.price = price;
	}

	
	public void setItem(Computer item) {
		this.item = item;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String display(){
		StringBuffer sb=new StringBuffer();
		sb.append("상품:"+item.getContents()+"\n");
		sb.append("수량:"+cnt+"\n");
		sb.append("금액:"+price+"\n");
		
		return sb.toString();
	}
	
}
