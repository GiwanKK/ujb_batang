<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : businessStatus.jsp
  * @Description : 대시보드 - 재난현황 페이지
  * @Modification Information
  *
  *  수정일         수정자         수정내용
  *  -------       -------------   ----------------------
  *  2021.08.17.      김부권          최초 생성
  */
%>	


<div id="container">
	<div class="location">
		<ul class="page_navi">
			<li><span class="pt2">재난 현황</span></li>
			<li class="current_page">재난 현황</li>
		</ul>
		<p class="search_box">
		</p>
	</div>
	<div class="content_wrap">
				<div class="content">
					
					<div class="col3_2 coline_r">
						<h3 class="did_title">돌발상황 정보<span id="dataTimeTxt" class="add_note"></span></h3>
						<div id="map" class="accident_map"></div>
						<div id="legned" style="width :100px; heigth:100px; position: absolute;">
						<div style="padding:5px"><span style="background-color: red;width:15px;height:15px;border-radius: 10px;display: inline-block;"></span>
						<span>사고</span></div>
						<div style="padding:5px"><span style="background-color: yellow;width:15px;height:15px;border-radius: 10px;display: inline-block;"></span>
						<span>공사</span></div>
						<div style="padding:5px"><span style="background-color: #00FA00;width:15px;height:15px;border-radius: 10px;display: inline-block;"></span>
						<span>행사</span></div>
						<div style="padding:5px"><span style="background-color: #1100FF;width:15px;height:15px;border-radius: 10px;display: inline-block;"></span>
						<span>기타</span></div>
						</div>
						<div class="mapsub_all">
							<div class="outbreak_list">
								<ul id="calaStatusData">
								</ul>
							</div>
							<div class="grp_rescue">
								<p class="subtitle" id="calaCaseCntP">유형별 긴급 구조 수 </p>
								<div id="calaCaseCnt" class="graph_389"></div>
							</div>
						</div>
					</div>
					
					<div class="col3">
						<h3 class="did_title">화재 발생 현황</h3>
						<div class="fire_area">
							<p class="subtitle" id="calaPlaceTotalP">1. 발화장소별 화재 발생 누적 현황</p>
							<div id="calaPlaceTotal" class="graph_391"></div>
						</div>
						<div class="fire_area mt15">
							<p class="subtitle" id="calaFactorTotalP">2. 발화요인별 화재 발생 누적 현황</p>
							<div id="calaFactorTotal" class="graph_391"></div>
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
<%-- <script src="${pageContext.request.contextPath}/dist/js/common/d3/d3_v5.min.js"></script> --%>
<script src="${pageContext.request.contextPath}/dist/js/common/etc/loading/ajax-loading.js"></script>
    	        
    <script src="${pageContext.request.contextPath}/dist/js/common/commonUtil.js"></script>	
    <script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/calamity/calamity.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquer.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.mockjax.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.orgchart.js"></script>
     --%>
     