package modele;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Donnees_Login {
	private Connection con=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	
	
    public Donnees_Login() {
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
  

  
    
    public ArrayList<Login> RechercheUser(String user, String passe)
	{
		 ArrayList <Login> liste=new ArrayList<Login>();
		try
		{
			st=con.prepareStatement("select * from login where utilisateur=? and mpasse=?");
			st.setString(1,user);
			st.setString(2, passe);
		
			rs=st.executeQuery();
			while(rs.next())
			{
				Login l=new Login();
				
				l.setNuml(rs.getInt("numl"));
				l.setNomprenom(rs.getString("nomprenom"));
				l.setUtilisateur(rs.getString("utilisateur"));
				l.setMpasse(rs.getString("mpasse"));
				l.setNiveau(rs.getInt("niveau"));
				liste.add(l);
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return liste;
	}
    
   
 
}
