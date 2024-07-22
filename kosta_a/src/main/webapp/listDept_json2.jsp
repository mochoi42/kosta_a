<%@page import="com.google.gson.Gson"%>
<%@page import="com.kosta.vo.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kosta.dao.DeptDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Thread.sleep(5000);
	DeptDAO dao = new DeptDAO();
	ArrayList<DeptVO> list = dao.findAll();
	Gson gson = new Gson();
	String data = gson.toJson(list);
%>
<%= data %>
