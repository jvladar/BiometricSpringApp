$(document).ready(
    function() {

        // SUBMIT FORM
        $("#searchForm").submit(function(event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {

            var formData = {
                id : $("#id").val(),
                docName : $("#docName").val(),
                data: $("#data").val(),
                size : $("#size").val(),
                docType : $("#docType").val()
            }
            // DO POST
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "searchData",
                data : JSON.stringify(formData),
                dataType : 'json',
                success : function(result) {
                    if (result.status == "success") {

                        $('#getResult ul').empty();
                        var custList = "";
                        $.each(result.data, function(i, datas) {
                            var user = "ID  = " + datas.id
                                + ", Name  = " + datas.docName
                                + ", Type  = " + datas.docType
                                + ", Size  = " + datas.size + "    ";
                            var b1 = document.createElement("button");
                            b1.textContent = " Download ";
                            b1.onclick = function() {location.href = '/downloadFile/'+ datas.id;};
                            $('#getResult .list-group').append(
                                user).append(b1).append("<br>")
                        });
                        console.log("Success: ", result);

                    } else {
                        $("#getResult").html("<strong>Error</strong>");
                        console.log("Fail: ", result);
                    }
                },
                error : function(e) {
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });

        }

    })