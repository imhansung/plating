package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LectureDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	// DB ���� �޼ҵ�
	public void getConnection() {
		try {
			// JDBC ����̹� ���� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			
			// ������ ���̽� ���ᰴü ����
			conn = DriverManager.getConnection(url, user, password);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// DB close �޼ҵ�
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// �������� ��ü �����͸� �����ִ� �޼ҵ�
	public ArrayList<LectureVO> Lecture_ViewAll() {
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		
		try {
			getConnection();
			
			// �������� ��ü��� sql��
			String sql = "select * from Lecture";
			
			// SQL ���� ��ü����
			psmt = conn.prepareStatement(sql);
			
			// sql�� ����
			rs = psmt.executeQuery();
			
			// ���ó��
			if(rs.next()) {		
				System.out.println("�������� ��� ����");
				
				int get_no = rs.getInt("lecture_no");
				String get_NM = rs.getString("lecture_NM");
				String get_teach = rs.getString("lecture_teach");
				String get_site = rs.getString("lecture_site");
				String get_count = rs.getString("lecture_count");
				int get_price = rs.getInt("lecture_price");
				double get_point = rs.getDouble("lecture_point");
				String get_review = rs.getString("lecture_review");
				String get_url = rs.getString("lecture_url");
				String get_cat = rs.getString("lecture_cat");
				
				LectureVO vo = new LectureVO(get_no, get_NM, get_teach, get_site, get_count, get_price, get_point, get_review, get_url, get_cat);
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("�������� ��� ����");
		} finally {
			close();
		}
		return list;
	}

	// �˻� �޼ҵ�
	public ArrayList<LectureVO> Lecture_Search(String words){
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		String sql = "";
		
		try {
			getConnection();
			
			// �������� �˻�� ����
			String[] hitwords = words.split(" ");
			
			for (int i=0; i<hitwords.length; i++) {
				// �˻� sql��
				sql = "select * from Lecture where lecture_NM like '%?%' OR lecture_teach like '%?%' OR lecture_site like '%?%' OR lecture_count like '%?%' OR lecture_price like '%?%' OR lecture_point like '%?%' OR lecture_review like '%?%' OR lecture_url like '%?%' OR lecture_cat like '%?%'";
				
				// SQL ���� ��ü ����
				psmt = conn.prepareStatement(sql);
				
				// ���ε� ���� ä���
				for (int j=0; j<9; j++) {
					psmt.setString(j+1, hitwords[i]);
				}
				
				// sql�� ����
				rs = psmt.executeQuery();
				
				// ���ó��
				if(rs.next()) {		
					int get_no = rs.getInt("lecture_no");
					String get_NM = rs.getString("lecture_NM");
					String get_teach = rs.getString("lecture_teach");
					String get_site = rs.getString("lecture_site");
					String get_count = rs.getString("lecture_count");
					int get_price = rs.getInt("lecture_price");
					double get_point = rs.getDouble("lecture_point");
					String get_review = rs.getString("lecture_review");
					String get_url = rs.getString("lecture_url");
					String get_cat = rs.getString("lecture_cat");
					
					LectureVO vo = new LectureVO(get_no, get_NM, get_teach, get_site, get_count, get_price, get_point, get_review, get_url, get_cat);
					list.add(vo);
				}
				
			}	
			System.out.println("�˻� ����");
					
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("�˻� ����");
		} finally {
			close();
		}
		
		return list;
	}

	// ���� �޼ҵ�
	public ArrayList<LectureVO> Lecture_filter(ArrayList<String> filter){
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		String sql = "";
		
		try {
			getConnection();
			
			for(int i=0; i<filter.size();i++) {
				// ���� sql��(�ݺ����� ���� ������ ���Ϳ� ���� ����鸸 ��������)
				sql = "select * from Lecture where lecture_cat = ?";
				
				// SQL ���� ��ü ����
				psmt = conn.prepareStatement(sql);
				
				// ���ε� ���� ä���
				psmt.setString(1, filter.get(i));
				
				// sql�� ����
				rs = psmt.executeQuery();
				
				// ���ó��
				if(rs.next()) {		
					int get_no = rs.getInt("lecture_no");
					String get_NM = rs.getString("lecture_NM");
					String get_teach = rs.getString("lecture_teach");
					String get_site = rs.getString("lecture_site");
					String get_count = rs.getString("lecture_count");
					int get_price = rs.getInt("lecture_price");
					double get_point = rs.getDouble("lecture_point");
					String get_review = rs.getString("lecture_review");
					String get_url = rs.getString("lecture_url");
					String get_cat = rs.getString("lecture_cat");
					
					LectureVO vo = new LectureVO(get_no, get_NM, get_teach, get_site, get_count, get_price, get_point, get_review, get_url, get_cat);
					list.add(vo);
				}
			}
			System.out.println("���� �˻� ����");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("���� �˻� ����");
		} finally {
			close();
		}
		return list;
	}
	
}