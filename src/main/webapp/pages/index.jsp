<html><head><title>Login Page</title></head><body onload='document.f.username.focus();'>
<form name='f' action='/login' method='POST'>
    <table>
        <tr><td>User:</td><td><input type='text' name='username' value=''></td></tr>
        <tr><td>Password:</td><td><input type='password' name='password'/></td></tr>
        <tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input name="token" type="input" />
    </table>
</form></body></html>