<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside class="sidenav bg-white navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-4 " id="sidenav-main">
    <div class="sidenav-header">
      <i class="fas fa-times p-3 cursor-pointer text-secondary opacity-5 position-absolute end-0 top-0 d-none d-xl-none" aria-hidden="true" id="iconSidenav"></i>
      <a class="navbar-brand m-0" href="#">
        <img src="./resources/assets/img/logo-ct-dark.png" class="navbar-brand-img h-100" alt="main_logo">
        <span class="ms-2 font-weight-bold">목 록</span>
      </a>
    </div>
    <hr class="horizontal dark mt-0">
    <div class="collapse navbar-collapse  w-auto " id="sidenav-collapse-main">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" href="mList">
            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
              <i class="ni ni-book-bookmark text-primary text-sm opacity-10"></i>
            </div>
            <span class="nav-link-text ms-1">회원목록</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="bList">
            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
              <i class="ni ni-tv-2 text-warning text-sm opacity-10"></i>
            </div>
            <span class="nav-link-text ms-1">게시판</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="writeForm">
            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
              <i class="ni ni-credit-card text-success text-sm opacity-10"></i>
            </div>
            <span class="nav-link-text ms-1">게시글작성</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="bSearch?category=BWRITER&keyword=${loginId}">
            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
              <i class="ni ni-bullet-list-67 text-info text-sm opacity-10"></i>
            </div>
            <span class="nav-link-text ms-1">내가쓴글</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="#">
            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
              <i class="ni ni-world-2 text-danger text-sm opacity-10"></i>
            </div>
            <span class="nav-link-text ms-1">인트라올</span>
          </a>
        </li>
        <li class="nav-item mt-3">
          <h6 class="ps-4 ms-2 text-uppercase text-xs font-weight-bolder opacity-6">Account pages</h6>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="mView?mId=${loginId}">
            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
              <i class="ni ni-single-02 text-dark text-sm opacity-10"></i>
            </div>
            <span class="nav-link-text ms-1">내정보</span>
          </a>
        </li>
        
        
        <c:choose>

			<c:when test="${loginId ne null}">
        		<li class="nav-item">
          			<a class="nav-link " href="mLogout">
            		<div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
             		 <i class="ni ni-bold-left text-info text-sm opacity-10"></i>
            		</div>
            		<span class="nav-link-text ms-1">로그아웃</span>
         		 </a>
        	</li>
        	</c:when>
        	
        	<c:otherwise>
        		<li class="nav-item">
         			 <a class="nav-link " href="loginForm">
           			 <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
             		 <i class="ni ni-bold-right text-warning text-sm opacity-10"></i>
           			 </div>
            		<span class="nav-link-text ms-1">로그인</span>
          			</a>
        		</li>
        	</c:otherwise>
        </c:choose>
      </ul>
    </div>
    <div class="sidenav-footer mx-3 ">
      <div class="card card-plain shadow-none" id="sidenavCard">
        <img class="w-50 mx-auto" src="./resources/assets/img/illustrations/icon-documentation.svg" alt="sidebar_illustration">
        <div class="card-body text-center p-3 w-100 pt-0">
          <div class="docs-info">
            <h6 class="mb-0">도움이 필요하신가요?</h6>
            <p class="text-xs font-weight-bold mb-0">저도요.</p>
          </div>
        </div>
      </div>
      <a href="#" class="btn btn-dark btn-sm w-100 mb-3">도우미 이동</a>
      <a class="btn btn-primary btn-sm mb-0 w-100" href="#" type="button">페이지 활용</a>
    </div>
  </aside>