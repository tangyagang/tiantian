<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FreeMarkerTitle</title>
</head>
<body>
<table>
    <tr>
        <th>标题</th>
        <th>时间</th>
    </tr>
         <#list newsList>
             <#items as news>
                 <tr>
                     <td>${news.title}</td>
                     <td>${news.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                 </tr>
             </#items>
         </#list>
</table>

</body>
</html>