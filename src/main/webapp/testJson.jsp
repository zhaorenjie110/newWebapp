<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'testJson.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
		//将一个表单的数据返回成JSON对象
$.fn.serializeObject = function() {
  var o = {};
  var a = this.serializeArray();
  $.each(a, function() {
    if (o[this.name]) {
      if (!o[this.name].push) {
        o[this.name] = [ o[this.name] ];
      }
      o[this.name].push(this.value || '');
    } else {
      o[this.name] = this.value || '';
    }
  });
  return o;
};

$(document).ready(
    function() {
      jQuery.ajax( {
        type : 'GET',
        contentType : 'application/json',
        url : 'user/list',
        dataType : 'json',
        success : function(data) {
          if (data && data.success == "true") {
            $('#info').html("共" + data.total + "条数据。<br/>");
            $.each(data.data, function(i, item) {
              $('#info').append(
                  "编号：" + item.id + "，姓名：" + item.username
                      + "，年龄：" + item.age);
            });
          }
        },
        error : function() {
          alert("error")
        }
      });
      $("#submit").click(function() {
        var jsonuserinfo = $.toJSON($('#form').serializeObject());
        alert(jsonuserinfo);
        jQuery.ajax( {
          type : 'POST',
          contentType : 'application/json',
          url : 'user/add',
          data : jsonuserinfo,
          dataType : 'json',
          success : function(data) {
            alert("新增成功！");
          },
          error : function(data) {
            alert("error")
          }
        });
      });
    });
	</script>

</head>

<body>
	<form action="add" method="post" id="form">
		编号：<input type="text" name="id" /> 姓名：<input type="text"
			name="username" /> 年龄：<input type="text" name="age" /> <input
			type="button" value="提交" id="submie" />
	</form>
</body>
</html>
