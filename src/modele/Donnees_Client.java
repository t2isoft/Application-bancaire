package modele;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Donnees_Client {
	private Connection con=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	private java.sql.Date sqld;
	private String dn;
	private String dtn;
	
    public Donnees_Client() {
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
  //methode de transformation d'une chaine representant une date au format sql aaaa-mm-jj en chaine java jj-mm-aaaa
	private String sqlEnChaine(String source)
	{
		String res =null;
		res=source.substring(8)+"-"+source.substring(5,7)+"-"+source.substring(0,4);
		return res;
	}
	//methode de transformation d'une chaine representant une chaine java jj-mm-aaaa  en date au format sql aaaa-mm-jj
	private String chaineEnSql(String source)
	{
		String res =null;
		 res=source.substring(6)+"-"+source.substring(3,5)+"-"+source.substring(0,2);
		return res;
	}
	
	
    public ArrayList<Client> AfficheListe()
	{
		 ArrayList <Client> liste=new ArrayList<Client>();
		try
		{
			st=con.prepareStatement("select * from Client");
			rs=st.executeQuery();
			while(rs.next())
			{
				Client c=new Client();
				c.setNumcli(rs.getInt("NumCl"));
				c.setCivilite(rs.getString("Civilite"));
				c.setNom(rs.getString("Nom"));
				c.setPrenom(rs.getString("Prenom"));

				sqld=rs.getDate("DateNaisse");
				dn=String.valueOf(sqld);
				dtn=this.sqlEnChaine(dn);
				c.setDatenaisse(dtn);
				
				c.setAdresse(rs.getString("Adresse"));
				c.setTelephone(rs.getString("Telephone"));

				
				liste.add(c);
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return liste;
	}
    
    public ArrayList<Client> AfficheListeCl(String id)
	{
		 ArrayList <Client> liste=new ArrayList<Client>();
		try
		{
			st=con.prepareStatement("select * from Client where LibelleAg=?");
			st.setString(1,id);
			rs=st.executeQuery();
			while(rs.next())
			{
				Client c=new Client();
				c.setNumcli(rs.getInt("NumCl"));
				c.setCivilite(rs.getString("Civilite"));
				c.setNom(rs.getString("Nom"));
				c.setPrenom(rs.getString("Prenom"));
				sqld=rs.getDate("DateNaisse");
				dn=String.valueOf(sqld);
				dtn=this.sqlEnChaine(dn);
				c.setDatenaisse(dtn);
				
				c.setAdresse(rs.getString("Adresse"));
				c.setTelephone(rs.getString("Telephone"));
				c.setLibelleA(rs.getString("LibelleAg"));

				
				
				liste.add(c);
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return liste;
	}
    
    public void AjouterClient(Client c)
	{
		try
		{
			st=con.prepareStatement("insert into Client(Civilite,Nom,Prenom,DateNaisse,Adresse,Telephone,LibelleAg) values (?,?,?,?,?,?,?)");
			//st.setInt(1, c.getNumcli());
			st.setString(1, c.getCivilite());
			st.setString(2, c.getNom());
			st.setString(3, c.getPrenom());
			
			dn=c.getDatenaisse();
			dtn=this.chaineEnSql(dn);
			sqld=java.sql.Date.valueOf(dtn);
			st.setDate(4, sqld);

			st.setString(5, c.getAdresse());
			st.setString(6, c.getTelephone());
			st.setString(7, c.getLibelleA());

			

			st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
    
    public Client RechercherClient(int code)
	{
		Client c=null;
		try
		{
			st=con.prepareStatement("select * from Client where NumCl=?");
			st.setInt(1,code);
			rs=st.executeQuery();
			if(rs.next())
			{
				 c=new Client();
				 c.setNumcli(rs.getInt("NumCl"));
				 c.setCivilite(rs.getString("Civilite"));
					c.setNom(rs.getString("Nom"));
					c.setPrenom(rs.getString("Prenom"));

					sqld=rs.getDate("DateNaisse");
					dn=String.valueOf(sqld);
					dtn=this.sqlEnChaine(dn);
					c.setDatenaisse(dtn);
					
					c.setAdresse(rs.getString("Adresse"));
					c.setTelephone(rs.getString("Telephone"));
					c.setLibelleA(rs.getString("LibelleAg"));
				
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return c;
	}
    
    
    public Client RechercherClientC(String id)
	{
		Client c=null;
		try
		{
			st=con.prepareStatement("select * from Client where LibelleAg=?");
			st.setString(1,id);
			rs=st.executeQuery();
			if(rs.next())
			{
				 c=new Client();
				 c.setLibelleA(rs.getString("LibelleAg"));
				
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return c;
	}
    public Client RecupIdcli()
	{
		Client c=null;
		try
		{
			st=con.prepareStatement("select NumCl from client where NumCl=(select max(NumCl) from Client)");
			rs=st.executeQuery();
			if(rs.next())
			{
				 c=new Client();
				 c.setNumcli(rs.getInt("NumCl"));
				 
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return c;
		
	}
    public void ModifierClient(Client c)
	{
		try
		{
			st=con.prepareStatement("update client set Civilite=?,Nom=?, Prenom=?, DateNaisse=?,Adresse=?, Telephone=?, LibelleAg=? where NumCl=?");
			st.setString(1, c.getCivilite());
			st.setString(2, c.getNom());
			st.setString(3, c.getPrenom());
			
			dn=c.getDatenaisse();
			dtn=this.chaineEnSql(dn);
			sqld=java.sql.Date.valueOf(dtn);
			st.setDate(4, sqld);

			st.setString(5, c.getAdresse());
			st.setString(6, c.getTelephone());
			st.setString(7, c.getLibelleA());
			st.setInt(8, c.getNumcli());
			
			st.executeUpdate();
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
    
  
}
