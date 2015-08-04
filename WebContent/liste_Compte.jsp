<%@ include file="entete.jsp"%>

<div id="page">
<div id="titre">LISTE DES COMPTES</div>
<br />
<%
	ArrayList <Compte> liste=(ArrayList<Compte>)request.getAttribute("liste");
%>

<table border="0" cellspacing="0" cellpadding="1">
	<tr class="tit">
		<th>Numéro de compte</th>
		<th>Libellé</th>
		<th>Sense</th>
		<th>Solde</th>
		<th>Client</th>

		<th class="inac" colspan="3"><a href="TraiteClient?lien=lister"><img
			src="images/ajout.gif" title="Ajouter" border="0" /></a></th>
	</tr>
	<%
	Compte c=null; 
for (int i=0;i<liste.size();i++)
{
  	c=liste.get(i);
%>
	<tr>

		<td><%=c.getNumCp()%></td>
		<td><%=c.getLibellecp()%></td>
		<td><%=c.getSenscp()%></td>
		<td><%=c.getSolde()%></td>
		<td><%=c.getNumcli()%></td>

		<td><a href="TraiteCompte?lien=modif&amp;id=<%=c.getNumCp()%>"><img
			src="images/edit.gif" alt="" width="12" height="12" title="Modifier"
			title="Modifier" border="0" /></a></td>
	</tr>
	<%} %>

</table>
</div>
<%@ include file="footer.jsp"%>
