package persistence;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;
import utility.singlet;

/**
 * Servlet implementation class viewserv
 */
@WebServlet("/viewserv")
public class viewserv extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public viewserv() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection cn = singlet.GetConnection();
		
		Person p = new Person();
		List<Person> List = new ArrayList<Person>();

		Statement stm = cn.createStatement();
		ResultSet rs = stm.executeQuery("select * from AdventureWorks");
			
				while(rs.next()) {
						
					p.setName(rs.getString(1));
					p.setAge(rs.getInt(2));
				
						
					List.add(p);
				}	
				
				PrintWriter w = response.getWriter();
				
				String Res = "<html>";
				for(Person l : List) {
					 Res += "<p>" + l + "<br/>"; 
				}
				
				w.println(Res);
			}
			
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
