<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>CMPE 275 BOOK SHARE</title>
</head>
<body>
    <form:form id="homepage" action="homepage" method="post"
        commandName="homepageDetails">
        <table>
            <tr>
                <td colspan="3"><h3>Welcome 2 HomePage</h3></td>
            </tr>
            <tr>
                <td><label>ID</label></td>
                <td><form:input path="id"></form:input></td>
                <td><font color="red"><form:errors path="id"></form:errors></font></td>
            </tr>
            <tr>
                <td><label>First Name</label></td>
                <td><form:input path="firstname" ></form:input></td>
                <td><font color="red"><form:errors path="firstname"></form:errors></font></td>
            </tr>
            <tr>
                <td><label>Last Name</label></td>
                <td><form:input path="lastname" ></form:input></td>
               
            </tr>
            <tr>
                <td><label>Email</label></td>
                <td><form:input path="email" ></form:input></td>
                
            </tr>
            <tr>
                <td><label>Address</label></td>
                <td><form:input path="address" ></form:input></td>
                
            </tr>
            <tr>
                <td><label>Organization</label></td>
                <td><form:input path="organization" ></form:input></td>
               
            </tr>
            <tr>
                <td><label>About Myself</label></td>
                <td><form:input path="aboutMyself" ></form:input></td>
                
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit"
                    value="Create" /></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
            </tr>
        </table>
    </form:form>
</body>
</html>