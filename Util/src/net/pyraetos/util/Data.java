package net.pyraetos.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

public abstract class Data{

	public static void download(String url, String target){
		try{
			BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
			File file = new File(target);
			if(file.exists())
				file.delete();
			file.createNewFile();
			FileOutputStream out = new FileOutputStream(file);
			int datum;
			while((datum = in.read()) != -1){
				out.write(datum);
			}
			out.flush();
			out.close();
			in.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
