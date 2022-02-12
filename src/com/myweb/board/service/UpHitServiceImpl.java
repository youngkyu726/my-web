package com.myweb.board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;

public class UpHitServiceImpl implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		//bno받기
		String bno = request.getParameter("bno");

		//쿠키검사
		Cookie[] cookies = request.getCookies();

		boolean flag = true; //중복검사 변수
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals(bno)) {//쿠키이름이 bno랑 같으면 중복
					flag = false; //중복됨
					break;
				}
			}
		}
		//flag가 true인 경우만 조회수를 증가
		if(flag) {

			BoardDAO dao = BoardDAO.getInstance();
			dao.upHit(bno);
		}

		//쿠키문법
		Cookie cookie = new Cookie(bno, bno);//이름, 값
		cookie.setMaxAge(20);
		response.addCookie(cookie);
	}


}
