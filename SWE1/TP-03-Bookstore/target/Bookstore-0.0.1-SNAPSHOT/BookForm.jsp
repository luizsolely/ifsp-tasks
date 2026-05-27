<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-BR">

<head>

    <meta charset="UTF-8">

    <title>Books Store Application</title>

    <style>

        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .menu {
            margin-bottom: 20px;
        }

        .menu a {
            margin: 0 10px;
            text-decoration: none;
        }

        table {
            border-collapse: collapse;
            min-width: 400px;
        }

        table,
        th,
        td {
            border: 1px solid #000;
        }

        th,
        td {
            padding: 10px;
        }

        th {
            text-align: left;
        }

        .submit-row {
            text-align: center;
        }

        input {
            padding: 5px;
        }

        button {
            padding: 8px 16px;
            cursor: pointer;
        }

    </style>

</head>

<body>

    <div class="container">

        <h1>Books Management</h1>

        <div class="menu">
		<h2>
            <a href="${pageContext.request.contextPath}/new">
                Adicionar Livro
            </a>
            &nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/list">
                Listar Livros
            </a>
		</h2>
        </div>

        <c:set var="formAction"
               value="${not empty book ? 'update' : 'insert'}" />

        <form action="${pageContext.request.contextPath}/${formAction}"
              method="post">

            <c:if test="${not empty book}">

                <input type="hidden"
                       name="id"
                       value="${book.id}" />

            </c:if>

            <h2>

                <c:choose>

                    <c:when test="${not empty book}">
                        Editar Livro
                    </c:when>

                    <c:otherwise>
                        Adicionar Livro
                    </c:otherwise>

                </c:choose>

            </h2>

            <table>

                <tr>

                    <th>Titulo:</th>

                    <td>

                        <input type="text"
                               name="title"
                               size="45"
                               value="${book.title}"
                               required />

                    </td>

                </tr>

                <tr>

                    <th>Autor:</th>

                    <td>

                        <input type="text"
                               name="author"
                               size="45"
                               value="${book.author}"
                               required />

                    </td>

                </tr>

                <tr>

                    <th>preço:</th>

                    <td>

                        <input type="number"
                               name="price"
                               step="0.01"
                               min="0"
                               value="${book.price}"
                               required />

                    </td>

                </tr>

                <tr>

                    <td colspan="2" class="submit-row">

                        <button type="submit">
                            Salvar
                        </button>

                    </td>

                </tr>

            </table>

        </form>

    </div>

</body>

</html>