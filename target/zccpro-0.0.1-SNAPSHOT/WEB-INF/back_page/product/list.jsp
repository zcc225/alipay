<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-list</title>
<script type="text/javascript">
function getTableForm() {
	return document.getElementById('tableForm');
}
function optDelete(pageNo) {
	if(Pn.checkedCount('ids')<=0) {
		alert("请至少选择一个!");
		return;
	}
	if(!confirm("确定删除吗?")) {
		return;
	}
	var f = getTableForm();
	f.action="/product/delete.do?pageNo="+pageNo;
	f.submit();
}

function isShow(pageNo) {
	if(Pn.checkedCount('ids')<=0) {
		alert("请至少选择一个!");
		return;
	}
	if(!confirm("确定上架吗?")) {
		return;
	}
	var f = getTableForm();
	f.action="/product/isShow.do?pageNo="+pageNo;
	f.submit();
}

function noShow(pageNo) {
	if(Pn.checkedCount('ids')<=0) {
		alert("请至少选择一个!");
		return;
	}
	if(!confirm("确定下架吗?")) {
		return;
	}
	var f = getTableForm();
	f.action="/product/noShow.do?pageNo="+pageNo;
	f.submit();
}
function changePageNo(){
	$("input[name='pageNo']").val(1);
}
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 商品管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='/product/toAdd.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="/product/list.do" method="post" style="padding-top:5px;">
名称: <input type="text" name="name" value="${productQuery.name}"/>
	<select name="brandId">
		<option value="">请选择品牌</option>
		<c:forEach var="brand" items="${brandList}">
		<option value="${ brand.id}" <c:if test="${productQuery.brandId ==  brand.id}">selected="selected"</c:if>>${brand.name}</option>
		</c:forEach>
	</select>
	<select name="isShow">
		<option value="1" <c:if test="${productQuery.isShow eq true }">selected="selected"</c:if>>上架</option>
		<option value="0" <c:if test="${productQuery.isShow eq false }">selected="selected"</c:if>>下架</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
<form method="post" id="tableForm">
<table cellspacing="1" cellpadding="0" width="100%" border="0" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>图片</th>
			<th width="4%">新品</th>
			<th width="4%">热卖</th>
			<th width="4%">推荐</th>
			<th width="4%">上下架</th>
			<th width="12%">操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
	<c:forEach var="product" items="${productList}" varStatus="st">
		<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
			<td><input type="checkbox" name="ids" value="${product.id}"/></td>
			<td>${product.id}</td>
			<td align="center">${product.name}</td>
			<td align="center"><img width="50" height="50" src="${product.webSite }"/></td>
			<td align="center">${product.isNew eq true?"是":"否"}</td>
			<td align="center">${product.isHot eq true?"是":"否"}</td>
			<td align="center">${product.isCommend eq true?"是":"否"}</td>
			<td align="center">${product.isShow eq true?"上架":"下架"}</td>
			<td align="center">
			<a href="#" class="pn-opt">查看</a> | <a href="/product/toEdit.do?id=${product.id}" class="pn-opt">修改</a> | <a href="/product/delete.do?ids=${product.id}&amp;pageNo=${productQuery.pageNo}" onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt">删除</a> | <a href="/sku/list.do?id=${product.id}" class="pn-opt">库存</a>
			</td>
		</tr>
	</c:forEach>
		
	</tbody>
</table>
<div class="page pb15">
	<span class="r inb_a page_b">
	
		<c:if test="${productQuery.pageNo ne 1 }" >
		<a href="/product/list.do?brandId=${productQuery.brandId }&amp;isShow=${productQuery.isShow}&amp;name=${productQuery.name}&amp;pageNo=1"><font size="2">首页</font></a>
		<a href="/product/list.do?brandId=${productQuery.brandId }&amp;isShow=${productQuery.isShow}&amp;name=${productQuery.name}&amp;pageNo=${productQuery.pageNo -1}"><font size="2">上一页</font></a>
		</c:if>
		<c:forEach var="currentPage" begin="1" end="${productQuery.totalPage}" >
			<c:if test="${currentPage eq productQuery.pageNo}">
			<strong>${currentPage}</strong>
			</c:if>
			<c:if test="${currentPage ne productQuery.pageNo}">
			<a href="/product/list.do?brandId=${productQuery.brandId }&amp;isShow=${productQuery.isShow}&amp;name=${productQuery.name}&amp;pageNo=${currentPage}">${currentPage}</a>
			</c:if>
		</c:forEach>
		<c:if test="${productQuery.pageNo ne productQuery.totalPage}">
		<a href="/product/list.do?brandId=${productQuery.brandId }&amp;isShow=${productQuery.isShow}&amp;name=${productQuery.name}&amp;pageNo=${productQuery.pageNo +1}"><font size="2">下一页</font></a>
		<a href="/product/list.do?brandId=${productQuery.brandId }&amp;isShow=${productQuery.isShow}&amp;name=${productQuery.name}&amp;pageNo=${productQuery.totalPage}"><font size="2">尾页</font></a>
		</c:if>
		共<var>${productQuery.totalPage} </var>页 到第<input type="text" size="3" id="PAGENO"/>页 <input type="button" onclick="javascript:window.location.href = '/product/list.do?&amp;isShow=0&amp;pageNo=' + $('#PAGENO').val() " value="确定" class="hand btn60x20" id="skip"/>
	
	</span>
</div>
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete(${productQuery.pageNo});"/><input class="add" type="button" value="上架" onclick="isShow(${productQuery.pageNo});"/><input class="del-button" type="button" value="下架" onclick="noShow(${productQuery.pageNo});"/></div>
</form>
</div>
</body>
</html>