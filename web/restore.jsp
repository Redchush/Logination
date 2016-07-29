<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<fmt:setLocale value="${sessionScope.locale}" /><!-- locale = ru -->
<fmt:setBundle basename="resource.frontend.locale" var="loc" /><!-- locale_ru  -->

<fmt:message bundle="${loc}" key="locale.change_language.ru" var="ru" />

<fmt:message bundle="${loc}" key="locale.title" var="title" />

<fmt:message bundle="${loc}" key="locale.restore.title" var="head" />
<fmt:message bundle="${loc}" key="locale.restore.email" var="email" />
<fmt:message bundle="${loc}" key="locale.restore.email.notValid" var="eNotValid" />

<fmt:message bundle="${loc}" key="locale.restore.link.toEnter" var="toEnter" />
<fmt:message bundle="${loc}" key="locale.restore.notExist" var="notExist" />
<fmt:message bundle="${loc}" key="locale.restore.submit" var="submit" />

<jsp:useBean id="errorMessage" class="java.lang.String" scope="request" />

<head>
    <title>
        ${title}
    </title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}resources/css/main.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}resources/js/libs/jquery-3.0.0.min.js"></script>
    <script src="${pageContext.request.contextPath}resources/js/form.js"></script>
</head>

<body>
<div class="showMask"></div>
<div class="outer">
    <div class="msg_box"> ${notExist}</div>
    <div class="inner">
        <div class="top_box">
            <div class="back">

                <a href="index.jsp">
                    <div class="formicon icon_delete"></div>
                </a>

            </div>
        </div>

        <form  id="restore_form" novalidate="" method="post" class="s-form restore_form">
            <input type="hidden" name="command" value="restoration"/>

            <div class="title inline">${head}</div>
            <div class="s-field">
                <div class="text-wrapper">
                    <input type="email" tabindex="1" autofocus="" name="email"  value=""
                           required placeholder=${email}>
                    <div class="formicon shifted icon_email"></div>
                    <div class="s-error">${eNotValid}</div>
                </div>
            </div>

            <div class="s-buttons">
                <button tabindex="2" class="submit_btn" name="go" type="submit">${submit}</button>
            </div>
            <div class="links">
                <a href="logIn.jsp"> ${toEnter} </a>
            </div>
        </form>
    </div>
   </div>
</body>

</html>