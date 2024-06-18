// function uploadimg(input) {
//     if (window.FormData === undefined) {
//         alert('В вашем браузере FormData не поддерживается')
//     } else {
//         var formData = new FormData();
//         var id = input.getAttribute('value');
//         formData.append('file', input.files[0]);
//         formData.append('id', id);
//
//         $.ajax({
//             type: "POST",
//             url: './api/image',
//             cache: false,
//             contentType: false,
//             processData: false,
//             data: formData,
//             dataType: 'json',
//             success: function (msg) {
//                 if (msg.error == '') {
//                     $("#js-file").hide();
//                     $('#result').html(msg.success);
//                 } else {
//                     $('#result').html(msg.error);
//                 }
//             }
//         });
//     }
// };
//
//
// function showimg(id) { //При клике по элементу с id выполнять...
//     console.log("здесь")
//     $.ajax({
//         url: '/api/slider/' + id, //Путь к файлу, который нужно подгрузить
//         type: 'GET',
//         beforeSend: function () {
//             $('#content').empty(); //Перед выполнением очищает содержимое блока с id=content
//         },
//         success: function (responce) {
//             $('#content').append(responce); //Подгрузка внутрь блока с id=content
//         },
//         error: function () {
//             alert('Error!');
//         }
//     });
// }
// $('#content')
//     .dblclick(
//         function () {
//             document.getElementById("content").innerHTML = "";
//         }
//     );
//сохранение DF
// function validateInput(input) {
//     let value = parseFloat(input.value);
//     if (value.toFixed(3) != input.value) {
//         input.value = value.toFixed(3);
//     }
// }
$(document).ready(function () {
    $('#mvzAdd').click(
        function () {
            let sendInfo = {
                id: document.getElementById('mvzId').value,
                name: document.getElementById('mvzName').value
            };
            sendAjaxForm(sendInfo, '/api/addUpdateMvz');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});

$(document).ready(function () {
    $('#btn').click(
        function () {
            let dfVal = document.getElementById('df').value;
            let dfName = document.getElementById('dfName').value;
            //var type1 = document.querySelector('input[name="male"]:checked').value;
            let dfPeriod = document.getElementById('dfPeriod').value;
            let dfType = document.getElementById('dropDownListDf').value;
            let sendInfo = {
                df: dfVal,
                name: dfName,
                period: dfPeriod,
                dfType: dfType
            };
            sendAjaxForm(sendInfo, '/api/adddf');
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
            sendAjaxForm(sendInfo, '/api/adduser');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});
$(document).ready(function () {
    $('#dfFourAdd').click(
        function () {
            let sendInfo = {
                typeGTM: document.getElementById('typegtm').value,
                oilField: document.getElementById('oilfield').value,
                kp: document.getElementById('kp').value,
                well: document.getElementById('well').value,
                wellPurpose: document.getElementById('wellPurpose').value,
                type: document.getElementById('type').value,
                enddate: document.getElementById('enddate').value,
                upWater: document.getElementById('upWater').value,
                chart: document.getElementById('chart').value,
                duration: document.getElementById('duration').value,
                comment: document.getElementById('comment').value,
                dfid:  document.getElementById('dfId').value
            };
            sendAjaxForm(sendInfo, '/api/addDf4');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});
$(document).ready(function () {
    $('#dfFiveAdd').click(
        function () {
            let sendInfo = {
                dfId: document.getElementById('dfId').value,
                oilField: document.getElementById('oilfield').value,
                expWater: document.getElementById('expWater').value,
                medWater: document.getElementById('medWater').value,
                expPump: document.getElementById('expPump').value,
                medPump: document.getElementById('medPump').value,
                expHydro: document.getElementById('expHydro').value,
                medHydro: document.getElementById('medHydro').value,
                datePeriod: document.getElementById('datePeriod').value,
                comment: document.getElementById('comment').value
            };
            sendAjaxForm(sendInfo, '/api/addDf5');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});
$(document).ready(function () {
    $('#df8AddNew').click(
        function () {
            let sendInfo = {
                dfId: document.getElementById('dfId').value,
                name: document.getElementById('name').value,
                typeWater: document.getElementById('typeWater').value,
                oilfield: document.getElementById('oilfield').value,
                well: document.getElementById('well').value,
            };
            sendAjaxForm(sendInfo, '/api/addDf8');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});
$(document).ready(function () {
    $('#df14Add').click(
        function () {
            let sendInfo = {
                dfId: document.getElementById('dfId').value,
                mvz: document.getElementById('mvz').value,
                oilfield: document.getElementById('oilfield').value,
                well: document.getElementById('well').value,
                usedTon: document.getElementById('usedTon').value,
                coefLost: document.getElementById('coefLost').value,
                procLostPlan: document.getElementById('procLostPlan').value,
                procLostFact: document.getElementById('procLostFact').value,
                period: document.getElementById('datePeriod').value,
                comment: document.getElementById('comment').value
            };
            sendAjaxForm(sendInfo, '/api/addDf14');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});
$(document).ready(function () {
    $('#df17Add').click(
        function () {
            let sendInfo = {
                dfId: document.getElementById('dfId').value,
                mvz: document.getElementById('mvz').value,
                typeOil: document.getElementById('typeOil').value,
                affiliation: document.getElementById('affiliation').value,
                oilName: document.getElementById('oilName').value,
                date: document.getElementById('datePeriod').value,
                amt: document.getElementById('amt').value,
                comment: document.getElementById('comment').value
            };
            sendAjaxForm(sendInfo, '/api/addDf17');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});
$(document).ready(function () {
    $('#df24Add').click(
        function () {
            let sendInfo = {
                dfId: document.getElementById('dfId').value,
                mvz: document.getElementById('mvz').value,
                name: document.getElementById('name').value,
                comment: document.getElementById('comment').value
            };
            sendAjaxForm(sendInfo, '/api/addDf24');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});
$(document).ready(function () {
    $('#df26Add').click(
        function () {
            let sendInfo = {
                dfId: document.getElementById('dfId').value,
                mvz: document.getElementById('mvz').value,
                type: document.getElementById('type').value,
                nomenclature: document.getElementById('nomenclature').value,
                typeCar: document.getElementById('typeCar').value,
                valueCar: document.getElementById('valueCar').value,
                typeWork: document.getElementById('typeWork').value,
                purpose: document.getElementById('purpose').value,
                startPoint: document.getElementById('startPoint').value,
                endPoint: document.getElementById('endPoint').value,
                comment: document.getElementById('comment').value
            };
            sendAjaxForm(sendInfo, '/api/addDf26');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});
$(document).ready(function () {
    $('#df27Add').click(
        function () {
            let sendInfo = {
                dfId: document.getElementById('dfId').value,
                mvz: document.getElementById('mvz').value,
                type: document.getElementById('type').value,
                vid: document.getElementById('vid').value,
                nameChar: document.getElementById('nameChar').value,
                valueChar: document.getElementById('valueChar').value,
                specialChar: document.getElementById('specialChar').value,
                purpose: document.getElementById('purpose').value
            };
            sendAjaxForm(sendInfo, '/api/addDf27');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});
$(document).ready(function () {
    $('#df31Add').click(
        function () {
            let sendInfo = {
                dfId: document.getElementById('dfId').value,
                mvz: document.getElementById('mvz').value,
                target: document.getElementById('target').value,
                nomenclature: document.getElementById('nomenclature').value,
                affiliation: document.getElementById('affiliation').value,
                stock: document.getElementById('stock').value,
                comment: document.getElementById('comment').value
            };
            sendAjaxForm(sendInfo, '/api/addDf31');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});

$(document).ready(function () {
    $('#df32Add').click(
        function () {
            let sendInfo = {
                dfId: document.getElementById('dfId').value,
                mvz: document.getElementById('mvz').value,
                objectB: document.getElementById('objectB').value,
                dateKo: document.getElementById('dateKo').value,
                typeGas: document.getElementById('typeGas').value,
                date: document.getElementById('datePeriod').value,
                amt: document.getElementById('amt').value,
                comment: document.getElementById('comment').value
            };
            sendAjaxForm(sendInfo, '/api/addDf32');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});
$(document).ready(function () {
    $('#df34Add').click(
        function () {
            let sendInfo = {
                dfId: document.getElementById('dfId').value,
                mvz: document.getElementById('mvz').value,
                bosom: document.getElementById('bosom').value,
                type: document.getElementById('type').value,
                target: document.getElementById('target').value,
                place: document.getElementById('place').value,
                mark: document.getElementById('mark').value,
                amt: document.getElementById('amt').value,
                period: document.getElementById('datePeriod').value
            };
            sendAjaxForm(sendInfo, '/api/addDf34');
            setTimeout(sayHi, 1000);
            return false;
        }
    );
});
$(document).ready(function () {
    $('#df36Add').click(
        function () {
            let sendInfo = {
                dfId: document.getElementById('dfId').value,
                mvz: document.getElementById('mvz').value,
                name: document.getElementById('name').value,
                unit: document.getElementById('unit').value,
            };
            sendAjaxForm(sendInfo, '/api/addDf36');
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

function sendAjaxFormWithout(sendInfo, url) {
    $.ajax({
        url: url, //url страницы
        type: "POST", //метод отправки
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(sendInfo),

        success: function (response) { //Данные отправлены успешно
            if (response.massage === "") {
                showPopup('Ok');
            }else{
                showPopup(response.massage);
            }
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
    sendAjaxForm(sendInfo, '/api/addusertodf');
    setTimeout(sayHi, 1000);

}
function deleteDf(id) {
    let dfParentId = document.getElementById('dfId').value;
    let sendInfo = {
        dfParent: dfParentId,
        dfDel: id
    };
    sendAjaxForm(sendInfo, '/api/deleteDf');
    setTimeout(sayHi, 1000);
}
function handleInputChange8(event) {
    let val = event.target.value.replace(/,/, '.');
    let cId = event.target.id;
    let sendInfo = {
        values: val,
        parent: cId
    };
    sendAjaxFormWithout(sendInfo, '/api/adddf8monthval');
}
function handleInputChange24(event) {
    let val = event.target.value;
    let cId = event.target.id;
    let sendInfo = {
        values: val,
        parent: cId
    };
    sendAjaxFormWithout(sendInfo, '/api/adddf24monthval');
}
function handleInputChange26(event) {
    let val = event.target.value;
    let cId = event.target.id;
    let sendInfo = {
        values: val,
        parent: cId
    };
    sendAjaxFormWithout(sendInfo, '/api/adddf26monthval');
}
function handleInputChange(event) {
    let val = event.target.value;
    let cId = event.target.id;
    let sendInfo = {
        values: val,
        parent: cId
    };
    sendAjaxFormWithout(sendInfo, '/api/adddf27monthval');
}

function handleInputChange31(event) {
    let val = event.target.value;
    let cId = event.target.id;
    let sendInfo = {
        values: val,
        parent: cId
    };
    sendAjaxFormWithout(sendInfo, '/api/adddf31monthval');
}
function handleInputChange36(event) {
    let val = event.target.value;
    let cId = event.target.id;
    let sendInfo = {
        values: val,
        parent: cId
    };
    sendAjaxFormWithout(sendInfo, '/api/adddf36monthval');
}



function showPopup(text) {
    document.getElementById('popup-overlay').style.display = 'block';
    document.getElementById('popup').innerHTML = '';
    $('#popup').append(text);
    setTimeout(function () {document.getElementById('popup-overlay').style.display = 'none';
    }, 1000);

}


// const selectElement = document.querySelector(".cell");
//const result = document.querySelector(".result");

// selectElement.addEventListener('change', (event) => {
//    // result.textContent = `You like ${event.target.value}`;
//     //let trId = $(this).parent().find('.tr').html();
//     console.log(event.target.value + " " + event.target.id);
// });

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



