package controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Agence;
import modele.Donnees_Agence;
import modele.Client;
import modele.Donnees_Client;


/**
 * Servlet implementation class TraiteAgence
 */
public class TraiteAgence extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher disp=null;
	private ArrayList<Agence> liste=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Donnees_Agence bd =new Donnees_Agence();
		Donnees_Client dc= new Donnees_Client();
		 liste=null;
		String lien=request.getParameter("lien");
		
		if(lien.equals("lister"))
		{
			liste =bd.AfficheListe();
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_agence.jsp");
			disp.forward(request, response);
			
		}
		
		if(lien.equals("ajout"))
		{
			response.sendRedirect("ajout_agence.jsp");
		}
		
		if(lien.equals("ajout_cl"))
		{
			String id=request.getParameter("id");
			Agence a = bd.RechercherAgence(id);
			request.setAttribute("a", a);
			disp=request.getRequestDispatcher("ajout_Client.jsp");
			disp.forward(request, response);
		}
		if(lien.equals("modif"))
		{
			String id=request.getParameter("id");
			Agence a = bd.RechercherAgence(id);
			request.setAttribute("a", a);
			disp=request.getRequestDispatcher("modif_agence.jsp");
			disp.forward(request, response);
		}
		
		if(lien.equals("sup"))
		{
			String id=request.getParameter("id");
			Client c =dc.RechercherClientC(id);
			if(c!=null)
			{
				request.setAttribute("c",c);
				disp=request.getRequestDispatcher("suprimer_error.jsp");
				disp.forward(request, response);
			}else
			{
				bd.SupprimerAgence(id);
				liste=bd.AfficheListe();
				request.setAttribute("liste",liste);
				disp=request.getRequestDispatcher("liste_agence.jsp");
				disp.forward(request, response);
			}
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		disp=null;
		Donnees_Agence bd =new Donnees_Agence();
		String slibelle=request.getParameter("libelle");
		String sadresse=request.getParameter("adresse");
		
		Agence a = new Agence();
		a.setLibelle(slibelle);
		a.setAdresse(sadresse);
		
		String formul=request.getParameter("bouton");
		if(formul.equals("add"))
		{
			bd.AjouterAgence(a);
			liste=bd.AfficheListe();
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_agence.jsp");
			disp.forward(request, response);
		}
		if(formul.equals("mod"))
		{
			bd.ModifierAgence(a);
			liste=bd.AfficheListe();
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_agence.jsp");
			disp.forward(request, response);
		}
		
		
	}

}
