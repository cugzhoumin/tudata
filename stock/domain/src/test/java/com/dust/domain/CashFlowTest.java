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
public class CashFlowTest {

	@Test
	public void test() throws IOException {
		List<String> texts = TextFileUtil.getStringsFromFile(
				this.getClass().getResource("/text/cash_flow.txt").getFile(), "cf", "\001",
				CommonConstants.ENCODE.toString());
		
		TranslateService translateService = new TranslateService(new Class[] { CashFlow.class });
		
		if (CollectionUtils.isNotEmpty(texts)) {
			for (String text : texts) {
				Object object = translateService.getObject(text);
				if (object instanceof CashFlow) {
					CashFlow cashFlow = (CashFlow) object;
					System.out.println(translateService.toString(cashFlow));
				}
			}
		}
	}

}
