<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : businessStatus.jsp
  * @Description : 대시보드 - 사업현황 페이지
  * @Modification Information
  *
  *  수정일         수정자         수정내용
  *  -------       -------------   ----------------------
  *  2021.07.28.      김부권          최초 생성
  */
%>	


<div id="container">
	<div class="location">
		<ul class="page_navi">
			<li><span class="pt2">도시 통계 지표</span></li>
			<li class="current_page">도시 통계 지표</li>
		</ul>
		<p class="search_box">
		<input type='text' class="form-control dateSelect" name="startDate" id="startDate" value="${date.min }" />
			<span class="search_tip">(보유 데이터 : ${date.min } ~ ${date.max })</span>
			<input type="hidden" id="start" value="${date.min }" >
			<input type="hidden" id="end" value="${date.max }" >
		</p>
	</div>
	<div class="content_wrap">
				<div class="content">
					<div class="col1">
						
						<!-- <div class="city_left">
							<div class="barometer_box ca01 on">
								<p class="category_index">인구</p>
								<dl class="baro_desc">
									<dt>순이동 인구</dt>
									<dd>-1234<span class="unit_font">명</span></dd>
								</dl>
								<p class="sup_sm">2020년 12월 기준</p>
							</div>
							<div class="box_graph"><img src="image/city/graph.png" alt="그래프예시"></div>
						</div> -->

						<div class="city_right">
							
							<!-- 슬라이드 리스트(한 div에 최대36개) -->
							<div id="cityStatistics" class="mySlides baro_list_wrap">
								
								<!-- <div class="barometer_sbox ca01 on">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca02">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca03">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca04">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca05">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca06">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca07">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca08">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca09">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca10">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div> -->
								
							</div>
							
							<div id="cityStatistics2" class="mySlides baro_list_wrap">
								
								<!-- <div class="barometer_sbox ca01 on">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca02">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca03">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca04">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca05">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca06">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca07">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca08">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca09">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca10">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca10">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca10">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca01">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca02">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca03">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca04">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca05">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca06">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca07">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca08">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca09">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div>
								
								<div class="barometer_sbox ca10">
									<p class="category_index">인구</p>
									<dl class="baro_desc">
										<dt>순이동 인구</dt>
										<dd>-1234<span class="unit_font">명</span></dd>
									</dl>
									<p class="sup_sm">2020년 12월 기준</p>
								</div> -->
								
							</div>
							
							<a class="prev_baro" onclick="plusDivs(-1)"><img src="${pageContext.request.contextPath}/dist/images/city/ico_page_prev.png" alt=""></a>
							<a class="next_baro" onclick="plusDivs(1)"><img src="${pageContext.request.contextPath}/dist/images/city/ico_page_next.png" alt=""></a>
						</div>
						
						<script>
							
						</script>
						
					</div>
				</div>
			</div>
			
		</div>
			<!-- <div class="content_wrap">
				<div class="content">
				<div id ="city_popup">
					<div class="pop_all">
					<a id="close_button" href="#">닫기</a>
					<div class="flow_area02">
							<span style="display: inline-block; height: 15px;" class="searchName"></span>
							<div class="chart_wrap">
								<div id="cityStatisticsChart" class="graph_220"></div>
							</div>
						</div>
				</div>
				</div>
                	<div class="col1">
                		<div class="anal_area01">
							<h3 class="did_title">도시 통계 지표</h3>
							<div id="cityStatistics" class="city_wrap">
							</div>
						</div>
                	
                	
                    </div>
                    
                    
				</div>
			</div> -->
			
	
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
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/city/cityStatistics.js"></script>