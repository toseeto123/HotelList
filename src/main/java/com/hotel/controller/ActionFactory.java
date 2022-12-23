package com.hotel.controller;

import com.hotel.controller.action.Action;
import com.hotel.controller.action.BoardDeleteAction;
import com.hotel.controller.action.BoardUpdateAction;
import com.hotel.controller.action.BoardUpdateFormAction;
import com.hotel.controller.action.BoardViewAction;
import com.hotel.controller.action.BoardWriteAction;
import com.hotel.controller.action.BoardWriteFormAction;
import com.hotel.controller.action.DeleteMyInfoAction;
import com.hotel.controller.action.HotelIdFindForm;
import com.hotel.controller.action.HotelIdPWAction;
import com.hotel.controller.action.HotelLoginAction;
import com.hotel.controller.action.HotelMainPageForm;
import com.hotel.controller.action.HotelManageAction;
import com.hotel.controller.action.HotelPayFormAction;
import com.hotel.controller.action.HotelRegisterAction;
import com.hotel.controller.action.HotelRegisterIdCheckAction;
import com.hotel.controller.action.HotelRegisterSuccessForm;
import com.hotel.controller.action.HotelReservationDeleteAction;
import com.hotel.controller.action.HotelReservationForm;
import com.hotel.controller.action.HotelReservationResult;
import com.hotel.controller.action.HotelReservationUpdateAction;
import com.hotel.controller.action.HotelReservationUpdateFormAction;
import com.hotel.controller.action.HotelReservationViewAction;
import com.hotel.controller.action.HotelVisitReviewForm;
import com.hotel.controller.action.MypageUpdateAction;
import com.hotel.controller.action.MypageUpdateForm;
import com.hotel.controller.action.ReturnMainPageAction;
import com.hotel.controller.action.SearchIdAction;

public class ActionFactory {
	// �̱���
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
	
		Action action = null;
		if (command.equals("login_page")) {
			action = new HotelLoginAction();
			System.out.println(command);
		}else if (command.equals("hotel_main_page_form")) {
			action = new HotelMainPageForm();
		} else if (command.equals("hotel_register_form")) {
			action = new HotelRegisterAction();
		} else if (command.equals("hotel_register")) {
			action = new HotelRegisterSuccessForm();
		} else if (command.equals("hotel_id/pw_form")) {
			action = new HotelIdPWAction();
		}  else if (command.equals("hotel_id_check_form")) {
			action = new HotelRegisterIdCheckAction();
		}else if (command.equals("visit_review")) {
			action = new HotelVisitReviewForm();
		} else if (command.equals("reservation_form")) {
			action = new HotelReservationForm();
		} else if (command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		} else if (command.equals("board_write")) {
			action = new BoardWriteAction();
		} else if (command.equals("board_view")) {
			action = new BoardViewAction();
		} else if (command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		} else if (command.equals("board_update")) {
			action = new BoardUpdateAction();
		} else if(command.equals("board_delete_form")) {
			action = new BoardDeleteAction();
		}else if (command.equals("hotel_reservation_result")) {
			action = new HotelReservationResult();
		} else if (command.equals("hotel_pay_form")) {
			action = new HotelPayFormAction();	
		}else if(command.equals("member_mypage")) {
			action = new MypageUpdateForm();
		}else if(command.equals("member_mypage_update")) {
			action = new MypageUpdateAction();
		}else if (command.equals("reservation_manage")) {
			action = new HotelManageAction();
		}else if (command.equals("reservation_view")) {
			action = new HotelReservationViewAction();
		}else if (command.equals("reservation_delete_form")) {
			action = new HotelReservationDeleteAction();
		} else if (command.equals("reservation_update_form")) {
			action = new HotelReservationUpdateFormAction();
		} else if (command.equals("reservation_update")) {
			action = new HotelReservationUpdateAction();
		}else if(command.equals("return_main_page")) {
			action = new ReturnMainPageAction();
		}else if(command.equals("delete_myinfo")) {
			action = new DeleteMyInfoAction();
		}else if(command.equals("search_id")) {
			action = new SearchIdAction();
		}
		return action;
	}
} 
