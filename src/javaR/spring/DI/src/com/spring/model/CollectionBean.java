//package com.spring.model;
//
//import java.util.*;
//import com.spring.model.product.Computer;
//
//public class CollectionBean {
//
//	
//	List<Computer> itemList;
//	
//	public void setItemList(List<Computer> itemList){
//		this.itemList=itemList;
//	}
//	
//	public void printItemList(){
//		for(Computer item : itemList){
//			System.out.println(item.getContents());
//		}
//	}
//	
//	Set<Computer> itemSet;
//	
//	public void setItemSet(Set<Computer> itemSet){
//		this.itemSet=itemSet;
//	}
//	
//	public void printItemSet(){
//		for(Computer item : itemSet){
//			System.out.println(item.getContents());
//		}
//	}
//	
//	Map<String, Computer> itemMap;
//
//	public void setItemMap(Map<String, Computer> itemMap) {
//		this.itemMap = itemMap;
//	}
//	
//	public void printItemMap(){
//		for(String key : itemMap.keySet()){
//			Computer item= itemMap.get(key);
//			System.out.println(key+" : "+item.getContents());
//		}
//	}
//}
