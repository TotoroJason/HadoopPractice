package hadoop;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

public class ListFileStatus {
	public static void main(String[] args) throws Exception
	{
		String uri = args[0];
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
		
		Path[] paths = new Path[args.length];
		for(int i=0; i<paths.length; i++)
		{
			paths[i] = new Path(args[i]);
		}
		
		FileStatus[] status =  fs.listStatus(paths);
		Path[] listedPaths = FileUtil.stat2Paths(status);
		for(Path p : listedPaths)
		{
			System.out.println(p);
		}		
		System.out.println("===================================================="); 
		FileStatus[] stt=fs.globStatus(new Path("hdfs://localhost:9000/user/*/*/{31,20}"), 
																	new RegexExcludePathFilter("^.*/2015/12/31$"));          
        Path[]pa1=FileUtil.stat2Paths(stt);  
        for(Path p:pa1)  
        {  
            System.out.println(p);  
        }  
	}
}


