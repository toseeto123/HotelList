package com.hotel.controller.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.hotelDAO;
import com.hotel.vo.hotelVO;

public class HotelIdFindForm implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		//
		hotelDAO hdao= new hotelDAO();
		hotelVO hvo=hdao.serchID(name,email);
		//
		if(hvo!=null) {
			RequestDispatcher rd=request.getRequestDispatcher("/hotel/serchId.jsp");
			request.setAttribute("hvo", hvo);
			rd.forward(request, response);
		}else {
			request.setAttribute("message", "정확한 정보를 입력해주세요");
			request.setAttribute("loc", "/");
			RequestDispatcher rd=request.getRequestDispatcher("HotelServlet?command=hotel_id/pw_form");
			rd.forward(request, response);
		}

		
	}
}

		
		

