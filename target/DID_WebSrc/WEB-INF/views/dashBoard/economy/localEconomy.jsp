<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : productionTrend.jsp
  * @Description : 대시보드 - 지역산업 생태계 > 경기, 생산동향 페이지
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
				<li><span class="pt2">지역경제(상권) 분석</span></li>
				<li class="current_page">지역경제(상권) 분석</li>
			</ul>
			<p class="search_box">
				<input type='text' class="form-control dateSelect" name="startDate" id="startDate" value="${date.maxdate}" />
				<span class="search_tip">(보유 데이터 : ${date.mindate} ~ ${date.maxdate})</span>
				<input type="hidden" id="start" value="${date.mindate}" >
				<input type="hidden" id="end" value="${date.maxdate}" >
			</p>
		</div>
		
		<div class="content_wrap">
			<div class="content">
				
				<div class="col2 coline_r">
					<h3 class="did_title">지역경제(상권) 분석<span class="add_note" id="dateTxtLl"></span></h3>
						<div class="chart_wrap po_rel">
							<div id="mapLegend" class="remark_map locl_grp01"></div>
							<div id="localEconomyMap" class="graph_481 mapboxgl-map"></div>
						</div>
                       <div class="tax_desc">
						<ul class="list_title">
							<li style="width:8%"></li>
							<li style="width:15%">상권명</li>
							<li style="width:15%">상권종류</li>
							<li style="width:47%">업종정보</li>
							<li style="width:15%">점포수</li>
						</ul>
						<div class="tax_list">
							<table id="localEconomyList" class="sm_table bt0" summary="지역경제 상권 리스트">
							</table>
						</div>
					</div>
				</div>
				
				<div class="col2">
					<div class="right_subchart">
						<p class="subtitle">행정동별 공시지가 증가율<span class="tiny_12" id="dateTxtEc"></span></p>
						<div id="emdEconomy" class="graph_268"></div>
					</div>
					
                       <div class="right_subchart2">
						<p class="subtitle">행정동별 상가업소 수<span class="tiny_12" id="dateTxtSt"></span></p>
						<div id="emdStore" class="graph_248"></div>
					</div>
					
                       <div class="right_subchart3">
						<p class="subtitle">업종별 상가업소 수<span class="tiny_12" id="dateTxtTy"></span></p>
						<div id="typeStore" class="graph_248"></div>
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
	<script src="${pageContext.request.contextPath}/pageJs/dashBoard/economy/localEconomy.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>
     