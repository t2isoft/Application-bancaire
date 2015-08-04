package controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Agence;
import modele.Client;
import modele.Compte;
import modele.Donnees_Agence;
import modele.Donnees_Client;
import modele.Donnees_Compte;

/**
 * Servlet implementation class TraiteClient
 */
public class TraiteClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher disp=null;
	private ArrayList<Client> liste=null;
	private ArrayList<Agence> listea=null;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Donnees_Client bd =new Donnees_Client();
		Donnees_Agence ba=new Donnees_Agence();
		 liste=null;
		String lien=request.getParameter("lien");
		
		if(lien.equals("lister"))
		{
			liste =bd.AfficheListe();
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_Client.jsp");
			disp.forward(request, response);
		}
		
		if(lien.equals("lister_cl"))
		{
			String id=request.getParameter("id");
			liste =bd.AfficheListeCl(id);
			if(liste.size()!=0)
			{
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_Clientag.jsp");
			disp.forward(request, response);
			}else
			{
				disp=request.getRequestDispatcher("liste_error.jsp");
				disp.forward(request, response);
			}
			
		}
		
		
		
		if(lien.equals("ajout_cp"))
		{
			String id=request.getParameter("id");
			int num=Integer.parseInt(id);
			Client c = bd.RechercherClient(num);
			request.setAttribute("c", c);
			disp=request.getRequestDispatcher("ajout_Compte.jsp");
			disp.forward(request, response);
		}
		
		if(lien.equals("ajout"))
		{
			
			response.sendRedirect("ajout_Client.jsp");
		}
		if(lien.equals("modif"))
		{
			
			listea =ba.AfficheListe();
			request.setAttribute("listea",listea);
			
			String id=request.getParameter("id");
			int num=Integer.parseInt(id);
			Client c = bd.RechercherClient(num);
			request.setAttribute("c", c);
			disp=request.getRequestDispatcher("modif_Client.jsp");
			disp.forward(request, response);
		}
		
		if(lien.equals("listerCP"))
		{
			String id=request.getParameter("id");
			int num=Integer.parseInt(id);
			Client c = bd.RechercherClient(num);
			if(c!=null)
			{
			request.setAttribute("c", c);
			disp=request.getRequestDispatcher("detaille_Client.jsp");
			disp.forward(request, response);
			}else
			{
				response.sendRedirect("error_detaille.jsp");
			}
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// pour client
		disp=null;
		Donnees_Client bd =new Donnees_Client();
	   String numcl=request.getParameter("numcl");
	 	int num=Integer.parseInt(numcl);
		String civilite=request.getParameter("civilite");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String datenaisse=request.getParameter("datenaisse");
		String adresse=request.getParameter("adresse");
		String telephone=request.getParameter("telephone");
		String libelleagence=request.getParameter("libelleag");
		
		Client c= new Client();
		c.setNumcli(num);
		c.setCivilite(civilite);
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setDatenaisse(datenaisse);
		c.setAdresse(adresse);
		c.setTelephone(telephone);
		c.setLibelleA(libelleagence);
		
		
		//pour compte
		Donnees_Compte bc =new Donnees_Compte();
		String numct=request.getParameter("NumCp");
		int numc=Integer.parseInt(numct);
		String libelle=request.getParameter("LibelleCp");
		String sense=request.getParameter("SensCp");
		String ssolde=request.getParameter("Solde");
		int solde=Integer.parseInt(ssolde);
	  		
			
		String formul=request.getParameter("bouton");
		if(formul.equals("add"))
		{
			bd.AjouterClient(c);
			//pour compte
			Compte ct= new Compte();
			ct.setNumCp(numc);
			ct.setLibellecp(libelle);
			ct.setSenscp(sense);
			ct.setSolde(solde);
			
			Client cl= new Client();
     		cl=bd.RecupIdcli();
			
		    ct.setNumcli(cl.getNumcli());
		    System.out.println("Numéro du client recemmemnt ajouté : "+cl.getNumcli()); 
		    
			bc.AjouterCompte(ct);
			liste=bd.AfficheListe();
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_Client.jsp");
			disp.forward(request, response);
		}
		if(formul.equals("mod"))
		{
			bd.ModifierClient(c);
			liste=bd.AfficheListe();
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_Client.jsp");
			disp.forward(request, response);
		}
		
		
	}

}
