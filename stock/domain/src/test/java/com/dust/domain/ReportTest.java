/**
 * 
 */
package com.dust.domain;

import java.io.IOException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import com.dust.common.CommonConstants;
import com.dust.datautil.file.TextFileUtil;
import com.dust.datautil.strtool.TranslateService;

/**
 * @author min
 *
 */
public class ReportTest {

	@Test
	public void test() throws IOException {
		List<String> texts = TextFileUtil.getStringsFromFile(
				this.getClass().getResource("/text/report.txt").getFile(), "rp", "\001",
				CommonConstants.ENCODE.toString());
		
		TranslateService translateService = new TranslateService(new Class[] { Report.class });
		
		if (CollectionUtils.isNotEmpty(texts)) {
			for (String text : texts) {
				Object object = translateService.getObject(text);
				if (object instanceof Report) {
					Report report = (Report) object;
					System.out.println(translateService.toString(report));
				}
			}
		}
	}

}
