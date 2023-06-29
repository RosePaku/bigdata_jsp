//파일을 보이게 하고 싶으면 c:upload 파일을 프로젝트 안으로 가져와야 함
//그게 아니라면 처음부터 사진을 처음부터 프로젝트 파일 안에 저장하기 
//물론 해도 되지만 근데 이건 보안 문제가 크고 파일이 흩어져서 관리하기 힘듬.
//다만 외부 경로로 저장하면 사용자 입장에서 보이지가 않음
package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BEditService implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
//		String uploadPath = "C:/workspace/jspMall_0621/src/main/webapp/upload";
		String uploadPath = "C:/upload";

		int size = 10*1024*1024;
		try {
			MultipartRequest multi = 
					new MultipartRequest(request, uploadPath,size,"utf-8",new DefaultFileRenamePolicy());
		
			int bno = Integer.parseInt(multi.getParameter("bno"));
			String id = multi.getParameter("id");
			String btitle = multi.getParameter("btitle");
			String bcontent = multi.getParameter("bcontent");
			String oldfile = multi.getParameter("oldfile");
			String bfile = multi.getFilesystemName("bfile");
			
			if(bfile==null) { bfile = oldfile;	}
			
			System.out.println("oldfile : "+ oldfile);
			System.out.println("bfile : "+ bfile);
			
			BoardDao bdao = new BoardDao();
			int result = bdao.updateOne(bno, id, btitle, bcontent, bfile);
			
			request.setAttribute("result", result);
		
		} catch (Exception e) {e.printStackTrace();}

	}

}