<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
 @Author : Rusiru De Silva
--%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>
    <tiles:getAsString name="title"/>
  </title>
  <link href="resources/css/icon.css" rel="stylesheet">
  <link rel="stylesheet" href="resources/css/materialize.min.css">
  <script type="text/javascript" src="resources/js/config/jquery-3.1.1.min.js"></script>
  <script src="resources/js/config/materialize.min.js"></script>

</head>
<body>
<header>
  <tiles:insertAttribute name="header"/>
</header>
<section>
  <tiles:insertAttribute name="menu"/>
</section>
<section>
  <tiles:insertAttribute name="body"/>
</section>
<footer>
  <tiles:insertAttribute name="footer"/>
</footer>
</body>
</html>
