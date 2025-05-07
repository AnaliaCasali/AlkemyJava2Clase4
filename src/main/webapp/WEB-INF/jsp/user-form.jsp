<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Usuario</title>
</head>
<body>
    <h1>${user.id == 0 ? 'Crear Usuario' : 'Editar Usuario'}</h1>
        <form action="${pageContext.request.contextPath}/users${user.id != 0 ? '/update/' : ''}${user.id != 0 ? user.id : ''}" method="post">

        <label for="name">Nombre:</label>
        <input type="text" id="name" name="name" value="${user.name}" required>
        <br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}" required>
        <br>
        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password" value="${user.password}" required>
        <br>
        <button type="submit">Guardar</button>
        <a href="${pageContext.request.contextPath}/users">Cancelar</a>
    </form>
</body>
</html>