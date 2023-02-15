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
				<li><span class="pt2">지역산업 생태계</span></li>
				<li class="current_page">경기ㆍ생산 동향</li>
			</ul>
		</div>
	
	
		
		<div class="content_wrap">
			<div class="content">
				
				<div class="col2 coline_r">
					<div class="flow_area01">
						<h3 class="did_title">연간 업종별 기업부채비율</h3>
						<ul id="sortList" class="list_title">
							<li style="width:35%">업종</li>
							<li style="width:15%">연도</li>
							<li style="width:25%">기업부채비율(%)</li>
							<li style="width:25%">재무구조상태</li>
						</ul>
						<div class="fnc_list" style="width: 100%;height: 410px;">
							<table id="productSalesList" class="sm_table bt0" summary="재정 항목 설명리스트">
							</table>
						</div>
					</div>
				</div>
				
				<div class="col2">
					<div class="flow_area02">
						<h3 class="did_title">신생기업 생존율<span class="add_note" id="dateTxt"></span><span class="add_note">(1년/5년)</span></h3>
						<div class="subcon_all">
							<div class="subcon_area">
								<div class="chart_wrap" style="padding: 40px 0 0 30px;">
									<img src="/dist/images/company/icon_startup.png" /><br/>
									<div style="margin-top:10px;background:#000;padding:20px;border-radius: 10px;height:200px;">
									<p style="font-size: 16px;font-weight:bold;margin-bottom:15px;">신생기업 기준</p>
									<span style="font-size:14px;">
									설립당시 의정부시에 주소를 두었거나<br/>
									설립 후 1년 이내에 의정부시로 이주한 경우
									</span>
									</div>
								</div>
							</div>
							<div class="subcon_area ml2p">
								<div id="survivalRateChart" class="chart_wrap"></div>
							</div>
						</div>
						<!-- <div id="survivalRateChart" class="chart_wrap">
						</div> -->
					</div>
				</div>
				
				<div class="col2 coline_t coline_r">
					<div class="flow_area03">
						<h3 class="did_title">월별 휴폐업 수 <span class="add_note">(최근 1년간)</span></h3>
						<div id="monthClosedChart" class="chart_wrap">
						</div>
					</div>
				</div>
				
				<div class="col2 coline_t">
					<div class="flow_area04">
						<h3 class="did_title">업종별 업체 수 <span class="add_note" id="dateTxt2"></span></h3>
						<div id="companyIndustryChart" class="chart_wrap">
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
	<script src="${pageContext.request.contextPath}/pageJs/dashBoard/company/productionTrend.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>
     