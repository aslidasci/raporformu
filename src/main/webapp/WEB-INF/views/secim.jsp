<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<script type="text/javascript">

</script>
<style>
a:link, a:visited, a:active {

font-size : 20px;
color : #465adc;
text-decoration : none;
}
a:hover {
font-size : 20px;
color : 		#3300cc;
text-decoration : underline;
}

</style>
</head>
<body>
<h2>Seçim Sayfasi</h2>

<form method="post" action="/rapor/secim/row">
 
    <div >
      <a href ="http://localhost:8080/rapor/add/row">KayitEkle</a>
      <br>
      <a href ="http://localhost:8080/rapor/list/rows">Raporlistele</a>
    </div>
    
</form>
</body>
</html>