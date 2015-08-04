<%@ include file="entete.jsp"%>
<div id="page">
<%
	ArrayList <Client> liste=(ArrayList<Client>)request.getAttribute("liste");
Client cc=null;
cc=liste.get(0);
%>
<div id="titre">LISTE DES CLIENTS DE L'AGENCE <%=cc.getLibelleA()%></div>
<br>
<table border="0" cellspacing="0" cellpadding="0">
	<tr class="tit">
		<th width="89" align="left">Civilite</th>
		<th width="80" align="left">Nom</th>
		<th width="89" align="left">Prenom</th>
		<th width="100" align="left">Naissance</th>
		<th width="89" align="left">Téléphone</th>
		<td width="71" class="inac">ACTION</td>
		<td width="71" class="inac"><a href="TraiteSecteur?lien=lister"><img
			src="images/ajout.gif" title="Ajouter" border="0" /></a></td>
	</tr>
	<%
	Client c=null; 
for (int i=0;i<liste.size();i++)
{
  	c=liste.get(i);
%>
	<tr>
		<td><%=c.getCivilite()%></td>
		<td><%=c.getNom()%></td>
		<td><%=c.getPrenom()%></td>
		<td><%=c.getDatenaisse()%></td>
		<td><%=c.getTelephone()%></td>


		<td align="center" valign="middle"><a
			href="TraiteClient?lien=modif&amp;id=<%=c.getNumcli()%>"><img
			src="images/edit.gif" alt="" width="12" height="12" title="Modifier"
			title="Modifier" border="0" /></a> &nbsp;</td>
		
		<td width="220"><a
			href="TraiteCompte?lien=listercp&amp;id=<%=c.getNumcli()%>">Comptes</a> &nbsp;
			<a
			href="TraiteCompte?lien=Ajoutcp&amp;id=<%=c.getNumcli()%>">Add Compte</a>
			</td>
	</tr>
	<%} %>

</table>

</div>
<%@ include file="footer.jsp"%>