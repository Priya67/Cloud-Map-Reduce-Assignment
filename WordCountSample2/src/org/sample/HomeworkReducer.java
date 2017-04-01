
package org.sample;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// import org.apache.commons.logging.Log;
// import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;

/**
 *
 * @author mac
 */
public class HomeworkReducer extends Reducer<Text,LongWritable,Text,LongWritable> {
    // The Karmasphere Studio Workflow Log displays logging from Apache Commons Logging, for example:
    // private static final Log LOG = LogFactory.getLog("org.sample.WordCountReducer");

	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	
	ArrayList<String> anslist = new ArrayList<String>();

	int key1 = 0;
	int key2 = 0;
	
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context)
                        throws IOException, InterruptedException {
		List<Integer> list = new ArrayList<Integer>();

		String[] keys = key.toString().split(" ");
		
		key1 = Integer.parseInt(keys[0]);
		key2 = Integer.parseInt(keys[1]);
				
    	if(map.containsKey(key1)){
			map.get(key1).add(key2);
		}
		else {
		list.add(key2);
		
		map.put(key1, list);
		}
     	
    	for(int selectedKey: map.keySet()) {
    		System.out.println("\n\n"+Arrays.asList(map));
    		for(int MiddleNumber : map.get(selectedKey)) {
    			if(map.containsKey(MiddleNumber)) {
    				for(int lastNumber : map.get(MiddleNumber)) {

    					StringBuilder sb = new StringBuilder();
    					sb.append(lastNumber);
    					sb.append(",");
    					sb.append(MiddleNumber);
    					
    					StringBuilder ansSb = new StringBuilder();

    					ansSb.append(sb);
    					ansSb.append(selectedKey);
    					
    					
    					if(anslist.indexOf(ansSb.toString())==-1) {
    						if(selectedKey!=MiddleNumber&&MiddleNumber!=lastNumber&&lastNumber!=selectedKey) {
    							context.write(new Text(sb.toString()), new LongWritable(selectedKey));
    							anslist.add(ansSb.toString());
    						}
    					}
    				}
        		}
    		}
    	}
    }
}
