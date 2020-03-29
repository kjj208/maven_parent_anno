<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/hello.js"></script>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <script>

        if (typeof (jQuery) == "undefined") {
            alert("jQuery is not imported");
        } else {
            alert("jQuery is imported");
        }
        // 页面加载，绑定单击事件
        $(function () {
            $("#btn").on("click", function () {
                // 发送ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url: "user/testAjax",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"username":"hehe","password":"123","age":30}',
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        // data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });
        /*
          测试失败：
          $(function () {
                  $("#btn").on("click", function () {
                      // 发送ajax请求
                      var paramObj = {
                          "username": "hh",
                          "password": "123",
                          "age": 12
                      };
                      var loadURL = "user/testAjax";
                      $.post(loadURL, paramObj, function (data) {
                          alert(data);
                          alert(data.username);
                          alert(data.password);
                          alert(data.age);

                      }, "json");
                  });
              });*/
    </script>
</head>
<body>

<p>我是什么颜色？ ${account.id}</p>


${account.name}
${account.money}

<input type="button" id="btn" value="发送ajax的请求">
</body>
</html>
