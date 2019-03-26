<html>
<body>
<h2>Hello World!</h2>
<form name="from1" method="post" action="/manage/product/upload.do" enctype="multipart/form-data">
    <input type="file" name="upload_file"/>
    <input type="submit" value="SpringMvc上传文件"/>
</form>
<form name="from2" method="post" action="/manage/product/richtext_img_upload.do" enctype="multipart/form-data">
    <input type="file" name="upload_file"/>
    <input type="submit" value="富文本文件上传"/>
</form>
</body>

</html>
