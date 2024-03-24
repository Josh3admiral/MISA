<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="business.Patient" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lab Technician Form</title>
     <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <table border="1">
        <tr>
            <th>StudentRegNo</th>
            <th>Name</th>
            <th>Symptoms</th>
            <th>Prescription</th>
            <th>Lab Test</th>
          
        </tr>
        <% Patient patient=(Patient) request.getAttribute("patient"); %>
            <tr>
                <td><%= patient.getstudentRegNo()%></td>
                <td><%= patient.getname()%> </td>
                <td><%= patient.getsymptoms()%></td>
                <td><%= patient.getprescription()%></td>
                <td><%= patient.getlabTest()%></td>
              
            </tr>
      
        </table>
</body>
</html>