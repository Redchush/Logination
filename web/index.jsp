<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

<head>
  <title>

    Ответы на любые вопросы LIKE_IT
  </title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet"
    href="${pageContext.request.contextPath}resources/css/main.css">

        <%--href="<c:url value="${pageContext.request.contextPath}resources/css/main.css"/>"--%>

  <script type="text/javascript" src="${pageContext.request.contextPath}resources/js/libs/jquery-3.0.0.min.js"></script>
  <script src="${pageContext.request.contextPath}resources/js/main.js"></script>
</head>

<body>
<%!
  private static final String c = "${pageContext.request.contextPath}";
%><% out.print(c); %>

<fmt:setLocale value="${sessionScope.locale}" /><!-- locale = ru -->
<fmt:setBundle basename="resource.locale" var="loc" /><!-- locale_ru  -->

<fmt:message bundle="${loc}" key="locale.change_language.ru" var="ru" />
<fmt:message bundle="${loc}" key="locale.index.login" var="login" />

<jsp:useBean id="errorMessage" class="java.lang.String" scope="request" />

<header class="header">
  <div class="headerContainer">
    <div class="col1">
      <div class="logo">
        <span> LikeIT </span>
      </div>
    </div>

    <div class="col3">
      <ul class="rightHeader">
        <li class="bigScreen content">
          <div class="btn btn-log leftRounded" >
            <a href="${pageContext.request.contextPath}/logIn.jsp">Войти</a>
          </div>
        </li>

        <li class="bigScreen content rightRounded dropdown ">
          <div class="btn btn-log rightRounded" >
            <a href="${pageContext.request.contextPath}signUp.jsp"><span>Регистрация</span></a>
          </div>
        </li>

        <li class="smallScreen content leftRounded dropdown">
          <bottom class="icon btn leftRounded">
            <img class="icon" src="${pageContext.request.contextPath}resources/img/Search-48.png">
          </bottom>
          <div class="dropdown-content wide">
            <div class="searchForm">
              <form name="search" method="GET" action="/search/">
                <input class="field" placeholder="Поиск" autocomplete="off">
                <img class="seachicon" alt="search" src="${pageContext.request.contextPath}resources/img/Search-48.png">
              </form>
            </div>
          </div>
        </li>

        <li class="smallScreen content rightRounded dropdown">
          <bottom class="icon btn drop rightRounded">
            <img class="icon" src="${pageContext.request.contextPath}resources/img/Menu-48.png">
          </bottom>
          <div class="dropdown-content">
            <ul class="rightHeader">
              <li class="content leftRounded">
                <div class="btn btn-log leftRounded">
                  <a href="${pageContext.request.contextPath}logIn.jsp">Войти</a>
                </div>
              </li>

              <li class="content rightRounded">
                <div class="btn btn-log rightRounded" >
                  <a href="${pageContext.request.contextPath}signUp.jsp"><span>Регистрация</span></a>
                </div>
              </li>

            </ul>
          </div>

        </li>

        <li class="mediumScreen bothRounded dropdown">
          <bottom class="icon btn drop bothRounded">
            <img class="icon" src="${pageContext.request.contextPath}resources/img/Menu-48.png">
          </bottom>
          <div class="dropdown-content">
            <ul class="rightHeader">
              <li class="content leftRounded">
                <div class="btn btn-log leftRounded" id="logIn">
                  <a href="${pageContext.request.contextPath}logIn.jsp">Войти</a>
                </div>
              </li>

              <li class="content rightRounded">
                <div class="btn btn-log rightRounded" id="signIn">
                  <a href="${pageContext.request.contextPath}signUp.jsp"><span>Регистрация</span></a>
                </div>
              </li>

            </ul>
          </div>
        </li>
        <li class="clearfix"></li>
      </ul>
    </div>
    <div class="col2">
      <div class="searchForm">
        <form name="search" method="GET" action="/search/">
          <input class="field" placeholder="Поиск" autocomplete="off">
          <img class="seachicon" alt="search" src="${pageContext.request.contextPath}resources/img/Search-48.png">
        </form>
      </div>
    </div>
    <div class="clearfix"></div>
  </div>
</header>



<section class="content-wrapper">
  <div class="center">
    <div class="title">
      <h1> Все вопросы </h1>
    </div>
    <div class="subheader">
      <div id="tabs" class="tabs">

        <a  class="sort-btn" data-sort="down"> <!-- href="?sort=creation" -->
          <span>создание</span>
          <div class="icon formicon icon_down"></div>
        </a>

        <a  class="sort-btn" data-sort="down"> <!-- href="?sort=update" -->
          <span>обновление</span>
          <div class="icon formicon icon_down"></div>
        </a>
        <a class="sort-btn" data-sort="down"><!--  href="?sort=answers"  -->
          <span>ответы</span>
          <div class="icon formicon icon_down" ></div>
        </a>
        <a  href="?sort=see"  class="sort-btn" data-sort="down"> <!-- href="?sort=see" -->
          <span>просмотры</span>
          <div class="icon formicon icon_down"></div>
        </a>

      </div>
    </div>
    <div class="column_main column">
      <main class="main">
        <div class="page_body">
          <ul class="content_list">
            <li class="content-list_item">
              <div class="question_box">
                <div class="question_content">
                  <nav class="question_tags">
                    <ul>
                      <li class="tokenWrapper">
                        <div class="tokenContainer">
                          <span>java</span>
                        </div>

                      </li>
                      <li class="tokenWrapper">
                        <div class="tokenContainer">
                          <span data-element-type="227">java</span>
                        </div>

                      </li>
                    </ul>
                  </nav>
                  <h2 class="question_title">
                    <a class="question_title-link" href="#">Java наше все</a>
                  </h2>
                </div>

                <div class="question_info">
                  <div class="question_info_box">
                    <div class="info">
                      <span class="counter"> 3 </span>
                    </div>
                    <div class="answers info">ответов</div>
                  </div>
                </div>
                <ul class="question_attrs">
                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="${pageContext.request.contextPath}resources/img/Star%20Filled-48.png">
                    <span class="followers_count" title="Количество подписавшихся на вопрос">23</span>
                  </li>
                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="${pageContext.request.contextPath}resources/img/Visible-48.png">
                    <span class="views-count"> 1074 </span>
                  </li>

                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="${pageContext.request.contextPath}resources/img/Available%20Updates-52.png">
                    <time class="created_date" title="Дата публикации: 28 июня 2016, в 09:38"  datetime="2016-06-28 09:38:36"> 3 часа назад</time>
                  </li>

                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="${pageContext.request.contextPath}resources/img/Date%20To-52.png">
                    <time class="created_date" title="Дата публикации: 28 июня 2016, в 09:38"  datetime="2016-06-28 09:38:36">2016-06-28 09:38 </time>
                  </li>
                </ul>
                <div class="clearfix"></div>
              </div>
            </li>
            <li class="content-list_item">
              <div class="question_box">
                <div class="question_content">
                  <nav class="question_tags">
                    <ul>
                      <li class="tokenWrapper">

                        <div class="tokenContainer">
                          <span>java</span>
                        </div>

                      </li>
                      <li class="tokenWrapper">

                        <div class="tokenContainer">
                          <span data-element-type="227">java</span>
                        </div>

                      </li>
                    </ul>
                  </nav>
                  <h2 class="question_title">
                    <a class="question_title-link" href="#">Java наше все</a>
                  </h2>

                </div>

                <div class="question_info">
                  <div class="question_info_box">
                    <div class="info">
                      <span class="counter"> 3 </span>
                    </div>
                    <div class="answers info">ответов</div>
                  </div>
                </div>
                <ul class="question_attrs">
                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="${pageContext.request.contextPath}resources/img/Star%20Filled-48.png">
                    <span class="followers_count" title="Количество подписавшихся на вопрос">23</span>
                  </li>
                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="${pageContext.request.contextPath}resources/img/Visible-48.png">
                    <span class="views-count"> 1074 </span>
                  </li>

                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="${pageContext.request.contextPath}resources/img/Available%20Updates-52.png">
                    <time class="created_date" title="Дата публикации: 28 июня 2016, в 09:38"  datetime="2016-06-28 09:38:36"> 3 часа назад</time>
                  </li>


                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="${pageContext.request.contextPath}resources/img/Date%20To-52.png">
                    <time class="created_date"  title="Дата публикации: 28 июня 2016, в 09:38" datetime="2016-06-28 09:38:36">2016-06-28 09:38 </time>
                  </li>

                </ul>
                <div class="clearfix"></div>
              </div>
            </li>
            <li class="content-list_item">
              <div class="question_box">
                <div class="question_content">
                  <nav class="question_tags">
                    <ul>
                      <li class="tokenWrapper">

                        <div class="tokenContainer">
                          <span>java</span>
                        </div>

                      </li>
                      <li class="tokenWrapper">
                        <div class="tokenContainer">
                          <span data-element-type="227">java</span>
                        </div>

                      </li>
                    </ul>
                  </nav>
                  <h2 class="question_title">
                    <a class="question_title-link" href="#">Java наше все</a>
                  </h2>

                </div>

                <div class="question_info">
                  <div class="question_info_box">
                    <div class="info">
                      <span class="counter"> 3 </span>
                    </div>
                    <div class="answers info">ответов</div>
                  </div>
                </div>
                <ul class="question_attrs">
                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="${pageContext.request.contextPath}resources/img/Star%20Filled-48.png">
                    <span class="followers_count" title="Количество подписавшихся на вопрос">23</span>
                  </li>
                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="${pageContext.request.contextPath}resources/img/Visible-48.png">
                    <span class="views-count"> 1074 </span>
                  </li>

                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="${pageContext.request.contextPath}resources/img/Available%20Updates-52.png">
                    <time class="created_date" title="Дата публикации: 28 июня 2016, в 09:38"  datetime="2016-06-28 09:38:36"> 3 часа назад</time>
                  </li>


                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="${pageContext.request.contextPath}resources/img/Date%20To-52.png">
                    <time class="created_date"  title="Дата публикации: 28 июня 2016, в 09:38" datetime="2016-06-28 09:38:36">2016-06-28 09:38 </time>
                  </li>

                </ul>
                <div class="clearfix"></div>
              </div>
            </li>
          </ul>

          <ul class="pagination">
            <li><a href="#">«</a></li>
            <li><a href="#">1</a></li>
            <li><a class="active" href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">6</a></li>
            <li><a href="#">7</a></li>
            <li><a href="#">»</a></li>
          </ul>
        </div>
      </main>

    </div>
    <div class="column_sidebar column">
      <aside>
        <div class="tags">
          <h2> Tеги: </h2>
          <div class="chosenTags">
            <ul>
            </ul>
          </div>
          <div class="separator"></div>
          <div class="column possibleTags">
            <ul>
              <li class="tokenWrapper">
                <div class="SearchInputToken">
                  <div class="tokenContainer">
                    <span data-tag="4">html</span>
                    <span class="remove">
				         <em></em>
					  </span>
                  </div>
                </div>
              </li>
              <li class="tokenWrapper">
                <div class="SearchInputToken">
                  <div class="tokenContainer">
                    <span data-tag="6">css</span>
                    <span class="remove">
				         <em></em>
					  </span>
                  </div>
                </div>
              </li>
              <li class="tokenWrapper">
                <div class="SearchInputToken">
                  <div class="tokenContainer">
                    <span data-tag="1">java</span>
                    <span class="remove">
				         <em></em>
					  </span>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </aside>
    </div>
  </div>
</section>
<footer class="footer">
</footer>

</body>

</html>