package com.springmvc.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传至服务器
 */
public class ServerFileUploadUtil {

	@org.jetbrains.annotations.Nullable
	public static String load(MultipartFile file, HttpServletRequest request) throws IOException{
			//为了一时间命名上传文件的名字
		    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyyMMddHHmmssSS");
		    String str=simpleDateFormat.format(new Date());

			// uploads文件夹位置
			String rootPath = request.getServletContext().getRealPath("/uploadFiles/images");

		    //得到文件的上传的原始文件名称
			String oldname=file.getOriginalFilename();
		    String extName = oldname.substring(oldname.lastIndexOf(".")).toLowerCase();

		    String imgeExt = "bmp dib gif jfif jpe jpeg jpg png tif tiff ico";
				//得到新的文件名
				String newFileName = oldname + oldname.substring(oldname.lastIndexOf("."));

				//创建新的文件夹
				Calendar calendar = Calendar.getInstance();

				File dataDirs = new File(calendar.get(Calendar.YEAR) + File.separator + (calendar.get(Calendar.MONTH)+1));
				File newFile = new File(rootPath + File.separator + dataDirs + File.separator + newFileName);

				if ( !newFile.getParentFile().exists()){
					newFile.getParentFile().mkdirs();
				}
				file.transferTo(newFile	);

				String fileUrl = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH)+1) + "/" + newFileName;;
				return fileUrl;
	}
}
