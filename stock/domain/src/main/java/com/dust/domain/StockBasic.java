/**
 * 
 */
package com.dust.domain;

import com.dust.datautil.strtool.Strable;

/**
 * @author min
 * 基本面数据
 */
@Strable(tag="sbic", separator='\001')
public class StockBasic {

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
	 * 行业
	 */
	@Strable.index(i = 3)
	private String industry;
	
	/**
	 * 区域
	 */
	@Strable.index(i = 4)
	private String area;
	@Strable.index(i = 5)
	private Double pe;
	@Strable.index(i = 6)
	private String outstanding;
	@Strable.index(i = 7)
	private String totals;
	@Strable.index(i = 8)
	private String totalAssets;
	@Strable.index(i = 9)
	private String liquidAssets;
	@Strable.index(i = 10)
	private String fixedAssets;
	@Strable.index(i = 11)
	private String reserved;
	@Strable.index(i = 12)
	private String reservedPerShare;
	/**
	 * 每股收益
	 */
	@Strable.index(i = 13)
	private String esp;
	@Strable.index(i = 14)
	private String bvps;
	@Strable.index(i = 15)
	private String pb;
	@Strable.index(i = 16)
	private String timeToMarket;
	@Strable.index(i = 17)
	private String undp;
	@Strable.index(i = 18)
	private String perundp;
	@Strable.index(i = 19)
	private String rev;
	@Strable.index(i = 20)
	private String profit;
	@Strable.index(i = 21)
	private String gpr;
	@Strable.index(i = 22)
	private String npr;
	
	/**
	 * 最近的持股人数
	 */
	@Strable.index(i = 23)
	private Integer holders;
}
