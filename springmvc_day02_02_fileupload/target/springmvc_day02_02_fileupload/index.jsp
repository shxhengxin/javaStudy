<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/16
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>传统文件上传</h3>


<form method="post" action="user/fileUpload1" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload"><br />
    <input type="submit" value="上传">
</form>

    <h3>springMVC文件上传</h3>

    <form method="post" action="user/fileUpload2" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"><br />
        <input type="submit" value="上传">
    </form>



    <h3>跨服务器文件上传</h3>

    <form method="post" action="user/fileUpload3" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"><br />
        <input type="submit" value="上传">
    </form>
</body>
</html>
