package com.getbestplace.util;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

public class FilesUtil {

	static final Logger LOGGER = Logger.getLogger(FilesUtil.class);
	
	
   public static void saveFile(File file, String fileName, String filesDirectory) throws IOException{
       FileInputStream in = null;
       FileOutputStream out = null;
        
       File dir = new File (filesDirectory);
       if ( !dir.exists() )
          dir.mkdirs();
        
       String targetPath =  dir.getPath() + File.separator + fileName;
       LOGGER.info("source file path ::"+file.getAbsolutePath());
       LOGGER.info("saving file to ::" + targetPath);
       File destinationFile = new File ( targetPath);
       try {
           /*in = new FileInputStream( file );
           out = new FileOutputStream( destinationFile );
           int c;

           while ((c = in.read()) != -1) {
               out.write(c);
           }*/
    	   
    	   FileUtils.copyFile(file, destinationFile);

       }finally {
           if (in != null) {
               in.close();
           }
           if (out != null) {
               out.close();
           }
       }
        
   }
}
