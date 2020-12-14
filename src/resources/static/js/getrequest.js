GET: $(document).ready(
    function() {

        // GET REQUEST
        $("#getALlDatas").click(function(event) {
            event.preventDefault();
            ajaxGet();
        });

        // DO GET
        function ajaxGet() {
            $.ajax({
                type : "GET",
                url : "getFiles",
                success : function(result) {
                    if (result.status == "success") {
                        $('#getResultDiv ul').empty();
                        var custList = "";
                        $.each(result.data, function(i, datas) {
                            var user = "ID  = " + datas.id
                                + ", Name  = " + datas.docName
                                + ", Type  = " + datas.docType
                                + ", Request  = " + datas.request
                                + ", Size  = " + datas.size + "    ";
                            var b1 = document.createElement("button");
                            b1.textContent = "Download";
                            b1.onclick = function() {location.href = '/downloadFile/'+datas.id;};
                            $('#getResultDiv .list-group').append(
                                user).append(b1).append("<br>")
                        });
                        console.log("Success: ", result);

                    } else {
                        $("#getResultDiv").html("<strong>Error</strong>");
                        console.log("Fail: ", result);
                    }
                },
                error : function(e) {
                    $("#getResultDiv").html("<strong>Error</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })