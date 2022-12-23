package com.hotel.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.hotelDAO;
import com.hotel.vo.hotelVO;

public class SearchIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
//		String id=request.getParameter("id");
		
		hotelDAO hdao = hotelDAO.getInstance();
		hotelVO hvo=null;
		
		
		
		hvo=hdao.idFind(name,email);
//		System.out.println(hvo);
	
		if(hvo!=null) {
			out.print("<script>alert('"+name+"+"+email+"+님의 아이디는 "+hvo.getId()+"입니다.');"
                   + "location.href='HotelServlet?command=login_page'</script>");
		}else {
			 out.println("<script>alert('아이디가 존재하지 않습니다.');"
	                  + "location.href='HotelServlet?command=login_page'</script>");
	    }
	}
}
