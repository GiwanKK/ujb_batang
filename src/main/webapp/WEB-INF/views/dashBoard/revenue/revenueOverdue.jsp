<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : revenueOverdue.jsp
  * @Description : 대시보드 - 체납 및 수납 현황 페이지
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
			<li class="current_page">체납 및 수납 현황</li>
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
						<h3 class="did_title">행정동별 체납 및 수납 현황</h3>
						<div id="revnMap" class="overdue_map">
							<ul class="select_map">
								<li><input type="radio" name="iptDue" id="iptDueIn" value="1" class="rd" checked="checked"> <label for="iptDueIn">체납</label></li>
								<li><input type="radio" name="iptDue" id="iptDueOut" value="2" class="rd"> <label for="iptDueOut">수납</label></li>
							</ul>
							<p class="bt_xs b_gray57 ext_move_bottom"><a id="btnTotalSearch">의정부시 전체</a></p>
							<div id="mapLegend" class="remark_map tax_map01">
								<!-- <ul>
									<li><span class="rm01"></span> #dceff0</li>
									<li><span class="rm02"></span> #a0d7d3</li>
									<li><span class="rm03"></span> #56b6bb</li>
									<li><span class="rm04"></span> #5691bb</li>
									<li><span class="rm05"></span> #5677bb</li>
								</ul> -->
							</div>
						</div>
						
						<div class="overdue_desc">
							<ul class="list_title">
								<li style="width:9.9%">No.</li>
								<li style="width:29.6%">징수세목명</li>
								<li style="width:19.6%">본세 <span class="tiny_12">(원)</span></li>
								<li style="width:19.7%">가산세 <span class="tiny_12">(원)</span></li>
								<li style="width:19.6%">총액 <span class="tiny_12">(원)</span></li>
							</ul>
							<div class="overdue_list">
								<table id="revnOverdueTable" class="sm_table bt0" summary="체납현황 리스트">
									<!-- <caption>체납현황 리스트 테이블</caption>
									<colgroup>
										<col width="10%" />
										<col width=" " />
										<col width="20%" />
										<col width="20%" />
										<col width="20%" />
									</colgroup>
									<tbody>
										<tr>
											<td>1</td>
											<td>취득세(부동산)</td>
											<td class="t_r">14,971,957,180</td>
											<td class="t_r">14,971,957,180</td>
											<td class="t_r">14,971,957,180</td>
										</tr>
									</tbody> -->
								</table>
							</div>
						</div>
					</div>
					
					<div class="col3">
						
						<div class="right_subchart">
							<p class="subtitle">1. <span>의정부시</span> 연도별 <span class="sortName">체납</span> 현황 <span class="tiny_12">(최근 10년간)</span></p>
							<div id="revnOverdueYear" class="graph_268"></div>
						</div>
						
						<div class="right_subchart4">
							<p class="subtitle">2. <span class="searchName">의정부시</span> <span class="searchYear"></span> 세목별 <span class="sortName">체납</span> 현황</p>
							<div id="revnOverdueStatus" class="overdue_items">
								<!-- <ul class="list_title">
									<li style="width:28.9%">세목명</li>
									<li style="width:19.7%">행정동명</li>
									<li style="width:48.3%">체납액</li>
								</ul>
								<div class="items_list">
									<table class="view_table bt0" summary="거주지별 인구리스트">
										<caption>거주지별 인구리스트</caption>
										<colgroup>
											<col width="30%" />
											<col width="20%" />
											<col width=" " />
										</colgroup>
										<tbody>
											<tr>
												<th class="t_l" rowspan="2">지방소득세(양도소득)</th>
												<th class="t_l">호원2동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th class="t_l">흥선동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th class="t_l" rowspan="14">지방소득세(종합소득)</th>
												<th class="t_l">가동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th class="t_l">녹동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th class="t_l">송산1동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th class="t_l">송산2동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th class="t_l">송산3동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th class="t_l">신곡1동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th class="t_l">신곡2동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th class="t_l">흥선동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th class="t_l">흥선동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th class="t_l">흥선동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th class="t_l">흥선동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th class="t_l">흥선동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
											<tr>
												<th class="t_l">흥선동</th>
												<td class="t_l"><img src="image/tax/graph_06.png" alt="그래프예시" /></td>
											</tr>
										</tbody>
									</table> -->
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
    <script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/revenue/revenueOverdue.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquer.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.mockjax.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.orgchart.js"></script>
     --%>
     