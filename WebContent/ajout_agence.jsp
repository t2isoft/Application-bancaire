<%@ include file="entete.jsp"%>
<script type="text/javascript">
function verfiagence()
{
	if (document.form.libelle.value == "")	
	{
		alert("Veuillez saisir le libelle de l'agance")
		document.form.libelle.focus()
		return false;
	}
	if (document.form.adresse.value == "")	
	{
		alert("Veuillez saisir l'adresse de l'agence")
		document.form.adresse.focus()
		return false;
	}
}
</script>
<!--

//-->

<div id="page">
<div id="titre">FORMULAIRE D'AJOUT D'UN AGENCE</div>
<br />
<form id="form1" name="form" method="post" action="TraiteAgence" onsubmit="return verfiagence();">
<table width="346" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="28">Libelle</td>
		<td><input type="text" name="libelle" value=""></td>
	</tr>
	<tr>
		<td height="28">Adresse</td>
		<td><input type="text" name="adresse" value=""></td>
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
