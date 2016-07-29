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
  <link href="../css/main.css" rel="stylesheet">
  <script type="text/javascript" src="../js/libs/jquery-3.0.0.min.js"></script>
  <script src="../js/main.js"></script>

</head>

<body>
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
            <div class="btn btn-user leftRounded" id="logIn">
              <a class="usernameLink">
                <img alt="Ksenia Podoksenova" class="icon profile rounded" src="https://s-media-cache-ak0.pinimg.com/avatars/kpodoksenova_1449508979_30.jpg">
                <span> Kseniya</span>
              </a>
            </div>
          </li>

          <li class="bigScreen content rightRounded dropdown ">
            <bottom class="icon btn rightRounded">
              <img class="icon" src="../img/Speech%20Bubble-50.png">
            </bottom>
          </li>

          <!--         small-->
          <li class="smallScreen content leftRounded dropdown">
            <bottom class="icon btn leftRounded">
              <img class="icon" src="../img/Search-48.png">
            </bottom>
            <div class="dropdown-content wide">
              <div class="searchForm">
                <form name="search" method="GET" action="/search/">
                  <input class="field" placeholder="Поиск" autocomplete="off">
                  <img class="seachicon" alt="search" src="../img/Search-48.png">
                </form>
              </div>
            </div>
          </li>

          <li class="smallScreen content rightRounded dropdown">
            <bottom class="icon btn drop rightRounded">
              <img class="icon" src="../img/Menu-48.png">
            </bottom>
            <div class="dropdown-content">
              <ul class="rightHeader">
                <li class="content leftRounded">
                  <div class="btn btn-user leftRounded" id="logIn">
                    <a class="usernameLink">
                      <img alt="Ksenia Podoksenova" class="icon profile rounded" src="https://s-media-cache-ak0.pinimg.com/avatars/kpodoksenova_1449508979_30.jpg"> Kseniya
                    </a>
                  </div>
                </li>

                <li class="content rightRounded dropdown ">
                  <bottom class="icon btn rightRounded">
                    <img class="icon" src="../img/Speech%20Bubble-50.png">
                  </bottom>
                </li>
              </ul>
            </div>
          </li>

          <li class="mediumScreen bothRounded dropdown">
            <bottom class="icon btn drop bothRounded">
              <img class="icon" src="../img/Menu-48.png">
            </bottom>
            <div class="dropdown-content">
              <ul class="rightHeader">
                <li class="content leftRounded">
                  <div class="btn btn-user leftRounded" id="logIn">
                    <a class="usernameLink">
                      <img alt="Ksenia Podoksenova" class="icon profile rounded" src="https://s-media-cache-ak0.pinimg.com/avatars/kpodoksenova_1449508979_30.jpg">
                      <span> Kseniya </span>
                    </a>
                  </div>
                </li>

                <li class="content rightRounded dropdown ">
                  <bottom class="icon btn rightRounded">
                    <img class="icon" src="../img/Speech%20Bubble-50.png">
                  </bottom>
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
            <img class="seachicon" alt="search" src="../img/Search-48.png">
          </form>
        </div>
      </div>
      <div class="clearfix"></div>
    </div>
  </header>

  <section class="content-wrapper">
    <div class="center">
      <div class="post_separator">

      </div>
      <div class="column_main column">
        <div class="post_header">
          <div class="left leftContainer">
            <div class="post_title subUp">
              <h1> Java наше все</h1>
            </div>

            <div class="post_tags subDown">
              <nav class="question_tags">
                <ul>
                  <li class="tokenWrapper">
                    <div class="tokenContainer">
                      <span data-tag="1">java</span>
                    </div>
                  </li>
                  <li class="tokenWrapper">
                    <div class="tokenContainer">
                      <span data-tag="1">java</span>
                    </div>
                  </li>
                </ul>
              </nav>
            </div>
            <div class="clearfix"></div>
          </div>
          <div class="right rightContainer">
            <div class="subUp">
              <div class="btn empty">
                <a class="usernameLink">
                  <img alt="Ksenia Podoksenova" class="icon profile-big rounded" src="https://s-media-cache-ak0.pinimg.com/avatars/kpodoksenova_1449508979_30.jpg">
                  <span> Kseniya</span>
                </a>
              </div>

            </div>
            <div class="subDown">
              <div class="question_attrs_item">
                <img class="icon icon-micro" src="../img/Date%20To-52.png">
                <time class="created_date" pubdate="" title="Дата публикации: 28 июня 2016, в 09:38" itemprop="dateCreated" datetime="2016-06-28 09:38:36">2016-06-28 09:38 </time>
              </div>
            </div>
          </div>

        </div>
        <main class="main">
          <div class="page_body">
            <div class="post_box">
              <div class="post_content">
                <div class="floatLeft">
                  <img class="icon" src="../img/Star%20Filled-48.png">
                  <div class="info">
                    <span class="counter"> 23 </span>
                  </div>
                </div>
                <!--
                        <div class="post_info info">
                  <div class="post_info _box">
                    <div class="info">
                      <span class="counter"> 3 </span>
                    </div>
                    <div class="answers info">ответов</div>
                  </div>
                </div>              
-->
                <div class="question_body">
                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Excepturi voluptates, dignissimos error animi hic omnis, mollitia harum, architecto deserunt nam, tempora. Soluta dolores, officia. Deserunt aperiam reiciendis qui fuga odio! Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perspiciatis expedita nam ipsum aliquid, ipsam esse, praesentium architecto distinctio modi fugit animi earum! Voluptatum atque sequi, iure minus fugiat facere id!
                </div>

                <ul class="post_attrs">
                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="../img/Visible-48.png">
                    <span class="views-count"> 1074 </span>
                  </li>
                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="../img/Available%20Updates-52.png">
                    <time class="created_date" pubdate="" title="Дата публикации: 28 июня 2016, в 09:38" itemprop="dateCreated" datetime="2016-06-28 09:38:36"> 3 часа назад</time>
                  </li>
                </ul>
                <div class="dropdown-field">
                  <bottom class="btn newAnswer-btn">
                    <span>Ответить</span>
                  </bottom>
                  <div class="newAnswer dropdown-content-field">
                  </div>

                </div>

               


              </div>
            </div>

            <div class="answer_box">
              <div class="answer_content">
                <div class="floatLeft">
                  <a href="#">
                    <img class="icon profile-medium rounded" alt="Ksenia Podoksenova" src="https://s-media-cache-ak0.pinimg.com/avatars/kpodoksenova_1449508979_30.jpg">
                  </a>
                  <a href="#">
                    <img class="icon inline" src="../img/Sort%20Up-48.png">
                  </a>
                  <a href="#">
                    <img class="icon inline" src="../img/Sort%20Down-48.png">
                  </a>
                </div>
                <!--
                        <div class="post_info info">
                  <div class="post_info _box">
                    <div class="info">
                      <span class="counter"> 3 </span>
                    </div>
                    <div class="answers info">ответов</div>
                  </div>
                </div>              
-->
                <div class="answer_body">
                  <div class="name"> Kseniya </div>

                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Excepturi voluptates, dignissimos error animi hic omnis, mollitia harum, architecto deserunt nam, tempora. Soluta dolores, officia. Deserunt aperiam reiciendis qui fuga odio! Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perspiciatis expedita nam ipsum aliquid, ipsam esse, praesentium architecto distinctio modi fugit animi earum! Voluptatum atque sequi, iure minus fugiat facere id!
                </div>

                <ul class="post_attrs">
                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="../img/Date%20To-52.png">
                    <time class="created_date" pubdate="" title="Дата публикации: 28 июня 2016, в 09:38" itemprop="dateCreated" datetime="2016-06-28 09:38:36">2016-06-28 09:38 </time>
                  </li>

                  <li class="question_attrs_item">
                    <img class="icon icon-micro" src="../img/Available%20Updates-52.png">
                    <time class="created_date" pubdate="" title="Дата публикации: 28 июня 2016, в 09:38" itemprop="dateCreated" datetime="2016-06-28 09:38:36"> 3 часа назад</time>
                  </li>
                </ul>
                <bottom class="btn newComment-btn">
                  <span>Комментировать</span>
                </bottom>
              </div>
            </div>
          </div>
        </main>

      </div>
      <div class="column_sidebar column">
        <aside>
          <div class="relatedPosts">
            <h2> Похожие посты: </h2>
            <ul class="similarPost">
              <li class="similarPost_item">
                <a href="#"> 
                      Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
                 </a>
              </li>
              <li class="similarPost_item">
                <a href="#"> 
                      Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
                 </a>
              </li>
            </ul>
          </div>
        </aside>
      </div>
    </div>
  </section>

  <footer class="footer">
  </footer>

</body>

</html>