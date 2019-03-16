<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%--<html lang="en" xmlns:th="http://www.thymeleaf.org/">--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%--<title th:text="${title}">Glucose Monitor</title>--%>
    <title>Glucose Monitor</title>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="https:www.gstatic.com/charts/loader.js"></script>

    <script>
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                dataType: "json",
                contentType: "application/json",
                url: '${pageContext.request.contextPath}/api/chart/findall',
                success: function (result) {
                    google.charts.load('current', {
                        'packages' : ['line']
                    });
                    google.charts.setOnLoadCallback(function () {
                        drawChart(result);
                    });
                }
            });

            function drawChart(result) {

                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Name');
                data.addColumn('number', 'Quantity');
               /* data.addColumn('string', 'Glucose');
                data.addColumn('number', 'Quantity');*/
                var dataArray = [];
                $.each(result, function (i, obj) {
                    dataArray.push([obj.name, obj.quantity]);
                    //dataArray.push([obj.glucose, obj.quantity]);
                });
                data.addRows(dataArray);

                var options = {
                    title: 'Line Chart: Placeholder',
                    width: 900,
                    height: 500
                };
                var chart = new google.charts.Line(document.getElementById('linechart_material'));
                chart.draw(data, google.charts.Line.convertOptions(options));
            }
        });
    </script>

</head>
<body>

<table class="columns">
    <tr>
        <td><div id="linechart_material" style="border: 1px solid #ccc"></div></td>
    </tr>
</table>

</body>
</html>