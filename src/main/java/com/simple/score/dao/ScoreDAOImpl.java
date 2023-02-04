package com.simple.score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("yyy")
public class ScoreDAOImpl implements ScoreDAO {
	
	@Autowired
	private DataSource dataSource; 
	
	@Override
	public void regist(ScoreVO vo) {
		String sql = "insert into score(name, kor, eng) values (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn =dataSource.getConnection();
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getKor());
			pstmt.setString(3, vo.getEng());
			
			pstmt.executeUpdate(); // insert, update, delete
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		String sql ="select * from score order by num desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		ArrayList<ScoreVO> list = new ArrayList<>();
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			//ORM -> 오브젝트릴레이션 맵핑
			while(rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getString("kor"));
				vo.setEng(rs.getString("eng"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(conn!=null)	conn.close();
				if(pstmt!=null)	pstmt.close();
				if(rs!=null)	rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}

	@Override
	public void delete(int num) {
		// 삭제기능 - num은 key가 아니고 인덱스가 넘어옴 (화면에서 key를 넘기도록 변경)
		String sql = "delete from score where num = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			int correct =pstmt.executeUpdate();
			System.out.println(correct);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(conn!=null)	conn.close();
				if(pstmt!=null)	pstmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}
	
//	//데이터베이스
//	List<ScoreVO> list = new ArrayList<>();
//	@Override
//	public void regist(ScoreVO vo) {
//		
//		//연결...
//		//connect
//		
//		
//		list.add(vo);//insert
//		System.out.println(list.toString());
//		
//	}
//	
//	public List<ScoreVO> getList() {
//		//데이터조회
//		
//		return list; 
//	}
//
//	@Override
//	public void delete(int num) {
//		list.remove(num);
//	}
	
	
	
	
}
