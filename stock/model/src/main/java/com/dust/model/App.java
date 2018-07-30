package com.dust.model;

import com.dust.datautil.strtool.TranslateService;
import com.dust.domain.StockBasic;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        TranslateService ts = new TranslateService(new Class[] {StockBasic.class});
        Object obj = ts.getObject("");
        if (obj instanceof StockBasic) {
			System.out.println("================================>>");
		}else {
			System.out.println("--------------------------------<<");
		}
    }
}
