<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>CMPE 275 BOOK SHARE</title>
</head>
<table>

        
            <tr>
                <td colspan="3"><h3>Buyer Feedbacks </h3><br/><label>${sellerId},  ${sellerName}</label></td>
                
                
                
            </tr>
            
            <c:forEach items="${str}" var="result">
            
           
            <tr>
                <td><label>BuyerID</label></td>
                <td><label>${result.buyerId.userId}</label></td>
                <td></td>
                
            </tr>
            
             <tr>
                <td><label>Comments</label></td>
                <td><label>${result.buyerComments}</label></td>
                <td></td>
                
            </tr>
            
             <tr>
                <td><label>Date</label></td>
                <td><label>${result.feedbacktime}</label></td>
                <td></td>
                
            </tr>
             </c:forEach>
        </table>
    
   
</body>
</html>