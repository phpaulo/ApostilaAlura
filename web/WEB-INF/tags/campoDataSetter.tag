<%-- 
    Document   : campoDataSetter
    Created on : 20/09/2023, 21:53:53
    Author     : Paulo Henrique
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="id" required="true"%>
<%@attribute name="value"  required="false"%>

<%-- any content can be specified here e.g.: --%>
<input id="${id}" name="${id}" type="text" value="${value}">

<script>              
    $("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
    $("#${value}").datepicker({dateFormat: 'dd/mm/yy'}; 
</script>