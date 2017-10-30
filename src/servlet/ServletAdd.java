package servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookManageDao;
import entity.BookManage;

/**
 * Servlet implementation class ServletAdd
 */
@WebServlet("/ServletAdd")
public class ServletAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String path = req.getContextPath();
		BookManageDao dao = new BookManageDao();
		
		String petName = req.getParameter("petName");
		String petBreed = req.getParameter("petBreed");
		String birthday = req.getParameter("birthday");
		Integer petType = Integer.parseInt(req.getParameter("petType"));
		BookManage pet = new BookManage(petName, petBreed, birthday, petType);
		
		int result = dao.add(pet);
		HttpSession session = req.getSession();
		if(result>0){
			session.setAttribute("message", "添加成功");
			resp.sendRedirect(path+"/list");
		}else{
			session.setAttribute("message", "添加失败");
			resp.sendRedirect(path+"/Add.jsp");
		}
	}

}
