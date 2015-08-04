<%@ include file="entete.jsp"%>
<div id="page">
<%
	ArrayList <Operation> liste=(ArrayList<Operation>)request.getAttribute("liste");
Operation cc=null;
cc=liste.get(0);
%>
<div id="titre">JOURNAL DES OPERATION DU COMPTE N° <%=cc.getNumcp()%></div>
<br>
<table border="0" cellspacing="0" cellpadding="0">
	<tr class="tit">
		<th width="120">Libelle</th>
		<th width="60">Sense</th>
		<th width="80">Montant</th>
		<th width="100">Date de l'opéraiton</th>
	</tr>
	<%
	Operation c=null; 
for (int i=0;i<liste.size();i++)
{
  	c=liste.get(i);
%>
	<tr align="center">
		<td><%=c.getLibelleop()%></td>
		<td><%=c.getSenseop()%></td>
		<td><%=c.getMontantop()%></td>
		<td><%=c.getDateop()%></td>
	</tr>
	<%} %>

</table>

</div>
<%@ include file="footer.jsp"%>