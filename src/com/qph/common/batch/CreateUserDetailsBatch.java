package com.qph.common.batch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import com.qph.model.UserDetails;

public class CreateUserDetailsBatch implements Runnable{
	private int beginIndex;
	
	public CreateUserDetailsBatch(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	
	@Override
	public void run() {
		UserDetails user = null;
		File file = new File("D://tmp//UserIndexFrom" + beginIndex + ".txt");
		ObjectOutputStream writer = null;
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			writer = new ObjectOutputStream(new FileOutputStream(file));

			for (int i = beginIndex; i < beginIndex + 10; i++) {
				user = new UserDetails();
				user.setCreatedDate(new Date());
				user.setUserName("User " + i);
				user.setUserId(i);
				writer.writeObject(user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(writer != null){
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
