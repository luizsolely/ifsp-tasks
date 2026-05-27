<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Créditos</title>

<style>
    body{
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    .container{
        width: 60%;
        margin: 50px auto;
        background: white;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0,0,0,0.2);
        text-align: center;
    }

    h1{
        color: #333;
        margin-bottom: 20px;
    }

    .creditos{
        font-size: 18px;
        color: #555;
        line-height: 1.8;
    }

    .footer{
        margin-top: 30px;
        color: #888;
        font-size: 14px;
    }

    a{
        text-decoration: none;
        color: white;
        background-color: #007bff;
        padding: 10px 20px;
        border-radius: 5px;
    }

    a:hover{
        background-color: #0056b3;
    }
</style>

</head>
<body>

    <div class="container">
        <h1>Créditos do Sistema</h1>

        <div class="creditos">
            <p><strong>Projeto:</strong> Sistema Bookstore</p>

            <p><strong>Desenvolvedores:</strong> 
            <br>Luiz Felipe Gonçalves da Silva
            <br>Geovanna Barros de Assunção</p>

            <p><strong>Tecnologias utilizadas:</strong></p>

            <p>
                Java JSP/Servlets <br>
                Apache Tomcat <br>
                JDBC <br>
                H2 Database <br>
            </p>

            <p>
                Projeto desenvolvido para fins acadêmicos e aprendizado
                de desenvolvimento web em Java.
            </p>
        </div>

        <br>

        <a href="list">Voltar ao Sistema</a>

        <div class="footer">
            © 2026 - Bookstore
        </div>
    </div>

</body>
</html>