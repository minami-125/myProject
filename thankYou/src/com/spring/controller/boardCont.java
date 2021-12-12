package com.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.beans.board;
import com.spring.beans.boardPage;
import com.spring.service.boardService;

@Controller
@RequestMapping("/freeboard")
public class boardCont {


	@Autowired
	private boardService boardservice;
	
	@Resource(name="pageCalculator")
	private boardPage pageCalculator;
	@Resource(name="writeform")
	private board writeform;
	
	//DB���� �۹�ȣ, ����, ��¥ ��������, page ��ȭ�� size ����
	@GetMapping("/list")
	
	public String list(Model mo, HttpServletRequest request) {
		String pagesize = request.getParameter("pageSize"); //�� ������ �ٲپ��� �� �װ��� �Ķ���ͷ� ������ ���� ����
		int pageSize=5; //������ ��꿡 ����� ������ ������
		if(pagesize==null&pageCalculator.getPageSize()==0) {
			pageSize=5;
		}else if(pagesize==null) { //������ ��ȣ�� ������ �̵��� ��
			pageSize=pageCalculator.getPageSize();
		}else { //�������� �� ��(select-option)�� ������ ��
			pageSize=Integer.parseInt(pagesize);
		}
		
		String pagenum = request.getParameter("pageNum");
		int currentPage=1; //������ ����� ������ ��ȣ
		if(pagenum==null) {
			currentPage=1;
		}else {
			currentPage=Integer.parseInt(pagenum);
		}
		int count=0; //���� �� ����
		int number=0; //ȭ��� �������� ��ȣ
		count = boardservice.countAll();
		int startRow=(currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		List<board> li = boardservice.allFreeNote(startRow, endRow); //startrow, endrow �̿��ؼ� �ҷ�����
		
		number=count-(currentPage-1)*pageSize;
		
		int pageCount=1;
		int startPage =1;
		int endPage=10;
		
		if(count>0) {
			pageCount=count/pageSize+(count%pageSize==0?0:1); //�� ������ ��
			if(currentPage%10!=0) {
				startPage=(int)(currentPage/10)*10+1;
			}else {
				startPage=(int)(currentPage/10-1)*10+1;
			}//startpage(������������ȣ) �����ϴ� �ڵ�
			
			endPage=startPage-1+pageCalculator.getPageBlock(); //���� ��������ȣ +9
			if(endPage>pageCount) {
				endPage = pageCount;
			}
		}
		
		pageCalculator.setPageSize(pageSize);
		pageCalculator.setCurrentPage(currentPage);
		pageCalculator.setCount(count);
		pageCalculator.setContent_num(number);
		pageCalculator.setStartRow(startRow);
		pageCalculator.setEndRow(endRow);
		pageCalculator.setPageCount(pageCount);
		pageCalculator.setStartPage(startPage);
		pageCalculator.setEndPage(endPage);
		
		request.setAttribute("pages", pageCalculator);
		mo.addAttribute("list1", li);
		return "freeboard/list";
	} 
	
	//���� ������ �� �д� ��������
	@GetMapping("/read")
	public String read(@RequestParam String post_num, Model mo) {
		board Board = boardservice.selectOneBoard(post_num);
		mo.addAttribute("board", Board);
		
		return "freeboard/read";
	}
	
	//�۾��� ��ư ������ ���� ���� �������� �̵�
	@GetMapping("/write")
	public String write(@ModelAttribute("boardWriteBean") board writeboard) {
		return "freeboard/write";
	}
	
	//�� ���� ���
	@PostMapping("/insert")
	public String insert(HttpServletRequest request) throws IOException{
		request.setCharacterEncoding("UTF-8");
		String post_sub = request.getParameter("post_sub");
		writeform.setPost_sub(post_sub);
		
		boardservice.uploadNote(writeform);
		
		return "freeboard/insert";
	}
	
	//�� �����ϱ�
	@GetMapping("/deleteProc")
	public String deletProc(@RequestParam String postNum) {
		int post_num = Integer.parseInt(postNum);
			boardservice.deletePost(post_num);
			
			return "freeboard/deletesuccess";
	}
	
	//�� ���� �������� �̵�
	@GetMapping("/update")
	public String update(@RequestParam String post_num, Model mo) {
		board Board = boardservice.selectOneBoard(post_num);
		mo.addAttribute("board", Board);
		return "freeboard/update";
	}
	
	//�� �����ϱ�
	@PostMapping("/updateProc")
	public String update(HttpServletRequest request) throws IOException{
		request.setCharacterEncoding("EUC-KR");
		String post_sub = request.getParameter("post_sub");
		String post_num = request.getParameter("post_num");
		int postnum = Integer.parseInt(post_num);
		writeform.setPost_sub(post_sub);
		writeform.setPost_num(postnum);
		
		boardservice.updateNote(writeform);
		return "freeboard/updatesuccess";
	}
	
}
