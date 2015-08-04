<%@ include file="entete.jsp"%>
<div id="page">
<div id="titre">LISTE DES AGENCES</div>
<% 	ArrayList <Agence> liste=(ArrayList<Agence>)request.getAttribute("liste");%>
<br>
<table border="0" cellspacing="0" cellpadding="0" >
	<tr class="tit">
		<td width="80">Libellé</td>
		<td width="71">Adresse</td>
		<td width="220" class="inac">ACTION</td>
		<td class="inac" width="100"><a href="TraiteAgence?lien=ajout" class="inac"><img
			src="images/ajout.gif" title="Ajouter" border="0" /></a>
	</tr>

	<%
Agence a=null; 
for (int i=0;i<liste.size();i++)
{
  	a=liste.get(i);
%>
	<tr>
		<td width="120"><%=a.getLibelle()%></td>
		<td width="100"><%=a.getAdresse()%></td>
		<td><a href="TraiteAgence?lien=modif&id=<%=a.getLibelle()%>"><img
			src="images/edit.gif" alt="" width="12" height="12" title="Modifier"
			border="0" /></a> <a
			href="TraiteAgence?lien=ajout_cl&id=<%=a.getLibelle()%>">Add Client</a> <a href="TraiteClient?lien=lister_cl&id=<%=a.getLibelle()%>">Clients</a></td>
	</tr>
	<%} %>
</table>
</div>
<%@ include file="footer.jsp"%>