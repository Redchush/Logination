<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<fmt:setLocale value="${sessionScope.locale}" /><!-- locale = ru -->
<fmt:setBundle basename="resource.frontend.locale" var="loc" /><!-- locale_ru  -->

<fmt:message bundle="${loc}" key="locale.change_language.ru" var="ru" />
<fmt:message bundle="${loc}" key="locale.title" var="title" />

<fmt:message bundle="${loc}" key="locale.signIn.title" var="head"/>
<fmt:message bundle="${loc}" key="locale.signIn.email" var="email" />
<fmt:message bundle="${loc}" key="locale.signIn.email.notValid" var="eNotValid" />

<fmt:message bundle="${loc}" key="locale.signIn.login" var="login" />
<fmt:message bundle="${loc}" key="locale.signIn.login.notValid" var="lNotValid" />

<fmt:message bundle="${loc}" key="locale.signIn.password" var="password" />
<fmt:message bundle="${loc}" key="locale.signIn.password.notValid" var="pNotValid" />

<fmt:message bundle="${loc}" key="locale.signIn.confirm" var="confirm" />
<fmt:message bundle="${loc}" key="locale.signIn.confirm.notValid" var="notConfirm" />


<fmt:message bundle="${loc}" key="locale.signIn.link.toLogIn" var="toLogIn" />
<fmt:message bundle="${loc}" key="locale.signIn.notExist" var="notExist" />
<fmt:message bundle="${loc}" key="locale.signIn.submit" var="submit" />

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
    <div class="msg_box">  ${notExist} </div>
    <div class="inner">
      <div class="top_box">
          <div class="inline">
           <a  href="Controller?command=change_language&language=en&return=signIn.jsp" tabindex="1" class="opt">EN</a>
           <span>|</span>
           <a href="Controller?command=change_language&language=en&return=signIn.jsp" tabindex="2" class="opt">${ru}</a>
          </div>

        <div  class="back">
          <a href="index.jsp" tabindex="3">
            <div class="formicon icon_delete"></div>
          </a>
        </div>

      </div>

      <form  id="register_form" name = "regitster_form"
      novalidate="" data-remote="true" method="get" class="s-form register_form">
        <input type="hidden" name="command" value="registration" />

        <div class="title">${head}</div>
        <div class="s-field">
          <div class="text-wrapper">
            <input type="email" tabindex="3" autofocus="" 
              data-required="true" name="email" value=""
            required placeholder=${email}>

            <div class="formicon shifted icon_email"></div>
            <div class="s-error">${eNotValid}</div>
          </div>
        </div>

        <div class="s-field">
          <div class="text-wrapper">
            <input type="text" tabindex="4" autofocus="" name="login"  value=""
            required placeholder=${login}>
            <div class="formicon shifted icon_login"></div>
            <div class="s-error">${lNotValid}</div>
          </div>
        </div>

        <div class="s-field">
          <div class="text-wrapper">
            <input type="password" tabindex="5" name="password" data-required="true"
                   value="" required placeholder=${password}>
            <div class="formicon shifted icon_password"></div>
            <div class="s-error">${pNotValid}</div>
          </div>
        </div>

        <div class="s-field">
          <div class="text-wrapper">
            <input type="password" tabindex="6" autofocus="" name="confirm_pas" 
            value="" required  placeholder=${confirm}>
            <div class="formicon shifted icon_password"></div>
            <div class="s-error">${notConfirm}</div>
          </div>
        </div>

        <div class="s-buttons">
          <button tabindex="7" class="submit_btn" name="go" type="submit">${submit}
          </button>
        </div>

      </form>

      <div class="links">
        <a tabindex="8" class="remind" href="logIn.jsp">${toLogIn}</a>
      </div>
    </div>


  </div>
</body>

</html>