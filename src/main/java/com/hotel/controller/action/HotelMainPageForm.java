	package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.dao.hotelDAO;
import com.hotel.vo.hotelVO;

public class HotelMainPageForm implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
			
		String url=null;
		//id & 비밀번호 맞지않을경우 로그인되지않게 하기위한 명령어 추가구간 (파라미터값 id,pass,lev 가져오기는 생)
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String lev=request.getParameter("lev");
		//싱글톤 객체 DAO객체 생성
		hotelDAO hdao=hotelDAO.getInstance();
		int result=hdao.userCheck(id, pass,lev);
		if(result==2) {
		  //로그인 성공시 Vo객체에 id를 통하여 나머지 정보 가져오기
		  hotelVO hvo=hdao.getMember(id); 
		  //세션 사용
		  HttpSession session=request.getSession();
		  session.setAttribute("loginUser",hvo);
		  session.setAttribute("result",result);
		  
		   url="/hotel/hotelMainPage.jsp";
		}else if(result==0) {//비밀번호 틀렸을
				url="/hotel/hotelLogin.jsp";
				System.out.println("비밀번호입력 틀림");
			}else if(result==-1) {//아이디가 없을경우
				url="/hotel/hotelLogin.jsp";
			}else if (result ==3) {//레벨이 관리자일경우
				url="hotel/hotelMainPage2.jsp";
			}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
}
