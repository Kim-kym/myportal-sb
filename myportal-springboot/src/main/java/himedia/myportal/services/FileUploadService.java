package himedia.myportal.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import himedia.myportal.controllers.FileUploadController;

@Service
public class FileUploadService {
	private static final String SAVE_PATH = "c://uploads";
	
	private static final Logger logger = 
			LoggerFactory.getLogger(FileUploadController.class);
	
	//	입력 매개변수 
	//	클라이언트가 업로드한 파일을 MultipartFile 객체로 받음 
	public String store(MultipartFile multipartFile) {
		String saveFilename = "";
		
		try {
			//	originalFilename: 업로드된 파일의 원래 이름 
			//	extName: 파일 확장자
			String originalFilename = multipartFile.getOriginalFilename();
			//	substring과 lastIndexOf를 활용한 파일 확장자 추출 
			String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
			//	extName은 getSaveFilename 메서드에 전달되어, 고유 파일 이름 생성 시 확장자로 사용 
			saveFilename = getSaveFilename(extName);
			
			logger.debug("########## " + saveFilename);
			
			//	멀티파트 파일을 저장
			//	작동 과정: writeFile 호출
			writeFile(multipartFile, saveFilename);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		return saveFilename;	//	새로 생성된 파일 이름 
	}
	//	멀티파트 파일을 실제 위치로 저장하는 메서드 
	private void writeFile(
			MultipartFile multipartFile, //	업로드된 파일 데이터 
			String saveFilename) //	저장할 파일 이름  
		throws IOException {
		byte[] fileData = multipartFile.getBytes();	//	업로드된 파일의 내용을 바이트 배열로 변환 
		FileOutputStream fos = 
				new FileOutputStream(SAVE_PATH + "/" + saveFilename);
		fos.write(fileData);
		
		fos.close();
	}
	
	//	중복되지 않은 파일명 부여 
	//	반환되는 파일 이름에 ext(확장자)가 추가 
	private String getSaveFilename(String ext) {
		//	파일 이름 중복 방지를 위한 파일명 생성 
		//	TODO: 규칙 만들어 보기 
		Calendar cal = Calendar.getInstance();
		//	반환값은 파일 이름의 기본 부분이 됨
		return String.valueOf(cal.getTimeInMillis() / 1000)
				+ ext.toLowerCase();
	}
}
