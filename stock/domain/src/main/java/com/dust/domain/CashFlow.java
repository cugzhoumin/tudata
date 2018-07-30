/**
 * 
 */
package com.dust.domain;

import com.dust.datautil.strtool.Strable;

/**
 * @author min
 *	现金流
 */
@Strable(tag="cf",separator='\001')
public class CashFlow {

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
	 * 经营现金流对比销售收入的比率
	 */
	@Strable.index(i = 3)
	private String cf_sales;
	
	/**
	 * 资产的经营现金流量汇报率
	 */
	@Strable.index(i = 4)
	private String rateofreturn;
	
	/**
	 * 经营现金流与净利润的比率
	 */
	@Strable.index(i = 5)
	private String cf_nm;
	
	/**
	 * 经营现金流量对负债比率
	 */
	@Strable.index(i = 6)
	private String cf_liabilities;
	
	/**
	 * 现金流量比率
	 */
	@Strable.index(i = 7)
	private String cashflowratio;

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
	 * @return the cf_sales
	 */
	public String getCf_sales() {
		return cf_sales;
	}

	/**
	 * @param cf_sales the cf_sales to set
	 */
	public void setCf_sales(String cf_sales) {
		this.cf_sales = cf_sales;
	}

	/**
	 * @return the rateofreturn
	 */
	public String getRateofreturn() {
		return rateofreturn;
	}

	/**
	 * @param rateofreturn the rateofreturn to set
	 */
	public void setRateofreturn(String rateofreturn) {
		this.rateofreturn = rateofreturn;
	}

	/**
	 * @return the cf_nm
	 */
	public String getCf_nm() {
		return cf_nm;
	}

	/**
	 * @param cf_nm the cf_nm to set
	 */
	public void setCf_nm(String cf_nm) {
		this.cf_nm = cf_nm;
	}

	/**
	 * @return the cf_liabilities
	 */
	public String getCf_liabilities() {
		return cf_liabilities;
	}

	/**
	 * @param cf_liabilities the cf_liabilities to set
	 */
	public void setCf_liabilities(String cf_liabilities) {
		this.cf_liabilities = cf_liabilities;
	}

	/**
	 * @return the cashflowratio
	 */
	public String getCashflowratio() {
		return cashflowratio;
	}

	/**
	 * @param cashflowratio the cashflowratio to set
	 */
	public void setCashflowratio(String cashflowratio) {
		this.cashflowratio = cashflowratio;
	}
	
	
	
}
