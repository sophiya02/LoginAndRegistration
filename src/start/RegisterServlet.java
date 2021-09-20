package start;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public RegisterServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
	response.setContentType("text/html; charset=UTF-8");
	try(PrintWriter out = response.getWriter()){
			out.println("<!Doctype html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet RegisterServlet</title>");
			out.println("</head>");
			out.println("<body>");
			
			//fetch data from registration page
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			//make user object
			User userModel = new User(name, email, password);
			
			//create a database model
			UserDatabase regUser = new UserDatabase(ConnectionProvider.getConnection());
			if (regUser.saveUser(userModel)) {
			   response.sendRedirect("index.jsp");
			} else {
			    String errorMessage = "User Available";
			    HttpSession regSession =  request.getSession();
			    regSession.setAttribute("RegError", errorMessage);
			    response.sendRedirect("registration.jsp");
			    }
			out.println("</body>");
			out.println("</html>");
	}
	
	
//	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.setContentType("text/html; charset=UTF-8");
//		try(PrintWriter out = response.getWriter()){
//				out.println("<!Doctype html>");
//				out.println("<html>");
//				out.println("<head>");
//				out.println("<title>Servlet RegisterServlet</title>");
//				out.println("</head>");
//				out.println("<body>");
//				
//				//fetch data from registration page
//				String name = request.getParameter("name");
//				String email = request.getParameter("email");
//				String password = request.getParameter("password");
//				
//				//make user object
//				User userModel = new User(name, email, password);
//				
//				//create a database model
//				UserDatabase regUser = new UserDatabase(ConnectionProvider.getConnection());
//				if (regUser.saveUser(userModel)) {
//				   response.sendRedirect("index.jsp");
//				} else {
//				    String errorMessage = "User Available";
//				    HttpSession regSession = (HttpSession) request.getSession();
//				    regSession.setAttribute("RegError", errorMessage);
//				    response.sendRedirect("register.jsp");
//				    }
//				out.println("</body>");
//				out.println("</html>");
//		}
				
	}

}
