/**
 * 
 */
package com.dust.domain;

import com.dust.datautil.strtool.Strable;

/**
 * @author min
 * 商业运营能力
 */
@Strable(tag = "bo",separator='\001')
public class BusinessOperation {

	/**
	 * 股票代码
	 */
	@Strable.index(i = 1)
	private String code;
	
	/**
	 * 股票名称
	 */
	@Strable.index(i = 2)
	private String name;
	
	/**
	 * 应收账款周转率（次）
	 */
	@Strable.index(i = 3)
	private String arturnover;
	
	/**
	 * 应收账款周转天数
	 */
	@Strable.index(i = 4)
	private String arturndays;
	
	/**
	 * 存货周转率
	 */
	@Strable.index(i = 5)
	private String inventory_turnover;
	
	/**
	 * 存货周转天数
	 */
	@Strable.index(i = 6)
	private String inventory_days;
	
	/**
	 * 流动资产周转率(次)
	 */
	@Strable.index(i = 7)
	private String currentasset_turnover;
	
	/**
	 * 流动资产周转天数
	 */
	@Strable.index(i = 8)
	private String currentasset_days;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArturnover() {
		return arturnover;
	}

	public void setArturnover(String arturnover) {
		this.arturnover = arturnover;
	}

	public String getArturndays() {
		return arturndays;
	}

	public void setArturndays(String arturndays) {
		this.arturndays = arturndays;
	}

	public String getInventory_turnover() {
		return inventory_turnover;
	}

	public void setInventory_turnover(String inventory_turnover) {
		this.inventory_turnover = inventory_turnover;
	}

	public String getInventory_days() {
		return inventory_days;
	}

	public void setInventory_days(String inventory_days) {
		this.inventory_days = inventory_days;
	}

	public String getCurrentasset_turnover() {
		return currentasset_turnover;
	}

	public void setCurrentasset_turnover(String currentasset_turnover) {
		this.currentasset_turnover = currentasset_turnover;
	}

	public String getCurrentasset_days() {
		return currentasset_days;
	}

	public void setCurrentasset_days(String currentasset_days) {
		this.currentasset_days = currentasset_days;
	}
	
	
}
