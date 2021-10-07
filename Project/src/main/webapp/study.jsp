<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
h1 {
	text-align: center;
}

.certificate {
	height: 100px;
	border: 1px solid black;
	vertical-align: middle;
	padding: 5px;
	font-family: corbel, sans-serif;
	font-size: 14px;
	margin: 10px;
}

table {
	width: 100%;
	height: 600px;
	border-left: 1px solid black;
	border-right: 1px solid black;
	border-top: 1px solid black;
	border-bottom: 1px solid black;
}

td {
	border-left: 1px solid black;
	border-right: 1px solid black;
	border-top: 1px solid black;
	border-bottom: 1px solid black;
	color: #495057;
	background-color: #e9ecef;
	border-color: #dee2e6;
}

th {
	height: 20px;
	border-left: 1px solid black;
	border-right: 1px solid black;
	border-top: 1px solid black;
	border-bottom: 1px solid black;
	color: #fff;
	background-color: #343a40;
	border-color: #454d55;
}
</style>
        <link rel="stylesheet" href="1cha.css">
</head>
<body>
    <h1><b>Study</b></h1>
    <table class="certificate" style="margin-top: 10px; margin-bottom: 30px;">
        <tr>
            <%for(int i =0, k = 0 ; i<4;i++){ %>
            
            	<td>
            		<%for(int j = 0; j<3; j++){ %>
            			<input type="radio" value="" name="certificate">�ڰ���<%=k+1 %><br>
            			<%k++; %>
            		<%} %>
            	</td>
            <%} %>
           
        </tr>
    </table>
    <div>
        <table>
            <tr>
                <th>����</th>
                <th>���͵��</th>
                <th>��������</th>
                <th>��������</th>
                <th>���͵� ����</th>
                <th>���</th>
                <th>����(��ȭ�����)</th>
                <th>�ð�(���νð� �ð�����)</th>
            </tr>
        <%for(int i = 0; i<12;i++){ %><!-- �ݺ����� �̿��Ͽ� ���̺��� ���� �Ͽ����ϴ�. ���߿� �����ͺ��̽����� �÷����� ������ �����ͼ� �ٿ����� ��. -->
            <tr>
                <td>����<%=i+1 %></td>
                <td>���͵��</td>
                <td>��������</td>
                <td>��������</td>
                <td>���͵� ����</td>
                <td>���</td>
                <td>����(��ȭ�����)</td>
                <td>�ð�(���νð� �ð�����)</td>
            </tr>
            <%} %>
           
        </table>
    </div>
</body>
</html>