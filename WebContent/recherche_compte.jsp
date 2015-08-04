<%@ include file="entete.jsp"%>

<div id="page">
<div id="titre">FORMULAIRE DE RECHERCHE D'UN COMTPE</div>
<br />
<form id="form1" name="form1" method="post" action="TraiteCompte">
<table width="346" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="28">Numéro du compte</td>
		<td><input type="text" name="NumCp" value=""></td>
	</tr>
	<tr>
		<td><input type="hidden" name="Solde" value="0"> <input
			type="hidden" name=numcl value="0"> <input type="hidden"
			name="bouton" value="rech"></td>
		<td><input name="button" type="image" src="images/valider.gif"
			id="button" value="VALIDER" /></td>
	</tr>
</table>
</form>

</div>
<%@ include file="footer.jsp"%>
