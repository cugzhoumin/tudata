/**
 * 
 */
package com.dust.domain;

import com.dust.datautil.strtool.Strable;

/**
 * @author min
 * 企业的成长能力
 */
@Strable(tag="bg",separator='\001')
public class BusinessGrowth {

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
	 * 主营业务收入增长率
	 */
	@Strable.index(i = 3)
	private String mbrg;
	
	/**
	 * 净利润增长率
	 */
	@Strable.index(i = 4)
	private String nprg;
	
	/**
	 * 净资产增长率
	 */
	@Strable.index(i = 5)
	private String nav;
	
	/**
	 * 总资产增长率
	 */
	@Strable.index(i = 6)
	private String targ;
	
	/**
	 * 每股收益增长率
	 */
	@Strable.index(i = 7)
	private String epsg;
	
	/**
	 * 股东权益增长率
	 */
	@Strable.index(i = 8)
	private String seg;

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

	public String getMbrg() {
		return mbrg;
	}

	public void setMbrg(String mbrg) {
		this.mbrg = mbrg;
	}

	public String getNprg() {
		return nprg;
	}

	public void setNprg(String nprg) {
		this.nprg = nprg;
	}

	public String getNav() {
		return nav;
	}

	public void setNav(String nav) {
		this.nav = nav;
	}

	public String getTarg() {
		return targ;
	}

	public void setTarg(String targ) {
		this.targ = targ;
	}

	public String getEpsg() {
		return epsg;
	}

	public void setEpsg(String epsg) {
		this.epsg = epsg;
	}

	public String getSeg() {
		return seg;
	}

	public void setSeg(String seg) {
		this.seg = seg;
	}
	
	
}
