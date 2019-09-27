
<#function generateId>
    <#if indexIncrement??>
        <#assign indexIncrement = indexIncrement + 1>
    <#else>
        <#global indexIncrement = 1>
    </#if>

    <#return indexIncrement - 1>
</#function>