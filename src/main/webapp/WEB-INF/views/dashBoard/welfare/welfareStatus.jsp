<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : welfareStatus.jsp
  * @Description : 대시보드 - 복지현황 페이지
  * @Modification Information
  *
  *     수정일                   수정자                          수정내용
  *  -----------   -------------   ----------------------
  *  2021.08.05        김혜림                          최초 생성
  */
%>	


 	<div id="container">
		<div class="location">
			<ul class="page_navi">
				<li><span class="pt2">복지 현황</span></li>
				<li class="current_page">복지 현황</li>
			</ul>
	<%-- 		<p class="search_box">
				<input type='text' class="form-control dateSelect base_ipt" name="startDate" id="startDate" value="${date.max }" />
				<span>(검색 조건 기간 : ${date.min } ~ ${date.max })</span>
				<input type="hidden" id="start" value="${date.min }" >
				<input type="hidden" id="end" value="${date.max }" >
			</p> --%>
		</div>
	
		<div class="content_wrap">
				<div class="content">
					
					<div class="col2 coline_r">
					
                    	<div class="welfare_left_wrap">
                        	<h3 class="did_title">보육시설 현황</h3>
                            <div id="ujbMap" class="welfare_map">
								<div  id="mapLegend" class="remark_map welfare_grp01">
									<ul>
										<li><span class="rm01"></span> 유치원</li>
										<li><span class="rm02"></span> 어린이집</li>
									</ul>
								</div>
								<div class="graph_451">
									<!-- <img src="image/welfare/welfare_map01.png" alt="그래프예시" /> -->
								</div>
							</div>
                            
                            <div class="welfare_left_btm">
                            	<div class="capacity_left">
                                	<p class="subtitle" id="kndgdLimitChartP">1. 유형별 유치원 정원 수</p>
                                    <div id="kndgdLimitChart" class="graph_318">
                                    <!-- <img src="image/welfare/graph02.png" alt="그래프예시" /> -->
                                    </div>
                                </div>
                                <div class="capacity_right spacing1_5">
                                	<p class="subtitle" id="nurseryLimitChartP">2. 유형별 어린이집 정원 수</p>
                                    <div id="nurseryLimitChart" class="graph_318">
                                    <!-- <img src="image/welfare/graph03.png" alt="그래프예시" /> -->
                                    </div>
                                </div>
                            </div>
                            
                        </div>
					</div>
					
                    <div class="col2 pd0">
                    	<div class="col1">
                        	<div class="silver_welfare">
                            	<h3 class="did_title">노인복지시설 현황</h3>
                                
                                <div class="silver_left">
									<p class="subtitle" id="OldWfFacilGridP">1. 행정동별 노인복지시설 현황</p>
                                	<div class="fx_title">
                                        <table class="title_table" summary="">
                                            <colgroup>
                                                <col width=" " />
                                                <col width="14%" />
                                                <col width="14%" />
                                                <col width="14%" />
                                                <col width="14%" />
                                                <col width="14%" />
                                                <col width="14%" />
                                        	</colgroup>
                                            <thead>
                                                <tr>
                                                    <th rowspan="2">행정동</th>
                                                    <th colspan="2">노인의료 복지시설</th>
                                                    <th colspan="2">재가노인복지시설</th>
                                                    <th colspan="2">노인여가복지시설</th>
                                                </tr>
                                                <tr>
                                                    <th>시설수</th>
                                                    <th>정원수</th>
                                                    <th>시설수</th>
                                                    <th>정원수</th>
                                                    <th>시설수</th>
                                                    <th>정원수</th>
                                                </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div class="table_scroll">
                                        <table class="sm_table" summary="노인복지시설 현황리스트">
                                            <caption>노인복지시설 현황테이블</caption>
                                            <colgroup>
                                                <col width=" " />
                                                <col width="14%" />
                                                <col width="14%" />
                                                <col width="14%" />
                                                <col width="14%" />
                                                <col width="14%" />
                                                <col width="14%" />
                                        	</colgroup>
                                            <tbody id="oldWfFacilTbody">
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                
                                <div class="silver_right spacing1_5">
									<p class="subtitle" id="oldWfFacilRatioChartP">2. 유형별 시설 및 정원 비중</p>
									<div  id="oldWfFacilRatioChart" class="graph_491">
									</div>
								</div>
                            </div>
                        </div>
                        
                        <div class="col1 coline_t">
                        	<div class="disability_area">
                            	<h3 class="did_title">수급자 현황 <span class="add_note">(기초생활보장 및 장애인)</span></h3>
                                
                            	<div class="disability_left">
                                	<p class="subtitle" id="disDegreeCntChartP">1. 장애정도별 수급자 수</p>
                                    <div id="disDegreeCntChart" class="graph_298">
                                    <!-- <img src="image/welfare/graph05.png" alt="그래프예시" /> -->
                                    </div>
                                </div>
                                
                                <div class="disability_right spacing1_5">
                                	<p class="subtitle" id="disAgeCntChartP">2. 연령별 수급자 수</p>
                                    <div id="disAgeCntChart" class="graph_298">
                                    <!-- <img src="image/welfare/graph06.png" alt="그래프예시" /> -->
                                    </div>
                                </div>
                                
                            </div>
                        </div>
                        
                    </div>
					<!--  -->
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
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/welfare/welfareStatus.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>	

