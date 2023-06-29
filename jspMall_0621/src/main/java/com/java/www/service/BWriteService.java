//파일을 보이게 하고 싶으면 c:upload 파일을 프로젝트 안으로 가져와야 함
//그게 아니라면 처음부터 사진을 처음부터 프로젝트 파일 안에 저장하기 
//물론 해도 되지만 근데 이건 보안 문제가 크고 파일이 흩어져서 관리하기 힘듬.
//다만 외부 경로로 저장하면 사용자 입장에서 보이지가 않음

package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import com.java.www.dao.BoardDao;

public class BWriteService implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//바로 하고 싶으면 (사용자 입장 고려)
//		String uploadPath = "C:/workspace/jspMall_0621/src/main/webapp/upload";
		String uploadPath = "C:/upload";
		int size = 10 * 1024 * 1024;

		try {
			MultipartRequest multi1 = new MultipartRequest(request, uploadPath, size, "utf-8",
					new DefaultFileRenamePolicy());
			String id = multi1.getParameter("id");
			String btitle = multi1.getParameter("btitle");
			String bcontent = multi1.getParameter("bcontent");
			String bfile1 = multi1.getFilesystemName("bfile");

			BoardDao bdao = new BoardDao();
			int result = bdao.insertOne(id, btitle, bcontent, bfile1);

//			// 두 번째 경로에 대한 파일 업로드
//			MultipartRequest multi2 = new MultipartRequest(request, uploadPath2, size, "utf-8",
//					new DefaultFileRenamePolicy());
//			String bfile2 = multi2.getFilesystemName("bfile");
//			int result2 = bdao.insertOne(id, btitle, bcontent, bfile2);
//
//			int result = Math.min(result1, result2);
			request.setAttribute("result", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	private HttpServletRequest getCopyOfRequest(HttpServletRequest request) {
//		// 기존 request 객체의 정보를 복사하여 새로운 request 객체를 생성하여 반환
//		// 요청 메서드, 헤더, 쿠키 등의 정보를 복사
//		// 파라미터 정보는 복사하지 않음
//		// 필요에 따라 파라미터 정보도 복사해야 할 경우 추가로 구현해야 함
//		return new CustomHttpServletRequest(request);
//	}
}
