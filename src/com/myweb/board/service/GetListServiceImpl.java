package com.myweb.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;
import com.myweb.util.PageVO;

public class GetListServiceImpl implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//받을 값x

		BoardDAO dao = BoardDAO.getInstance();
		
		//1.첫 페이지 진입시 초기값
		int pageNum = 1;
		int amount = 10;
		
		//2. 화면에서 pageNum, amount 값이 넘어오는 경우
		if(request.getParameter("pageNum") != null || request.getParameter("amount") != null) {
			pageNum = Integer.parseInt( request.getParameter("pageNum") );
			amount = Integer.parseInt( request.getParameter("amount") );
		}
		
		ArrayList<BoardVO> list = dao.getList(pageNum, amount);//리스트반환
		
		//화면에서 값을 사용하기 위해 request에 저장
		request.setAttribute("list", list);
		
		//3. pageVO계산
		int total = dao.getTotal();
		PageVO pageVO = new PageVO(pageNum, amount, total);
		//4. pageVO를 화면에 전달
		request.setAttribute("pageVO", pageVO);
	}

	
}
