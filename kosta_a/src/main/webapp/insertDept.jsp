<%@page import="com.google.gson.Gson"%>
<%@page import="com.kosta.vo.MessageVO"%>
<%@page import="com.kosta.dao.DeptDAO"%>
<%@page import="com.kosta.vo.DeptVO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int dno = Integer.parseInt(request.getParameter("dno"));
	String dname = request.getParameter("dname");
	String dloc = request.getParameter("dloc");
	DeptVO d = new DeptVO(dno, dname, dloc);
	DeptDAO dao = new DeptDAO();
	int re = dao.insert(d);
	MessageVO m = new MessageVO();
	m.setMsg(re+"");
	Gson gson = new Gson();
%>
<%= gson.toJson(m) %>
