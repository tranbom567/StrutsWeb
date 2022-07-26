<%-- 
    Document   : PostAVTBody
    Created on : Jul 24, 2022, 4:05:30 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form action="/SetAvatar" enctype="multipart/form-data" method="post">
    <input type="file" name="avatar" class="input" accept="image/jpeg,image/gif,image/bmp,image/png"/>
    <input type="checkbox" name="defAvatar" value="Use Default Avatar"/>
    <button type="submit" class="SignUpButton">Set Avatar</button>
</form>
