<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : innovationTrend.jsp
  * @Description : 대시보드 - 지역산업 생태계 > 혁신동향 페이지
  * @Modification Information
  *
  *  수정일         수정자         수정내용
  *  -------       -------------   ----------------------
  *  2021.08.09.      김성중          최초 생성
  */
%>	


	
	<div id="container">
		<div class="location">
			<ul class="page_navi">
				<li><span class="pt2">지역산업 생태계</span></li>
				<li class="current_page">혁신 동향</li>
			</ul>
		</div>
		
		<div class="content_wrap">
			<div class="content">
				
				<div class="col2 coline_r">
					<div class="flow_area01">
						<h3 class="did_title">행정동별 혁신기업 수 <span class="add_note" id="dateTxt"></span></h3>
						<div id="innovationChart" class="chart_wrap">
						</div>
					</div>
				</div>
				
				<div class="col2">
					<div class="flow_area02">
						<h3 class="did_title">업종별 연구개발투자비</h3>
						<div class="flow_area03">
							<ul id="sortList" class="list_title">
								<li style="width:30%">업종</li>
								<li style="width:10%">연도</li>
								<li style="width:60%">금액(천원)</li>
							</ul>
							<div class="fnc_list" style="width: 100%;height: 410px;">
								<table id="investmentTable" class="sm_table bt0" summary="업종별 연구개발투자비 리스트">
								</table>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col2 coline_t coline_r">
					<div class="flow_area03">
						<ul id="sortList" class="list_title">
							<li style="width:20%">행정동별</li>
							<li style="width:20%">벤처기업수</li>
							<li style="width:20%">이노비즈수</li>
							<li style="width:20%">기업부설연구소</li>
							<li style="width:20%">연구개발전담부서</li>
						</ul>
						<div class="fnc_list" style="width: 100%;height: 340px;">
							<table id="innovationTable" class="sm_table bt0" summary="행정동별 혁신기업 수 리스트">
							</table>
						</div>
					</div>
				</div>
				
				<div class="col2 coline_t">
					<div class="flow_area04">
						<h3 class="did_title">연도별 연구개발투자비 <span class="add_note">(최근 5년간)</span></h3>
						<div id="rndChart" class="chart_wrap">
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
			
	<!-- js 라이브러리 -->
	<!-- Date Time Picker   --> 
<script src="${pageContext.request.contextPath}/dist/js/moment.min.js"></script>
    <!-- Date Picker Locale 설정 -->
<script src="${pageContext.request.contextPath}/dist/js/locale.ko.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>    
<script src="${pageContext.request.contextPath}/dist/js/common/jquery-ui.min.js"></script>
<%-- 	<script src="${pageContext.request.contextPath}/dist/js/common/d3/d3_v5.min.js"></script> --%>
	<script src="${pageContext.request.contextPath}/dist/js/common/etc/loading/ajax-loading.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/common/commonUtil.js"></script>	
	<script src="${pageContext.request.contextPath}/pageJs/dashBoard/company/innovationTrend.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>
     