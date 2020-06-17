package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.DogListAction;
import vo.ActionForward;


@WebServlet("*.dog")
public class DogFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DogFrontController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 이전에 서블릿의 처리는 유형은 정해져있었다.
		// 1. 요청파악
		String requestURI = request.getRequestURI();
		// 요청 URL : http://localhost:8081/project/boardWriteForm.bo 라는 요청이 넘어 온다면
		// requestURI : /project/boardWriteForm.bo 가 반환이 된다.
		
		String contextPath = request.getContextPath();
		// contextPath = /project 가 반환이 된다.
		
		// contextPath.length() 를 넣어주면 /project/ 에서  끝의 / 를 가지게 된다.
		String command = requestURI.substring(contextPath.length());
		// command ==> /boardWriteForm.bo 가 된다.
		
		// 2. 요쳥처리
		// 다형성을 이용해야 편리하게 가능하다. 
		// Action 인터페이스로 두면 많은 변수를 받을 수 있다.
		Action action = null;
		ActionForward forward = null;
		if (command.contentEquals("/dogList.dog")) {
			// 모든 요소를 처리할 수 있게끔 다형성을 이용한다. 
			action = new DogListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 요청 처리를 했으면 3. 포워딩을 해야한다.
		if (forward != null) {
			// 각  Action 클래스의 execute 메소드가 정상적으로 실행되서 비지니스 로직 실행이 성공했을 떼
			if (forward.isRedirect()) {
				// redirect가 true 면 redirect 방식으로 사용
				response.sendRedirect(forward.getUrl());
			}
			else {
				// dispatcher를 사용해서 forward한다.
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getUrl());
				dispatcher.forward(request, response);
			}
		}
		else {
				
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
