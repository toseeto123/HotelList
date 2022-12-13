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

	// 회원가입 메소드
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

	// 아이디 찾기 메소드
	public hotelVO idFind(String name, String email, String id, String pass) {

		String sql = "select id from register where name=? and email=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		hotelVO hvo = null; // 회원정보 저장 객체

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
	//유저 check 메소드 (로그인관련) (jsp로그인 참고)
	public int userCheck(String id,String pass,String lev) {
		int result=3;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from register where id=?"; //전체 정보가져오는 것으로 바꿔
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			//아이디 하나로 가져올것이니깐 if
			if(rs.next()) {//id&password 일치할때
				if(pass.equals(rs.getString("pass"))) {
					if(lev.equals(rs.getString("lev"))) {
						result=2;
						if(lev.equals("B")) {
							result=3;
						}
					}else {//레벨 불일치일경우
						result=1;
					}
				}else {//비밀번호 다를 경우
					result=0;
				}
				
		}else { //아이디가 없을때
			result=-1;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, pstmt, conn);
		}
		return result;
	}
		// 회원정보를 가져올 getMember메소드 
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

				//찾는건 한번이니깐 if문 사용
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
		// 회원정보 업데이트 메소드
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
		
		//아이디 찾기 메소드
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

		// 아이디 중복체크 메소드
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
				//찾는거 한번이니깐 if문사용
				if(rs.next()) {
					result=1; //아이디 존재할경우 1로지정
					System.out.println(result);
				}else {
					result=-1; //아이디가 존재하지않을경우 -1로 지정
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
				//VO 객체 선언후 vo에 해당 값 전부 담기
				hotelVO hvo = new hotelVO();
				hvo.setId(rs.getString("id"));
				hvo.setName(rs.getString("name"));
				hvo.setPass(rs.getString("pass"));
				hvo.setLev(rs.getString("lev"));
				hvo.setEmail(rs.getString("email"));
				hvo.setPhone(rs.getString("phone"));
				//전체값 guestList에 담기
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
	// 하나의 게시글 삽입하는 메소드
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
		// 조회수 증가하는 메소드
		
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

		// 게시판 글 클릭시 상세보기 메소드(글번호로 찾아오고 실패시 null)

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
		// 해당회원의 정보를 담아올 메소드
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
				//가져올건 id 하나이므로 if문 사
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
