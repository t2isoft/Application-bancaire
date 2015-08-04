package controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Compte;
import modele.Donnees_Compte;
import modele.Donnees_Operation;
import modele.Operation;


/**
 * Servlet implementation class TraiteCompte
 */
public class TraiteOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher disp=null;
	private ArrayList<Operation> liste=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Donnees_Operation bd =new Donnees_Operation();
		Donnees_Compte bc=new Donnees_Compte();
		 liste=null;
		String lien=request.getParameter("lien");
		
		if(lien.equals("listerop"))
		{
			String id=request.getParameter("id");
			int num=Integer.parseInt(id);
			liste =bd.AfficheListeOp(num);
			if(liste.size()!=0)
			{
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_Operation.jsp");
			disp.forward(request, response);
			}else
			{
				disp=request.getRequestDispatcher("liste_errorO.jsp");
				disp.forward(request, response);
			}
		}
		
		if(lien.equals("lister"))
		{
			
			liste =bd.AfficheListe();
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_Operation.jsp");
			disp.forward(request, response);
			
		}
		
		
		
		if(lien.equals("ajout"))
		{
			String id=request.getParameter("id");
			int num=Integer.parseInt(id);
			
			Compte ct = bc.RechercherCompteC(num);
			request.setAttribute("ct", ct);
			disp=request.getRequestDispatcher("ajout_Operation.jsp");
			disp.forward(request, response);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		disp=null;
		Donnees_Operation bd =new Donnees_Operation();
		Donnees_Compte dc=new Donnees_Compte();
		//String numop=request.getParameter("NumOp");
		//int num=Integer.parseInt(numop);
		String libelle=request.getParameter("LibelleOp");
		String sense=request.getParameter("SensOp");
		String smontant=request.getParameter("MontantOp");
		int montanop=Integer.parseInt(smontant);
		String numc=request.getParameter("numcp");
		int numcc=Integer.parseInt(numc);
		String mt=request.getParameter("montantancien");
		int mAncien=Integer.parseInt(mt);
		
		
		
		String formul=request.getParameter("bouton");
		if(formul.equals("add"))
		{
			int mtotal=0;
			if(sense.contentEquals("Crediteur"))
			{
			mtotal=mAncien+montanop;
			}else
			{
			 mtotal=mAncien-montanop;
			 if(mtotal<0)
			 {
				 System.out.println("LES SOLDES NEGATIFS NE SONT PAS GERER VEUIILEZ CONTACTER L'ADMINISTRATEUR"); 
			 }
			}
			
			Operation o= new Operation();
			o.setLibelleop(libelle);
			o.setSenseop(sense);
			o.setNumcp(numcc);
			o.setMontantop(montanop);
				
			dc.ModifierSoldeCompte(mtotal,numcc);	
			System.out.println("MONTANT TOTAL :"+mtotal+" Montant de l'opération :"+montanop);

			bd.AjouterOperation(o);
			liste=bd.AfficheListeOp(numcc);
			if(liste.size()!=0)
			{
			request.setAttribute("liste",liste);
			disp=request.getRequestDispatcher("liste_Operation.jsp");
			disp.forward(request, response);
			}else
			{System.out.println("OPERATION ECHOUEE"); }
		}
		
		
	}

}
