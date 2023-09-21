<%-- 
    Document   : campoData
    Created on : 04/09/2023, 17:29:57
    Author     : Paulo Henrique
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="id" required="true"%>

<%-- any content can be specified here e.g.: --%>
<input id="${id}" name="${id}" type="text">

<script>              
    $("#${id}").datepicker({dateFormat: 'dd/mm/yy'}); 
</script>