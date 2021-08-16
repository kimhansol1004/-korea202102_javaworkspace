<%@page import="com.koreait.springdb.model.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	
	//BoardDAO dao = new MybatisBoardDAO(); //일시킨다!! 컨트롤러가 된다..jsp는 뷰이지 컨트롤러가 아니므로,이거 하지말자!!
	List<Board> boardList=(List)request.getAttribute("boardList");//동생 컨트롤러가 심은 데이터 가져오기
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
  position:relative;
  left:-1000px;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
    var table = $("table");  
    table.animate({left: '0px'}, "slow");	
});
</script>
</head>
<body>

<h2>게시판 목록</h2>

<table>
	<tr>
		<th>No</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
	<%for(Board board : boardList){ %>
	<tr>
		<td>Jill</td>
		<td><a href="/client/board/detail?board_id=<%=board.getBoard_id()%>"><%=board.getTitle()%></a></td>
		<td><%=board.getWriter() %></td>
		<td><%=board.getRegdate()%></td>
		<td><%=board.getHit() %></td>
	</tr>
	<%} %>
	<tr>
		<td colspan="5">
			<button onClick="location.href='/board/regist.jsp';">등록</button>
		</td>
	</tr>
</table>
</body>
</html>
