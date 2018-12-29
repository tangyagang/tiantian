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
         <#list productCategorys>
             <#items as productCategory>
                 <tr>
                     <td>${productCategory.pcName}</td>
                     <#--<td>${productCategory.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>-->
                 </tr>
             </#items>
         </#list>
</table>
<table>
    <tr>
        <th>商品名</th>
        <th>时间</th>
    </tr>
         <#list products>
             <#items as product>
                 <tr>
                     <td>${product.proName}</td>
                 <td>${product.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                 </tr>
             </#items>
         </#list>
</table>
</body>
</html>