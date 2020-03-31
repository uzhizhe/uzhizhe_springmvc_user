<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#click").click(function () {

                $(".aaa,.div1").css("background", "#ffbbcc");

            });
        });
    </script>

</head>
<body>
<a href="${pageContext.request.contextPath}/uzhizhe/users">User Info List</a>
</body>
</html>