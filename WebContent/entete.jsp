<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,modele.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PROJET JEE GESTION COMPTE BANCAIRE</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
</script>
</head>

<body onload="MM_preloadImages('images/m_01.png','images/m_02.png','images/m_03.png','images/m_04.png','images/accuei1.png')">
 
 <table width="505" border="0" align="center">
    <tr>
      <td width="388">Utilisateur connecté:<%ArrayList<modele.Login> listes=(ArrayList<modele.Login>) session.getAttribute("listes");
for (Login l:listes)
{
if(l.getNomprenom()=="")
{
	response.sendRedirect("index.jsp");
	}%>
	
<%=l.getNomprenom() %>
<%} %></td>
      <td width="107"><a href="TraiteLogin?lien=logoff">Deconnexion</a></td>
    </tr>
  </table>
<div id="bannier">
  <div id="menucon">
  <a href="TraiteClient?lien=lister" title="Liste des clients de la banque" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image1','','images/m_01.png',1)"><img src="images/MM (1).png" name="Image1" width="72" height="50" border="0" id="Image1" /></a>
  <a href="TraiteAgence?lien=lister"  title="Liste des agences de la banque" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image2','','images/m_02.png',1)"><img src="images/MM (2).png" name="Image2" width="71" height="50" border="0" id="Image2" /></a>
  <a href="TraiteCompte?lien=lister" title="Liste des comptes de la banque" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image3','','images/m_03.png',1)"><img src="images/MM (3).png" name="Image3" width="81" height="50" border="0" id="Image3" /></a>
  <a href="TraiteCompte?lien=rech" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image4','','images/m_04.png',1)"><img src="images/MM (4).png" name="Image4" width="104" height="50" border="0" id="Image4" /></a>
  <a href="accueil.jsp" title="Retour à la page d'accueil)" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image5','','images/accuei1.png',1)"><img src="images/accueil.png" name="Image5" width="41" height="40" border="0" id="Image5" /></a>
  </div>