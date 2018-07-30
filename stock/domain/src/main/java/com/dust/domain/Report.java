/**
 * 
 */
package com.dust.domain;

import com.dust.datautil.strtool.Strable;

/**
 * @author min
 * 业绩报告
 */
@Strable(tag = "rp" , separator='\001')
public class Report {

	/**
	 * 股票代码
	 */
	@Strable.index( i = 1)
	private String code;
	
	/**
	 * 股票名称
	 */
	@Strable.index( i = 2)
	private String name;
	
	/**
	 * 每股收益
	 */
	@Strable.index( i = 3)
	private String esp;
	
	/**
	 * 每股收益同比
	 */
	@Strable.index( i = 4)
	private String esp_yoy;
	
	/**
	 * 每股净资产
	 */
	@Strable.index( i = 5)
	private String bvps;
	
	/**
	 * 净资产收益率
	 */
	@Strable.index( i = 6)
	private String roe;
	
	/**
	 * 每股现金流量(元)
	 */
	@Strable.index( i = 7)
	private String epcf;
	
	/**
	 * 净利润(万元)
	 */
	@Strable.index( i = 8)
	private String net_profits;
	
	/**
	 * 净利润同比(%)
	 */
	@Strable.index( i = 9)
	private String profits_yoy;
	
	/**
	 * 分配方案
	 */
	@Strable.index( i = 10)
	private String distrib;
	
	/**
	 * 发布日期
	 */
	@Strable.index( i = 11)
	private String report_date;

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
	 * @return the esp_yoy
	 */
	public String getEsp_yoy() {
		return esp_yoy;
	}

	/**
	 * @param esp_yoy the esp_yoy to set
	 */
	public void setEsp_yoy(String esp_yoy) {
		this.esp_yoy = esp_yoy;
	}

	/**
	 * @return the bvps
	 */
	public String getBvps() {
		return bvps;
	}

	/**
	 * @param bvps the bvps to set
	 */
	public void setBvps(String bvps) {
		this.bvps = bvps;
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
	 * @return the epcf
	 */
	public String getEpcf() {
		return epcf;
	}

	/**
	 * @param epcf the epcf to set
	 */
	public void setEpcf(String epcf) {
		this.epcf = epcf;
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
	 * @return the profits_yoy
	 */
	public String getProfits_yoy() {
		return profits_yoy;
	}

	/**
	 * @param profits_yoy the profits_yoy to set
	 */
	public void setProfits_yoy(String profits_yoy) {
		this.profits_yoy = profits_yoy;
	}

	/**
	 * @return the distrib
	 */
	public String getDistrib() {
		return distrib;
	}

	/**
	 * @param distrib the distrib to set
	 */
	public void setDistrib(String distrib) {
		this.distrib = distrib;
	}

	/**
	 * @return the report_date
	 */
	public String getReport_date() {
		return report_date;
	}

	/**
	 * @param report_date the report_date to set
	 */
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	
	
}
