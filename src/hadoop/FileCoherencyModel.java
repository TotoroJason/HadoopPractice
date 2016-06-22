package hadoop;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class FileCoherencyModel {
	public static void main(String[] args) throws Exception
	{
		String filename = args[0];
		String fileContent = args[1];
		
		
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(filename), conf);
		
		Path p = new Path(filename);
		
		FSDataOutputStream out = fs.create(p);
		out.write(fileContent.getBytes("UTF-8"));
		out.flush();
		out.sync();
	//	assertThat(fs.getFileStatus(p).getLen(), (long)(fileContent.length()));
		System.out.print("File length is "+ fs.getFileStatus(p).getLen());
	}
}
