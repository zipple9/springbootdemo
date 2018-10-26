<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
</head>
<body>
<#--<#if param.error><div>登录失败</div></#if>-->
<#--<#if param.logout == "Big Joe"><div>注销成功</div></#if>-->
<form action="/loginPage" method="post">
    <label>用户名<input type="text" name="username"/></label><br>
    <label>密码<input type="text" name="password"/></label><br>
    <input type="submit"/>
</form>

</body>
</html>