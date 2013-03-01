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
<h3><s:text name="nuevo" /></h3>
<a href="/JuegoDeTronos/principal">Principal</a> | <a href="/JuegoDeTronos/casas">Casas</a> |<a href="/JuegoDeTronos/nuevo">Nuevo</a> |<a href="/JuegoDeTronos/acercade">Acerda de</a> 
<s:form action="guardarOActualizarPersonaje">
		<s:hidden name="id" />
		<s:textfield key="nombre" />
		<s:textarea key="descripcion" />
			<s:select headerKey="0" headerValue="Seleccionar sexo"
				list="#{'0':'Hombre', '1':'Mujer'}" 
				key="sexo"  />
			<s:select headerKey="" headerValue="Seleccionar casa"
				list="#{'Stark':'Stark', 'Lannister':'Lannister','Baratheon':'Baratheon','Targaryen':'Targaryen','Greyjoy':'Greyjoy','Arryn':'Arryn','Tully':'Tully'}" 
				key="casa"  />

		<s:submit key="submit" />
</s:form>
<div><s:text name="greet" /></div>
</body>
</html>