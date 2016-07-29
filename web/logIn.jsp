<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.locale}" /><!-- locale = ru -->
<fmt:setBundle basename="resource.frontend.locale" var="loc" /><!-- locale_ru  -->

<fmt:message bundle="${loc}" key="locale.change_language.ru" var="ru" />
<fmt:message bundle="${loc}" key="locale.title" var="title" />

<fmt:message bundle="${loc}" key="locale.logIn.enter" var="head"/>
<fmt:message bundle="${loc}" key="locale.logIn.email" var="email" />
<fmt:message bundle="${loc}" key="locale.logIn.email.notValid" var="eNotValid" />
<fmt:message bundle="${loc}" key="locale.logIn.password" var="password" />
<fmt:message bundle="${loc}" key="locale.logIn.password.notValid" var="pNotValid" />
<fmt:message bundle="${loc}" key="locale.logIn.link.signUp" var="signUp" />
<fmt:message bundle="${loc}" key="locale.logIn.link.restore" var="restore" />
<fmt:message bundle="${loc}" key="locale.logIn.notExist" var="notExist" />
<fmt:message bundle="${loc}" key="locale.logIn.submit" var="submit" />

<jsp:useBean id="errorMessage" class="java.lang.String" scope="request" />


<!DOCTYPE html>
<html>
<head>
  <title>
    ${title}
  </title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath}resources/css/main.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}resources/js/libs/jquery-3.0.0.min.js"></script>
  <script src="${pageContext.request.contextPath}resources/js/form.js"></script>

  <style>
    <%
    Object isWrong = request.getAttribute("wrong");
    if ((isWrong != null) && (isWrong.equals("true"))){
      out.print(".msg_box{\n display: block \n}");
    }
     %>
  </style>

</head>

<body>
<div class="showMask"></div>
<div class="outer">
  <div class="msg_box"> ${notExist}</div>

  <div class="inner">
    <div class="top_box">

      <div class="inline">
        <a href="Controller?command=change_language&language=en&return=logIn.jsp" class="opt">EN</a>
        <span>|</span>
        <a href="Controller?command=change_language&language=ru&return=logIn.jsp" class="opt">${ru}</a>
      </div>

      <div class="back">
        <a href="index.jsp">
          <div class="formicon icon_delete"></div>
        </a>
      </div>

    </div>


    <form id="login_form" name= "login_form"
          action = "logIn.jsp"
          data-remote="true" method="get"  class="s-form login_form">
      <input type="hidden" name="command" value="logination" />

      <div class="title inline">${head}</div>

      <div class="s-field">
        <div class="text-wrapper">
          <input type="email" tabindex="1" autofocus="" name="email"  value=""
                 required placeholder=${email}>
          <div class="formicon shifted icon_email"></div>
          <div class="s-error">${eNotValid}</div>
        </div>
      </div>

      <div class="s-field">
        <div class="text-wrapper">
          <input type="password" tabindex="2" name="password"
                 value="" required placeholder=${password}>
          <div class="formicon shifted icon_password"></div>
          <div class="s-error">${pNotValid}</div>
        </div>
      </div>

      <div class="s-buttons">
        <button tabindex="3" class="submit_btn disabled=" type="submit">${submit}</button>
      </div>
    </form>

    <div class="linksContainer">
      <div class="links">
        <a class="remind" href="restore.jsp">${restore}</a>
      </div>
      <div class="links">
        <a class="remind" href="signUp.jsp">${signUp}</a>
      </div>
    </div>

  </div>
</div>
</body>
</html>