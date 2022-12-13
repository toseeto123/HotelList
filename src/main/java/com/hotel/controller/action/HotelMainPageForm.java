	package com.hotel.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.dao.hotelDAO;
import com.hotel.vo.hotelVO;

public class HotelMainPageForm implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
			
		String url=null;
		//id & ��й�ȣ ����������� �α��ε����ʰ� �ϱ����� ��ɾ� �߰����� (�Ķ���Ͱ� id,pass,lev ��������� ��)
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String lev=request.getParameter("lev");
		//�̱��� ��ü DAO��ü ����
		hotelDAO hdao=hotelDAO.getInstance();
		int result=hdao.userCheck(id, pass,lev);
		if(result==2) {
		  //�α��� ������ Vo��ü�� id�� ���Ͽ� ������ ���� ��������
		  hotelVO hvo=hdao.getMember(id); 
		  //���� ���
		  HttpSession session=request.getSession();
		  session.setAttribute("loginUser",hvo);
		  session.setAttribute("result",result);
		  
		   url="/hotel/hotelMainPage.jsp";
		}else if(result==0) {//��й�ȣ Ʋ����
				url="/hotel/hotelLogin.jsp";
				System.out.println("��й�ȣ�Է� Ʋ��");
			}else if(result==-1) {//���̵� �������
				url="/hotel/hotelLogin.jsp";
			}else if (result ==3) {//������ �������ϰ��
				url="hotel/hotelMainPage2.jsp";
			}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
}
