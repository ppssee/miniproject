<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>login</title>
  <link rel="stylesheet" href="/miniproject/resources/css/login.css?after">
  
  <meta name='viewport' content='width=device-width, initial-scale=1'>
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
  <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js'></script>
  <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>
</head>


<body>
  <div id="container">
    <header>
      <div>
        <a href="/miniproject/index2.html">
          <img src="/miniproject/resources/img/indexImg/header.jpg" alt="headerImg">
        </a>
      </div>
      <nav id="topInfo">
        <ul>
          <li><a href="/miniproject/index.jsp">로그인</a></li>
          <li><a href="member/enrollView.kh">회원가입</a></li>
          <li><a href="/miniproject/cart.html">장바구니</a></li>
        </ul>
      </nav>
      <nav id="topMenu">
        <ul>
          <li><a href="/miniproject/index2.html">HOME</a></li>
          <li><a href="/miniproject/menu.html">MENU</a></li>
          <li><a href="/miniproject/location.html">LOCATION</a></li>
          <li><a href="/miniproject/notice.html">NOTICE</a></li>
        </ul>
      </nav>
	</header>
    <main>
    <c:if test="${sessionScope.memberId eq null}">
    <div id="main-div">
      <form action="/miniproject/member/login.kh" method="post">
      <h1>로그인</h1>
      <ul>
        <li>
          <span style="width: 20%; display: inline-block;"><img src="/miniproject/resources/img/loginImg/login_icon.jpg" alt=""></span>
          <input type="text" name="member-id">
        </li>
        <li>
          <span style="width: 20%; display: inline-block;"><img src="/miniproject/resources/img/loginImg/login_icon2.jpg" alt=""></span>
          <input type="password" name="member-pw">
        </li>
      </ul>
      <input type="submit" value="로그인" class="btn btn-danger">
    </form>
    <div id="text-div">
      <a href="member/enrollView.kh">회원가입</a>
      <a href="">아이디찾기</a>ㅣ
      <a href="">비밀번호찾기</a>
    </div>
    <div id="other-login">
      <strong>다른 정보로 로그인하기</strong>
      <ul>
        <li><a href="" id="naverLogin"> 네이버 로그인</a></li>
        <li><a href="" id="kakaoLogin"> 카카오톡 로그인</a></li>
        <li><a href="" id="appleLogin"> 애플 로그인</a></li>
      </ul>
    </div>
    
    </div>
    </c:if>
    <div id="main1">
    <c:if test="${sessionScope.memberId ne null }">	
		${sessionScope.memberId }님 환영합니다 <br>
	    
	    <a href="product/printName.kh" >상품 이름으로 조회</a> <br>
	    <a href="product/printAllProduct.kh" >상품 전체 조회</a> <br>
	    <a href="product/enrollView.kh">상품 등록</a> <br>
	    <a href="product/remove.kh" >상품 제거</a> <br>
	    <a href="product/update.kh" >상품 수정</a> <br>	    
	    <a href="member/logout.kh" >로그아웃</a>  
	    
	    
        </c:if>
    </div>
    </main>
    <footer>
      <div id="footer-top">
        <div id="footer-top-div1">
          <ul>
            <li><a href="">회사소개</a></li>
            <li><a href="">매장안내</a></li>
            <li><a href="">이용약관</a></li>
            <li><a href="">개인정보처리방침</a></li>
          </ul>
        </div>
        <div id="footer-top-div2">
          <div>
            <a href=""><img src="/miniproject/resources/img/indexImg/facebookImg.png" alt=""></a>
            <a href=""><img src="/miniproject/resources/img/indexImg/instaImg.png" alt=""></a>
          </div>
        </div>
      </div>
      <div id="footer-bottom">
        <p id="web-font">대표: 박상은 법인명: 상은당 주식회사 전화: 010-1234-5678 E-mail: ppssee222@gmail.com <br>
          주소: 서울특별시 중구 남대문로 120 그레이츠 청계(구 대일빌딩) 2F, 3F 개인정보책임자: 박상은 (ppssee222@gmail.com) <br>
          사업자등록번호: 301-80-49599 통신판매신고: 제2015-서울중구-0015호</p>
      </div>
    </footer>
  </div>
</body>
</html>