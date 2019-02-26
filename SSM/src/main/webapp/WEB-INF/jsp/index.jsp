<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path=request.getContextPath();
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=path%>/js/easyUI/themes/black/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/js/easyUI/themes/icon.css">
<script type="text/javascript" src="<%=path%>/js/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/easyUI/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path%>/js/easyUI/jquery.form.js"></script>
<title></title>
<script type="text/javascript">
    $(function(){
    	getTable();
    })
    
    function getTable(){
    	$('#dg').datagrid({
    	    url:'<%=path%>/user/queryAll.do',
    	    fitColumns:true,
    	    autoRowHeight:false,
    	    rownumbers: true,
    	    pagination:true,//设置是否分页
		    pageList:[10,20,30,50],
		    pageSize:10,
    	    toolbar: '#tb',
    	    //[{"age":30,"birthday":1548000000000,"intid":0,"salary":2309.98,"sex":"0","userid":"1","username":"刘备"}]
    	    columns:[[
    			{field:'name',title:'用户名',width:100},
    			{field:'pwd',title:'密码',width:100},
    			{field:'age',title:'年龄',width:100},
    			{field:'birthdays',title:'生日',width:100},
    			{field:'sex',title:'性别',width:100,
    				formatter : function(value,row,index){
                        if(value=='1'){return '男'}  
                        else if(value=='0'){return '女'}                        
                      }
},
    			{field:'salary',title:'工资',width:100,align:'right'},
    			{field:'userid',title: '操作', width: 100,
	            	formatter: function(value,row,index){
	            		var str = "";
	            		str +="  <a href=\"javascript:deleteUser('"+value+"')\">删除</a>  ";
	            		str +="  <a href=\"javascript:toupdate('"+value+"')\">修改</a>  ";
	            		return str;
	    			}
				}
    			
    	    ]]
    	});
    }
    
    function add(){
    	//弹出模态表单框 
    	$('#dd').dialog('open');
    }
    //
    function submitForm(){
    	$('#form').form('submit',{
    		/* onSubmit:function(){
    			return $(this).form('enableValidation').form('validate');
    		},  */   
    	    success:function(){    
    	    	$.ajax({
    	    		type:"post",
    	    		url:"<%=path%>/user/usersave.do",
    	    		data:$('#form').serialize(),
    	    		dataType:"text",
    	    		success:function(res){
    	    			$('#dd').dialog('close');
    	    			$('#dg').datagrid('reload');
    	    		}
    	    	})
    	    }
    	});
    	
    }
    function dateformatter(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	}
    
    
    
    
</script>
</head>
<body>
    <!-- 按钮 -->
    <div id="tb">
		<a href="javaScript:add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a>
	</div>
	<!-- 列表 -->
    <table id="dg"></table>
    <!-- 弹出框 -->
    <div id="dd" class="easyui-dialog" title="用户维护" style="width:300px;height:300px;"
	    data-options="iconCls:'icon-save',resizable:true,modal:true" closed="true"> 
	    <!-- form 表单-->
	    <form id="form" method="post" style="margin-left: 20px;margin-top: 20px;">
		        <input type="hidden" id="userid" name="userid"/>
				<div style="height: 30px;">
				    <label for="name">用户:</label> <input id="name" name="name" class="easyui-textbox" required="true"/>
				</div>
				<div style="height: 30px;">
					<label for="sex">性别:</label> 
					<select id="sex" name="sex" class="easyui-combobox" panelHeight="auto" style="width: 160px;">
						<option  value="1">男</option>
						<option  value="0">女</option>
					</select>
				</div>
				<div style="height: 30px;">
					<label for="age">年龄:</label> <input id="age" name="age" class="easyui-textbox" required="true">
				</div>
				<div style="height: 30px;">
					<label for="pwd">密码:</label> <input id="pwd" name="pwd" class="easyui-textbox" required="false">
				</div>
				<div style="height: 30px;">
					<label for="birthdays">生日:</label> <input id="birthdays" name="birthdays" class="easyui-datebox" data-options="formatter:dateformatter">
				</div>
				<div style="height: 30px;">
					<label for="salary">工资:</label> <input id="salary" name="salary" class="easyui-numberbox" data-options="precision:'2'" >
				</div>
				
			</form>
			<div>
				<a href="javascript:submitForm()" class="easyui-linkbutton" iconCls="icon-save" >保存</a>
				<a href="javascript:dialogClose()" class="easyui-linkbutton" iconCls="icon-clear">取消</a>
			</div>
	</div>
   
   
</body>
</html>