package LibPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("userId");
	       
        String password = request.getParameter("pwd");
        String searchQuery = "select * from admin where username='" + userId
                + "' AND password='" + password + "';";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
        	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
     	            "root", "root");
          //  Connection con = DriverManager.getConnection(
            //        "jdbc:mysql://localhost:3306/myDb", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(searchQuery);
            boolean isEmpty = rs.next();
            if (!isEmpty) {
                // redirect to error page
                response.sendRedirect("LoginFailure.jsp");
            } 
            else if (isEmpty) {
                // fetch the session from request, create new session if session
                // is not present in the request
                HttpSession session = request.getSession(true); 
                response.sendRedirect("check.jsp");
              //  session.setAttribute("FirstName", rs.getString("firstname"));
              //  session.setAttribute("LastName", rs.getString("lastname"));
                // redirect to success page
               // response.sendRedirect("confirm.jsp"); 
            }
        } 
        catch (SQLException e) {
            System.out.println("SQLException occured: " + e.getMessage());
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
