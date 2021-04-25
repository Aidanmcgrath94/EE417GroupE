<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Character Descussion</title>
</head>
<body>
<sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306"
         user = "root"  password = "test"/>

<sql:query dataSource = "${snapshot}" var = "result">
SELECT * FROM mydata.character  </sql:query>


<table>
   <tr>
      <th>character</th>
      <th>source</th>
      <th>about</th>
   </tr>
    <c:forEach var = "row" items = "${result.rows}">
   <tr>   
       <td><c:out value = "${row.name}"/> </td>
       <td><c:out value = "${row.show}"/></td>
       <td><c:out value = "${row.content}"/></td>
       <td> <input type="submit" name="action" value="like"></td> 
       <td><input type="text" name="user_comment" placeholder="comment.."></td>
       <td> <input type="submit" name="action" value="comment"></td>      
    </tr>
    </c:forEach>
</table>
</body>
</html>


