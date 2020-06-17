package svc;
import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;
import dao.DogDAO;
import vo.DogVO;

public class DogListService {

	public ArrayList<DogVO> getDogList() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(con);
		
		ArrayList<DogVO> dogList = dogDAO.selectDogList();
		close(con);
		return dogList;
	}

}
