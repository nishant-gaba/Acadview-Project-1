package Master;
import java.io.*;
import java.util.*;
public class Filelist {
    public static void listf(String DirectoryName) {
    	File files = new File(DirectoryName);
        File[] list=files.listFiles();
        for(File file:list) {
          if(file.isFile()) {
        	  System.out.println("File Name :" + file.getName() + " File Path : " + file.getPath()); 
          }
          else if(file.isDirectory()) {
        	  listf(file.getPath());
          }
        } 		
    }
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter file path");
    String path=sc.nextLine();
    String pathin="";
    FileReader reader = null;
    try {
    	reader = new FileReader(path);
    	int c;
    	while((c=reader.read())!=10)
    	  pathin=pathin+(char)c;	
    }catch(Exception e){
    	System.out.println(e);
    }
    System.out.println(pathin);
    int a=pathin.length();
    String path1=pathin.substring(0,a-1);
    listf(path1);
  }
}
