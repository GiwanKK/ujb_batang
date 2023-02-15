<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : revenueStatus.jsp
  * @Description : 대시보드 - 세입현황 페이지
  * @Modification Information
  *
  *  수정일         수정자         수정내용
  *  -------       -------------   ----------------------
  *  2021.08.09.      김부권          최초 생성
  */
%>	


<div id="container">
	<div class="location">
		<ul class="page_navi">
			<li><span class="pt2">수질 현황</span></li>
			<li class="current_page">정수장 수질현황</li>
		</ul>
		<p class="search_box">
		</p>
	</div>
			<div class="content_wrap">
				<div class="content">
					
					<div class="col2 coline_r pd0">
						<div class="col1">
							<h3 class="did_title">급수시설 현황</h3>
                            <div class="water_map">
                            	<div id="mapLegend" class="remark_map water_grp01">
									<!-- <ul>
										<li><span class="rm01"></span> #3bbdc8</li>
										<li><span class="rm02"></span> #3a8db6</li>
										<li><span class="rm03"></span> #f5ce7d</li>
									</ul> -->
								</div>
								<div id="waterMap" class="graph_451"></div>
                            </div>
						</div>
                        
						<div class="col1 coline_t po_rel">
							<h3 class="did_title">1시간 단위 수질 현황</h3>
							<div class="water_quality">
                            	<dl id="sort1" class="wq_box">
								</dl>
								<dl id="sort2" class="wq_box bt0">
								</dl>
                            </div>
						</div>
					</div>
					
					<div class="col2">
						<h3 class="did_title">시간 누적 수질 현황<span class="add_note"></span></h3>
						<div class="stab_box">
							<ul class="stab_all">
								<li class="stab_link on" data-tab="tab-1">덕소정수장</li>
								<li class="stab_link"  data-tab="tab-2">와부정수장</li>
							</ul>
						</div>
						<div id="tab-1" class="stab_content on">
                        	<div class="chart_ci">
								<p class="subtitle">1. 잔류염소(mg/L)</p>
								<div id="waterQualityTotalCh" class="water_grp"></div>
							</div>
                            <div class="chart_ph">
								<p class="subtitle">2. 산성도(ph)</p>
								<div id="waterQualityTotalAc" class="water_grp"></div>
							</div>
                            <div class="chart_ntu">
								<p class="subtitle">3. 탁도(Ntu)</p>
								<div id="waterQualityTotalTu" class="water_grp"></div>
							</div>
                        </div>
						
						<div id="tab-2" class="stab_content">
                        	<div class="chart_ci">
								<p class="subtitle">1. 잔류염소(mg/L)</p>
								<div id="waterQualityTotalCh2" class="water_grp"></div>
							</div>
                            <div class="chart_ph">
								<p class="subtitle">2. 산성도(ph)</p>
								<div id="waterQualityTotalAc2" class="water_grp"></div>
							</div>
                            <div class="chart_ntu">
								<p class="subtitle">3. 탁도(Ntu)</p>
								<div id="waterQualityTotalTu2" class="water_grp"></div>
							</div>
                        </div>
						
						<!-- 20210804 tab스크립트 -->
						<script>
							
						</script>
						
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
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/water/waterQuality.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquer.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.mockjax.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.orgchart.js"></script>
     --%>
     