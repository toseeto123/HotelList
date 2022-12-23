package com.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hotel.util.DBManager;
import com.hotel.vo.hotelVO;

public class hotelDAO {
	
	public hotelDAO() {}
	private static hotelDAO instance = new hotelDAO();
	public static hotelDAO getInstance() {
		return instance;
	}

	// ȸ������ �޼ҵ� >> ȸ�����Խ� ���� �� sql������ �Ϲ�ȸ���� B�� �ٲܰ�
	public void insertMember(hotelVO hvo) {
		String sql = "insert into register(id,pass,name,lev,email,phone) values(?,?,?,'B',?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			// set
			pstmt.setString(1, hvo.getId());
			pstmt.setString(2, hvo.getPass());
			pstmt.setString(3, hvo.getName());
			pstmt.setString(4, hvo.getEmail());
			pstmt.setString(5, hvo.getPhone());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
	}

	// ���̵� ã�� �޼ҵ�
	public hotelVO serchPass(hotelVO hvo) {
		String sql = "select * from register where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hvo.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				hvo = new hotelVO();
				hvo.setId(rs.getString("id"));
				hvo.setPass(rs.getString("pass"));
				hvo.setName(rs.getString("name"));
				hvo.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return hvo;
	}

	// ���̵� ã�� �޼ҵ�
	public hotelVO idFind(String name,String email) {
		hotelVO hvo=null;
		String sql = "select * from register where name=? and email=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("123444");
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			System.out.println(name);
			System.out.println(email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				hvo=new hotelVO();
				hvo.setId(rs.getString("id"));
				hvo.setName(rs.getString("name"));
				hvo.setEmail(rs.getString("email"));
//				System.out.println("12345555");
		   }
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return hvo;
	}
	// ���� check �޼ҵ� (�α��ΰ���) (jsp�α��� ����)
	// �α��Τ� �������ͺ���...

	public int userCheck(String id, String pass, String lev) {
		int result = 4;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from register where id=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			// ���̵� �ϳ��� �����ð��̴ϱ� if
			if (rs.next()) {// id&password ��ġ�Ҷ�
				if (pass.equals(rs.getString("pass"))) {
					if (lev.equals(rs.getString("lev"))) {
						result = 2;// ������ �α���
						if (lev.equals("B")) {// �Ϲ�ȸ���α���
							result = 3;
						}
					} else {// ���� ����ġ�ϰ��
						result = 1;
					}
				} else {// ��й�ȣ �ٸ� ���
					result = 0;
				}
			} else { // ���̵� ������
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return result;
	}

	// ȸ�������� ������ getMember�޼ҵ�
	public hotelVO getMember(String id) {
		hotelVO member = null;
		String sql = "select * from register where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			// ã�°� �ѹ��̴ϱ� if�� ���
			if (rs.next()) {
				member = new hotelVO();
				member.setId(rs.getString("id"));
				member.setPass(rs.getString("pass"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setLev(rs.getString("lev"));
				member.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return member;
	}
	// update member method
	public void updateMember(hotelVO hvo) {
		String sql = "update register set pass=?, name=?, email=?, phone=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			//
			pstmt.setString(1, hvo.getPass());
			pstmt.setString(2, hvo.getName());
			pstmt.setString(3, hvo.getEmail());
			pstmt.setString(4, hvo.getPhone());
			pstmt.setString(5, hvo.getId());
			//
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
	}
	// delete method
	public void deleteMember(String id) {
		String sql = "delete from register where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
	}

	// ȸ�����Խÿ� ���̵� �ߺ�üũ �޼ҵ�
	public int confirmID(String id) {
		int result = 0;
		String sql = "select id from register where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			// ã�°� �ѹ��̴ϱ� if�����
			if (rs.next()) {
				result = 1; // ���̵� �����Ұ�� 1������
			} else {
				result = -1; // ���̵� ��������������� -1�� ����
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return result;
	}

	public List<hotelVO> selectAllGuest() {
		String sql = "select * from register order by name desc";
		ArrayList<hotelVO> guestList = new ArrayList<hotelVO>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				// VO ��ü ������ vo�� �ش� �� ���� ���
				hotelVO hvo = new hotelVO();
				hvo.setId(rs.getString("id"));
				hvo.setName(rs.getString("name"));
				hvo.setPass(rs.getString("pass"));
				hvo.setLev(rs.getString("lev"));
				hvo.setEmail(rs.getString("email"));
				hvo.setPhone(rs.getString("phone"));
				// ��ü�� guestList�� ���
				guestList.add(hvo);

			}
		} catch (Exception e) {

		} finally {
			DBManager.close(rs, psmt, conn);
		}
		return guestList;

	}

	public List<hotelVO> selectAllBoard() {
		String sql = "select * from board order by num desc";

		List<hotelVO> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				hotelVO bvo = new hotelVO();
				bvo.setNum(rs.getInt("num"));
				bvo.setName(rs.getString("name"));
				bvo.setEmail(rs.getString("email"));
				bvo.setPass(rs.getString("pass"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContent(rs.getString("content"));
				bvo.setReadcount(rs.getInt("readcount"));
				bvo.setWritedate(rs.getTimestamp("writedate"));
				bvo.setStarpoint(rs.getString("starpoint"));

				list.add(bvo);
			}
		} catch (Exception e) {

		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return list;
	}
	// �ϳ��� �Խñ� �����ϴ� �޼ҵ�
	public void insertBoard(hotelVO hvo) {
		String sql = "insert into board(num, name, email, pass, title, content,starpoint) values(null,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hvo.getName());
			pstmt.setString(2, hvo.getEmail());
			pstmt.setString(3, hvo.getPass());
			pstmt.setString(4, hvo.getTitle());
			pstmt.setString(5, hvo.getContent());
			pstmt.setString(6, hvo.getStarpoint());
			//
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
	}
	// ��ȸ�� �����ϴ� �޼ҵ�

	public void updateReadCount(String num) {
		String sql = "update board set readcount = readcount+1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
	}
	// �Խ��� �� Ŭ���� �󼼺��� �޼ҵ�(�۹�ȣ�� ã�ƿ��� ���н� null)

	public hotelVO selectBoardByNum(String num) {
		String sql = "select * from board where num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		hotelVO hvo = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				hvo = new hotelVO();

				hvo.setNum(rs.getInt("num"));
				hvo.setName(rs.getString("name"));
				hvo.setPass(rs.getString("pass"));
				hvo.setEmail(rs.getString("email"));
				hvo.setTitle(rs.getString("title"));
				hvo.setContent(rs.getString("content"));
				hvo.setWritedate(rs.getTimestamp("writedate"));
				hvo.setReadcount(rs.getInt("readcount"));
				hvo.setStarpoint(rs.getString("starpoint"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return hvo;
	}
	public void updateBoard(hotelVO hvo) {
		String sql = "update board set name=?, email=?, pass=?, title=?, content=?, starpoint=? where num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hvo.getName());
			pstmt.setString(2, hvo.getEmail());
			pstmt.setString(3, hvo.getPass());
			pstmt.setString(4, hvo.getTitle());
			pstmt.setString(5, hvo.getContent());
			pstmt.setString(6, hvo.getStarpoint());
			pstmt.setInt(7, hvo.getNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
	}
	public void deleteBoard(String num) {
		String sql = "delete from board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
	}
	// �ش�ȸ���� ������ ��ƿ� �޼ҵ�
	public hotelVO selectMemberById(String Id) {
		String sql = "select * from register where id=?";
		hotelVO hvo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Id);
			rs = pstmt.executeQuery();
			// �����ð� id �ϳ��̹Ƿ� if�� ��
			if (rs.next()) {
				hvo = new hotelVO();
				hvo.setId(rs.getString("id"));
				hvo.setPass(rs.getString("pass"));
				hvo.setName(rs.getString("name"));
				hvo.setEmail(rs.getString("email"));
				hvo.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return hvo;
	}
	
	public hotelVO selectReservationByNum(String num) {
		String sql = "select * from reservation where num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		hotelVO hvo = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				hvo = new hotelVO();

				hvo.setNum(rs.getInt("num"));
				hvo.setRoom(rs.getString("room"));
				hvo.setPerson(rs.getString("person"));
				hvo.setRoom_num(rs.getString("room_num"));
				hvo.setStart_date(rs.getString("start_date"));
				hvo.setFinish_date(rs.getString("finish_date"));
				hvo.setPayment(rs.getString("payment"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return hvo;

	}
	public List<hotelVO> selectAllReservation() {
		String sql = "select * from reservation";

		List<hotelVO> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				hotelVO hvo = new hotelVO();
				
				hvo.setNum(rs.getInt("num"));
				hvo.setRoom(rs.getString("room"));
				hvo.setPerson(rs.getString("person"));
				hvo.setRoom_num(rs.getString("room_num"));
				hvo.setStart_date(rs.getString("start_date"));
				hvo.setFinish_date(rs.getString("finish_date"));
				hvo.setPayment(rs.getString("payment"));

				list.add(hvo);

			}
		} catch (Exception e) {

		} finally {

			DBManager.close(rs, pstmt, conn);

		}
		return list;
	}
	public void insertReservation(hotelVO hvo) {
		String sql = "insert into reservation(start_date,finish_date,room,room_num,person,num) values(?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hvo.getRoom());
			pstmt.setString(2, hvo.getPerson());
			pstmt.setString(3, hvo.getRoom_num());
			pstmt.setString(4, hvo.getStart_date());
			pstmt.setString(5, hvo.getFinish_date());
			pstmt.setInt(6, hvo.getNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);

		}

	}
	public void deleteReservation(String num) {
		String sql = "delete from reservation where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}

	}
	public void updateReservation(hotelVO hvo) {
		String sql = "update reservation set room=?, person=?, room_num=?, start_date=?, finish_date=?, payment=? where num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hvo.getRoom());
			pstmt.setString(2, hvo.getPerson());
			pstmt.setString(3, hvo.getRoom_num());
			pstmt.setString(4, hvo.getStart_date());
			pstmt.setString(5, hvo.getFinish_date());
			pstmt.setString(6, hvo.getPayment());
			pstmt.setInt(7, hvo.getNum());
			

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);

		}

	}

	
}

