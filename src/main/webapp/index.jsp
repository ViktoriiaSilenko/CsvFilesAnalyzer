<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Csv Files</title>
</head>
<body>

<h2>Csv Files Information</h2>
<ul>
<c:forEach items="${filesInfo}" var="fileInfo" >
    <li><u>${fileInfo.fileName}</u></li>
        Rows number: ${fileInfo.rowsNumber}<br/>
        Empty cells count: ${fileInfo.emptyCellsNumber}<br/>
        Columns:<br/>
        <ul>
            <c:forEach items="${fileInfo.columnsNames}" var="columnsName" >
                <li>${columnsName}</li>
            </c:forEach>
        </ul>
</c:forEach>
</ul>

</body>
</html>