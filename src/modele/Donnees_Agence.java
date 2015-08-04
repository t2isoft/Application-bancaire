package modele;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class Donnees_Agence  {
	private Connection con=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
    
    public Donnees_Agence() {
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
    public ArrayList<Agence> AfficheListe()
	{
		 ArrayList <Agence> liste=new ArrayList<Agence>();
		try
		{
			st=con.prepareStatement("select * from agence");
			rs=st.executeQuery();
			while(rs.next())
			{
				Agence a=new Agence();
				a.setLibelle(rs.getString("LibelleAg"));
				a.setAdresse(rs.getString("AdresseAg"));
				
				liste.add(a);
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return liste;
	}
    
    public void AjouterAgence(Agence a)
	{
		try
		{
			st=con.prepareStatement("insert into agence(LibelleAg,AdresseAg) values (?,?)");
			st.setString(1, a.getLibelle());
			st.setString(2, a.getAdresse());

			st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
    
    public Agence RechercherAgence(String id)
	{
		Agence a=null;
		try
		{
			st=con.prepareStatement("select * from agence where LibelleAg=?");
			st.setString(1,id);
			rs=st.executeQuery();
			if(rs.next())
			{
				 a=new Agence();
					a.setLibelle(rs.getString("LibelleAg"));
					a.setAdresse(rs.getString("AdresseAg"));
				
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return a;
	}
    
    public void ModifierAgence(Agence a)
	{
		try
		{
			st=con.prepareStatement("update agence set AdresseAg=? where LibelleAg=?");
			
			st.setString(1, a.getAdresse());
			st.setString(2, a.getLibelle());
			
			st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
    
    public void SupprimerAgence(String code)
	{
		try
		{
		st=con.prepareStatement("delete from agence where  LibelleAg=?");
		st.setString(1,code);
		st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}

}
