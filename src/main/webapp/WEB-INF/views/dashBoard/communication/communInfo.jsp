<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : communInfo.jsp
  * @Description : 대시보드 - 소통정보 > 소통정보 페이지
  * @Modification Information
  *
  *     수정일                   수정자                          수정내용
  *  -----------   -------------   ----------------------
  *  2021.08.26        김혜림                          최초 생성
  */
%>	

	<div id="container">
			<div class="location">
				<ul class="page_navi">
					<li><span class="pt2">교통 및 CCTV 현황</span></li>
					<li class="current_page">교통 정보 <span id="createdDate" class="tiny_12" style="line-height: 160%;">(실시간 교통 현황)</span></li>
				</ul>
				<!-- <p class="search_box">
					<input type="text" class="base_ipt" placeholder="검색일자를 선택하세요" />
				</p> -->
			</div>
			
			<div class="content_wrap">
				<div class="content">
					
					<div class="col1">
						<div class="traffic_all">
							<div class="traffic_remark">
								<table class="remark_table">
									<colgroup>
										<col width="20%" />
										<col width="20%" />
										<col width="20%" />
										<col width="20%" />
										<col width="20%" />
									</colgroup>
									<thead>
										<tr>
											<th>(km/h)</th>
											<th>도시부</th>
											<th>지방부</th>
											<th>도시고속</th>
											<th>고속도로</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th class="tf_lv1">원활</th>
											<td>25이상</td>
											<td>50이상</td>
											<td>50이상</td>
											<td>80이상</td>
										</tr>
										<tr>
											<th class="tf_lv2">서행</th>
											<td>15~25</td>
											<td>30~50</td>
											<td>30~50</td>
											<td>40~80</td>
										</tr>
										<tr>
											<th class="tf_lv3">정체</th>
											<td>15미만</td>
											<td>30미만</td>
											<td>30미만</td>
											<td>40미만</td>
										</tr>
										<tr>
											<th>정보없음</th>
											<td colspan="4">대상정보없음</td>
										</tr>
									</tbody>
								</table>
							</div>
							
							<div id="ujbMap" class="traffic_map"></div>
								<p class="bt_xs b_gray57 ext_move_lt"><a id="btnRefresh">새로고침</a></p>

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
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/communication/communInfo.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/commonUtil.js"></script>	
    <script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>	
		