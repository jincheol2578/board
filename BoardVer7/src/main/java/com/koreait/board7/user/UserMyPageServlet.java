package com.koreait.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UserMyPageServlet
 */
@WebServlet("/user/mypage")
public class UserMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyUtils.openJSP("마이페이지", "user/userMyPage", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath = request.getServletContext().getRealPath("/res/img");
		int maxFileSize = 10_485_760; //10*1024*1024 (10mb)
		
		System.out.println(uploadPath);
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath + "/temp", maxFileSize,
				"UTF-8", new DefaultFileRenamePolicy());
		
		int loginUserPk = MyUtils.getLoginUserPk(request);
		
		String targetFolder = uploadPath + "/user/" + loginUserPk;
		
		File folder = new File(targetFolder);
		
//		if(!folder.exists()) {   mkdirs()에서 exists를 검사해줌.
			folder.mkdirs();  // mkdirs()는 중간경로가 비어있어도 다 만들어줌  mkdir는 x
//		}
		
		String fileNm = multi.getFilesystemName("profileImg");
		System.out.println(fileNm);
		
		int lastDotIdx = fileNm.lastIndexOf("."); 
		String ext = fileNm.substring(lastDotIdx); // 확장자명 구하기
//		String ext2 = fileNm.substring(fileNm.lastIndexOf(".") + 1); 
		
		String newFileNm = UUID.randomUUID().toString() + ext;
		
		File imgFile = new File(uploadPath + "/temp" + "/" + fileNm);
		imgFile.renameTo(new File(targetFolder + "/" + newFileNm));
	}

}
