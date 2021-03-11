

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.example.HibernateUtil;
import com.example.User;
import com.example.dao.UserDAO;

/**
 * Servlet implementation class UserAuthenticate
 */
@WebServlet
public class UserAuthenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//create UserDAO field
	private UserDAO loginDao;
	
	//create UserDAO constructor
	public void init() {
		loginDao = new UserDAO();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public UserAuthenticate() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	        response.sendRedirect("login.jsp");
//        try {
//               SessionFactory factory = HibernateUtil.getSessionFactory();
//               
//               Session session = factory.openSession();
//               
//               //instantiate User
//               User user = new User();
//               //getting name from form and assign to field
//               String name = request.getParameter("name");
//               
//               // using HQL
////               String hqlquery = "From User u where u.name = :name";
////               Query q = session.createQuery(hqlquery).list();
//               
//               
//               session.close();
//               
//                PrintWriter out = response.getWriter();
//                out.println("<html><body>");
////                out.println("<b>User Listing</b><br>");
////                for(User p: list) {
////                        out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
////                                        ", Email: " + String.valueOf(p.getEmail()) + ", Password: " + p.getPassword() + "<br>");
////                }
//             
//            out.println("<a href = 'index.jsp'>Back to Main</a<br>");
//            out.println("</body></html>");
//            
//            
//        } catch (Exception ex) {
//                throw ex;
//        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        String username = request.getParameter("name");
        String password = request.getParameter("password");

        if (loginDao.validate(username, password)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
            dispatcher.forward(request, response);
        } else {
            throw new Exception("Login not successful..");
        }
    }
//		doGet(request, response);
//	}

}
