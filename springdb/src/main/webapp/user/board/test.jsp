<%@ page contentType="text/html;charset=UTF-8"%>
<%
try{
	int[] arr = new int[3];
	arr[3]=5;
}catch(Exception e){
	out.print("error");
}
out.print("result");
%>