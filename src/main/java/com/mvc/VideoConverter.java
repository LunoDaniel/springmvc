package com.mvc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VideoConverter {
	public void videoConverter() throws IOException {
		File file = new File("/home/lunobatista/Área de Trabalho/Pessoal/videos/teste.dv");

		byte[] buf = new byte[1024];
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try (FileInputStream fis = new FileInputStream(file);) {
			for (int readNum; (readNum = fis.read(buf)) != -1;) {
				bos.write(buf, 0, readNum);
			}
		} catch (IOException ex) {
		} finally {
			byte[] bytes = bos.toByteArray();

			File someFile = new File("/home/lunobatista/Área de Trabalho/Pessoal/videos/teste.mp4");
			FileOutputStream fos = new FileOutputStream(someFile);
			fos.write(bytes);
			fos.flush();
			fos.close();
		}
	}
}
