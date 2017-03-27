
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cupcake Heaven</title>
    </head>
    <body>
        <h1>Best cupcakes ever!! </h1>
        <ul>
            <%=request.getAttribute("bottom")%>

            <%=request.getAttribute("toppings")%>

            <form action="/Main" method="post">
                <input type="text" name="bottom" value=""/>
                <input type="submit" value=""/>  
                
                <input type="text" name="toppings" value=""/>
                <input type="submit" value=""/>  
            </form>
        </ul>
    </body>
</html>
