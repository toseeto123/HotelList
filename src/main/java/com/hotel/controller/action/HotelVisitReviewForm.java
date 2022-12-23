package com.hotel.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.dao.hotelDAO;
import com.hotel.vo.hotelVO;

public class HotelVisitReviewForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "/hotel/hotelVisitReviw.jsp";

			hotelDAO dao = hotelDAO.getInstance();

			List<hotelVO> boardList = dao.selectAllBoard();
			request.setAttribute("boardList", boardList);

			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

		}

}
