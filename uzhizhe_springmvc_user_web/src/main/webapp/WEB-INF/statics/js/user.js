$(document).ready(function () {
    $("#addUser").attr('href', '#').click(function () {
        $tr = $(this).next().children('tbody').children(':first');
        var index = $tr.children(':eq(0)').text();
        var uid = $tr.children(':eq(1)').text();

        var userName = $tr.children(':eq(2)').text();
        var age = $tr.children(':eq(3)').text();


        var html = "<tr><td>" + index + "</td><td>" + uid + "</td><td>" + userName + "</td><td>" + age + "</td></tr>";

        $("#userBody").append(html);

        console.log(Math.uuid(1));
    });

    $("#clickMe").click(function () {
        $.ajax({
            url: "/uzhizhe_user/uzhizhe/user",
            type: "get",
            contentType: "application/json;charset=utf-8",
            processData: true,
            data: {uid: "1222223"},
            dataType: "json",
            success: function (response) {
                //on_success(response);
                console.log(response.uid);
                console.log(response.userName);
                console.log(response.age);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                //showAlertInfo("error");
                console.log("Error");
            }
        });
    });
 
});