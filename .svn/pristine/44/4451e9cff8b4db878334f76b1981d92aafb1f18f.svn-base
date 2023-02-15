<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관외지역 전입, 전출</title>
<link rel="stylesheet" href="/dist/css/import.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/mapbox_1.12/mapbox-gl.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/mapbox_1.12/mapbox-gl-draw-1.2.css" />

<!-- jQuery 3 -->
	<%-- <script src="${pageContext.request.contextPath}/dist/js/jquery-3.4.1.min.js"></script> --%>

<script src="${pageContext.request.contextPath}/dist/js/common/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/common/jquery-2.2.2.min.js"></script>
<!-- <script src="https://cdn.jsdelivr.net/npm/@marp-team/marpit-svg-polyfill/lib/polyfill.browser.js"></script> -->
<script src="${pageContext.request.contextPath}/dist/js/common/jquery.bpopup.min.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/common/d3/polyfill.min.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/common/d3/fetch.umd.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/dist/js/common/d3/fetch.js"></script> --%>
<script src="${pageContext.request.contextPath}/dist/js/common/jquery-ui.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/dist/js/common/jquery-3.4.1.min.js"></script> --%>
<script src="${pageContext.request.contextPath}/dist/js/common/menu.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/common/jquery.easing.min.js"></script>

<!-- amchart -->
<script src="${pageContext.request.contextPath}/dist/js/common/amcharts_v4.10.19/core.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/common/amcharts_v4.10.19/charts.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/common/amcharts_v4.10.19/themes/dark.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/common/amcharts_v4.10.19/animated.js"></script>
<%-- <script src="${pageContext.request.contextPath}/dist/js/common/amcharts_v4.10.19/maps.js"></script> --%>
<script src="${pageContext.request.contextPath}/dist/js/common/amcharts_v4.10.19/forceDirected.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/common/amcharts_v4.10.19/wordCloud.js"></script>



<!-- mapbox -->
<script src="${pageContext.request.contextPath}/dist/js/common/mapbox/mapbox-gl-1.12.0.js"></script>

	

</head>
<body>
	
	<div class="map_pop">
		<p class="p_map_title">관외지역 <span id="sortText"></span></p>
		<div id="extendMap" class="p_map_body">
			<!-- <ul class="select_map">
			<li><input type="radio" name="iptMove" id="iptIn" value="1" class="rd"> <label for="iptIn">전입</label></li>
			<li><input type="radio" name="iptMove" id="iptOut" value="2" class="rd"> <label for="iptOut">전출</label></li>
			</ul> -->
			<div id="mapLegend" class="remark_map move_grp04">
			<!-- <ul>
				<li><span class="rm01"></span> #dceff0</li>
				<li><span class="rm02"></span> #a0d7d3</li>
				<li><span class="rm03"></span> #56b6bb</li>
				<li><span class="rm04"></span> #5691bb</li>
				<li><span class="rm05"></span> #5677bb</li>
			</ul> -->
			</div>
		</div>
	
	</div>
	
	<input type="hidden" id="sort" value= ${sort}>
	<input type="hidden" id="startDate" value=${startDate}>
</body>
</html>


<%-- <script src="${pageContext.request.contextPath}/dist/js/common/d3/d3_v5.min.js"></script> --%>
<script src="${pageContext.request.contextPath}/dist/js/common/etc/loading/ajax-loading.js"></script>
    	        
    <script src="${pageContext.request.contextPath}/dist/js/common/commonUtil.js"></script>	
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/population/populationMovePopup.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>	