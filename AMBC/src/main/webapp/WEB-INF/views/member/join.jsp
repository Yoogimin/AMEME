<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="apple-touch-icon" sizes="76x76" href="./resources/assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="./resources/assets/img/favicon.png">
  <title>
    898『O4』
  </title>
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
  <!-- Nucleo Icons -->
  <link href="./resources/assets/css/nucleo-icons.css" rel="stylesheet" />
  <link href="./resources/assets/css/nucleo-svg.css" rel="stylesheet" />
  <!-- Font Awesome Icons -->
  <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
  <link href="./resources/assets/css/nucleo-svg.css" rel="stylesheet" />
  <!-- CSS Files -->
  <link id="pagestyle" href="./resources/assets/css/argon-dashboard.css?v=2.0.4" rel="stylesheet" />
</head>

<body class="g-sidenav-show   bg-gray-100">
  <div class="min-height-300 bg-primary position-absolute w-100"></div>
  	<%@ include file="../sidebar.jsp" %>
  <main class="main-content position-relative border-radius-lg ">
    <!-- Navbar -->
    <%@ include file="../header.jsp" %>
    <!-- End Navbar -->
    <div class="pagetitle">
			<h2 style="color: white;">회원가입</h2>

		</div>
		<!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-9">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title"></h5>

							<!-- 회원가입 form 양식 -->
							<form action="mJoin" method="post" enctype="multipart/form-data">

								<!-- 아이디 -->
								<div class="row mb-3">
									<label for="inputText" class="col-sm-2 col-form-label">아이디</label>
									<div class="col-sm-10">
										<input type="text" name="mId" id="mId" class="form-control" />
										<p id="check1"></p>
									</div>
								</div>

								<!-- 비밀번호 -->
								<div class="row mb-3">
									<label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
									<div class="col-sm-10">
										<input type="password" name="mPw" id="mPw"
											class="form-control" />
										<p id="check2"></p>
									</div>
								</div>

								<!-- 비밀번호 확인 -->
								<div class="row mb-3">
									<label for="inputPassword" class="col-sm-2 col-form-label">비밀번호
										확인</label>
									<div class="col-sm-10">
										<input type="password" id="checkPw" class="form-control" />
										<p id="check3"></p>
									</div>
								</div>

								<!-- 이름 -->
								<div class="row mb-3">
									<label for="inputText" class="col-sm-2 col-form-label">이름</label>
									<div class="col-sm-10">
										<input type="text" name="mName" class="form-control" />
									</div>
								</div>

								<!-- 생년월일 -->
								<div class="row mb-3">
									<label for="inputDate" class="col-sm-2 col-form-label">생년월일</label>
									<div class="col-sm-10">
										<input type="date" name="mBirth" class="form-control">
									</div>
								</div>

								<!-- 성별 -->
								<fieldset class="row mb-3">
									<legend class="col-form-label col-sm-2 pt-0">성별</legend>
									<div class="col-sm-10">

										<div class="form-check">
											<input class="form-check-input" type="radio" name="mGender"
												id="mGender1" value="남자"> <label
												class="form-check-label" for="mGender1"> 남자 </label>
										</div>

										<div class="form-check">
											<input class="form-check-input" type="radio" name="mGender"
												id="mGender2" value="여자"> <label
												class="form-check-label" for="mGender2"> 여자 </label>
										</div>

									</div>
								</fieldset>

								<!-- 이메일 -->
								<div class="row mb-3">
									<label for="inputEmail" class="col-sm-2 col-form-label">이메일</label>
									<div class="col-sm-10">
										<input type="email" name="mEmail" class="form-control">
									</div>
								</div>

								<!-- 연락처 -->
								<div class="row mb-3">
									<label for="inputText" class="col-sm-2 col-form-label">연락처</label>
									<div class="col-sm-10">
										<input type="text" name="mPhone" class="form-control" />
									</div>
								</div>


								<!-- 주소 -->
								<div class="row mb-3">
									<label for="inputText" class="col-sm-2 col-form-label">주소</label>
									<div class="col-md-6">
										<div class="input-group">
											<input type="text" name="addr1" id="sample6_postcode"
												class="form-control" placeholder="우편번호"> <input
												type="button" onclick="sample6_execDaumPostcode()"
												class="btn btn-secondary" value="주소찾기">
										</div>
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputText" class="col-sm-2 col-form-label"></label>
									<div class="col-md-6">
										<input type="text" name="addr2" id="sample6_address"
											class="form-control" placeholder="주소">
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputText" class="col-sm-2 col-form-label"></label>
									<div class="col-md-6">
										<input type="text" name="addr3" id="sample6_detailAddress"
											class="form-control" placeholder="상세주소">
									</div>
								</div>

								<!-- 프로필 사진 -->
								<div class="row mb-3">
									<label for="inputNumber" class="col-sm-2 col-form-label">프로필 사진</label>
									<div class="col-sm-10">
										<input class="form-control" type="file" id="mProfile"name="mProfile"> 
										<br/><img id="preview" width="150px" />
									</div>
								</div>

								<!-- 가입 버튼 -->
								<div class="row mb-3">
									<div class="col-sm-10" style="text-align: center;">
										<button type="submit" class="btn btn-primary">회원가입</button>
									</div>
								</div>

							</form>
							<!-- End General Form Elements -->

						</div>
					</div>

				</div>

			</div>
		</section>
  </main>
  <div class="fixed-plugin">
    <a class="fixed-plugin-button text-dark position-fixed px-3 py-2">
      <i class="fa fa-cog py-2"> </i>
    </a>
    <div class="card shadow-lg">
      <div class="card-header pb-0 pt-3 ">
        <div class="float-start">
          <h5 class="mt-3 mb-0">Argon Configurator</h5>
          <p>See our dashboard options.</p>
        </div>
        <div class="float-end mt-4">
          <button class="btn btn-link text-dark p-0 fixed-plugin-close-button">
            <i class="fa fa-close"></i>
          </button>
        </div>
        <!-- End Toggle Button -->
      </div>
      <hr class="horizontal dark my-1">
      <div class="card-body pt-sm-3 pt-0 overflow-auto">
        <!-- Sidebar Backgrounds -->
        <div>
          <h6 class="mb-0">Sidebar Colors</h6>
        </div>
        <a href="javascript:void(0)" class="switch-trigger background-color">
          <div class="badge-colors my-2 text-start">
            <span class="badge filter bg-gradient-primary active" data-color="primary" onclick="sidebarColor(this)"></span>
            <span class="badge filter bg-gradient-dark" data-color="dark" onclick="sidebarColor(this)"></span>
            <span class="badge filter bg-gradient-info" data-color="info" onclick="sidebarColor(this)"></span>
            <span class="badge filter bg-gradient-success" data-color="success" onclick="sidebarColor(this)"></span>
            <span class="badge filter bg-gradient-warning" data-color="warning" onclick="sidebarColor(this)"></span>
            <span class="badge filter bg-gradient-danger" data-color="danger" onclick="sidebarColor(this)"></span>
          </div>
        </a>
        <!-- Sidenav Type -->
        <div class="mt-3">
          <h6 class="mb-0">Sidenav Type</h6>
          <p class="text-sm">Choose between 2 different sidenav types.</p>
        </div>
        <div class="d-flex">
          <button class="btn bg-gradient-primary w-100 px-3 mb-2 active me-2" data-class="bg-white" onclick="sidebarType(this)">White</button>
          <button class="btn bg-gradient-primary w-100 px-3 mb-2" data-class="bg-default" onclick="sidebarType(this)">Dark</button>
        </div>
        <p class="text-sm d-xl-none d-block mt-2">You can change the sidenav type just on desktop view.</p>
        <!-- Navbar Fixed -->
        <div class="d-flex my-3">
          <h6 class="mb-0">Navbar Fixed</h6>
          <div class="form-check form-switch ps-0 ms-auto my-auto">
            <input class="form-check-input mt-1 ms-auto" type="checkbox" id="navbarFixed" onclick="navbarFixed(this)">
          </div>
        </div>
        <hr class="horizontal dark my-sm-4">
        <div class="mt-2 mb-5 d-flex">
          <h6 class="mb-0">Light / Dark</h6>
          <div class="form-check form-switch ps-0 ms-auto my-auto">
            <input class="form-check-input mt-1 ms-auto" type="checkbox" id="dark-version" onclick="darkMode(this)">
          </div>
        </div>
        <a class="btn bg-gradient-dark w-100" href="https://www.creative-tim.com/product/argon-dashboard">Free Download</a>
        <a class="btn btn-outline-dark w-100" href="https://www.creative-tim.com/learning-lab/bootstrap/license/argon-dashboard">View documentation</a>
        <div class="w-100 text-center">
          <a class="github-button" href="https://github.com/creativetimofficial/argon-dashboard" data-icon="octicon-star" data-size="large" data-show-count="true" aria-label="Star creativetimofficial/argon-dashboard on GitHub">Star</a>
          <h6 class="mt-3">Thank you for sharing!</h6>
          <a href="https://twitter.com/intent/tweet?text=Check%20Argon%20Dashboard%20made%20by%20%40CreativeTim%20%23webdesign%20%23dashboard%20%23bootstrap5&amp;url=https%3A%2F%2Fwww.creative-tim.com%2Fproduct%2Fargon-dashboard" class="btn btn-dark mb-0 me-2" target="_blank">
            <i class="fab fa-twitter me-1" aria-hidden="true"></i> Tweet
          </a>
          <a href="https://www.facebook.com/sharer/sharer.php?u=https://www.creative-tim.com/product/argon-dashboard" class="btn btn-dark mb-0 me-2" target="_blank">
            <i class="fab fa-facebook-square me-1" aria-hidden="true"></i> Share
          </a>
        </div>
      </div>
    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="./resources/assets/js/core/popper.min.js"></script>
  <script src="./resources/assets/js/core/bootstrap.min.js"></script>
  <script src="./resources/assets/js/plugins/perfect-scrollbar.min.js"></script>
  <script src="./resources/assets/js/plugins/smooth-scrollbar.min.js"></script>
  <script src="./resources/assets/js/plugins/chartjs.min.js"></script>
  <script>
    var ctx1 = document.getElementById("chart-line").getContext("2d");

    var gradientStroke1 = ctx1.createLinearGradient(0, 230, 0, 50);

    gradientStroke1.addColorStop(1, 'rgba(94, 114, 228, 0.2)');
    gradientStroke1.addColorStop(0.2, 'rgba(94, 114, 228, 0.0)');
    gradientStroke1.addColorStop(0, 'rgba(94, 114, 228, 0)');
    new Chart(ctx1, {
      type: "line",
      data: {
        labels: ["Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        datasets: [{
          label: "Mobile apps",
          tension: 0.4,
          borderWidth: 0,
          pointRadius: 0,
          borderColor: "#5e72e4",
          backgroundColor: gradientStroke1,
          borderWidth: 3,
          fill: true,
          data: [50, 40, 300, 220, 500, 250, 400, 230, 500],
          maxBarThickness: 6

        }],
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
          legend: {
            display: false,
          }
        },
        interaction: {
          intersect: false,
          mode: 'index',
        },
        scales: {
          y: {
            grid: {
              drawBorder: false,
              display: true,
              drawOnChartArea: true,
              drawTicks: false,
              borderDash: [5, 5]
            },
            ticks: {
              display: true,
              padding: 10,
              color: '#fbfbfb',
              font: {
                size: 11,
                family: "Open Sans",
                style: 'normal',
                lineHeight: 2
              },
            }
          },
          x: {
            grid: {
              drawBorder: false,
              display: false,
              drawOnChartArea: false,
              drawTicks: false,
              borderDash: [5, 5]
            },
            ticks: {
              display: true,
              color: '#ccc',
              padding: 20,
              font: {
                size: 11,
                family: "Open Sans",
                style: 'normal',
                lineHeight: 2
              },
            }
          },
        },
      },
    });
  </script>
  <script>
    var win = navigator.platform.indexOf('Win') > -1;
    if (win && document.querySelector('#sidenav-scrollbar')) {
      var options = {
        damping: '0.5'
      }
      Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
    }
  </script>
  <!-- Github buttons -->
  <script async defer src="https://buttons.github.io/buttons.js"></script>
  <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="./resources/assets/js/argon-dashboard.min.js?v=2.0.4"></script>
</body>

</html>