/**
 * 
 */
package com.dust.datautil.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.dust.common.CommonConstants;

/**
 * @author min
 *
 */
public class TextFileUtil {
	
	/**
	 * 用来做单元测试使用
	 * @param filePath
	 * @param tag
	 * @param sep
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	public static List<String> getStringsFromFileJunit(String filePath,String tag,String sep,String charset) throws IOException{
		
		String path = TextFileUtil.class.getClassLoader().getResource(filePath).getPath();
		return getStringsFromFile(path, tag, sep, charset);
	}
	
	/**
	 * 获取文件内容
	 * @param filePath
	 * @param tag
	 * @param sep
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	public static List<String> getStringsFromFile(String filePath,String tag,String sep,String charset) throws IOException{
		
		
		String path = StringUtils.trim(filePath);
		File file = new File(path);
		charset = StringUtils.isNotEmpty(charset) ? charset.trim() : "UTF-8";
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file),charset);
		BufferedReader br = new BufferedReader(isr);
		List<String> textList = new ArrayList<String>();
		String tempString = br.readLine();
		while(tempString != null) {
			if (StringUtils.isNotEmpty(tempString)) {
				textList.add(tag+sep+tempString.trim());
			}else {
				textList.add(tempString);
			}
			tempString = br.readLine();
		}
		br.close();
		isr.close();
		return textList;
	}
	
	/**
	 * 文本写入文件
	 * @param filePath
	 * @param textList
	 * @throws IOException
	 */
	public static void stringToFile(String filePath,List<String> textList) throws IOException {
		if (!StringUtils.isNotEmpty(filePath)) {
			return;
		}
		File file = new File(filePath.trim());
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), CommonConstants.ENCODE.toString());
		BufferedWriter bw = new BufferedWriter(osw);
		if (CollectionUtils.isNotEmpty(textList)) {
			for(String str : textList) {
				bw.write(str);
				bw.newLine();
			}
		}
		bw.close();
		osw.close();
	}

}
