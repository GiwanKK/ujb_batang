<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : financeStatus.jsp
  * @Description : 대시보드 - 재정 현황 페이지
  * @Modification Information
  *
  *  수정일         수정자         수정내용
  *  -------       -------------   ----------------------
  *  2021.08.03.      김부권          최초 생성
  */
%>	

<div id="container">
	<div class="location">
		<ul class="page_navi">
			<li><span class="pt2">재정 현황</span></li>
			<li class="current_page">신속집행 현황</li>
		</ul>
		<p class="search_box">
			<input type='text' class="form-control dateSelect" name="startDate" id="startDate" value="${date.max }" />
			<span class="search_tip">(보유 데이터 : ${date.min } ~ ${date.max })</span>
			<input type="hidden" id="start" value="${date.min }" >
			<input type="hidden" id="end" value="${date.max }" >
			<!-- <select class="select01" >
				<option value="" selected>조직을 선택하세요</option>
				<option value="">조직001</option>
				<option value="">조직002</option>
			</select> -->
		</p>
	</div>
	
	<div class="content_wrap">
				<div class="content">
					
					<div class="col2 coline_r">
						<div class="quick_all">
							<h3 class="did_title">부서별 신속집행
							<span class="add_note">(상위 25개 부서)</span></h3>
							<!-- <p class="quick_tip">* 지출액의 괄호( )안은 집행률을 나타냅니다.</p> -->
							<div id="executionDept" class="graph_861"></div>
						</div>
					</div>
					
					<div class="col2">
						<div class="quick_all">
							<h3 class="did_title">분야별 신속집행</h3>
							<!-- <p class="quick_tip">* 지출액의 괄호( )안은 집행률을 나타냅니다.</p> -->
							<div id="executionSort" class="graph_861"></div>
						</div>
					</div>
					
				</div>
			</div>
	
	<!-- <div class="content_wrap">
		<div class="content">
			<div style="width: 50%; height: 30%; min-height: 830px; float: left;">
				<div style="width:100%; height: 100%;">
					<div style="width: 100%; height: 30px;">
						<h2 id="" style="display: inline-block; float : left; font-size:16px;">부서별 신속집행</h2><span style="display: inline-block; float : left; font-size:12px; padding-top: 3px;"></span>
						
					</div>
					chart영역
					<div id="executionDept" style="width: 100%; height: 100%; min-height: 800px;">
						
					</div>
				</div>
			</div>
			<div style="width: 50%; height: 30%; min-height: 830px; float: right;">
				<div style="width:100%; height: 100%;">
					<div style="width: 100%; height: 30px;">
						<h2 style="display: inline-block; float : left; font-size:16px;">분야별 신속집행</h2>
					</div>
					
					<div id="executionSort" style="width: 100%; height: 100%; min-height: 800px;">
					</div>
				</div>
			</div>
			
		</div>
	</div> -->
</div>
			

<!-- js 라이브러리 -->
<!-- Date Time Picker   --> 
<script src="${pageContext.request.contextPath}/dist/js/moment.min.js"></script>
    <!-- Date Picker Locale 설정 -->
<script src="${pageContext.request.contextPath}/dist/js/locale.ko.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>    
<script src="${pageContext.request.contextPath}/dist/js/common/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/common/etc/loading/ajax-loading.js"></script>
    	        
    <script src="${pageContext.request.contextPath}/dist/js/common/commonUtil.js"></script>	
    <script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/finance/finaceExecution.js"></script>
