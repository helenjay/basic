package com.basic.commons.util;

import java.io.*;
public class FileUtil {
	public static boolean renameFile(String srcname, String destname) {
		if (!FileUtil.isFileExist(srcname)) {
			return false;
		}
		
		try {
			File srcfile = new File(srcname);
			File destfile = new File(destname);
			File path=new File(destfile.getPath());
			if(!path.exists()){
				path.mkdirs();
			}
			if (destfile.exists()) {
				destfile.delete();
			}
			return srcfile.renameTo(destfile);
		} catch (Exception e) {
			System.out.println("error while rename the file" + e);
		}
		return false;
	}

	public static boolean copyFile(String src, String dest) {
		boolean ok = false;
		try {
			File fsrc = new File(src);
			File fdest = new File(dest);
			BufferedReader in =
				new BufferedReader(new FileReader(fsrc));
			BufferedWriter out =
				new BufferedWriter(new FileWriter(fdest));
			String buf;
			while ((buf = in.readLine()) != null) {
				out.write(buf + "\n");
			}
			in.close();
			out.close();
			ok = true;
		} catch (Exception e) {
			System.out.println("ERROR COPYING " + src + " TO " + dest);
			e.printStackTrace();
		}
		return ok;
	}

	public static boolean removeFile(String file) {
		boolean ok = false;
		try {
			File f = new File(file);
			if (f.exists())
				f.delete();
			ok = true;
		} catch (Exception e) {
			System.out.println("ERROR DELETING " + file);
			e.printStackTrace();
		}
		return ok;
	}

	public static boolean isFileExist(String filename) {
		try {
			if ((filename == null) || ("".equals(filename.trim())))
				return false;
			File f1 = new File(filename);
			if (f1.exists()) {
				f1 = null;
				return true;
			}

		} catch (Exception e) {
		}
		return false;

	}
	
	public static String fileToString(String src)
	{
		StringBuffer sbuf = new StringBuffer();
		try
		{
			File inputFile = new File(src);
			FileInputStream in = new FileInputStream(inputFile);
			int c;
			while ((c = in.read()) != -1) sbuf.append((char) c);
			in.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "";
		}
		return sbuf.toString();
	}

	public static boolean stringToFile(String filename, String s) {
		if (s == null) return true;
		if (! s.equals("")) {
			try {
				File f = new File(filename);
				BufferedWriter msgout = new BufferedWriter(new FileWriter(f));
				msgout.write(s);
				msgout.close();
				return true;
			}
			catch (Exception e) { e.printStackTrace(); return false; }
		}
		return true;
	}	

	public static void main(String arg[]) {
		try {
			FileUtil.renameFile(
				"D:\\test.xls",
				"D:\\temp\\sosss.xls");
		} catch (Exception e) {
			System.out.println("Error" + e);
		}

	}

}
