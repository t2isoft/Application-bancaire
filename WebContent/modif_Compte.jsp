<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,modele.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="entete.jsp"%>

<div id="page">
<%
	Compte c=(Compte)request.getAttribute("c");
%>
<div id="titre">Formulaire de modification d'un compte  du client  N°:<%=c.getNumcli()%></div>

<form action="TraiteCompte" method="post">
<table width="346" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>Numéro du Compte:</td>
		<td><input type="text" name="NumCp" value="<%=c.getNumCp()%>"
			readonly="readonly"
			title="Le numerode compte ne peut pas être mise à jour"></td>
	</tr>
	<tr>
		<td>Libellé:</td>
		<td><input type="text" name="LibelleCp"
			value="<%=c.getLibellecp()%>"></td>
	</tr>
	<tr>
		<td>Sense:</td>
		<td><select name="SensCp">
			<option value="<%=c.getSenscp()%>" selected="selected"><%=c.getSenscp()%></option>
			<option value="Crediteur" selected="selected">Crediteur</option>
			<option value="Debiteur" selected="selected">Debiteur</option>
		</select></td>
		<tr>
			<td>Solde:</td>
			<td><input type="text" name="Solde" value="<%=c.getSolde()%>"></td>
		</tr>
		<tr>
	
			<td><input type="hidden" name="numcl" value="<%=c.getNumcli()%>"></td>
		</tr>
		<tr>
			<td><input name="button" type="image" src="images/valider.gif"
				id="button" value="MODIFIER" /></td>
			<td><input type="hidden" name="bouton" value="mod"></td>
		</tr>
</table>
</form>

</div>
<%@ include file="footer.jsp"%>