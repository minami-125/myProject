package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.spring.beans.board;
import com.spring.beans.boardPage;

@Configuration
public class RootContext {
	
	//글 쓰기 할 때에 임시로 그 내용을 저장하기 위한 빈
	@Bean("writeform")
	@SessionScope
	public board writeform() {
		return new board();
	}
	
	//페이지 수 계산해서 화면에 띄우기 위한 빈
	@Bean("pageCalculator")
	@SessionScope
	public boardPage calcuator() {
		return new boardPage();
	}

}
