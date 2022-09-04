<%@taglib url="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 align="center">all Employees</h1>
<hr>

<table border="2" align="center">
<tr>
<th> Employee Id</th>
<th>Employee Name</th>
<th>Employee Address</th>
</tr>
<c:foreach var="employees" items="${employee}">

<tr>
<td>${employee.id}</td>
<td>${employee.emp_name}</td>
<td>${employee.emp_address}</td>
</tr>
</c:foreach>
</table>
<a href="/addEmployee">Add more Employee</a>
