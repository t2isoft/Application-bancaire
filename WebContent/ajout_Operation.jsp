<%@ include file="entete.jsp"%>

<div id="page">
<%
	Compte c=(Compte)request.getAttribute("ct");
%>
<form action="TraiteOperation" method="post">
<table width="346" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="138" height="28">Numero du compte</td>
		<td width="208"><input type="hidden" name="montantancien"
			value="<%=c.getSolde()%>"> <input type="text" name="numcp"
			value="<%=c.getNumCp()%>" readonly="readonly" title=""></td>
	</tr>
	<tr>
		<td width="138" height="28">Libelle de l'opération</td>
		<td width="208"><input type="text" name="LibelleOp" value=""></td>
	</tr>
	<tr>
		<td height="29">Sense de l'opération</td>
		<td><input type="radio" name="SensOp" id="radio1"
			value="Crediteur" checked="checked" />Crediteur <input type="radio"
			name="SensOp" id="radio2" value="Debiteur" />Debiteur</td>
	</tr>
	<tr>
		<td>Montant</td>
		<td><input type="text" name="MontantOp" value=""></td>
	</tr>
	<tr>
		<td><input type="hidden" name="bouton" value="add"></td>
		<td><input name="button" type="image" src="images/valider.gif"
			id="button" value="VALIDER" /></td>
	</tr>
</table>
</form>

</div>
<%@ include file="footer.jsp"%>