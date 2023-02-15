<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : populationMove.jsp
  * @Description : 대시보드 - 인구 전입,전출 및 순이동 페이지
  * @Modification Information
  *
  *  수정일         수정자         수정내용
  *  -------       -------------   ----------------------
  *  2021.07.19.      김부권          최초 생성
  */
%>	


<div id="container">
	<div class="location">
		<ul class="page_navi">
			<li><span class="pt2">인구현황</span></li>
			<li class="current_page">유동인구 현황</li>
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
					
					<div class="col2 coline_r">
						<div class="flow_area01">
							<h3 class="did_title">행정동별 유동인구 <span class="add_note">(단위: 명)</span></h3>
							<div class="chart_wrap po_rel">
								<p class="move_info">* 각 행정동을 클릭하시면 우측과 하단에 상세한<br /> &nbsp;&nbsp;&nbsp;유동인구 정보를 보실 수 있습니다.</p>
								<p class="bt_xs b_gray57 ext_move_bottom"><a id="btnTotalSearch">의정부시 전체</a></p>
								<div id="mapLegend" class="remark_map flow_grp01">
									<!-- <ul>
										<li><span class="rm01"></span> #e5eece</li>
										<li><span class="rm02"></span> #c3d682</li>
										<li><span class="rm03"></span> #96c64a</li>
										<li><span class="rm04"></span> #4aa83d</li>
										<li><span class="rm05"></span> #29762b</li>
									</ul> -->
								</div>
								<div id="popEmdTime" class="graph_451"></div>
							</div>
						</div>
					</div>
					
					<div class="col2">
						<div class="flow_area02">
							<h3 class="did_title"><span class="searchName">의정부시</span> 요일별 유동인구 <span class="add_note">(단위: 명)</span></h3>
							<div class="chart_wrap">
								<div id="popDayFlow" class="graph_451"></div>
							</div>
						</div>
					</div>
					
					<div class="col2 coline_t coline_r">
						<div class="flow_area03">
							<h3 class="did_title"><span class="searchName">의정부시</span> 성 연령별 유동인구 <span class="add_note">(단위: 명)</span></h3>
							<div class="chart_wrap">
								<div id="popGenderFlow" class="graph_320"></div>
							</div>
						</div>
					</div>
					
					<div class="col2 coline_t">
						<div class="flow_area04">
							<h3 class="did_title"><span class="searchName">의정부시</span> 거주지별 생활인구/서비스인구 <span class="add_note">(단위: 명)</span></h3>
							<div id="" class="chart_wrap">
								<div id="popRegService" class="graph_320"></div>
								<!-- <ul class="list_title">
									<li style="width:19.7%">행정동</li>
									<li style="width:79%">거주지</li>
								</ul>
								<div class="roll_list">
									<table class="view_table bt0" summary="거주지별 인구리스트">
										<caption>거주지별 인구리스트</caption>
										<colgroup>
											<col width="20%" />
											<col width=" " />
										</colgroup>
										<tbody>
											<tr>
												<th rowspan="10">의정부시</th>
												<td><img src="image/population/flow_grp04.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<td><img src="image/population/flow_grp04.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<td><img src="image/population/flow_grp04.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<td><img src="image/population/flow_grp04.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<td><img src="image/population/flow_grp04.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<td><img src="image/population/flow_grp04.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<td><img src="image/population/flow_grp04.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<td><img src="image/population/flow_grp04.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<td><img src="image/population/flow_grp04.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<td><img src="image/population/flow_grp04.png" alt="그래프예시" /></td>
											</tr>
										</tbody>
									</table>
								</div> -->
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
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/population/populationFlow.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquer.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.mockjax.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.orgchart.js"></script>
     --%>
     