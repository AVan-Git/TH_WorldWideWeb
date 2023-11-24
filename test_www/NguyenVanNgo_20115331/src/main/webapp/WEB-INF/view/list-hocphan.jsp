<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>Danh Sach Hoc Phan</div>
	</div>
	<div>
		<div>
			<input type="button" value="AddHocPhan"
				onclick="window.location.href='showFormAdd';return false" />
			<table>
				<tr>
					<th>Ma lop</th>
					<th>Mon Hoc</th>
					<th>So Tin Chi</th>
					<th>Ma GV</th>
					<th>Loai</th>
					<th>Phong</th>
				</tr>
				<c:forEach var="tempHP" items="${listhocphan }">
					<c:url var="updatelink" value="/showFormUpdate">
						<c:param name="hocphanId" value="${tempHP.maLop }" />
					</c:url>
					<c:url var="deleteLink" value="/delete">
						<c:param name="hocphanId" value="${tempHP.maLop }" />
					</c:url>
					<tr>
						<td>${tempHP.maLop}</td>
						<td>${tempHP.monHoc}</td>
						<td>${tempHP.soTinChi}</td>
						<td>${tempHP.maGv}</td>
						<td>${tempHP.loai}</td>
						<td>${tempHP.phong}</td>

						<td>${tempHP.phong}</td>

						<td><a href="${updatelink }">Update</a></td>
						<td><a href="${deleteLink }">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>
</body>
</html>