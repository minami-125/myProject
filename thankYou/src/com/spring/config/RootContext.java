package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.spring.beans.board;
import com.spring.beans.boardPage;

@Configuration
public class RootContext {
	
	//�� ���� �� ���� �ӽ÷� �� ������ �����ϱ� ���� ��
	@Bean("writeform")
	@SessionScope
	public board writeform() {
		return new board();
	}
	
	//������ �� ����ؼ� ȭ�鿡 ���� ���� ��
	@Bean("pageCalculator")
	@SessionScope
	public boardPage calcuator() {
		return new boardPage();
	}

}
