

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.HibernateUtil;
import com.example.User;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            
            Session session = factory.openSession();
            
            //get transaction and begin session
            session.getTransaction().begin();
            
            //instantiate user class
            User user = new User();
            
            //get field values
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("psw");
            
            //Insert new user to user table
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            
            //save the session
            session.save(user);
            
            //commit the changes
            session.getTransaction().commit();
            
            //close the session
            session.close();
            
             PrintWriter out = response.getWriter();
             out.println("<html><body>");
            
             out.println(name+" has successfully registered");
             out.println("<br>");
         //link back to Main menu    
         out.println("<a href = 'index.jsp'>Back to Main</a<br>");    
         out.println("</body></html>");
         
         
     } catch (Exception ex) {
             throw ex;
     }
		doGet(request, response);
	}

}
