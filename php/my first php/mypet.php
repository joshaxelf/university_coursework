<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>My Pet PHP</title>
</head>
<body>
<h1>My Pet PHP</h1>

<form method="POST">
<input type="text" name="petDOB" placeholder="Pet DOB -> DD-MM-YYYY">
<input type="submit" value="Submit">
</form>
<br>

<?php

if($_SERVER["REQUEST_METHOD"] == "POST"){
    $dob = $_POST["petDOB"];
    $petDOB = DateTime::createFromFormat('d-m-Y', $dob);
}

function daysBetween($petDOB, $todayDate)
{
    return ($petDOB->diff($todayDate))->days;
}
$todayDate = new DateTime();

echo "<p> Today is: " .date("d-m-Y") . "</p>";

echo "<p> This means that your pet is " .daysBetween($petDOB, $todayDate) . " days old <br></p>";

?>
</body>
</html>