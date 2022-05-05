<?php

require __DIR__ . '/classes/Database.php';
$db_connection = new Database();
$conn = $db_connection->dbConnection();

$email = $_GET["email"];
$query= $conn -> prepare("SELECT name , birthday , phone_number FROM users WHERE email=$email");
$query -> execute() ;
$array = $query -> fetch();

echo json_encode($array);




?>