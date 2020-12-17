<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, users-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form method="post" action="#{pageContext-}/mangerSys/login"><br/>
    用户：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    <input type="checkbox" name="remember-me"/>记住我<br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>