<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//현재 클라이언트가 사용중인 session 객체를 무효화시키자 즉 기존 세션을 더이상 사용못하게 처리
	session.invalidate();
%>
<script>
alert("로그아웃 처리되었습니다");
location.href="/member/login.jsp";
</script>