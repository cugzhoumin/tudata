/**
 * 
 */
package com.dust.domain;

import com.dust.datautil.strtool.Strable;

/**
 * @author min
 * 商业盈利能力
 */
@Strable(tag="bp", separator='\001')
public class BusinessProfit {

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
	 * 净资产收益率
	 */
	@Strable.index(i = 3)
	private String roe;
	
	/**
	 * 净利率
	 */
	@Strable.index(i = 4)
	private String net_profit_ratio;
	
	/**
	 * 毛利率
	 */
	@Strable.index(i = 5)
	private String gross_profit_rate;
	
	/**
	 * 净利润（万元）
	 */
	@Strable.index(i = 6)
	private String net_profits;
	
	/**
	 * 每股收益
	 */
	@Strable.index(i = 7)
	private String esp;
	
	/**
	 * 营业收入(百万元)
	 */
	@Strable.index(i = 8)
	private String business_income;
	
	/**
	 * 每股主营收业务收入(元)
	 */
	@Strable.index(i = 9)
	private String bips;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the roe
	 */
	public String getRoe() {
		return roe;
	}

	/**
	 * @param roe the roe to set
	 */
	public void setRoe(String roe) {
		this.roe = roe;
	}

	/**
	 * @return the net_profit_ratio
	 */
	public String getNet_profit_ratio() {
		return net_profit_ratio;
	}

	/**
	 * @param net_profit_ratio the net_profit_ratio to set
	 */
	public void setNet_profit_ratio(String net_profit_ratio) {
		this.net_profit_ratio = net_profit_ratio;
	}

	/**
	 * @return the gross_profit_rate
	 */
	public String getGross_profit_rate() {
		return gross_profit_rate;
	}

	/**
	 * @param gross_profit_rate the gross_profit_rate to set
	 */
	public void setGross_profit_rate(String gross_profit_rate) {
		this.gross_profit_rate = gross_profit_rate;
	}

	/**
	 * @return the net_profits
	 */
	public String getNet_profits() {
		return net_profits;
	}

	/**
	 * @param net_profits the net_profits to set
	 */
	public void setNet_profits(String net_profits) {
		this.net_profits = net_profits;
	}

	/**
	 * @return the esp
	 */
	public String getEsp() {
		return esp;
	}

	/**
	 * @param esp the esp to set
	 */
	public void setEsp(String esp) {
		this.esp = esp;
	}

	/**
	 * @return the business_income
	 */
	public String getBusiness_income() {
		return business_income;
	}

	/**
	 * @param business_income the business_income to set
	 */
	public void setBusiness_income(String business_income) {
		this.business_income = business_income;
	}

	/**
	 * @return the bips
	 */
	public String getBips() {
		return bips;
	}

	/**
	 * @param bips the bips to set
	 */
	public void setBips(String bips) {
		this.bips = bips;
	}
	
	
	
}
