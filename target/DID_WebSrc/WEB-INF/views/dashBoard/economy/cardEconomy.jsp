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
				<li class="current_page">카드 매출 분석</li>
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
					<div class="flow_area01">
						<h3 class="did_title">성연령별 업종별 카드매출 현황</h3>
						<div id="ageCategoryChart" class="chart_wrap"></div>
					</div>
				</div>
				
				<div class="col2">
					<div class="flow_area02">
						<h3 class="did_title">행정동별 카드매출 현황</h3>
						<div id="emdChart" class="chart_wrap"></div>
					</div>
				</div>
				
				<div class="col2 coline_t coline_r">
					<div class="flow_area03">
						<h3 class="did_title">요일별 시간대별 카드매출 현황</h3>
						<div id="weekChart" class="chart_wrap"></div>
					</div>
				</div>
				
				<div class="col2 coline_t">
					<div class="flow_area04">
						<h3 class="did_title">월별 카드매출 현황</h3>
						<div id="monthChart" class="chart_wrap"></div>
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
	<script src="${pageContext.request.contextPath}/pageJs/dashBoard/economy/cardEconomy.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>
     