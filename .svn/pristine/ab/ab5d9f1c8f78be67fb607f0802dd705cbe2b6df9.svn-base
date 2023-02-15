<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : welfareStatus.jsp
  * @Description : 대시보드 - 기상 대기 현황 페이지
  * @Modification Information
  *
  *     수정일                   수정자                          수정내용
  *  -----------   -------------   ----------------------
  *  2021.08.11        김혜림                          최초 생성
  */
%>	
		<div id="container">
			<div class="location">
				<ul class="page_navi">
					<li><span class="pt2">기상 및 대기 현황</span></li>
					<li class="current_page">기상 및 대기 현황</li>
				</ul>
			</div>
			
			<div class="content_wrap">
				<div class="content">
					
					<div class="col1">
						<h3 class="did_title">기상 현황<span id="dataTimeTxt" class="search_tip" style="margin-left:10px;"></span></h3>
						<div class="weather_top">
							
							<div class="weather_box">
								<dl class="temp_box">
									<dt>평균기온</dt>
									<dd id=""><span id="tempValue"></span>&deg;<br />
										<!-- <span id="maxMinTempValue" class="sub_temp">최고 18.9˚ /  최저 4.6˚</span> -->
									</dd>
								</dl>
							</div>
							
							<div class="weather_box">
								<dl class="rain_box">
									<dt>시간당 강수량</dt>
									<dd id=""><span id="rainValue"></span> ㎜</dd>
								</dl>
							</div>
							
							<div class="weather_box">
								<dl class="basic_box">
									<dt>미세먼지 농도 <span class="air_measure">(PM10)</span></dt>
									<dd ><span id="pm10Value"></span> <span class="txt_40">㎛/㎥</span></dd>
								</dl>
								<p class="air_level"><img id="pm10ValueImg" src="/dist/images/weather/weather_level1.png" alt="" /></p>
							</div>
							
							<div class="weather_box">
								<dl class="basic_box">
									<dt>초미세먼지 농도 <span class="air_measure">(PM2.5)</span></dt>
									<dd id=""><span id="pm25Value"></span> <span class="txt_40">㎛/㎥</span></dd>
								</dl>
								<p class="air_level"><img id="pm25ValueImg" src="/dist/images/weather/weather_level2.png" alt="" /></p>
							</div>
							
							<div class="weather_box">
								<dl class="basic_box">
									<dt>오존 농도 <span class="air_measure">(ppm)</span></dt>
									<dd id="o3Value"></dd>
								</dl>
								<p class="air_level"><img id="o3ValueImg" src="/dist/images/weather/weather_level3.png" alt="" /></p>
							</div>
							
							<div class="weather_box">
								<dl class="basic_box">
									<dt>이산화질소 농도 <span class="air_measure">(ppm)</span></dt>
									<dd id="no2Value"></dd>
								</dl>
								<p class="air_level"><img id="no2ValueImg" src="/dist/images/weather/weather_level4.png" alt="" /></p>
							</div>
							
							<div class="weather_box">
								<dl class="basic_box">
									<dt>이산화탄소 농도 <span class="air_measure">(ppm)</span></dt>
									<dd id="coValue"></dd>
								</dl>
								<p class="air_level"><img id="coValueImg" src="/dist/images/weather/weather_level4.png" alt="" /></p>
							</div>
							
							<div class="weather_box">
								<dl class="basic_box">
									<dt>아황산가스 농도 <span class="air_measure">(ppm)</span></dt>
									<dd id="so2Value"></dd>
								</dl>
								<p class="air_level"><img id="so2ValueImg" src="/dist/images/weather/weather_level4.png" alt="" /></p>
							</div>
							
						</div>
					</div>
					
					<div class="col1 coline_t pd0">
						<div class="weather_bottom">
							<h3 class="did_title">미세먼지/초미세먼지농도 <span class="add_note">(관측소별)</span>
							
							<p class="search_box">
								<input type='text' class="form-control dateSelect" name="startDate" id="startDate" value="${date.max }"  placeholder="검색일자를 선택하세요"/>
								<span class="search_tip">(보유 데이터 : ${date.min } ~ ${date.max })</span>
								<input type="hidden" id="start" value="${date.min }" >
								<input type="hidden" id="end" value="${date.max }" >
							</p></h3>
							<div class="air_databox">
								<ul class="check_area">
									<li> <span class="wea01"></span> 0~30 좋음</li>
									<li> <span class="wea02"></span> 31~80 보통</li>
									<li> <span class="wea03"></span> 81~150 나쁨</li>
									<li> <span class="wea04"></span> 151이상 매우나쁨</li>
								</ul>
								<table class="weather_table" summary="날짜별 미세먼지 관측표">
									<caption>날짜별 미세먼지 관측 테이블</caption>
									<colgroup class="colgroups">
										<!-- <col width="7.5%" /><col width="7.5%" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /> -->
									</colgroup>
									
									<tbody id="pm10Tbody">
									</tbody>
								</table>
							</div>
							
							<div class="air_databox mt10">
								<ul class="check_area">
									<li> <span class="wea01"></span> 0~15 좋음</li>
									<li> <span class="wea02"></span> 16~35 보통</li>
									<li> <span class="wea03"></span> 36~75 나쁨</li>
									<li> <span class="wea04"></span> 76이상 매우나쁨</li>
								</ul>
								<table class="weather_table" summary="날짜별 미세먼지 관측표">
									<caption>날짜별 미세먼지 관측 테이블</caption>
									<colgroup class="colgroups">
										<!-- <col width="7.5%" /><col width="7.5%" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /><col width="" /> -->
									</colgroup>
									
									<tbody id="pm25Tbody">
									</tbody>
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
<%-- <script src="${pageContext.request.contextPath}/dist/js/common/d3/d3_v5.min.js"></script> --%>
<script src="${pageContext.request.contextPath}/dist/js/common/etc/loading/ajax-loading.js"></script>
   	        
<script src="${pageContext.request.contextPath}/dist/js/common/commonUtil.js"></script>	
<script src="${pageContext.request.contextPath}/pageJs/dashBoard/weather/weatherStatus.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>	
