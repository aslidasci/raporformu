<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }

</script>
<style>
form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #465adc;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}



.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
<body>

<h2>Kullanici Girisi</h2>

<form action="/rapor/login/row" method="post">

  <div class="container">
    <label><b>KULLANICI ADI</b></label>
    <input type="text" placeholder="Kullanici adini giriniz" name="kadi" required>

    <label><b>SIFRE</b></label>
    <input type="password" placeholder="Sifrenizi giriniz" name="sifre" required>
        
    <button type="submit" class="girisbtn">GIRIS</button>
  </div>
  <div class="container" style="background-color:#f1f1f1">
  <button type="button" class="kayitbtn"    onclick="openPage('http://localhost:8080/rapor/k/rows')">KAYDOL</button>
  </div>

 ${result}
</form>



</body>
</html>