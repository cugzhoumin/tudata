package com.dust.domain;

import com.dust.datautil.strtool.Strable;

/**
 * 
 * @author min
 * 企业偿债能力
 */
@Strable(tag="dp",separator='\001')
public class DebtPaying {
	
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
	 * 流动比率
	 */
	@Strable.index(i = 3)
	private String currentratio;
	
	/**
	 * 速动比率
	 */
	@Strable.index(i = 4)
	private String quickratio;
	
	/**
	 * 现金比率
	 */
	@Strable.index(i = 5)
	private String cashratio;
	
	/**
	 * 利息支付倍数
	 */
	@Strable.index(i = 6)
	private String icratio;
	
	/**
	 * 股东权益比率
	 */
	@Strable.index(i = 7)
	private String sheqratio;
	
	/**
	 * 股东权益增长率
	 */
	@Strable.index(i = 8)
	private String adratio;

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
	 * @return the currentratio
	 */
	public String getCurrentratio() {
		return currentratio;
	}

	/**
	 * @param currentratio the currentratio to set
	 */
	public void setCurrentratio(String currentratio) {
		this.currentratio = currentratio;
	}

	/**
	 * @return the quickratio
	 */
	public String getQuickratio() {
		return quickratio;
	}

	/**
	 * @param quickratio the quickratio to set
	 */
	public void setQuickratio(String quickratio) {
		this.quickratio = quickratio;
	}

	/**
	 * @return the cashratio
	 */
	public String getCashratio() {
		return cashratio;
	}

	/**
	 * @param cashratio the cashratio to set
	 */
	public void setCashratio(String cashratio) {
		this.cashratio = cashratio;
	}

	/**
	 * @return the icratio
	 */
	public String getIcratio() {
		return icratio;
	}

	/**
	 * @param icratio the icratio to set
	 */
	public void setIcratio(String icratio) {
		this.icratio = icratio;
	}

	/**
	 * @return the sheqratio
	 */
	public String getSheqratio() {
		return sheqratio;
	}

	/**
	 * @param sheqratio the sheqratio to set
	 */
	public void setSheqratio(String sheqratio) {
		this.sheqratio = sheqratio;
	}

	/**
	 * @return the adratio
	 */
	public String getAdratio() {
		return adratio;
	}

	/**
	 * @param adratio the adratio to set
	 */
	public void setAdratio(String adratio) {
		this.adratio = adratio;
	}
	
	
	
}
