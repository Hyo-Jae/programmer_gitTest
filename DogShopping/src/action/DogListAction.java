package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogListService;
import vo.ActionForward;
import vo.DogVO;

public class DogListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		DogListService dogListService = new DogListService();
		ArrayList<DogVO> dogList = dogListService.getDogList();
		
		request.setAttribute("dogList", dogList);
		ActionForward forward = new ActionForward();
		forward.setUrl("dogList.jsp");
	
		
		return forward;
	}
	
}
