<%@ include file="entete.jsp"%>
<script type="text/javascript" src="highslide/highslide-with-html.js"></script>
<link rel="stylesheet" type="text/css" href="highslide/highslide.css" />

<script type="text/javascript">
hs.graphicsDir = 'highslide/graphics/';
hs.outlineType = 'rounded-white';
hs.wrapperClassName = 'draggable-header';

</script>

<%
	ArrayList <Compte> liste=(ArrayList<Compte>)request.getAttribute("liste");
Compte cc=null;
cc=liste.get(0);
%>
<div id="page">
<div id="titre">RESULTAT DES RECHERCHE</div>
<br />
<table width="568" border="0" cellspacing="2" cellpadding="0">
	<tr>
		<td height="28" colspan="4"><strong><a
			href="TraiteClient?lien=listerCP&amp;id=<%=cc.getNumcli()%>"
			onclick="return hs.htmlExpand(this, { objectType: 'iframe' } )">CLIENT
		PROPRIETAIRE DU COMPTE</a></strong></td>

	</tr>
	<tr>
		<td height="21" align="right"><strong>Numero de compte</strong></td>
		<td class="numc"><%=cc.getNumCp() %></td>
		<td align="right"><strong>Solde </strong></td>
		<td class="solde"><%=cc.getSolde()%></td>
	</tr>
	<tr>
		<td height="21" align="right"><strong>Libelle du compte</strong></td>
		<td  class="numc"><%=cc.getLibellecp()%></td>
		<td align="right"><strong>Sense du compte</strong></td>
	<td  class="numc"><%=cc.getSenscp() %></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><a
			href="TraiteOperation?lien=listerop&amp;id=<%=cc.getNumCp()%>"><img
			src="images/histocomp.jpg" width="120" height="20" border="0" /></a></td>
		<td colspan="2" align="right" valign="top"><a
			href="TraiteOperation?lien=ajout&amp;id=<%=cc.getNumCp()%>"><img
			src="images/opadd.jpg" width="120" height="20" border="0" /></a></td>
	</tr>
</table>
<br />

<br />
</div>

<%@ include file="footer.jsp"%>
