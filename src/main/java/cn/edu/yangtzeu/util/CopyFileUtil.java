package cn.edu.yangtzeu.util;

import java.io.*;

/**
 * @Description: 复制一个路径下目录及文件工具类 
 * @param  src 源文件的路径 
 * @param  target 目标文件的路径 
 * @author 解智鹏 
 *  
*/  
public class CopyFileUtil {
	 public static void main(String[] args) {  
		 	CopyFileUtil.copyFileOrDir("E:\\sofeware\\Tomcat\\Tomcat9\\webapps\\upload", "E:\\sofeware\\Tomcat\\Tomcat9\\webapps\\admin\\upload");  
	    }  
	      
	     /** 
	     * @Description: 整合两个操作，一个是文件夹的所有目录，然后复制目录下的所有文件到相应的目录 
	     * @param srcPath   需要复制的目录 
	     * @param targetPath  复制到哪里 
	     * @author 解智鹏 
	     * create: 2018-5-16 
	     */  
	    public static void copyFileOrDir(String srcPath, String targetPath){  
	        parseDir(srcPath,targetPath);  
	        copyAllFile(srcPath, targetPath);  
	    }  
	      
	    public static void copyAllFile(String srcPath, String targetPath){  
	        File f = new File(srcPath);  
	        File[] fileList = f.listFiles();  
	        for(File f1 : fileList){  
	            if(f1.isFile()) {  
	            	CopyFileUtil.copyFile(srcPath + "//" + f1.getName(), targetPath + "//" + f1.getName());  
	            }  
	            //判断是否是目录  
	            if(f1.isDirectory()) {  
	                copyAllFile(f1.getPath().toString(), targetPath + "//" + f1.getName());  
	            }  
	        }  
	    }  
	      
	     /** 
	         * @Description: 通过字节流复制一个文件 
	         * @param src      源文件的路径 
	         * @param target   目标文件的路径 
	         * @author 解智鹏 
	         * create: 2018-5-16 
	    */  
	    public static void copyFile(String src, String target){  
	            InputStream is = null;  
	            OutputStream os = null;  
	              
	            try {  
	                is = new FileInputStream(src);  
	                os = new FileOutputStream(target);  
	                byte[] buff = new byte[1024];  
	                int len = 0;  
	                while((len = is.read(buff, 0, buff.length)) != -1) {  
	                    os.write(buff, 0, len);  
	                }  
	                System.out.println("文件拷贝成功！");  
	            } catch (FileNotFoundException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            } catch (IOException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            } finally {  
	                if(os!=null){  
	                    try {  
	                        os.close();  
	                    } catch (IOException e) {  
	                        // TODO Auto-generated catch block  
	                        e.printStackTrace();  
	                    } finally {  
	                        if(is!=null){  
	                            try {  
	                                is.close();  
	                            } catch (IOException e) {  
	                                // TODO Auto-generated catch block  
	                                e.printStackTrace();  
	                            }  
	                        }  
	                    }  
	                }  
	            }  
	              
	        }  
	      
	     /** 
	     * @Description: 复制一个目录下的所有目录文件（只复制目录结构） 
	     * @param pathName   需要复制的目标目录 
	     * @param target     生成的目标文件目录 
	     * @author 解智鹏 
	     * create: 2018-5-16 
	     */  
	    public static void parseDir(String pathName, String target){  
	        //创建一个新的目录  
	        File targetFile = new File(target);  
	        if(!targetFile.exists()) {  
	            targetFile.mkdirs();  
	        }  
	          
	        //创建一个抽象路径  
	        File file = new File(pathName);  
	        if(file.isDirectory()){  
	            File[] files = file.listFiles();  
	            for(File f : files){  
	                if(f.isDirectory()) {  
	                    parseDir(f.getPath(), target + "//" + f.getName());  
	                }  
	            }  
	        }  
	    }  
}
