package com.spring.database;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.beans.board;
public interface boardMapper {

	//�����Խ��� �� ���� ��������
	@Select("select count(*) from tyboard")
	public int countAll();
		
	//�����Խ��� ���ö� ùȭ�� ���� ���� �۾�
	@Select("select * from (select A.*, Rownum Rnum from (select post_num, post_sub, post_date from tyboard order by post_date desc)A) where Rnum>=#{param1} and Rnum<=#{param2}")
	public List<board> allFreeNote(int startRow, int endRow);
		
	//�� ���� ���� �� �� �д� �۾�
	@Select("select post_num, post_sub, post_date from tyboard where post_num=#{post_num}")
	public board selectOneNote(String post_num);
		
	//�ۼ����� DB�� ����
	@Insert("insert into tyboard values(tyboard_seq.nextval, #{post_sub}, sysdate)")
	public void uploadNote(board Board);
		
	//���� �ֱ� ���� �۹�ȣ ��������
	@Select("select post_num from (select * from tyboard order by post_date desc) where rownum=1")
	public String getPostNo();
		
	//�� �����ϱ�
	@Delete("delete from tyboard where post_num=#{post_num}")
	public void deletePost(int post_num);
	
	//�� ���� ���ý� �� �д� �۾�
	@Select("select post_num, post_sub, post_date from tyboard where post_num=#{post_num}")
	public board selectOneBoard(String post_num);
	
	//�� �����ϱ�
	@Update("update tyboard set post_sub=#{post_sub} where post_num=#{post_num}")
	public void updateNote(board writeform);
	
	
}
