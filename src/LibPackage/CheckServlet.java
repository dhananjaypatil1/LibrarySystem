package LibPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.re
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import javax.servlet.jsp.jstl.sql.ResultImpl;
import javax.servlet.jsp.jstl.sql.ResultSupport;

//import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("ID");
		 HttpSession session = request.getSession(true); 
         session.setAttribute("FirstName", userId);
         response.sendRedirect("List1.jsp");
//        String searchQuery = "select b.book_name, r.record_id, r.issue_date from library.record r, library.book b where b.book_id = r.book_id and  r.customer_id ='" + userId + "';";       
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } 
//        catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//        	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
//     	            "root", "root");
//          //  Connection con = DriverManager.getConnection(
//            //        "jdbc:mysql://localhost:3306/myDb", "root", "");
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(searchQuery);
//            ResultImpl result = ResultSupport.toResult(rs);
//            request.setAttribute("result", result);
//            RequestDispatcher rd = request.getRequestDispatcher("/List.jsp");
//            rd.forward(request, response);
//        } 
//        catch (SQLException e) {
//            System.out.println("SQLException occured: " + e.getMessage());
//            e.printStackTrace();
//        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
