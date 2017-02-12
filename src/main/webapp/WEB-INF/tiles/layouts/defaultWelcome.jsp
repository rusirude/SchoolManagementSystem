<%--
 @Author : Rusiru De Silva
--%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>
      <tiles:getAsString name="title"/>
    </title>
    <link href="resources/css/icon.css" rel="stylesheet">
    <%--<link rel="stylesheet" href="resources/css/materialize.min.css">--%>
    <link rel="stylesheet" href="resources/css/material.min.css">
    <link rel="stylesheet" href="resources/css/dataTables.material.min.css">
    <script type="text/javascript" src="resources/js/config/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="resources/js/config/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="resources/js/config/material.min.js"></script>
    <script type="text/javascript" src="resources/js/config/dataTables.material.min.js"></script>
    <script type="text/javascript" src="resources/js/config/template.js"></script>
    <%--<script type="text/javascript" src="resources/js/config/materialize.min.js"></script>--%>

  </head>
  <body>
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
      <header class="mdl-layout__header">
        <div class="mdl-layout__header-row">
          <span class="mdl-layout-title">School Management System</span>
          <!-- Add spacer, to align navigation to the right -->
          <div class="mdl-layout-spacer"></div>
          <tiles:insertAttribute name="header"/>
        </div>
      </header>
      <main class="mdl-layout__content">
        <div class="page-content">
          <tiles:insertAttribute name="body"/>
        </div>
      </main>
      <footer class="mdl-mini-footer">
        <tiles:insertAttribute name="footer"/>
      </footer>
    </div>
  </body>
</html>
