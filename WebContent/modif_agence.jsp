<%@ include file="entete.jsp"%>

<div id="page">
<div id="titre">Formulaire de modification d'une agence</div>
<% Agence a=(Agence)request.getAttribute("a"); %>
<form action="TraiteAgence" method="post">

<table width="346" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<td></td>
		<td><input type="hidden" name="code" value="<%=a.getLibelle()%>"
			readonly="readonly" title=""></td>
	</tr>
	<tr>
		<td>Libellé de l'agence:</td>
		<td><input type="text" name="libelle" value="<%=a.getLibelle()%>"
			readonly="readonly" title="Vous ne pouvez pas modifiez le libelle"></td>
	</tr>
	<tr>
		<td>Adresse:</td>
		<td><input type="text" name="adresse" value="<%=a.getAdresse()%>"></td>
	</tr>
	<tr>
		<td><input name="button" type="image" src="images/valider.gif"
			id="button" value="MODIFIER" /></td>
		<td><input type="hidden" name="bouton" value="mod"></td>
	</tr>
</table>
</div>
<%@ include file="footer.jsp"%>