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

	//게시글 수정
		public void updateNote(board writeform) {
			boarddao.updateNote(writeform);
		}
		
		//게시글 개수 가져오기
		public int countAll() {
			return boarddao.countAll();
		}
		
		//게시글 가져오기
		public List<board> allFreeNote(int startRow, int endRow){
			return boarddao.allFreeBoard(startRow, endRow);
		}
		
		//게시글 읽기
		public board selectOneNote(String post_num) {
			return boarddao.selectOneNote(post_num);
		}
		
		//업로드할 글을 DB에 insert
		public void uploadNote (board Board) {
			boarddao.uploadNote(Board);
		}
		
		//가장 최근 글의 글번호 가져오기
		public String getPostNo() {
			return boarddao.getPostNo();
		}
		
		//게시글 삭제
		public void deletePost(int post_num) {
			boarddao.deletePost(post_num);
		}
}
