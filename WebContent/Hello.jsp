<!DOCTYPE html>
<html lang="en">
<head>
  <title>Hello Commute</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <div class="jumbotron">
    <h1>Commute API</h1>
    
  </div>
  <div class="row">
    <div class="col-sm-4">
      <h3>api/insertCommute</h3>
      <p>Insert a commute</p>
      <p>Input JSON: {"commuteId":123,"city":"Bangalore","commuteStart":"BTM","commuteDest":"Marathalli"}
      </p>
      
    </div>
    </div>
    <div class="row">
    <div class="col-sm-4">
      <h3>api/getAllCommutes</h3>
      <p>get All Commutes</p>
      <p>output JSON: [{"commuteId":567,"city":"Bangalore","commuteStart":"BTM","commuteDest":"White fields"},
      	<p>			   {"commuteId":567,"city":"Bangalore","commuteStart":"BTM","commuteDest":"White fields"},</p>
      	<p>			   {"commuteId":123,"city":"Bangalore","commuteStart":"BTM","commuteDest":"Marathalli"},</p>
      	<p>			   {"commuteId":123,"city":"Bangalore","commuteStart":"BTM","commuteDest":"Marathalli"}]</p>
</p>
    </div>
    </div>
    <div class="row">
    <div class="col-sm-4">
      <h3>api/verify</h3>        
      <p>Checks if the service is up</p>
      
    </div>
     </div>
  


 <div class="row">
    <div class="col-sm-4">
      <h3>DB details</h3>        
      <p>broids.cfirgz1jw56c.us-east-1.rds.amazonaws.com <p>
 <p>port:1521 <p>
 <p>SID :ORCL <p>
 <p>username: broids <p>
 
      
    </div>
     </div>
  
</div>

</body>
</html>
