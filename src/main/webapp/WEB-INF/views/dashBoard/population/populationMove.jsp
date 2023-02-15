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
				<li class="current_page">전입,전출 및 순이동</li>
			</ul>
			<p class="search_box">
				<input type='text' class="form-control dateSelect" name="startDate" id="startDate" value="${date.max }" />
				<span class="search_tip">(보유 데이터 : ${date.min } ~ ${date.max })</span>
				<%-- <span>(검색 조건 기간 : ${date.min } ~ ${date.max })</span> --%>
				<input type="hidden" id="start" value="${date.min }" >
				<input type="hidden" id="end" value="${date.max }" >
			</p>
		</div>
	
		<div class="content_wrap">
				<div class="content">
					
					<div class="col2 coline_r pd0">
						<div class="col1">
							<h3 class="did_title">월별 전입/전출 순이동 인구 <span class="add_note">(단위: 명)</span></h3>
							<div class="chart_wrap">
								<div class="move_area01">
									<p class="deco_bird">새장식</p>
									<p class="deco_leaf">나뭇잎장식</p>
									<div class="movedata_all">
										
										<div class="move_in">
											<dl class="move_box">
												<dt>전입</dt>
												<dd id="moveIn" class="move_num c_aqua">243</dd>
												<dd><span class="move_perc">이동률 <b id="moveInRate" class="pl10">13.3</b></span></dd>
											</dl>
										</div>
										
										<div class="move_center">
											<dl class="move_box">
												<dt>순이동</dt>
												<dd id="move" class="move_num">-14</dd>
												<dd><span class="move_perc">이동률 <b id="moveRate" class="pl10">-0.8</b></span></dd>
											</dl>
										</div>
										
										<div class="move_out">
											<dl class="move_box">
												<dt>전출</dt>
												<dd id="moveOut" class="move_num c_orange">257</dd>
												<dd><span class="move_perc">이동률 <b id="moveOutRate" class="pl10">14</b></span></dd>
											</dl>
										</div>
										
									</div>	
								</div>
							</div>
						</div>
						<div class="col1 coline_t po_rel">
							<h3 class="did_title">10년 전입, 전출 현황 <span class="add_note">(단위: 명)</span></h3>
							<!-- tooltip -->
							<div class="tip_loc">
								<div class="info_tip">
									<span class="ico_tip">?</span>
									<div class="tooltip-content">
										<ul class="tip_desc">
											<li class="bullet_blue"><span class="c_blue">전입</span> : 행정구역 경계(시도,시군구,읍면동)를 넘어 
              								다른 지역에서 특정 지역으로 이동해 온 경우</li>
											<li class="bullet_orange"><span class="c_orange">전출</span> : 행정구역 경계(시도,시군구,읍면동)를 넘어 
              								특정 지역에서 다른 지역으로 이동해 온 경우</li>
											<li><span>순이동</span> : 전입과 전출의 차이(전국의 순이동은 0)</li>
											<li><span>이동률</span> : 주민등록인구(거주자) 100명당 이동자의 수</li>
										</ul>
									</div>
								</div>
							</div>
							
							<div class="chart_wrap">
								<div id="popMoveYear" class="move_area02"></div>
							</div>
						</div>
					</div>
					
					<div class="col2">
						<h3 class="did_title">동별 전입, 전출 현황 <span class="add_note">(단위: 명)</span></h3>
						<div class="subcon_all">
							
							<div class="subcon_area">
								<p class="subtitle">1. 전입현황</p>
								<div id="popIncomeStatus" class="sm_rollist">
									<!-- <table class="view_table" summary="전입현황 리스트">
										<caption>"전입현황 테이블입니다.</caption>
										<colgroup>
											<col width="20%" />
											<col width=" " />
										</colgroup>
										<tbody>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp02.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp02.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp02.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp02.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp02.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp02.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp02.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp02.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp02.png" alt="그래프예시" /></td>
											</tr>
										</tbody>
									</table> -->
								</div>
							</div>
							
							<div class="subcon_area ml2p">
								<p class="subtitle">2. 전출현황</p>
								<div id="popOutcomeStatus" class="sm_rollist">
									<!-- <table class="view_table" summary="전출현황 리스트">
										<caption>"전출현황 테이블입니다.</caption>
										<colgroup>
											<col width="20%" />
											<col width=" " />
										</colgroup>
										<tbody>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp03.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp03.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp03.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp03.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp03.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp03.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp03.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp03.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th>가능 1동</th>
												<td><img src="image/population/move_grp03.png" alt="그래프예시" /></td>
											</tr>
										</tbody>
									</table> -->
								</div>
							</div>
							
						</div>
						
						<!-- 전입,전출 (지도) -->
						<div class="subcon_bottom">
							<p class="subtitle">3. 전입,전출 (지도)</p>
							<div id="popMoveMap" class="move_map">
								<ul class="select_map">
									<li><input type="radio" name="iptMove" id="iptIn" value="1" checked="checked" class="rd"> <label for="iptIn">전입</label></li>
									<li><input type="radio" name="iptMove" id="iptOut" value="2" class="rd"> <label for="iptOut">전출</label></li>
								</ul>
								<p class="bt_xs b_gray57 ext_move"><a id="btnExtend" class="" href="#">관외 보기</a></p>
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
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/population/populationMove.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>	
    <%-- <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquer.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.mockjax.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.orgchart.js"></script>
     --%>
     