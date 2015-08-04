package modele;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Donnees_Operation {
	private Connection con=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	private java.sql.Date sqld;
	private String dn;
	private String dtn;
	
    public Donnees_Operation() {
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
	public ArrayList<Operation> AfficheListe()
	{
		 ArrayList <Operation> liste=new ArrayList<Operation>();
		try
		{
			st=con.prepareStatement("select * from operation");
			rs=st.executeQuery();
			while(rs.next())
			{
				Operation c=new Operation();
				
				c.setNumop(rs.getInt("NumOp"));
				c.setLibelleop(rs.getString("LibelleOp"));
				c.setSenseop(rs.getString("SensOp"));
				c.setMontantop(rs.getInt("MontantOp"));
			
				sqld=rs.getDate("DateOp");
				dn=String.valueOf(sqld);
				dtn=this.sqlEnChaine(dn);
				c.setDateop(dtn);
				c.setNumcp(rs.getInt("NumCp"));

				
				liste.add(c);
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return liste;
	}
    
	public ArrayList<Operation> AfficheListeOp(int numcp)
	{
		 ArrayList <Operation> liste=new ArrayList<Operation>();
		try
		{
			st=con.prepareStatement("select * from operation where NumCp=?");
			st.setInt(1,numcp);
			rs=st.executeQuery();
			while(rs.next())
			{
				Operation c=new Operation();
				
				c.setNumop(rs.getInt("NumOp"));
				c.setLibelleop(rs.getString("LibelleOp"));
				c.setSenseop(rs.getString("SensOp"));
				c.setMontantop(rs.getInt("MontantOp"));
			
				sqld=rs.getDate("DateOp");
				dn=String.valueOf(sqld);
				dtn=this.sqlEnChaine(dn);
				c.setDateop(dtn);
				c.setNumcp(rs.getInt("NumCp"));

				
				liste.add(c);
				
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return liste;
	}
	
    public void AjouterOperation(Operation c)
	{
		try
		{
			st=con.prepareStatement("insert into Operation(LibelleOp,SensOp,MontantOp, DateOp,NumCp) values (?,?,?,?,?)");
			//st.setInt(1, c.getNumop());
			st.setString(1, c.getLibelleop());
			st.setString(2, c.getSenseop());
			st.setInt(3, c.getMontantop());
			
			sqld=new java.sql.Date(new java.util.Date().getTime());			
			st.setDate(4, sqld);
			
			st.setInt(5, c.getNumcp());
			

			st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
    
    public Operation RechercherOperationc(int code)
	{
		Operation c=null;
		try
		{
			st=con.prepareStatement("select * from Operation where NumOp=?");
			st.setInt(1,code);
			rs=st.executeQuery();
			if(rs.next())
			{
				 c=new Operation();
				
				 c.setNumop(rs.getInt("NumOp"));
					c.setLibelleop(rs.getString("LibelleOp"));
					c.setSenseop(rs.getString("SensOp"));
					c.setMontantop(rs.getInt("MontantOp"));
					sqld=rs.getDate("DateOp");
					dn=String.valueOf(sqld);
					dtn=this.sqlEnChaine(dn);
					c.setDateop(dtn);
					c.setNumcp(rs.getInt("NumCp"));
				
			}
		
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return c;
	}
    
    public Operation RechercherOperation(int code)
	{
		Operation c=null;
		try
		{
			st=con.prepareStatement("select * from Operation where NumOp=?");
			st.setInt(1,code);
			rs=st.executeQuery();
			if(rs.next())
			{
				 c=new Operation();
				
				 c.setNumop(rs.getInt("NumOp"));
					c.setLibelleop(rs.getString("LibelleOp"));
					c.setSenseop(rs.getString("SensOp"));
					c.setMontantop(rs.getInt("MontantOp"));
					sqld=rs.getDate("DateOp");
					dn=String.valueOf(sqld);
					dtn=this.sqlEnChaine(dn);
					c.setDateop(dtn);
					c.setNumcp(rs.getInt("NumCp"));
				
			}
		
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return c;
	}
  /*  
    public void ModifierOperation(Operation c)
	{
		try
		{
			st=con.prepareStatement("update operation set LibelleOp=?,SensOp=?, MontantOp=?, DateOp=?, NumCp=? where NumOp=?");
			st.setString(1, c.getLibelleop());
			st.setString(2, c.getSenseop());
			st.setInt(3, c.getMontantop());
			st.setString(4, c.getDateop());
			st.setInt(5, c.getNumcp());
			st.setInt(6, c.getNumop());
			
			st.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
   */ 
 
}
