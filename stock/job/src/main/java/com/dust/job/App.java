package com.dust.job;

import java.io.IOException;
import java.util.List;

import com.dust.common.CommonConstants;
import com.dust.datautil.file.TextFileUtil;

import jdk.internal.jshell.tool.resources.l10n;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	/**
    	 * 基本面数据
    	 */
    	String fileName = "basics.csv";
    	String tag = "sbic";
    	processFile(fileName, tag);
    	
    	/**
    	 * 现金流数据
    	 */
    	fileName = "bcf201701.csv"; 
    	tag = "cf";
    	processFile(fileName, tag);
    	
    	fileName = "bcf201702.csv"; 
    	processFile(fileName, tag);
    	
    	fileName = "bcf201703.csv"; 
    	processFile(fileName, tag);
    	
    	fileName = "bcf201704.csv"; 
    	processFile(fileName, tag);
    	
    	fileName = "bcf201801.csv"; 
    	processFile(fileName, tag);
    	
    	/**
    	 * 偿还债务能力
    	 */
    	fileName = "bdp201701.csv";
    	tag = "dp";
    	processFile(fileName, tag);
    	
    	fileName = "bdp201702.csv";
    	processFile(fileName, tag);
    	
    	fileName = "bdp201703.csv";
    	processFile(fileName, tag);
    	
    	fileName = "bdp201704.csv";
    	processFile(fileName, tag);
    	
    	fileName = "bdp201801.csv";
    	processFile(fileName, tag);
    	
    	/**
    	 * 商业成长能力
    	 */
    	fileName = "bg201701.csv";
    	tag="bg";
    	processFile(fileName, tag);
    	
    	fileName = "bg201702.csv";
    	processFile(fileName, tag);
    	
    	fileName = "bg201703.csv";
    	processFile(fileName, tag);
    	
    	fileName = "bg201704.csv";
    	processFile(fileName, tag);
    	
    	fileName = "bg201801.csv";
    	processFile(fileName, tag);
    	
    	/**
    	 * 商业运营能力 
    	 */
    	fileName = "bo201701.csv";
    	tag="bo";
    	processFile(fileName, tag);
    	
    	fileName = "bo201702.csv";
    	processFile(fileName, tag);
    	
    	fileName = "bo201703.csv";
    	processFile(fileName, tag);
    	
    	fileName = "bo201704.csv";
    	processFile(fileName, tag);
    	
    	fileName = "bo201801.csv";
    	processFile(fileName, tag);
    	
    	
    	/**
    	 * 
    	 */
    	fileName = "bp201701.csv";
    	tag="bp";
    	processFile(fileName, tag);
    	
    	fileName = "bp201702.csv";
    	processFile(fileName, tag);
    	
    	fileName = "bp201703.csv";
    	processFile(fileName, tag);
    	
    	fileName = "bp201704.csv";
    	processFile(fileName, tag);
    	
    	fileName = "bp201801.csv";
    	processFile(fileName, tag);
    	
    	/**
    	 * 
    	 */
    	fileName = "rp201701.csv";
    	tag = "rp";
    	processFile(fileName, tag);
    	
    	
    	fileName = "rp201702.csv";
    	processFile(fileName, tag);
    	
    	fileName = "rp201703.csv";
    	processFile(fileName, tag);
    	
    	fileName = "rp201704.csv";
    	processFile(fileName, tag);
    	
    	fileName = "rp201801.csv";
    	processFile(fileName, tag);
    	
    }
    
    private static void processFile(String fileName,String tag) throws IOException {
        List<String> textList = TextFileUtil.getStringsFromFile("/home/min/stock/"+fileName.trim(), tag, CommonConstants.DEFAULT_SEPARATOR, CommonConstants.ENCODE.toString());
        TextFileUtil.stringToFile("/home/min/stock/new/"+fileName.trim(), textList);
    }
}
