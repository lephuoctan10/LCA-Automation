package dxc.lca.automation.common.utils;

import java.io.*;

public class FileUtils {

	public static void copyFile(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			dest.createNewFile();
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}
	}
	
	public static void makeDirectory (String path) {
		File newFolder = new File(path);
        boolean created =  newFolder.mkdirs();
         
        if(created) {
            System.out.println(path + " was created !");
        }
        else {
            System.out.println(path + " was existed");
        }
	}
}
