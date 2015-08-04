<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,modele.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
    body {
	background-image: url(images/java.jpg);
	background-repeat: no-repeat;
	background-position: center top;
	margin: 0px;
	font-family: calibri;
	font-size: 13px;
	color: white;
}
</style>
</head>
  
<body > <br><br><br><br><br><br><br><br>
<form action="TraiteLogin" method="post" name="Form1">
  <table width="259" border="0" align="center">
    <tr>
      <td height="27" colspan="2" align="center" valign="middle">AUTHENTIFICATION</td>
    </tr>
    <tr>
      <td width="117">Utilisateur</td>
      <td width="132"><input type="text" name="user" id="user" /></td>
    </tr>
    <tr>
      <td>Mot de passe</td>
      <td><input type="password" name="passe" id="passe" /></td>
    </tr>

		<tr>
			<td><input type="hidden" name="bouton" value="add"></td>
			<td> <input type="submit"  name="button" id="button" value="Se connecter" /></td>
		</tr>
		<tr>
			<td colspan="2">  <font color="red">IMPOSSIBLE DE SE CONNECTER </font><br> Mot de passe ou nom d'utilisateur incorrect
</td>
		</tr>
</table>
</form>
</body>
</html>