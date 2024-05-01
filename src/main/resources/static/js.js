function uploadimg(input) {
    if (window.FormData === undefined) {
        alert('В вашем браузере FormData не поддерживается')
    } else {
        var formData = new FormData();
        var id = input.getAttribute('value');
        formData.append('file', input.files[0]);
        formData.append('id', id);

        $.ajax({
            type: "POST",
            url: './api/image',
            cache: false,
            contentType: false,
            processData: false,
            data: formData,
            dataType: 'json',
            success: function (msg) {
                if (msg.error == '') {
                    $("#js-file").hide();
                    $('#result').html(msg.success);
                } else {
                    $('#result').html(msg.error);
                }
            }
        });
    }
};


function showimg(id) { //При клике по элементу с id выполнять...
    console.log("здесь")
    $.ajax({
        url: '/api/slider/' + id, //Путь к файлу, который нужно подгрузить
        type: 'GET',
        beforeSend: function () {
            $('#content').empty(); //Перед выполнением очищает содержимое блока с id=content
        },
        success: function (responce) {
            $('#content').append(responce); //Подгрузка внутрь блока с id=content
        },
        error: function () {
            alert('Error!');
        }
    });
}
$('#content')
    .dblclick(
        function () {
            document.getElementById("content").innerHTML = "";
        }
    );
//сохранение DF
$(document).ready(function () {
    $('#btn').click(
        function () {
            let dfVal = document.getElementById('df').value;
            let dfName = document.getElementById('dfName').value;
            //var type1 = document.querySelector('input[name="male"]:checked').value;
            let dfPeriod = document.getElementById('dfPeriod').value;
            let dfType = document.getElementById('dropDownListDf').value;
            console.log(dfType);
            let sendInfo = {
                df: dfVal,
                name: dfName,
                period: dfPeriod,
                dfType: dfType
            };
            sendAjaxForm(sendInfo, 'api/adddf');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});
$(document).ready(function () {
    $('#userbtn').click(
        function () {
            let loginVal = document.getElementById('ulogin').value;
            let userName = document.getElementById('ufio').value;
            let userPassword = document.getElementById('upassword').value;
            let sendInfo = {
                login: loginVal,
                name: userName,
                password: userPassword,
            };
            sendAjaxForm(sendInfo, 'api/adduser');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});
$(document).ready(function () {
    $('#dfFourAdd').click(
        function () {
            let typegtm = document.getElementById('typegtm').value;
            let oilfield = document.getElementById('oilfield').value;
            let kp = document.getElementById('kp').value;
            let well = document.getElementById('well').value;
            let wellPurpose = document.getElementById('wellPurpose').value;
            let type = document.getElementById('type').value;
            let enddate = document.getElementById('enddate').value;
            let comment = document.getElementById('comment').value;
            let sendInfo = {
                typeGTM: typegtm,
                oilField: oilfield,
                kp: kp,
                well: well,
                wellPurpose: wellPurpose,
                type: type,
                enddate: enddate,
                comment: comment
            };
            sendAjaxForm(sendInfo, 'api/addDf4');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});





function sendAjaxForm(sendInfo, url) {
    $.ajax({
        url: url, //url страницы
        type: "POST", //метод отправки
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(sendInfo),

        success: function (response) { //Данные отправлены успешно
            alert(response.massage);
            try {
                result = $.parseJSON(response);
            } catch (e) {
            }
        },
        error: function (response) {
            alert("Ошибка сервера");
        }
    });
}

function sayHi() {
    location.reload();
}
function updateDf(id) {
    // document.getElementById('content').style.z-index = '2';
    $('#content').css('visibility','visible');
    $('#contentTable').css('visibility','hidden');
    document.getElementById('updateDfId').value = id;

}
function addUser(id) {
    $('#content').css('visibility','hidden');
    $('#contentTable').css('visibility','visible');
    let dfId = document.getElementById('updateDfId').value;
    let sendInfo = {
        dfId: dfId,
        user: id,
    };
    sendAjaxForm(sendInfo, 'api/addusertodf');
    setTimeout(sayHi, 1000);

}
// function change(id) {
//     $.ajax({
//         url: 'api/change/' + id,
//         type: 'GET',
//         dataType: 'json',
//         success: function (data) {
//             document.getElementById('cowid').value = data.id;
//             document.getElementById('tag').value = data.tag;
//             document.getElementById('color').value = data.color;
//             document.getElementById('birthday').value = data.birthday;
//             if (data.type == 'Б') {
//                 document.getElementById('type1').checked = true;
//             } else {
//                 document.getElementById('type2').checked = true;
//             }
//         }
//     });
//
// }



$(function () {
    $('#traffic').on('click', '.morning', function () {
        var date = $(this).parent().find('.date').html();
        window.location.href = '/cow/search?date=' + date + '&type=morning';
    });
});
$(function () {
    $('#traffic').on('click', '.morningOut', function () {
        var date = $(this).parent().find('.date').html();
        window.location.href = '/cow/search?date=' + date + '&type=morningout';
    });
});
$(function () {
    $('#traffic').on('click', '.evening', function () {
        var date = $(this).parent().find('.date').html();
        window.location.href = '/cow/search?date=' + date + '&type=evening';
    });
});
$(function () {
    $('#traffic').on('click', '.eveningOut', function () {
        var date = $(this).parent().find('.date').html();
        window.location.href = '/cow/search?date=' + date + '&type=eveningout';
    });
});



