package controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Client;
import modele.Compte;
import modele.Donnees_Client;
import modele.Donnees_Compte;


/**
 * Servlet implementation class TraiteCompte
 */
public class TraiteCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher disp=null;
	private ArrayList<Compte> liste=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Donnees_Compte bd =new Donnees_Compte();
		Donnees_Client dc=new Donnees_Client();
		 liste=null;
		String lien=request.getParameter("lien");
		
		if(lien.equals("lister"))
		{
			liste =bd.AfficheListe();
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_Compte.jsp");
			disp.forward(request, response);
			
		}
		
		if(lien.equals("listercp"))
		{
			String id=request.getParameter("id");
			int num=Integer.parseInt(id);
			liste =bd.RechercheCompteClient(num);
			if(liste.size()!=0)
			{
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_ComptClient.jsp");
			disp.forward(request, response);
			}else
			{
				response.sendRedirect("compte_error.jsp");
			}
			
		}
		
		if(lien.equals("lister_cp"))
		{
			String id=request.getParameter("id");
			int num=Integer.parseInt(id);
			bd.RechercherCompteC(num);
			liste=bd.AfficheListeC(num);
			if(liste.size()!=0)
			{
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("operation_Compte.jsp");
			disp.forward(request, response);
			}else
			{
				response.sendRedirect("aucun_resultat.jsp");
			}
		}
		
		if(lien.equals("lister_cli"))
		{
			String id=request.getParameter("id");
			int num=Integer.parseInt(id);
			bd.RechercherCompteCli(num);
			liste=bd.AfficheListeCli(num);
			if(liste.size()!=0)
			{
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("operation_Compte.jsp");
			disp.forward(request, response);
			}else
			{
				response.sendRedirect("aucun_resultat.jsp");
			}
		}
		
		if(lien.equals("ajout_op"))
		{
			String id=request.getParameter("id");
			int num=Integer.parseInt(id);
			Compte c = bd.RechercherCompte(num);
			request.setAttribute("c", c);
			disp=request.getRequestDispatcher("ajout_Operation.jsp");
			disp.forward(request, response);
		}
		
		if(lien.equals("Ajoutcp"))
		{
			String id=request.getParameter("id");
			int num=Integer.parseInt(id);
			Client c = dc.RechercherClient(num);
			request.setAttribute("c", c);
			disp=request.getRequestDispatcher("ajout_CompteClient.jsp");
			disp.forward(request, response);
		}
		
		if(lien.equals("rech"))
		{
			
			response.sendRedirect("recherche_compte.jsp");
		
		}
		
		if(lien.equals("ajout"))
		{
			
			response.sendRedirect("ajout_Compte.jsp");
		}
		if(lien.equals("modif"))
		{
			String id=request.getParameter("id");
			int num=Integer.parseInt(id);
			Compte c = bd.RechercherCompte(num);
			request.setAttribute("c", c);
			disp=request.getRequestDispatcher("modif_Compte.jsp");
			disp.forward(request, response);
		}
		
		/*if(lien.equals("sup"))
		{
			String id=request.getParameter("id");
			int num=Integer.parseInt(id);
			//bd.SupprimerCompte(num);
			liste=bd.AfficheListe();
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_Compte.jsp");
			disp.forward(request, response);
		}*/
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		disp=null;
		Donnees_Compte bd =new Donnees_Compte();
		String numcp=request.getParameter("NumCp");
		int num=Integer.parseInt(numcp);
		String libelle=request.getParameter("LibelleCp");
		String sense=request.getParameter("SensCp");
		String ssolde=request.getParameter("Solde");
		int solde=Integer.parseInt(ssolde);
		String numcl=request.getParameter("numcl");
		int nomc=Integer.parseInt(numcl);
		
		Compte c= new Compte();
		c.setNumCp(num);
		c.setLibellecp(libelle);
		c.setSenscp(sense);
		c.setSolde(solde);
		c.setNumcli(nomc);
		
		
		String formul=request.getParameter("bouton");
		if(formul.equals("add"))
		{
			bd.AjouterCompte(c);
			liste=bd.AfficheListe();
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_Compte.jsp");
			disp.forward(request, response);
		}
		if(formul.equals("mod"))
		{
			bd.ModifierCompte(c);
			liste=bd.AfficheListe();
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_Compte.jsp");
			disp.forward(request, response);
		}
		
		if(formul.equals("rech"))
		{
			bd.RechercherCompte(num);
			liste=bd.AfficheListeC(num);
			if(liste.size()!=0)
			{
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("operation_Compte.jsp");
			disp.forward(request, response);
			}else
			{
				response.sendRedirect("aucun_resultat.jsp");
			}
		}
		
		
	}

}
