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
		
		//id & ��й�ȣ ����������� �α��ε����ʰ� �ϱ����� ��ɾ� �߰����� (�Ķ���Ͱ� id,pass,lev )
			String id=request.getParameter("id");
			String pass=request.getParameter("pass");
			String lev=request.getParameter("lev");
			
			String url=null;
//			System.out.println("11111");
			//�̱��� ��ü DAO��ü ����
			hotelDAO hdao=hotelDAO.getInstance();
			int result=hdao.userCheck(id, pass,lev);
//			System.out.println("112");
			if(result== 2 || result == 3) { //������������� ������ �����Ǹ� ǥ���ϱ����� result��
			  //�α��� ������ Vo���� id�� ���Ͽ� ������ ȸ����������
		       hotelVO hvo=new hotelVO();
			    hvo=hdao.getMember(id); 
			    //���� ���
			  HttpSession session=request.getSession();
			  session.setAttribute("hotel",hvo);
			  session.setAttribute("result",result);
//			 System.out.println(result);
			  
			   url="/hotel/hotelMainPage.jsp";
//			   System.out.println("113");
			}else {
				url="/hotel/hotelLogin.jsp";
			    if(result==0) {//��й�ȣ Ʋ������
				}else if(result==-1) {//���̵� �������
					url="/hotel/hotelLogin.jsp";
				}else if(result==1) {//���� ����ġ�϶�
					url="/hotel/hotelLogin.jsp";
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
		
}

