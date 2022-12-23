package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.hotelDAO;
import com.hotel.vo.hotelVO;

public class HotelRegisterSuccessForm implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String url="/hotel/hotelLogin.jsp";
		
		hotelVO hvo = new hotelVO();
		hvo.setId(request.getParameter("id"));
		hvo.setPass(request.getParameter("pass"));
		hvo.setName(request.getParameter("name"));
		hvo.setLev(request.getParameter("lev"));		
		hvo.setEmail(request.getParameter("email"));
		hvo.setPhone(request.getParameter("phone"));
		
		hotelDAO hdao = hotelDAO.getInstance();
		hdao.insertMember(hvo);
		
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
