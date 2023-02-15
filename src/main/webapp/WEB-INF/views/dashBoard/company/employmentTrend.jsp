<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : employmentTrend.jsp
  * @Description : 대시보드 - 지역산업 생태계 > 고용동향 페이지
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
				<li class="current_page">고용 동향</li>
			</ul>
		</div>
		
		<div class="content_wrap">
			<div class="content">
				
				<div class="col2 coline_r">
					<div class="flow_area01">
						<h3 class="did_title">
							행정동별 종업원수
							<p class="search_box">
								<input type="text" class="form-control dateSelect" name="startDate" id="startDate" value="${date.max }">
								<span class="search_tip">(보유 데이터 : ${date.min } ~ ${date.max })</span>
								<input type="hidden" id="start" value="${date.min }" >
			<input type="hidden" id="end" value="${date.max }" >
							</p>
						</h3>
						<div class="chart_wrap po_rel">
							<div id="mapLegend" class="remark_map empl_grp01"></div>
							<div id="employmentMap" class="graph_451 mapboxgl-map"></div>
						</div>
					</div>
				</div>
				
				<div class="col2">
					<div class="flow_area02">
						<h3 class="did_title">업종별 평균급여<span class="add_note" id="dateTxt"></span></h3>
						<div id="industryAvgPayChart" class="chart_wrap"></div>
					</div>
				</div>
				
				<div class="col2 coline_t coline_r">
					<div class="flow_area03">
						<h3 class="did_title">월별 입사자/퇴사자수 <span class="add_note">(최근 1년간)</span></h3>
						<div id="entrantRetireesChart" class="chart_wrap"></div>
					</div>
				</div>
				
				<div class="col2 coline_t">
					<div class="flow_area04">
						<h3 class="did_title">연도별 평균급여 <span class="add_note">(최근 5년간)</span></h3>
						<div id="yearAvgPayChart" class="chart_wrap"></div>
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
	<script src="${pageContext.request.contextPath}/pageJs/dashBoard/company/employmentTrend.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>
     