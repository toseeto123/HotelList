package com.hotel.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.hotelDAO;
import com.hotel.vo.hotelVO;

public class HotelReservationResult implements Action {

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "hotel/hotelReservationResult.jsp";

		hotelVO hvo = new hotelVO();

		hvo.setRoom(request.getParameter("room"));
		hvo.setPerson(request.getParameter("person"));

		hvo.setRoom_num(request.getParameter("room_num"));

		hvo.setStart_date(request.getParameter("start_date"));

		hvo.setFinish_date(request.getParameter("finish_date"));
		
		hvo.setPayment(request.getParameter("payment"));
//		System.out.println("payment");

		hotelDAO dao = hotelDAO.getInstance();
		dao.insertReservation(hvo);

		List<hotelVO> reserveList = dao.selectAllReservation();
		request.setAttribute("reserveList", reserveList);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
