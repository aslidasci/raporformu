<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<style>
.genel

{

border:1px solid #d3d3d3;              

padding:10px;                         

width:500px;                          

height:150px;                         

background:#eee;                     

font:12px Arial, Tahoma, Verdana;;

}



.baslik

{

background:#465adc;  

color:; 

padding:5px;

font-weight:bold;  



}



.buton

{

float:right;                      

margin-right:25px; 

border:1px solid #666;         

padding:2px 5px;                  

background:cornflowerblue;      

color:#fff;                     

font-weight:bold;              

}
</style>
<body>


<div class="genel" >  

<div class="baslik" >KAYIT SAYFASI</div>

 <form method="post" action ="/rapor/k/rows" >

<p>Kullanici adi           <input type="text"  name="kadi"  value="${param.kadi}"  />    </p>

<p>Sifre   <input  style="margin-left:42px; " type="text" name="sifre"   value="${param.kadi}" />     </p>

 <p> <input class="buton" type="submit" value="KAYIT"  />   </p>
 
${result}

 </form> 

 </div>



</body>
</html>
