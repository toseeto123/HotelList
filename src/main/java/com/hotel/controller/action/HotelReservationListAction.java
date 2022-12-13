package com.hotel.controller.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.hotelDAO;
import com.hotel.vo.hotelVO;

public class HotelReservationListAction implements Action{

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/hotel/reservationList.jsp";
		//DAO 객체선언
		hotelDAO hdao=hotelDAO.getInstance();
		//
		List<hotelVO> reservationList=hdao.selectAllReservationList(); //DAO에 예약 리스트 만들어야함
	}
}
