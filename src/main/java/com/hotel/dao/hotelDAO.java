package com.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.hotel.util.DBManager;
import com.hotel.vo.hotelVO;

public class hotelDAO {
	public hotelDAO() {

	}

	private static hotelDAO instance = new hotelDAO();

	public static hotelDAO getInstance() {
		return instance;
	}

	// ȸ������ �޼ҵ�
	public void loginHotel(hotelVO hvo) {
		String sql = "insert into register(name,id,pass,email) values(?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hvo.getName());
			pstmt.setString(2, hvo.getId());
			pstmt.setString(3, hvo.getPass());
			pstmt.setString(4, hvo.getEmail());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);

		}

	}

	// ���̵� ã�� �޼ҵ�
	public hotelVO idFind(String name, String email, String id, String pass) {

		String sql = "select id from register where name=? and email=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		hotelVO hvo = null; // ȸ������ ���� ��ü

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				hvo = new hotelVO();
				hvo.setId(rs.getString("id"));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return hvo;
	}
	//���� check �޼ҵ� (�α��ΰ���) (jsp�α��� ����)
	public int userCheck(String id,String pass,String lev) {
		int result=3;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from register where id=?"; //��ü ������������ ������ �ٲ�
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			//���̵� �ϳ��� �����ð��̴ϱ� if
			if(rs.next()) {//id&password ��ġ�Ҷ�
				if(pass.equals(rs.getString("pass"))) {
					if(lev.equals(rs.getString("lev"))) {
						result=2;
						if(lev.equals("B")) {
							result=3;
						}
					}else {//���� ����ġ�ϰ��
						result=1;
					}
				}else {//��й�ȣ �ٸ� ���
					result=0;
				}
				
		}else { //���̵� ������
			result=-1;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, pstmt, conn);
		}
		return result;
	}
		// ȸ�������� ������ getMember�޼ҵ� 
		public hotelVO getMember(String id) {
			hotelVO member=null;
			String sql="select * from register where id=?";

			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;

			try {
				conn=DBManager.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();

				//ã�°� �ѹ��̴ϱ� if�� ���
				if(rs.next()) {
					member=new hotelVO();
					member.setId(rs.getString("id"));
					member.setPass(rs.getString("pass"));
					member.setName(rs.getString("name"));
					member.setEmail(rs.getString("email"));
					member.setLev(rs.getString("lev"));
					member.setPhone(rs.getString("phone"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(rs, pstmt, conn);
			}
			return member;
		}
		// ȸ������ ������Ʈ �޼ҵ�
		public void updateMember(hotelVO hvo) {
			String sql="update register set pass=?, name=?, email=?, phone=? where id=?";
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try {
				conn=DBManager.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, hvo.getPass());
				pstmt.setString(2, hvo.getName());
				pstmt.setString(3, hvo.getEmail());
				pstmt.setString(4, hvo.getPhone());
				//
				pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(pstmt, conn);
			}
		}
		
		//���̵� ã�� �޼ҵ�
		public hotelVO serchID(String name,String email) {
			String sql="select * from register where name=? and email=?";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			hotelVO hvo =null;
			
			try {
				conn=DBManager.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, email);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					hvo=new hotelVO();
					hvo.setId(rs.getString("id"));
					hvo.setPass(rs.getString("pass"));
					hvo.setName(rs.getString("name"));
					hvo.setEmail(rs.getString("email"));
					hvo.setPhone(rs.getString("phone"));
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(rs, pstmt, conn);
			}
			return 
		}

		// ���̵� �ߺ�üũ �޼ҵ�
		public int confirmID(String id){
			int result=0;
			String sql="select id from register where id=?";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;

			try {
				conn=DBManager.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				//ã�°� �ѹ��̴ϱ� if�����
				if(rs.next()) {
					result=1; //���̵� �����Ұ�� 1������
					System.out.println(result);
				}else {
					result=-1; //���̵� ��������������� -1�� ����
					System.out.println(result);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
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
				//VO ��ü ������ vo�� �ش� �� ���� ���
				hotelVO hvo = new hotelVO();
				hvo.setId(rs.getString("id"));
				hvo.setName(rs.getString("name"));
				hvo.setPass(rs.getString("pass"));
				hvo.setLev(rs.getString("lev"));
				hvo.setEmail(rs.getString("email"));
				hvo.setPhone(rs.getString("phone"));
				//��ü�� guestList�� ���
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
			String sql="select * from register where id=?";
			hotelVO hvo=null;
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
				conn=DBManager.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, Id);
				rs=pstmt.executeQuery();
				//�����ð� id �ϳ��̹Ƿ� if�� ��
				if(rs.next()) {
					hvo=new hotelVO();
					hvo.setId(rs.getString("id"));
					hvo.setPass(rs.getString("pass"));
					hvo.setName(rs.getString("name"));
					hvo.setEmail(rs.getString("email"));
					hvo.setPhone(rs.getString("phone"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(rs, pstmt, conn);
			}
			return hvo;
		}
}
