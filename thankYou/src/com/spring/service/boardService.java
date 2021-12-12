package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.beans.board;
import com.spring.dao.boardDao;

@Service
public class boardService {
	
	@Autowired
	private boardDao boarddao;
	
	public board selectOneBoard(String post_num) {
		return boarddao.selectOneBoard(post_num);
	}

	//�Խñ� ����
		public void updateNote(board writeform) {
			boarddao.updateNote(writeform);
		}
		
		//�Խñ� ���� ��������
		public int countAll() {
			return boarddao.countAll();
		}
		
		//�Խñ� ��������
		public List<board> allFreeNote(int startRow, int endRow){
			return boarddao.allFreeBoard(startRow, endRow);
		}
		
		//�Խñ� �б�
		public board selectOneNote(String post_num) {
			return boarddao.selectOneNote(post_num);
		}
		
		//���ε��� ���� DB�� insert
		public void uploadNote (board Board) {
			boarddao.uploadNote(Board);
		}
		
		//���� �ֱ� ���� �۹�ȣ ��������
		public String getPostNo() {
			return boarddao.getPostNo();
		}
		
		//�Խñ� ����
		public void deletePost(int post_num) {
			boarddao.deletePost(post_num);
		}
}
