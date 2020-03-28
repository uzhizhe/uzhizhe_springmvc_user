<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
    <script type="text/javascript" >
        $(function(){
            $("#click").click(function(){

                $(".aaa,.div1").css("background", "#ffbbcc");

            });
        });
    </script>

</head>
<body>
<p id="click">Click Me</p>
<p id="1" class="aaa abc">111</p><br/><br/>
<div id="2" class="aaa">222
    <p class="div1">888</p>
</div><br/><br/>
<p id="3" class="aaa">333</p><br/><br/>
<p id="4" class="ddd">444</p><br/><br/>

</body>
</html>