<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Listele</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript" src="/src/main/webapp/resources/jquery-latest.js"></script> 
  <script type="text/javascript" src="/src/main/webapp/resources/jquery.tablesorter.js"></script>
  <script>
  $( function() {
    $( "#raportarih" ).datepicker({ dateFormat: 'yy-mm-dd' });
    $("#myTable").tablesorter();
    
  } );
  
  

		   
  
  </script>
	
</head>
<style type=text/css>
table
{
 width:400px;
 border-collapse :collapse;
}
th{

background: #465adc ;
}
tr:hover { background:  #465adc ; cursor :pointer } 
th,td
{
border: 2px solid black;
padding:10px;
}
</style>
<body>
<h1>
	Listele
</h1>
<form method="post" action="/rapor/list/rows">
<table id="tablo">
 
	<tr>
		<td>Email</td>
		<td><input name="email" type="text" value="${param.email}" id="mail"/></td>
		
	</tr>
	<tr>
	    <td>Departman</td>
		<td><input name="departman" type="text" value="${param.departman}"/></td>
	</tr>
	<tr>
	    <td>RaporTarihi</td>
		<td><label for="meeting"></label><input name ="raportarih" id="raportarih" type="text" value= "${param.raportarih}"/></td>
		
	</tr>
	
	
	<tr>
		<td></td>
		<td><input type="submit" value="LISTELE"/></td>
	</tr>
	</table>
</form>
	<table >
		<thead>
			<tr>
				<th>No</th>
				<th>email</th>
				<th>departman</th>
				<th>rapor</th>
				<th>raportarih</th>
				
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="row" varStatus="st"><tr>
				<td>${st.index + 1}<br></td>
				<td>${row.email}</td>
				<td>${row.departman}</td>
				<td>${row.rapor}</td>
				<td>${row.raportarih}</td>
				
				
				
				
			</tr></c:forEach>
		</tbody>
	</table>
</body>
</html>
