package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.hotelDAO;

public class HotelRegisterIdCheckAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="/hotel/HotelRegisterIdCheck.jsp";
		String id=request.getParameter("id");
		
		hotelDAO hdao=hotelDAO.getInstance();
		
		int result=hdao.confirmID(id); // DAO�� confimID �����������.
		//userid, result ��� ����
		request.setAttribute("id", id);
		request.setAttribute("result", result);
		//����� �Ѹ���
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}
}
