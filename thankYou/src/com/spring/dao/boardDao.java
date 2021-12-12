package com.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.beans.board;
import com.spring.database.boardMapper;

@Repository
public class boardDao {

	@Autowired
	private boardMapper boardmapper;
	
	//게시글 읽기
	public board selectOneBoard(String post_num) {
		return boardmapper.selectOneBoard(post_num);
	}
	
	//글 수정
	public void updateNote (board writeform) {
		boardmapper.updateNote(writeform);
	}
	
	public int countAll() {
		return boardmapper.countAll();
	}
	
	public List<board> allFreeBoard(int startRow, int endRow){
		return boardmapper.allFreeNote(startRow, endRow);
	}
	public board selectOneNote(String post_num) {
		return boardmapper.selectOneNote(post_num);
	}
	public void uploadNote(board Board) {
		boardmapper.uploadNote(Board);
	}
	public String getPostNo() {
		return boardmapper.getPostNo();
	}
	public void deletePost(int post_num) {
		boardmapper.deletePost(post_num);
	}
}
