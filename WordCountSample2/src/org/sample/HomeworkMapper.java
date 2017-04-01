
package org.sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import org.apache.commons.logging.Log;
// import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.mapreduce.Mapper;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

/**
 *
 * @author mac
 */
public class HomeworkMapper extends Mapper<LongWritable,Text,Text,LongWritable> {
    // The Karmasphere Studio Workflow Log displays logging from Apache Commons Logging, for example:
    // private static final Log LOG = LogFactory.getLog("org.sample.WordCountMapper");

	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    @Override
    protected void map(LongWritable key, Text value, Context context)
                    throws IOException, InterruptedException {

    	for (String keyword : value.toString().split("\n")) {

    			if (keyword.length() > 0) {
    				context.write(new Text(keyword), new LongWritable(1));
    			}
    		}
    	}
    }