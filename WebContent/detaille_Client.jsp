<%@ page import="java.util.*,modele.*"%>
<style>
#page {
	background-color: #FFFFEC;
	border: 1px solid #FFFFC4;
}

#titre {
	background-color: #EDFDFE;
	border: 1px solid #49EDF5;
}

#page .tb {
	font-weight: bold;
}
</style>
<%
	Client cc=(Client)request.getAttribute("c");
%>
<div id="page">
<div id="titre">DETAILLE DU CLIENT</div>
<br />
<table border="0">
	<tr>
		<td height="21" class="tb">Nom prenom</td>
		<td class="solde" align="left"><%=cc.getCivilite()+" "+cc.getNom()+" "+cc.getPrenom() %></td>
	</tr>
	<tr>
		<td class="tb">Adresse</td>
		<td align="left"><%=cc.getAdresse()%></td>
	</tr>
	<tr>
		<td class="tb">Agence</td>
		<td align="left"><%=cc.getLibelleA()%></td>
	</tr>

</table>
<br />

<br />
</div>

