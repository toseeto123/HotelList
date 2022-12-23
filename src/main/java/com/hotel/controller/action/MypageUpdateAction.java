package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.hotelDAO;
import com.hotel.vo.hotelVO;

public class MypageUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//member info save to hvo
		hotelVO hvo=new hotelVO();
		//saved info
		hvo.setId(request.getParameter("id"));
		hvo.setPass(request.getParameter("pass"));
	    hvo.setName(request.getParameter("name"));
	    hvo.setEmail(request.getParameter("email"));
		hvo.setPhone(request.getParameter("phone"));
		
		//dao instance load
		hotelDAO hdao=hotelDAO.getInstance();
		//updateinfo to hdao
		hdao.updateMember(hvo);
		System.out.println(hvo);
		
		RequestDispatcher rd=request.getRequestDispatcher("/hotel/hotelLogin.jsp");
		rd.forward(request, response);
	}
}
