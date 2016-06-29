package hadoop;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.ChecksumFileSystem;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Progressable;
//copy from local file system
public class TestCheckSumFileSystem {
	public static void main(String[] args) throws Exception
	{
			Configuration conf = new Configuration();
			Job job = new Job(conf, "Crc");
			job.setJarByClass(TestCheckSumFileSystem.class);
			LocalFileSystem lfs = ChecksumFileSystem.getLocal(conf);
			System.out.println( lfs.getChecksumFile(new Path("/user/changes.txt")) );
	}
}
