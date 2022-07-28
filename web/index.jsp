<%-- 
    Document   : receive
    Created on : Jul 28, 2022, 12:34:11 PM
    Author     : Thiwanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BCD Green House</title>

        <link rel="stylesheet" href="style.css"/>

    </head>
    <body onload="run()">
    <center>
        <table class="content-table">
            <thead>
                <tr>
                    <th>Temperature</th>
                    <th>Humidity</th>
                    <th>Moisture</th>
                    <th>Light</th>
                    <th>Time Stamp</th>
                </tr>
            </thead>
            <tbody id="tbody">
            </tbody>
        </table>
    </center>

    <script src="apexcharts.min.js"></script>
    <script src="Chart.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

    <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
<script>
        function run() {
            $.ajax({
                url: "receive",
                dataType: 'json',
                success: function (data) {
                    console.log(data);
                }
            });
        }
        var f1 = function load() {
            $.ajax({
                url: "get",
                dataType: 'JSON',
                success: function (data) {
                    let val = '';
                    $.each(data, function (k, v) {
                        val +=' <tr>';
                        val += '<td>'+v.Temperature+'</td> ';
                        val += '<td>'+v.Humidity+'</td>';
                        val += '<td>'+v.Moisture+'</td>';
                        val += '<td>'+v.Light+'</td>';
                        val += '<td>'+v.Time+'</td>';
                        val += '</tr>';
                        
                                
                                
                                
                        
                                
                    });
                    $('#tbody').html(val);
                }
            });
        };
        setInterval(f1, 5000);

</script>
