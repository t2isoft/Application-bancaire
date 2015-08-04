package modele;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Donnees_Compte {
	private Connection con=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	
	
    public Donnees_Compte() {
    	try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","passer");
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println("Probleme de pilote base de donnèes");
			System.out.println(ex.getMessage());
		}
		catch(SQLException ex)
		{
			System.out.println("Probleme de connexion ou de requetes");
			System.out.println(ex.getMessage());
		}
		
		
    }
  
	
    public ArrayList<Compte> AfficheListe()
	{
		 ArrayList <Compte> liste=new ArrayList<Compte>();
		try
		{
			st=con.prepareStatement("select * from compte");
			rs=st.executeQuery();
			while(rs.next())
			{
				Compte c=new Compte();
				
				c.setNumCp(rs.getInt("NumCp"));
				c.setLibellecp(rs.getString("LibelleCp"));
				c.setSenscp(rs.getString("SensCp"));
				c.setSolde(rs.getInt("Solde"));
				c.setNumcli(rs.getInt("NumCl"));

				
				liste.add(c);
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return liste;
	}
    
    public void AjouterCompte(Compte c)
	{
		try
		{
			st=con.prepareStatement("insert into compte(NumCp,LibelleCp,SensCp,Solde,NumCl) values (?,?,?,?,?)");
			st.setInt(1, c.getNumCp());
			st.setString(2, c.getLibellecp());
			st.setString(3, c.getSenscp());
			st.setInt(4, c.getSolde());
			st.setInt(5, c.getNumcli());
			

			st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
    
    public Compte RechercherCompte(int code)
	{
		Compte c=null;
		try
		{
			st=con.prepareStatement("select * from compte where NumCp=?");
			st.setInt(1,code);
			rs=st.executeQuery();
			if(rs.next())
			{
				 c=new Compte();
				
					c.setNumCp(rs.getInt("NumCp"));
					c.setLibellecp(rs.getString("LibelleCp"));
					c.setSenscp(rs.getString("SensCp"));
					c.setSolde(rs.getInt("Solde"));
					c.setNumcli(rs.getInt("NumCl"));
				
			}
		
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return c;
	}
    
    public Compte RechercherCompteC(int code)
	{
		Compte c=null;
		try
		{
			st=con.prepareStatement("select * from compte where NumCp=?");
			st.setInt(1,code);
			rs=st.executeQuery();
			if(rs.next())
			{
				 c=new Compte();
				
					c.setNumCp(rs.getInt("NumCp"));
					c.setLibellecp(rs.getString("LibelleCp"));
					c.setSenscp(rs.getString("SensCp"));
					c.setSolde(rs.getInt("Solde"));
					c.setNumcli(rs.getInt("NumCl"));
				
			}
		
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return c;
	}
    
    
    public ArrayList<Compte> AfficheListeC(int cp)
	{
		 ArrayList <Compte> liste=new ArrayList<Compte>();
		try
		{
			st=con.prepareStatement("select * from compte where NumCp=?");
			st.setInt(1,cp);
			rs=st.executeQuery();
			while(rs.next())
			{
				Compte c=new Compte();
				
				c.setNumCp(rs.getInt("NumCp"));
				c.setLibellecp(rs.getString("LibelleCp"));
				c.setSenscp(rs.getString("SensCp"));
				c.setSolde(rs.getInt("Solde"));
				c.setNumcli(rs.getInt("NumCl"));

				
				liste.add(c);
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return liste;
	}
    
    public ArrayList<Compte> RechercheCompteClient(int numcli)
   	{
   		 ArrayList <Compte> liste=new ArrayList<Compte>();
   		try
   		{
   			st=con.prepareStatement("select * from compte where NumCl=?");
   			st.setInt(1,numcli);
   			rs=st.executeQuery();
   			while(rs.next())
   			{
   				Compte c=new Compte();
   				
   				c.setNumCp(rs.getInt("NumCp"));
   				c.setLibellecp(rs.getString("LibelleCp"));
   				c.setSenscp(rs.getString("SensCp"));
   				c.setSolde(rs.getInt("Solde"));
   				c.setNumcli(rs.getInt("NumCl"));

   				
   				liste.add(c);
   				
   			}
   			
   		}
   		catch(SQLException ex)
   		{
   			System.out.println(ex.getMessage());
   		}
   		return liste;
   	}
 
    
   
    public void ModifierCompte(Compte c)
	{
		try
		{
			st=con.prepareStatement("update compte set LibelleCp=?,SensCp=?, Solde=?, NumCl=? where NumCp=?");
			st.setString(1, c.getLibellecp());
			st.setString(2, c.getSenscp());
			st.setInt(3, c.getSolde());
			st.setInt(4, c.getNumcli());
			st.setInt(5, c.getNumCp());
			
			st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
    
    public void ModifierSoldeCompte(int solde, int compte)
   	{
    	
   		try
   		{
   			st=con.prepareStatement("update compte set  Solde=?  where NumCp=?");
   			
   			st.setInt(1, solde);
   			st.setInt(2, compte);
   			
   			st.executeUpdate();
   		}
   		catch(SQLException ex)
   		{
   			System.out.println(ex.getMessage());
   		}
   	}
    
    public Compte RechercherCompteCli(int code)
	{
		Compte c=null;
		try
		{
			st=con.prepareStatement("select * from compte where NumCl=?");
			st.setInt(1,code);
			rs=st.executeQuery();
			if(rs.next())
			{
				 c=new Compte();
				
					c.setNumCp(rs.getInt("NumCp"));
					c.setLibellecp(rs.getString("LibelleCp"));
					c.setSenscp(rs.getString("SensCp"));
					c.setSolde(rs.getInt("Solde"));
					c.setNumcli(rs.getInt("NumCl"));
				
			}
		
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return c;
	}
    public ArrayList<Compte> AfficheListeCli(int cp)
	{
		 ArrayList <Compte> liste=new ArrayList<Compte>();
		try
		{
			st=con.prepareStatement("select * from compte where NumCl=?");
			st.setInt(1,cp);
			rs=st.executeQuery();
			while(rs.next())
			{
				Compte c=new Compte();
				
				c.setNumCp(rs.getInt("NumCp"));
				c.setLibellecp(rs.getString("LibelleCp"));
				c.setSenscp(rs.getString("SensCp"));
				c.setSolde(rs.getInt("Solde"));
				c.setNumcli(rs.getInt("NumCl"));

				
				liste.add(c);
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return liste;
	}
 
}
