package Master;
import java.io.*;
import java.util.*;

public class Listing{
 public static void listf(String path1,String path2) throws IOException {
	 File Directory = new File(path1);
	 File[] list=Directory.listFiles();
	 
	  for(File file:list) {
		  if(file.isFile()) {
	//System.out.println("FileName :" + file.getName() + " FilePath :"+ file.getAbsolutePath() + " ");
			  FileWriter bw =null;
			//FileOutputStream writer = new FileOutputStream(path2,true);
		//	BufferedWriter bw = null;
			  try {
				//  bw=new BufferedWriter(new OutputStreamWriter(writer));
				  bw=new FileWriter(path2,true);
				 bw.write(file.getName() + "," + file.getPath());
				 bw.write(10);
				 bw.write(10);
			  }catch(Exception e) {
				  System.out.print(e);
			  }finally {
				  bw.close();
			  }
		  }
			else if(file.isDirectory()) {
				listf(file.getPath(),path2);
			}
	  }
 }
   public static void main(String[] args) throws IOException {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("enter file path");
	    String path=sc.nextLine();
	    String pathin="";
	    String pathout="";
	    FileReader reader = null;
	    try {
	    	reader = new FileReader(path);
	    	int c;
	    	while((c=reader.read())!=10)
	    	  pathin=pathin+(char)c;
	    	while((c=reader.read())!=-1)
	    		pathout=pathout+(char)c;
	    }catch(Exception e){
	    	System.out.println(e);
	    }
	  //  System.out.println(pathin);
	    int a=pathin.length();
	    String path1=pathin.substring(0,a-1);
	//   System.out.print(pathout);
	    listf(path1,pathout);
}
}