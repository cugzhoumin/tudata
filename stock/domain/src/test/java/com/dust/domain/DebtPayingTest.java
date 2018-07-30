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
public class DebtPayingTest {

	@Test
	public void test() throws IOException {
		List<String> texts = TextFileUtil.getStringsFromFile(
				this.getClass().getResource("/text/debt_paying.txt").getFile(), "dp", "\001",
				CommonConstants.ENCODE.toString());
		
		TranslateService translateService = new TranslateService(new Class[] { DebtPaying.class });
		
		if (CollectionUtils.isNotEmpty(texts)) {
			for (String text : texts) {
				Object object = translateService.getObject(text);
				if (object instanceof DebtPaying) {
					DebtPaying debtPaying = (DebtPaying) object;
					System.out.println(translateService.toString(debtPaying));
				}
			}
		}
	}

}
