<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-list</title>
<script type="text/javascript">
//全选
function checkBox(name,checked){
	
	$("input[name='" + name + "']").attr("checked",checked);
	
}
//删除
function optDelete(name,isDisplay,pageNo){
	//判断是否已经选
	var size = $("input[name='ids']:checked").size();
	if(size == 0){
		alert("请至少选择一个");
		return;
	}
	if(!confirm("你确定删除吗？")){
		return;
	}
	//删除
	$("#jvForm").attr("action","/brand/delete.do?name=" + name + "&isDisplay=" + isDisplay + "&pageNo=" + pageNo).attr("method","post").submit();
	
}
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='/brand/toAdd.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="/brand/list.do" method="post" style="padding-top:5px;">
品牌名称: <input type="text" name="name"  value = "${brandQuery.name}"/>
	<select  name = "isDisplay">
		<option value="true"<c:if test ="${brandQuery.isDisplay eq true }"> selected="selected"</c:if>>是</option>
		<option value="false"<c:if test ="${brandQuery.isDisplay eq false }"> selected="selected"</c:if>>不是</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
<form id = "jvForm">
<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="checkBox('ids',this.checked)"/></th>
			<th>品牌ID</th>
			<th>品牌名称</th>
			<th>品牌图片</th>
			<th>品牌描述</th>
			<th>排序</th>
			<th>是否可用</th>
			<th>操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
		<c:forEach items="${brandList}" var="Brand" varStatus="vs">
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="${Brand.id}" name="ids"/></td>
			<td align="center">${Brand.id}</td>
			<td align="center">${Brand.name}</td>
			<td align="center"><img width="40" height="40" src="${Brand.webSite}"/></td>
			<td align="center">${Brand.description}</td>
			<td align="center">${Brand.sort}</td>
			<td align="center">${Brand.isDisplay eq true?"是":"否"}</td>
			<td align="center">
			<a class="pn-opt" href="/brand/toEdit.do?id=${Brand.id}">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="/brand/delete.do?ids=${Brand.id}">删除</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</form>
<div class="page pb15">
	<span class="r inb_a page_b">
		<c:if test="${brandQuery.pageNo ne 1 }" >
		<a href="/brand/list.do?isDisplay=${brandQuery.isDisplay}&amp;name=${brandQuery.name}&amp;pageNo=1"><font size="2">首页</font></a>
		<a href="/brand/list.do?isDisplay=${brandQuery.isDisplay}&amp;name=${brandQuery.name}&amp;pageNo=${brandQuery.pageNo -1}"><font size="2">上一页</font></a>
		</c:if>
		<c:forEach var="currentPage" begin="1" end="${brandQuery.totalPage}" >
			<c:if test="${currentPage eq brandQuery.pageNo}">
			<strong>${currentPage}</strong>
			</c:if>
			<c:if test="${currentPage ne brandQuery.pageNo}">
			<a href="/brand/list.do?isDisplay=${brandQuery.isDisplay}&amp;name=${brandQuery.name}&amp;pageNo=${currentPage}">${currentPage}</a>
			</c:if>
		</c:forEach>
		<c:if test="${brandQuery.pageNo ne brandQuery.totalPage}">
		<a href="/brand/list.do?isDisplay=${brandQuery.isDisplay}&amp;name=${brandQuery.name}&amp;pageNo=${brandQuery.pageNo +1}"><font size="2">下一页</font></a>
		<a href="/brand/list.do?isDisplay=${brandQuery.isDisplay}&amp;name=${brandQuery.name}&amp;pageNo=${brandQuery.totalPage}"><font size="2">尾页</font></a>
		</c:if>
		共${brandQuery.totalPage}页 到第<input type="text" size="3" id="PAGENO"/>页 <input type="button" onclick="javascript:window.location.href = '/brand/list.do?&amp;pageNo=' + $('#PAGENO').val() " value="确定" class="hand btn60x20" id="skip"/>
	</span>
</div>
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete('${brandQuery.name}','${brandQuery.isDisplay}',${brandQuery.pageNo});"/></div>
</div>
</body>
</html>