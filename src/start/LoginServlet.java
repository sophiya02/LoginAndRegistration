package start;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
//    public LoginServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
				String lemail = request.getParameter("email");
				String lpassword = request.getParameter("password");
				
				//make user object
//				User userModel = new User(name, email, password);
				
				//create a database model
				UserDatabase db = new UserDatabase(ConnectionProvider.getConnection());
				User user= db.logUser(lemail, lpassword);
				if (user != null) {
					HttpSession session = request.getSession();
					session.setAttribute("logUser", user);
				   response.sendRedirect("welcome.jsp");
				   out.print("Done!!!");
				} 
				else{
				    out.print("User not found!!!"); 
				}
				out.println("</body>");
				out.println("</html>");
			}

		}
}
