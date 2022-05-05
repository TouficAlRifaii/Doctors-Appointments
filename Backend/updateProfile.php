<?php

require __DIR__ . '/classes/Database.php';
$db_connection = new Database();
$conn = $db_connection->dbConnection();

$email = $_GET["email"];
$name = $_POST["name"];
$birthday = $_POST["birthday"];
$number = $_POST["phone_number"];




$query = $conn-> prepare("UPDATE users SET name= $name ,birthday=$birthday  ,phone_number= $number, WHERE email= $email");

$query-> execute();


?>