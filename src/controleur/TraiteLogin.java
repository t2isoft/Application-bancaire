package controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

//import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import modele.Client;
import modele.Compte;
import modele.Donnees_Agence;
import modele.Donnees_Client;
import modele.Donnees_Compte;
import modele.Donnees_Login;
import modele.Login;


/**
 * Servlet implementation class TraiteLogin
 */
public class TraiteLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher disp=null;
	private ArrayList<Login> liste=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		
		String lien=request.getParameter("lien");
		
		if(lien.equals("logoff"))
		{
			liste.clear();
			session.setAttribute("liste", liste);
			response.sendRedirect("index.jsp");
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		disp=null;
		Donnees_Login bd =new Donnees_Login();
		HttpSession session =request.getSession();
	
		String formul=request.getParameter("bouton");
		if(formul.equals("add"))
		{
			String user=request.getParameter("user");
			String passe=request.getParameter("passe");
			
			Login l= new Login();
			l.setUtilisateur(user);
			l.setMpasse(passe);
			
			liste=bd.RechercheUser(user, passe);
			if(liste.size()!=0)
			{
			session.setAttribute("listes",liste);
			disp=request.getRequestDispatcher("accueil.jsp");
			disp.forward(request, response);
			
			}else
			{
				
				response.sendRedirect("log_error.jsp");
				
			}
		}
		
		
		
	}

}
