<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : companyTrend.jsp
  * @Description : 대시보드 - 지역산업 생태계 > 기업동향 페이지
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
				<li class="current_page">기업 동향</li>
			</ul>
		</div>
		
		<div class="content_wrap">
			<div class="content">
				<div class="col2 coline_r">
					<div class="flow_area01">
						<h3 class="did_title">행정동별 기업체 수 <span class="add_note">(단위: 개)</span></h3>
						<div class="chart_wrap po_rel">
							<div id="mapLegend" class="remark_map comp_grp01"></div>
							<div id="companyMap" class="graph_451 mapboxgl-map"></div>
						</div>
					</div>
				</div>
				<div class="col2">
					<div class="flow_area02">
						<p class="subtitle">1. 연간 기업 매출</p>
						<div id="emdCompanyStatsChart" class="chart_wrap"></div>
						<div class="subcon_bottom">
						<div class="subcon_area">
							<p class="subtitle">2. 업종별 기업비중 <span class="add_note" id="dateTxt"></span></p>
							<div id="industryRateChart" class="chart_wrap"></div>
						</div>
						<div class="subcon_area ml2p">
							<p class="subtitle">3. 업종별 영업이익규모<span class="add_note" id="dateTxt2"></span></p>
							<div id="industryProfitChart" class="chart_wrap"></div>
						</div>
					</div>
					</div>
				</div>
				<div class="col2 coline_t coline_r">
					
					<h3 class="did_title">행정동별 기업동향 통계</h3>
					<div class="flow_area03">
						<ul id="sortList" class="list_title">
							<li style="width:10%">행정동</li>
							<li style="width:10%">기준연도</li>
							<li style="width:11%">매출액<span class="tiny_12">(억)</span></li>
							<li style="width:11%">영업이익<span class="tiny_12">(억)</span></li>
							<li style="width:11%">자본총계<span class="tiny_12">(억)</span></li>
							<li style="width:11%">자산총계<span class="tiny_12">(억)</span></li>
							<li style="width:12%">종업원수<span class="tiny_12">(명)</span></li>
							<li style="width:12%">평균급여<span class="tiny_12">(천원)</span></li>
							<li style="width:">총급여<span class="tiny_12">(천원)</span></li>
						</ul>
						<div class="fnc_list" style="width: 100%;height: 300px;">
							<table id="yearCompanySalesList" class="sm_table bt0" summary="행정동별 기업동향 리스트">
							</table>
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
	<script src="${pageContext.request.contextPath}/pageJs/dashBoard/company/companyTrend.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>
     