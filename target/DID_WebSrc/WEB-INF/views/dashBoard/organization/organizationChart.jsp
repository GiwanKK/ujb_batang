<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : organizationChart.jsp
  * @Description : 대시보드 - 조직도 페이지
  * @Modification Information
  *
  *  수정일         수정자         수정내용
  *  -------       -------------   ----------------------
  *  2021.07.02.      김부권          최초 생성
  */
%>	
<!-- <script type="text/javascript">//<![CDATA[
					$(window).load(function(){
					$(document).ready(function()
					{
						
					 });     
					});//]]> 

				</script> -->
				

<!-- css -->
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/base.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/contents.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/font_face.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/import.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/layout.css" /> --%>


<!-- jQuery 3 -->
	<%-- <script src="${pageContext.request.contextPath}/dist/js/jquery-3.4.1.min.js"></script> --%>

<script src="${pageContext.request.contextPath}/dist/js/common/jquery-2.2.2.min.js"></script>
<!-- <script src="https://cdn.jsdelivr.net/npm/@marp-team/marpit-svg-polyfill/lib/polyfill.browser.js"></script> -->
<%-- <script src="${pageContext.request.contextPath}/dist/js/common/d3/fetch.js"></script> --%>
<script src="${pageContext.request.contextPath}/dist/js/common/jquery-ui.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/dist/js/common/jquery-3.4.1.min.js"></script> --%>
<script src="${pageContext.request.contextPath}/dist/js/common/menu.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/common/jquery.easing.min.js"></script>




<%-- <script src="${pageContext.request.contextPath}/dist/js/common/modal.js"></script>	 --%>

	<div id="full_pop">

		<div id="container">
			<p class="organ_title">의정부시 조직도</p>
			<!-- 20210723_팝업추가 -->
			<div id ="pop_wrap">
				<!-- <div class="pop_all">
					<a id="close_button" href="#">닫기</a>
					<div class="work_info">
						<p class="pic_profile"><img src="/dist/images/organ/pic_profile_man.jpg" alt="인물사진" /></p>
						<dl class="text_profile">
							<dt>김재훈 <span class="duty">기획예산과장</span></dt>
							<dd>T. <span class="pl5">031-123-4567</span></dd>
							<dd>E . <span class="pl5">abc@uijeongbu.co.kr</span></dd>
						</dl>
					</div>
					<div class="work_do">
						<ul class="work_list">
							<li>의정부시 예산</li>
							<li>마을복지계획 추진</li>
							<li>洞지역사회보장협의체 관리</li>
							<li>통합사례관리 및 사업비 집행</li>
							<li>복지톡톡 아카데미, 천사통장 운영</li>
							<li>복지사각지대 조사·발굴 및 지원·연계</li>
							<li>종합상담 및 찾아가는 복지상담</li>
						</ul>
					</div>
				</div> -->
			</div>
			<div class="content_wrap">
				<div>
						<dd class="org_bug">
							<a href="javascript:;" menucode="MENU_00028" linkurl="/dashBoard/finance/financeStatus.do">
							<p class="org_p">재정
							<br>바로가기</p>
							</a>
						</dd>
				</div>
				<div class="content" xxstyle="width:1920px !important;overflow:scroll">
					<div class="organ_wrap">
					
					<div id="firstDepth" class="first_area">
						<!-- 시장 -->
						<!-- <div class="dept01">
							<dl class="name_box">
								<dt class="b_blue">시장</dt>
								<dd>
									<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
									<span class="org_name">안병용</span>
								</dd>
							</dl>
						</div> -->
						
						<!-- 부시장 -->
						<!-- <div class="dept02">
							<dl class="name_box">
								<dt class="b_blgreen">부시장</dt>
								<dd>
									<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
									<span class="org_name">황범순</span>
								</dd>
							</dl>
						</div> -->
						
						<!-- 비서실 -->
						<!-- <div id="firstDepthSub" class="secretary_all">
							<p class="connect_line loc_left">연결선</p>
							<div class="secretary_area">
								
								<div class="dept01_1">
									<dl class="name_box">
										<dt class="b_yellow">비서실장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">조복현</span>
										</dd>
									</dl>
								</div>
								<div class="below_area">
									<p class="branch_vertical">세로연결선</p>
									<p class="branch_line">가로연결선</p>
									<div class="dept01_1_2">
										<dl class="name_box">
											<dt class="b_orange">행정비서</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">채민백</span>
											</dd>
										</dl>
									</div>
									<div class="dept01_1_2">
										<dl class="name_box">
											<dt class="b_orange">대외협력관</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">김흥수</span>
											</dd>
										</dl>
									</div>
								</div>
								
							</div>
						</div> -->
						
						<!-- 감사실 -->
						<!-- <div class="inspection_all">
							<p class="connect_line loc_right">연결선</p>
							<div class="inspection_area">
								
								<div class="dept01_1">
									<dl class="name_box">
										<dt class="b_yellow">감사담당관</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">김홍일</span>
										</dd>
									</dl>
								</div>
								
								<div class="below_area">
									<p class="branch_vertical">세로연결선</p>
									<p class="branch_line">가로연결선</p>
									<div class="dept01_1_2">
										<dl class="name_box">
											<dt class="b_orange">감사</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">강성수</span>
											</dd>
										</dl>
									</div>
									<div class="dept01_1_2">
										<dl class="name_box">
											<dt class="b_orange">일상감사</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">임봉찬</span>
											</dd>
										</dl>
									</div>
									<div class="dept01_1_2">
										<dl class="name_box">
											<dt class="b_orange">조사</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">김수경</span>
											</dd>
										</dl>
									</div>
								</div>
								
							</div>
						</div> -->
						<!-- <p class="branch_vertical hg150">하위단 잇는 하단 세로연결선</p> -->
						
					</div>
					
					<div id="secondDepth" class="second_area">
						<!-- <p class="branch_vertical">세로연결선</p>
						<p class="branch_line mn02">가로연결선</p> -->
						
						<!-- 자치행정국 -->
						<!-- <div class="bureau">
						   <p class="branch_vertical">세로연결선</p>
							<div class="dept03">
								<dl class="name_box">
									<dt class="b_green">자치행정국장</dt>
									<dd>
										<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
										<span class="org_name">고진택</span>
									</dd>
								</dl>
							</div>
							
							<div class="below_area">
								<p class="branch_vertical">세로연결선</p>
								<p class="bureau_line">가로연결선</p> 
									
								<div id="pollSlider-button" class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">기획예산 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">김재훈</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">자치행정 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">이영준</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">홍보 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">이종태</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">민원여권 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">김진혁</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">정보통신 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">김진혁</span>
										</dd>
									</dl>
								</div>
								
							</div>
							
						</div>
						
						일자리경제국
						<div class="bureau">
							<p class="branch_vertical">세로연결선</p>
							<div class="dept03">
								<dl class="name_box">
									<dt class="b_green">일자리경제국장</dt>
									<dd>
										<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
										<span class="org_name">이건철</span>
									</dd>
								</dl>
							</div>
							
							<div class="below_area">
								<p class="branch_vertical">세로연결선</p>
								<p class="bureau_line">가로연결선</p>
									
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">일자리정책 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">권영일</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">지역경제 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">고현숙</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">세정 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">윤동두</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">징수 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">장진자</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">회계 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">한상규</span>
										</dd>
									</dl>
								</div>
								
							</div>
							
						</div>
						
						복지국
						<div class="bureau">
							<p class="branch_vertical">세로연결선</p>
							<div class="dept03">
								<dl class="name_box">
									<dt class="b_green">복지국장</dt>
									<dd>
										<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
										<span class="org_name">윤교찬</span>
									</dd>
								</dl>
							</div>
							
							<div class="below_area">
								<p class="branch_vertical">세로연결선</p>
								<p class="bureau_line">가로연결선</p>
									
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">복지정책 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">권영일</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">노인장애인과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">박춘수</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">여성가족 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">류윤미</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">보육 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">정효경</span>
										</dd>
									</dl>
								</div>
								
							</div>
							
						</div>
						
						교육문화국
						<div class="bureau">
							<p class="branch_vertical">세로연결선</p>
							<div class="dept03">
								<dl class="name_box">
									<dt class="b_green">교육문화국장</dt>
									<dd>
										<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
										<span class="org_name">김근정</span>
									</dd>
								</dl>
							</div>
							
							<div class="below_area">
								<p class="branch_vertical">세로연결선</p>
								<p class="bureau_line">가로연결선</p>
									
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">교육청소년과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">한수완</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">문화관광 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">임우영</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">체육 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">안종성</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">도서관정책과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">이정석</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">도서관운영과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">박영애</span>
										</dd>
									</dl>
								</div>
								
							</div>
							
						</div>
						
						도시주택국
						<div class="bureau">
							<p class="branch_vertical">세로연결선</p>
							<div class="dept03">
								<dl class="name_box">
									<dt class="b_green">도시주택국장</dt>
									<dd>
										<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
										<span class="org_name">김덕현</span>
									</dd>
								</dl>
							</div>
							
							<div class="below_area">
								<p class="branch_vertical">세로연결선</p>
								<p class="bureau_line">가로연결선</p>
									
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">도시 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">이주성</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">주택 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">김종철</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">건축디자인과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">김동수</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">토지정보 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">이종열</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">도시농업 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">정희종</span>
										</dd>
									</dl>
								</div>
								
							</div>
							
						</div>
						
						안전교통건설국
						<div class="bureau">
							<p class="branch_vertical">세로연결선</p>
							<div class="dept03">
								<dl class="name_box">
									<dt class="b_green">안전교통건설국장</dt>
									<dd>
										<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
										<span class="org_name">윤무현</span>
									</dd>
								</dl>
							</div>
							
							<div class="below_area">
								<p class="branch_vertical">세로연결선</p>
								<p class="bureau_line">가로연결선</p>
									
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">교통기획 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">지우현</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">교통지도 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">임희수</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">도시철도 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">심진주</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">안전총괄 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">유희섭</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">도로 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">이구</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">자동차관리과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">이종일</span>
										</dd>
									</dl>
								</div>
								
							</div>
							
						</div>
						
						균형개발추진단
						<div class="bureau">
							<p class="branch_vertical">세로연결선</p>
							<div class="dept03">
								<dl class="name_box">
									<dt class="b_green">균형개발추진단장</dt>
									<dd>
										<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
										<span class="org_name">김장호</span>
									</dd>
								</dl>
							</div>
							
							<div class="below_area">
								<p class="branch_vertical">세로연결선</p>
								<p class="bureau_line">가로연결선</p>
									
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">균형개발 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">최종근</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">투자사업 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">안중현</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">도시재생 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">정춘일</span>
										</dd>
									</dl>
								</div>
								
							</div>
							
						</div> -->

					</div>
					
					<div  class="third_area">
						<!-- 직속기관 -->
						<div id="twoSort" class="sub_group">
							<!-- <p class="title_box">직속기관</p>
							<div class="bureau">
							<p class="branch_vertical">세로연결선</p>
							<div class="dept03">
								<dl class="name_box">
									<dt class="b_green">보건소장</dt>
									<dd>
										<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
										<span class="org_name">장연국</span>
									</dd>
								</dl>
							</div>
							
							<div class="below_area">
								<p class="branch_vertical">세로연결선</p>
								<p class="bureau_line">가로연결선</p>
									
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">보건관리 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">강경숙</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">건강증진 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">박금숙</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">동부보건 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">강춘원</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">위생 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">김병선</span>
										</dd>
									</dl>
								</div>
								
							</div>
							
						</div> -->
						</div>
						
						<!-- 사업소 -->
						<div id="thirdSort" class="sub_group">
							<!-- <p class="title_box">사업소</p>
							<div class="bureau">
							<p class="branch_vertical">세로연결선</p>
							<div class="dept03">
								<dl class="name_box">
									<dt class="b_green">맑은물사업소장</dt>
									<dd>
										<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
										<span class="org_name">이영재</span>
									</dd>
								</dl>
							</div>
							
							<div class="below_area">
								<p class="branch_vertical">세로연결선</p>
								<p class="bureau_line">가로연결선</p>
									
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">맑은물운영과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">서명학</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">수도 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">이교승</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">하수관리 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">최규석</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">하수시설 운영과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">노성천</span>
										</dd>
									</dl>
								</div>
								
							</div>
							
						</div>
							
						<div class="bureau">
							<p class="branch_vertical">세로연결선</p>
							<div class="dept03">
								<dl class="name_box">
									<dt class="b_green">환경사업소장</dt>
									<dd>
										<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
										<span class="org_name">이재송</span>
									</dd>
								</dl>
							</div>
							
							<div class="below_area">
								<p class="branch_vertical">세로연결선</p>
								<p class="bureau_line">가로연결선</p>
									
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">환경관리 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">이병택</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">자원순환 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">박현창</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">공원 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">정해창</span>
										</dd>
									</dl>
								</div>
								
								<div class="dept04">
									<p class="branch_vertical">세로연결선</p>
									<dl class="name_vbox">
										<dt class="b_yellow">녹지산림 과장</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">김상복</span>
										</dd>
									</dl>
								</div>
								
							</div>
							
						</div>	 -->
						
						</div>
						
						<!-- 의회사무국 -->
						<div id="fourthSort" class="sub_group">
							
						</div>
						<!-- 정무특별보좌관 -->
						<div id="sixSort" class="sub_group">
							
						</div>
					
					</div>
						
					<div class="fourth_area">
						<!-- 동 -->
						<div id="fivethSort" class="sub_group">
							<!-- <p class="title_box">동</p>
							흥선권역
							<div class="bureau">
								<p class="branch_vertical">세로연결선</p>
								<div class="dept03">
									<dl class="name_box">
										<dt class="b_green">흥선권역 국장(흥선동)</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">팽재녀</span>
										</dd>
									</dl>
								</div>
							
								<div class="below_area">
									<p class="dong_vertical">세로연결선</p>
									<p class="bureau_line">가로연결선</p>

									<div class="dept04">
										<p class="branch_vertical">세로연결선</p>
										<dl class="name_vbox">
											<dt class="b_yellow">자치민원 과장</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">강경숙</span>
											</dd>
										</dl>
									</div>

									<div class="dept04">
										<p class="branch_vertical">세로연결선</p>
										<dl class="name_vbox">
											<dt class="b_yellow">복지지원 과장</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">유준영</span>
											</dd>
										</dl>
									</div>
									
									<div class="dept04">
										<p class="branch_vertical">세로연결선</p>
										<dl class="name_vbox">
											<dt class="b_yellow">허가안전 과장</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">이상우</span>
											</dd>
										</dl>
									</div>
									
									<div class="dong_branch">
										<p class="dong_title">동 주민센터</p>

										<div class="dept04">
											<p class="branch_vertical">세로연결선</p>
											<dl class="name_vbox">
												<dt class="b_yellow">의정부 1동장</dt>
												<dd>
													<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
													<span class="org_name">정준모</span>
												</dd>
											</dl>
										</div>

										<div class="dept04">
											<p class="branch_vertical">세로연결선</p>
											<dl class="name_vbox">
												<dt class="b_yellow">가능동장</dt>
												<dd>
													<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
													<span class="org_name">홍승의</span>
												</dd>
											</dl>
										</div>

										<div class="dept04">
											<p class="branch_vertical">세로연결선</p>
											<dl class="name_vbox">
												<dt class="b_yellow">녹양동장</dt>
												<dd>
													<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
													<span class="org_name">이미현</span>
												</dd>
											</dl>
										</div>
									</div>
									
								</div>
								
							</div>
							
							호원권역
							<div class="bureau">
								<p class="branch_vertical">세로연결선</p>
								<div class="dept03">
									<dl class="name_box">
										<dt class="b_green">호원권역 국장(호원2동)</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">이정숙</span>
										</dd>
									</dl>
								</div>
							
								<div class="below_area">
									<p class="dong_vertical">세로연결선</p>
									<p class="bureau_line">가로연결선</p>

									<div class="dept04">
										<p class="branch_vertical">세로연결선</p>
										<dl class="name_vbox">
											<dt class="b_yellow">자치민원 과장</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">이형순</span>
											</dd>
										</dl>
									</div>

									<div class="dept04">
										<p class="branch_vertical">세로연결선</p>
										<dl class="name_vbox">
											<dt class="b_yellow">복지지원 과장</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">김학숙</span>
											</dd>
										</dl>
									</div>
									
									<div class="dept04">
										<p class="branch_vertical">세로연결선</p>
										<dl class="name_vbox">
											<dt class="b_yellow">허가안전 과장</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">유창섭</span>
											</dd>
										</dl>
									</div>
									
									<div class="dong_branch">
										<p class="dong_title">동 주민센터</p>

										<div class="dept04">
											<p class="branch_vertical">세로연결선</p>
											<dl class="name_vbox">
												<dt class="b_yellow">의정부 1동장</dt>
												<dd>
													<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
													<span class="org_name">정준모</span>
												</dd>
											</dl>
										</div>

										<div class="dept04">
											<p class="branch_vertical">세로연결선</p>
											<dl class="name_vbox">
												<dt class="b_yellow">가능동장</dt>
												<dd>
													<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
													<span class="org_name">홍승의</span>
												</dd>
											</dl>
										</div>
										
									</div>
								</div>
								
							</div>
							
							신곡권역
							<div class="bureau">
								<p class="branch_vertical">세로연결선</p>
								<div class="dept03">
									<dl class="name_box">
										<dt class="b_green">신곡권역 국장(신곡1동)</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">박성복</span>
										</dd>
									</dl>
								</div>
							
								<div class="below_area">
									<p class="dong_vertical">세로연결선</p>
									<p class="bureau_line">가로연결선</p>

									<div class="dept04">
										<p class="branch_vertical">세로연결선</p>
										<dl class="name_vbox">
											<dt class="b_yellow">자치민원 과장</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">전정일</span>
											</dd>
										</dl>
									</div>

									<div class="dept04">
										<p class="branch_vertical">세로연결선</p>
										<dl class="name_vbox">
											<dt class="b_yellow">복지지원 과장</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">조원상</span>
											</dd>
										</dl>
									</div>
									
									<div class="dept04">
										<p class="branch_vertical">세로연결선</p>
										<dl class="name_vbox">
											<dt class="b_yellow">허가안전 과장</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">이균섭</span>
											</dd>
										</dl>
									</div>
									
									<div class="dong_branch">
										<p class="dong_title">동 주민센터</p>

										<div class="dept04">
											<p class="branch_vertical">세로연결선</p>
											<dl class="name_vbox">
												<dt class="b_yellow">장암동장</dt>
												<dd>
													<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
													<span class="org_name">박재범</span>
												</dd>
											</dl>
										</div>

										<div class="dept04">
											<p class="branch_vertical">세로연결선</p>
											<dl class="name_vbox">
												<dt class="b_yellow">신곡2동장</dt>
												<dd>
													<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
													<span class="org_name">김상태</span>
												</dd>
											</dl>
										</div>
										
									</div>
								</div>
								
							</div>
							
							송산권역
							<div class="bureau">
								<p class="branch_vertical">세로연결선</p>
								<div class="dept03">
									<dl class="name_box">
										<dt class="b_green">송산권역 국장(송산3동)</dt>
										<dd>
											<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
											<span class="org_name">민형식</span>
										</dd>
									</dl>
								</div>
							
								<div class="below_area">
									<p class="dong_vertical">세로연결선</p>
									<p class="bureau_line">가로연결선</p>

									<div class="dept04">
										<p class="branch_vertical">세로연결선</p>
										<dl class="name_vbox">
											<dt class="b_yellow">자치민원 과장</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">조인영</span>
											</dd>
										</dl>
									</div>

									<div class="dept04">
										<p class="branch_vertical">세로연결선</p>
										<dl class="name_vbox">
											<dt class="b_yellow">복지지원 과장</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">김보경</span>
											</dd>
										</dl>
									</div>
									
									<div class="dept04">
										<p class="branch_vertical">세로연결선</p>
										<dl class="name_vbox">
											<dt class="b_yellow">허가안전 과장</dt>
											<dd>
												<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
												<span class="org_name">이병기</span>
											</dd>
										</dl>
									</div>
									
									<div class="dong_branch">
										<p class="dong_title">동 주민센터</p>

										<div class="dept04">
											<p class="branch_vertical">세로연결선</p>
											<dl class="name_vbox">
												<dt class="b_yellow">송산1동장</dt>
												<dd>
													<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
													<span class="org_name">김진수</span>
												</dd>
											</dl>
										</div>

										<div class="dept04">
											<p class="branch_vertical">세로연결선</p>
											<dl class="name_vbox">
												<dt class="b_yellow">송산2동장</dt>
												<dd>
													<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
													<span class="org_name">안윤배</span>
												</dd>
											</dl>
										</div>
										
										<div class="dept04">
											<p class="branch_vertical">세로연결선</p>
											<dl class="name_vbox">
												<dt class="b_yellow">자금동장</dt>
												<dd>
													<p class="org_pic"><img src="/dist/images/organ/man_pic.png" alt="인물사진" /></p>
													<span class="org_name">정호진</span>
												</dd>
											</dl>
										</div>
										
									</div>
								</div>
								
							</div> -->
							
						</div>
					</div>
					
					
					
				</div><!--organ_wrap end -->
					
				</div><!-- content_wrap end -->
				
			</div>
			
			
		</div>
		<!-- 하위조직도 슬라이딩 -->
			<div class="modal_02">
				<div class="modal_dialog_02">
					<div id="pollSlider" class="modal_body_02">
				
					</div>
				</div>
			</div>
	
	    <div id="divLoading" style="position: fixed;margin:0px auto;z-index: 1000;top: 0px;left: 0px;width: 100%;height: 100%; display: none;padding-top:15px;background-color: #fff;color: #000; opacity: 0.7; ">
			<div class="loading-container" style="">
			</div>
		</div>
	
	</div>



				
				
			

<!-- js 라이브러리 -->
<%-- <script src="${pageContext.request.contextPath}/dist/js/common/modal.js"></script> --%>	
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/organization.css" /> --%>
<%-- <script src="${pageContext.request.contextPath}/dist/js/common/d3/d3_v5.min.js"></script> --%>
<script src="${pageContext.request.contextPath}/dist/js/common/etc/loading/ajax-loading.js"></script>
    	        
    <script src="${pageContext.request.contextPath}/dist/js/common/commonUtil.js"></script>	
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/organization/organization_new.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquer.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.mockjax.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.orgchart.js"></script>
     --%>
     