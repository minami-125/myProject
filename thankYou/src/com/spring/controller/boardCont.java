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
	
	//DB에서 글번호, 제목, 날짜 가지오기, page 번화와 size 적용
	@GetMapping("/list")
	
	public String list(Model mo, HttpServletRequest request) {
		String pagesize = request.getParameter("pageSize"); //글 개수를 바꾸었을 때 그것을 파라미터로 가지고 오는 세팅
		int pageSize=5; //실제로 계산에 사용할 페이지 사이즈
		if(pagesize==null&pageCalculator.getPageSize()==0) {
			pageSize=5;
		}else if(pagesize==null) { //페이지 번호를 눌러서 이동할 때
			pageSize=pageCalculator.getPageSize();
		}else { //페이지당 글 수(select-option)를 변경할 때
			pageSize=Integer.parseInt(pagesize);
		}
		
		String pagenum = request.getParameter("pageNum");
		int currentPage=1; //실제로 사용할 페이지 번호
		if(pagenum==null) {
			currentPage=1;
		}else {
			currentPage=Integer.parseInt(pagenum);
		}
		int count=0; //글의 총 개수
		int number=0; //화면상에 보여지는 번호
		count = boardservice.countAll();
		int startRow=(currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		List<board> li = boardservice.allFreeNote(startRow, endRow); //startrow, endrow 이용해서 불러오기
		
		number=count-(currentPage-1)*pageSize;
		
		int pageCount=1;
		int startPage =1;
		int endPage=10;
		
		if(count>0) {
			pageCount=count/pageSize+(count%pageSize==0?0:1); //총 페이지 수
			if(currentPage%10!=0) {
				startPage=(int)(currentPage/10)*10+1;
			}else {
				startPage=(int)(currentPage/10-1)*10+1;
			}//startpage(시작페이지번호) 지정하는 코드
			
			endPage=startPage-1+pageCalculator.getPageBlock(); //시작 페이지번호 +9
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
	
	//제목 누르면 글 읽는 페이지로
	@GetMapping("/read")
	public String read(@RequestParam String post_num, Model mo) {
		board Board = boardservice.selectOneBoard(post_num);
		mo.addAttribute("board", Board);
		
		return "freeboard/read";
	}
	
	//글쓰기 버튼 누르면 글을 쓰는 페이지로 이동
	@GetMapping("/write")
	public String write(@ModelAttribute("boardWriteBean") board writeboard) {
		return "freeboard/write";
	}
	
	//글 쓰기 등록
	@PostMapping("/insert")
	public String insert(HttpServletRequest request) throws IOException{
		request.setCharacterEncoding("UTF-8");
		String post_sub = request.getParameter("post_sub");
		writeform.setPost_sub(post_sub);
		
		boardservice.uploadNote(writeform);
		
		return "freeboard/insert";
	}
	
	//글 삭제하기
	@GetMapping("/deleteProc")
	public String deletProc(@RequestParam String postNum) {
		int post_num = Integer.parseInt(postNum);
			boardservice.deletePost(post_num);
			
			return "freeboard/deletesuccess";
	}
	
	//글 수정 페이지로 이동
	@GetMapping("/update")
	public String update(@RequestParam String post_num, Model mo) {
		board Board = boardservice.selectOneBoard(post_num);
		mo.addAttribute("board", Board);
		return "freeboard/update";
	}
	
	//글 수정하기
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
