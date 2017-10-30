package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookManageDao;
import entity.BookManage;


public class ShowInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		BookManageDao dao = new BookManageDao();
		try{
			int id =  Integer.parseInt(req.getParameter("petId"));
			BookManage pet = dao.findById(id);
			req.setAttribute("info", pet);
			req.getRequestDispatcher("/Update.jsp").forward(req, resp);
			return;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
