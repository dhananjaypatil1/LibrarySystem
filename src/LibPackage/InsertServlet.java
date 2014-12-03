package LibPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String book = request.getParameter("Book");
        String name= request.getParameter("Name");
		String phone = request.getParameter("Phone");
        String email = request.getParameter("email");
        Calendar calendar = Calendar.getInstance();
        java.util.Date startDate = new java.util.Date();
        try{  
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "root");
        	
        	java.sql.PreparedStatement ps1=con.prepareStatement("INSERT INTO RECORD(CUSTOMER_ID, BOOK_ID, FINE, ISSUE_DATE) VALUES (?,?,?,?)");  

        	ps1.setString(1,session.getAttribute("FirstName").toString());

        	
        	ps1.setInt(2,Integer.parseInt(book));

        	ps1.setInt(3, 10);
        	
        	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        	String strDate = df.format(startDate);
        	
        	ps1.setString(4, strDate);

        	int row = ps1.executeUpdate();

        	if (row > 0) {
        		System.out.println("Record is inserted and saved into the Database!!");

           	 String searchQuery = "SELECT * FROM book WHERE book_id= '" + book
                        + "'";
           	 Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(searchQuery);
                boolean isEmpty = rs.next();
                if (!isEmpty || rs.getInt("quantity")<=0) {
                    // redirect to error page
                	System.out.println("Error");
                 //   response.sendRedirect("LoginFailure.jsp");
                } 
                else if (isEmpty) {
               

            	String query = "UPDATE book SET quantity= ? where book_id =?";
            	 java.sql.PreparedStatement ps2=con.prepareStatement(query);
            	 
            	 ps2.setInt(1, ((rs.getInt("quantity"))-1));
            	 
            	 ps2.setString(2, book);
            	
            	 ps2.executeUpdate();
        	}
        //	response.sendRedirect("welcome.jsp"); 
        	}
        	}
        	 catch (SQLException e) {
                 System.out.println("SQLException occured: " + e.getMessage());
                 e.printStackTrace();
             } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
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
