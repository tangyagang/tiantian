<#function transPhone phone>
    <#return phone?replace(phone?substring(3,7),"****")>
</#function>