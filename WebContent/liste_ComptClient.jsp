<%@ include file="entete.jsp"%>
<script type="text/javascript" src="highslide/highslide-with-html.js"></script>
<link rel="stylesheet" type="text/css" href="highslide/highslide.css" />

<script type="text/javascript">
hs.graphicsDir = 'highslide/graphics/';
hs.outlineType = 'rounded-white';
hs.wrapperClassName = 'draggable-header';

</script>
<div id="page">
<%
	ArrayList <Compte> liste=(ArrayList<Compte>)request.getAttribute("liste");
Compte cc=null;
cc=liste.get(0);
%>
<div id="titre">LISTE DES COMPTES  DU CLIENT N°: <%=cc.getNumcli()%><strong><a href="TraiteClient?lien=listerCP&amp;id=<%=cc.getNumcli()%>"
			onclick="return hs.htmlExpand(this, { objectType: 'iframe' } )">(Detaille du client)</a></strong></div>
<br />

<table border="0" cellspacing="0" cellpadding="1">
	<tr class="tit">
		<th width="100">Numéro de compte</th>
		<th>Libellé</th>
		<th>Sense</th>
		<th>Solde</th>
	</tr>
	<%
	Compte c=null; 
	int solde=0;
for (int i=0;i<liste.size();i++)
{
  	c=liste.get(i);
  	solde=solde+c.getSolde();
%>
	<tr>

		<td ><%=c.getNumCp()%></td>
		<td width="80"><%=c.getLibellecp()%></td>
		<td width="80"><%=c.getSenscp()%></td>
		<td bgcolor="green" width="120" style="color: white"><%=c.getSolde()+ " FCFA"%></td>
	<td width="130"><a
			href="TraiteCompte?lien=lister_cli&amp;id=<%=c.getNumcli()%>">Detaille
		du compte</a></td>
	</tr>
	<%} %>
<tr class="inac">
		<td colspan="3">SOLDE TOTAL DES COMPTES</td>
		<td bgcolor="red" width="120"><%=solde+ " FCFA"%></td>
	
	</tr>
</table>
</div>
<%@ include file="footer.jsp"%>
