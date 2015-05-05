<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>CMPE 275 BOOK SHARE</title>
</head>
<body>
    <form:form id="requestbook" action="requestbook" method="post" 
        commandName="requestbookdetails">
        <table>
            <tr>
                <td colspan="3"><h3>Please Enter the Details</h3></td>
            </tr>
            
            
            <tr>
                <td><label>Message</label></td>
                <td><form:input path="message"></form:input></td>
                <td><font color="red"><form:errors path="message"></form:errors></font></td>
            </tr>
           
            
            <tr>
                <td colspan="2" align="center"><input type="submit"
                    value="Enter" /></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
            </tr>
        </table>
    </form:form>
</body>
</html>