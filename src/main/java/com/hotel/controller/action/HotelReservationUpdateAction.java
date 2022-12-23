package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.hotelDAO;
import com.hotel.vo.hotelVO;

public class HotelReservationUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hotelVO hvo = new hotelVO();

		hvo.setNum(Integer.parseInt(request.getParameter("num")));
		hvo.setRoom(request.getParameter("room"));
		hvo.setPerson(request.getParameter("person"));
		hvo.setRoom_num(request.getParameter("room_num"));
		hvo.setStart_date(request.getParameter("start_date"));
		hvo.setFinish_date(request.getParameter("finish_date"));
		

		hotelDAO dao = hotelDAO.getInstance();
		dao.updateReservation(hvo);

		new HotelManageAction().execute(request, response);
	}
}
