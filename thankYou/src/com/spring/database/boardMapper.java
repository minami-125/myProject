package com.spring.database;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.beans.board;
public interface boardMapper {

	//자유게시판 글 개수 가져오기
	@Select("select count(*) from tyboard")
	public int countAll();
		
	//자유게시판 들어올때 첫화면 띄우기 위한 작업
	@Select("select * from (select A.*, Rownum Rnum from (select post_num, post_sub, post_date from tyboard order by post_date desc)A) where Rnum>=#{param1} and Rnum<=#{param2}")
	public List<board> allFreeNote(int startRow, int endRow);
		
	//글 제목 선택 시 글 읽는 작업
	@Select("select post_num, post_sub, post_date from tyboard where post_num=#{post_num}")
	public board selectOneNote(String post_num);
		
	//작성글을 DB에 저장
	@Insert("insert into tyboard values(tyboard_seq.nextval, #{post_sub}, sysdate)")
	public void uploadNote(board Board);
		
	//가장 최근 글의 글번호 가져오기
	@Select("select post_num from (select * from tyboard order by post_date desc) where rownum=1")
	public String getPostNo();
		
	//글 삭제하기
	@Delete("delete from tyboard where post_num=#{post_num}")
	public void deletePost(int post_num);
	
	//글 제목 선택시 글 읽는 작업
	@Select("select post_num, post_sub, post_date from tyboard where post_num=#{post_num}")
	public board selectOneBoard(String post_num);
	
	//글 수정하기
	@Update("update tyboard set post_sub=#{post_sub} where post_num=#{post_num}")
	public void updateNote(board writeform);
	
	
}
