<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">



<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/resources/dojo.css" />
	<link rel="stylesheet" href="webjars/dojo/1.10.1/dijit/themes/claro/claro.css" />
	<link rel="stylesheet" href="webjars/dojo/1.10.1/dojox/grid/resources/Grid.css" />
	<link rel="stylesheet" href="webjars/dojo/1.10.1/dojox/grid/resources/claroGrid.css" />
	
<title>Insert title here</title>
 <link rel="stylesheet" href="webjars/dojo/1.10.1/dijit/themes/claro/claro.css"/>
  <link rel="stylesheet" href="webjars/dojo/1.10.1/ dojox/grid/resources/claroGrid.css"/>
        <script>
            // configurar para agregar todos las librerias obligatorio
           dojoConfig = {
                parseOnLoad: true, isDebug: true,
                packages: [
                    // agregar la ruta del paquete
                    {name: 'modulos', location: location.href + 'modulos/'}
                ]
            }
        </script>
        <script src="webjars/dojo/1.10.1/dojo/dojo.js.uncompressed.js" ></script>
        <script>
            ///agregar solo las necesarias --no obligatorio
            require([
                'dojo/parser',
                'dijit/form/Button',
                'dijit/layout/BorderContainer',
                'dijit/layout/ContentPane',
                'dijit/layout/AccordionContainer',
                'dijit/layout/TabContainer',
                'dojox/validate/web',
                "dijit/TitlePane"
            ]);
        </script>
        

    </head>
    <body class="claro">

        <div id="main-container"  data-dojo-type="dijit/layout/BorderContainer">



 
            <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region: 'center'"  href="modulos/tabla.html">



           
       
    </div>
</body>
</html>