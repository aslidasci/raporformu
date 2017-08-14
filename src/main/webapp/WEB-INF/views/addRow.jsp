<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Rapor Ekle</title>
	<style type=text/css>
.class1 {
    margin:10px auto;
    max-width: 400px;
    padding: 20px 12px 10px 20px;
    font: 13px "Lucida Sans Unicode", "Lucida Grande", sans-serif;
}
.class1 li {
    padding: 0;
    display: block;
    list-style: none;
    margin: 10px 0 0 0;
}
.class1 label{
    margin:0 0 3px 0;
    padding:0px;
    display:block;
    font-weight: bold;
}
textarea,
select{
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    border:1px solid #BEBEBE;
    padding: 7px;
    margin:0px;
    -webkit-transition: all 0.30s ease-in-out;
    -moz-transition: all 0.30s ease-in-out;
    -ms-transition: all 0.30s ease-in-out;
    -o-transition: all 0.30s ease-in-out;
    outline: none; 
}
.class input[type=text]:focus,
.class textarea:focus,
.class select:focus{
    -moz-box-shadow: 0 0 8px #88D5E9;
    -webkit-box-shadow: 0 0 8px #88D5E9;
    box-shadow: 0 0 8px #88D5E9;
    border: 1px solid #88D5E9;
}
.class1 .field-divided{
    width: 49%;
}

.class1.field-long{
    width: 100%;
}
.class1.field-select{
    width: 100%;
}
.class1 .field-textarea{
    height: 100px;
}
.class1 input[type=submit], .class1 input[type=button]{
    background: #0066CC ;
    padding: 8px 15px 8px 15px;
    border: none;
    color: #fff;
}
.class1 input[type=submit]:hover, .class1 input[type=button]:hover{
    background: #465adc;
    box-shadow:none;
    -moz-box-shadow:none;
    -webkit-box-shadow:none;
}
.class1 .required{
    color:red;
}

</style>
</head>
<body>
<h1>
	RAPOR EKLE
</h1>
<form method="post" action="/rapor/add/row">
<ul class="class1">
    <li><label>E-mail <span class="required">*</span></label>
    <input type="text" id="email" name="email" class="field-divided" placeholder="First" value="${param.email}" />
    </li>
    <li><label>Departman <span class="required">*</span></label>
    <input type="text" id="departman" name="departman" class="field-divided" placeholder="First" value="${param.departman}" />
    </li>
    
    <li>
        <label>Rapor <span class="required">*</span></label>
        <textarea name="rapor" id="rapor" class="field-long field-textarea">${param.rapor}</textarea>
    </li>
    <li>
        <input type="submit" id="submit" value="Kayit"/>
    </li>
    <li>
        <input type="text" value="${result}" />
    </li>
       
</ul>
</form>
</body>
</html>
