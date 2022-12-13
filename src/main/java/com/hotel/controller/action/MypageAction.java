package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.hotelDAO;
import com.hotel.vo.hotelVO;

public class MypageAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String Id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		String url="HotelServlet?command=update_member";
		
		hotelDAO hdao=hotelDAO.getInstance();
		
		//멤버 정보 ID로 출력해올 selectMemberById 실
		hotelVO hvo=hdao.selectMemberById(Id);
		//
		
		//
		hvo.setId(Id);
		hvo.setPass(pass);
		hvo.setName(name);
		hvo.setEmail(email);
		hvo.setPhone(phone);
		
		hdao.updateMember(hvo);
		
		request.setAttribute("hotel", hvo);
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
	    
		
	}

}
