<%@page import="com.google.gson.Gson"%>
<%@page import="com.kosta.vo.MessageVO"%>
<%@page import="com.kosta.dao.DeptDAO"%>
<%@page import="com.kosta.vo.DeptVO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int dno = Integer.parseInt(request.getParameter("dno"));
	DeptDAO dao = new DeptDAO();
	int re = dao.delete(dno);
	MessageVO m = new MessageVO();
	m.setMsg(re+"");
	Gson gson = new Gson();
%>
<%= gson.toJson(m) %>
