<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-add</title>
<style type="">
.h2_ch a:hover, .h2_ch a.here {
    color: #FFF;
    font-weight: bold;
    background-position: 0px -32px;
}
.h2_ch a {
    float: left;
    height: 32px;
    margin-right: -1px;
    padding: 0px 16px;
    line-height: 32px;
    font-size: 14px;
    font-weight: normal;
    border: 1px solid #C5C5C5;
    background: url('../res/itcast/img/admin/bg_ch.gif') repeat-x scroll 0% 0% transparent;
}
a {
    color: #06C;
    text-decoration: none;
}
</style>
<script type="text/javascript">
$(function(){
	var tObj;
	$("#tabs a").each(function(){
		if($(this).attr("class").indexOf("here") == 0){tObj = $(this)}
		$(this).click(function(){
			var c = $(this).attr("class");
			if(c.indexOf("here") == 0){return;}
			var ref = $(this).attr("ref");
			var ref_t = tObj.attr("ref");
			tObj.attr("class","nor");
			$(this).attr("class","here");
			$(ref_t).hide();
			$(ref).show();
			tObj = $(this);
			if(ref == '#tab_2'){
				var fck = new FCKeditor("productdesc");
				fck.BasePath = "/res/fckeditor/";
				fck.Height = 400 ;
				fck.Config["ImageUploadURL"] = "/upload/uploadFck.do";
				fck.ReplaceTextarea();
			}
		});
	});
}); 

function uploadpic(){
	var options = {
			url : "/upload/uploadPic.do",
			type : "post",
			dataType : "json",
			success : function(data){
				//路径   二个绝对  显示图片  url
				// 保存数据库   path 
				$("#product_url").attr("src",data.url);
				$("#product_path").val(data.path);
			}
	}
	
	//异步提交
	$("#jvForm").ajaxSubmit(options);
}
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 商品管理 - 修改</div>
	<form class="ropt">
		<input type="submit" onclick="this.form.action='/product/list.do';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<h2 class="h2_ch"><span id="tabs">
<a href="javascript:void(0);" ref="#tab_1" title="基本信息" class="here">基本信息</a>
<a href="javascript:void(0);" ref="#tab_2" title="商品描述" class="nor">商品描述</a>
<a href="javascript:void(3);" ref="#tab_3" title="商品参数" class="nor">包装清单</a>
</span></h2>
<div class="body-box" style="float:right">
	<form id="jvForm" action="/product/edit.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name = "id" value="${product.id }" />
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody id="tab_1">
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						商品类型:</td><td width="80%" class="pn-fcontent">
								<select name="typeId">
									<c:forEach var="type" items="${typeList}">
								 
										<option value="${ type.id}" <c:if test="${product.typeId ==  type.id}">selected="selected"</c:if> >${type.name}</option>
									</c:forEach>
								</select>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						商品名称:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="name" maxlength="100" size="100" value = "${product.name }"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						商品品牌:</td><td width="80%" class="pn-fcontent">
						<select name="brandId">
							<c:forEach var="brand" items="${brandList}">
								<option value="${ brand.id}" <c:if test="${product.brandId ==  brand.id}">selected="selected"</c:if> >${brand.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						商品毛重:</td><td width="80%" class="pn-fcontent">
						<input type="text" value="${product.weight }" class="required" name="weight" maxlength="10" />KG
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						材质:</td><td width="80%" class="pn-fcontent">
						<c:forEach var="feature" items="${featureList }">
							<input type="checkbox" value="${feature.id }" name="features" <c:if test="${fn:contains( product.features , feature.id )}"> checked="checked"</c:if>/>${feature.name }
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						颜色:</td><td width="80%" class="pn-fcontent">
						<c:forEach var="color" items="${colorList}">
							<input type="checkbox" value="${color.id }" name="colors" <c:if test="${fn:contains( product.colors , color.id )}"> checked="checked"</c:if>/>${color.name }
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						尺码:</td><td width="80%" class="pn-fcontent">
						<input type="checkbox" name="sizes" value="S" <c:if test="${fn:contains( product.sizes , 'S' )}"> checked="checked"</c:if>/>S
						<input type="checkbox" name="sizes" value="M" <c:if test="${fn:contains( product.sizes , 'M' )}"> checked="checked"</c:if>/>M
						<input type="checkbox" name="sizes" value="L" <c:if test="${fn:contains( product.sizes , 'L' )}"> checked="checked"</c:if>/>L
						<input type="checkbox" name="sizes" value="XL" <c:if test="${fn:contains( product.sizes , 'XL' )}"> checked="checked"</c:if>/>XL
						<input type="checkbox" name="sizes" value="XXL" <c:if test="${fn:contains( product.sizes , 'XXL' )}"> checked="checked"</c:if>/>XXL
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						状态:</td><td width="80%" class="pn-fcontent">
						<input type="checkbox" name="isNew" value="1" <c:if test=" ${true eq product.isNew}"  >checked="checked"</c:if>/>新品
						<input type="checkbox" name="isCommend" value="1" <c:if test=" ${true eq product.isNew}"  >checked="checked"</c:if>/>推荐
						<input type="checkbox" name="isHot" value="1" <c:if test="${true eq product.isNew}"  >checked="checked"</c:if>/>热卖
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						上传商品图片(90x150尺寸):</td>
						<td width="80%" class="pn-fcontent">
						注:该尺寸图片必须为90x150。
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h"></td>
						<td width="80%" class="pn-fcontent">
						<img width="100" height="100" id="product_url" src="${product.webSite}"/>
						<input type="hidden" name="img.url" id="product_path" />
						<input type="file" onchange="uploadpic()" name="pic"/>
					</td>
				</tr>
			</tbody>
			<tbody id="tab_2" style="display: none">
				<tr>
					<td >
						<textarea rows="10" cols="10" id="productdesc" name="description" >${product.description}</textarea>
					</td>
				</tr>
			</tbody>
			<tbody id="tab_3" style="display: none">
				<tr>
					<td >
						<textarea rows="15" cols="136" id="productList" name="packageList">${product.packageList}</textarea>
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td class="pn-fbutton" colspan="2">
						<input type="submit" class="submit" value="提交"/> &nbsp; <input type="reset" class="reset" value="重置"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>