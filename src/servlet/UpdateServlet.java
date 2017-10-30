package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookManageDao;
import entity.BookManage;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String path = request.getContextPath();
		BookManageDao dao = new BookManageDao();
		String petName = request.getParameter("petName");
		String petBreed = request.getParameter("petBreed");
		String birthday = request.getParameter("birthday");
		Integer petType = Integer.parseInt(request.getParameter("petType"));
		int petId =  Integer.parseInt(request.getParameter("petId"));
		BookManage pet = new BookManage(petName, petBreed, birthday, petType);
		pet.setBid(petId);
		int result = dao.update(pet);
		HttpSession session = request.getSession();
		if(result>0){
			session.setAttribute("message", "修改成功");
			response.sendRedirect(path+"/list");
		}else{
			session.setAttribute("message", "修改失败");
			response.sendRedirect(path+"/Update.jsp?petId="+petId);
		}
	}

}
