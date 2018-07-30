/**
 * 
 */
package com.dust.job.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.springframework.context.ApplicationContext;

import com.dust.datautil.strtool.TranslateService;

/**
 * @author min
 *
 */
public class ChooseStockMR {
	
	private static final TranslateService TS = new TranslateService(new Class[] {});
	
	private static ApplicationContext CONTEXT;
	
	private static MultipleOutputs<Text, Text> mos;
	
	private static final Text NK = null;
	
	public static final class M extends Mapper<LongWritable, Text, Text, Text> {

		@Override
		protected void cleanup(Mapper<LongWritable, Text, Text, Text>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			super.cleanup(context);
		}

		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			super.map(key, value, context);
		}

		@Override
		protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
				throws IOException, InterruptedException {
			if (mos!=null) {
				mos.close();
			}
			super.setup(context);
		}
		
	}
}
