package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.vo.hotelVO;

public class ReturnMainPageAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		//로그인 정보로 세션보낸걸 다시 메인으로 가져가게 보내버려라
		hotelVO hvo=(hotelVO)session.getAttribute("hotel"); 
			String url="/hotel/hotelMainPage.jsp";
			RequestDispatcher rd=request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
}
