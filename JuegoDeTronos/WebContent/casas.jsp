<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestión Personajes</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<img src="got.jpg" alt="got logo" title="got logo" />
<h3><s:text name="casas" /></h3>
<a href="/JuegoDeTronos/principal">Principal</a> | <a href="/JuegoDeTronos/casas">Casas</a> |<a href="/JuegoDeTronos/nuevo">Nuevo</a> |<a href="/JuegoDeTronos/acercade">Acerda de</a> 
<s:form action="listarPorCasa">
			<s:select headerKey="" headerValue="Seleccionar casa"
				list="#{'Stark':'Stark', 'Lannister':'Lannister','Baratheon':'Baratheon','Targaryen':'Targaryen','Greyjoy':'Greyjoy','Arryn':'Arryn','Tully':'Tully'}" 
				key="casa"  />
		<s:submit key="submit" />
</s:form>

<s:if test="listaPersonajes.size() > 0">
		<s:iterator value="listaPersonajes" status="listaStatus">
		<div class="content">
				Nombre: <s:property value="nombre" /><br />
				Descripción: <s:property value="descripcion" /><br />
				Casa: <s:property value="casa" /><br />
				Sexo: <s:property value="sexo" /><br />
				<s:url id="deleteURL" action="eliminarPersonaje">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Eliminar</s:a>
				<br /><br />
		</s:iterator>
	</div>
</s:if>

<div><s:text name="greet" /></div>
</body>
</html>