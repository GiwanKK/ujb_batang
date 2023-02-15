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
			<li><span class="pt2">세입징수 현황</span></li>
			<li class="current_page">세입징수 현황</li>
		</ul>
		<ul class="month_year">
			<li><input type="radio" name="rdoStd" id="mn_yr1" value="mm" class="rd" checked="checked"> <label for="mn_yr1">월간</label></li>
			<li><input type="radio" name="rdoStd" id="mn_yr2" value="yy" class="rd"> <label for="mn_yr2">연간</label></li>
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
					
					<div class="col3_2 coline_r">
						<h3 class="did_title">2021년 8월 세입징수 현황</h3>
                        <div id="revnStatus" class="graph_481"></div>
                        <div class="tax_desc">
							<ul class="list_title">
								<li style="width:9.9%">본세목명</li>
								<li style="width:21.7%">징수세목명</li>
								<li style="width:7.9%">구성비율</li>
								<li style="width:14.8%">당월징수결정금액 <span class="tiny_12">(원)</span></li>
								<li style="width:14.7%">당월감액금액 <span class="tiny_12">(원)</span></li>
								<li style="width:14.8%">당월결손금액 <span class="tiny_12">(원)</span></li>
								<li style="width:15%">당월과오납금액 <span class="tiny_12">(원)</span></li>
							</ul>
							<div class="tax_list">
								<table id="revenueList" class="sm_table bt0" summary="세입현황 리스트">
									<!-- <caption>세입현황 리스트 테이블</caption>
									<colgroup>
										<col width="10%" />
										<col width=" " />
										<col width="8%" />
										<col width="15%" />
										<col width="15%" />
										<col width="15%" />
										<col width="15%" />
									</colgroup>
									<tbody>
										<tr>
											<th rowspan="3">취득세(부동산)</th>
											<td>교육세</td>
											<td>8%</td>
											<td>14,971,957,180</td>
											<td>14,971,957,180</td>
											<td>14,971,957,180</td>
											<td>14,971,957,180</td>
										</tr>
										<tr>
											<td>농특세</td>
											<td>3%</td>
											<td>5,759,099,042</td>
											<td>5,759,099,042</td>
											<td>5,759,099,042</td>
											<td>5,759,099,042</td>
										</tr>
										<tr>
											<td>취득세(부동산)</td>
											<td>89%</td>
											<td>169,551,311,620</td>
											<td>169,551,311,620</td>
											<td>169,551,311,620</td>
											<td>169,551,311,620</td>
										</tr>
										<tr>
											<th rowspan="2">담배소비세</th>
											<td>교육세</td>
											<td>31%</td>
											<td>14,971,957,180</td>
											<td>14,971,957,180</td>
											<td>14,971,957,180</td>
											<td>14,971,957,180</td>
										</tr>
										<tr>
											<td>담배소비세</td>
											<td>69%</td>
											<td>5,759,099,042</td>
											<td>5,759,099,042</td>
											<td>5,759,099,042</td>
											<td>5,759,099,042</td>
										</tr>
									</tbody> -->
								</table>
							</div>
						</div>
					</div>
					
					<div class="col3">
						
						<div class="right_subchart">
							<p class="subtitle">1. 연도별 세입징수 추이 <span class="tiny_12" id="dateTxt"></span></p>
							<div id="revnStatusYear" class="graph_268"></div>
						</div>
						
                        <div class="right_subchart2">
							<p class="subtitle">2. 항목별 세입징수 현황 <span class="tiny_12">(최근 10년간)</span></p>
							<div id="revnStatusMain" class="graph_248"></div>
						</div>
						
                        <div class="right_subchart3">
							<p class="subtitle">3. 전년 대비 세목별 세입징수 현황 <span class="tiny_12"></span></p>
							<div id="revnStatusSub" class="graph_248"></div>
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
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/revenue/revenueStatus.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquer.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.mockjax.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.orgchart.js"></script>
     --%>
     