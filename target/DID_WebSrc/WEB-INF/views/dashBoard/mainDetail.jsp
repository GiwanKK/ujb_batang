<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : mainDetail.jsp
  * @Description : 대시보드 메인 상세보기 페이지
  * @Modification Information
  *
  *     수정일                   수정자                          수정내용
  *  -----------   -------------   ----------------------
  *  2021.10.15        김부권                          최초 생성
  */
%>	
		<div id="container">
			<div class="location">
				<ul class="page_navi">
					<li><span class="pt2">의정부 도시 현황</span></li>
					<li class="current_page">의정부 도시 현황</li>
				</ul>
			</div>
			
			<div class="content_wrap">
				<div class="content">
					
					<div class="col1">
						
						<div class="detatil_all">
							<div class="dong_tab">
								<select id="dongList" class="select02">
									<!-- <option value="">녹양동</option>
									<option value="">가능동</option>
									<option value="">흥선동</option>
									<option value="">의정부2동</option>
									<option value="">호원2동</option>
									<option value="">호원1동</option>
									<option value="">장암동</option>
									<option value="">신곡1동</option>
									<option value="">의정부1동</option>
									<option value="">신곡2동</option>
									<option value="">자금동</option>
									<option value="">송산3동</option>
									<option value="">송산2동</option>
									<option value="">송산1동</option> -->
								</select>
							</div>
							<div id="detailMap" class="detail_map">
							</div>
							<input type="hidden" id="dongName" value="${dongName}">
							<input type="hidden" id="tp" value="${tp}">
							<div class="selc_detail">
								<ul class="selc_list">
									<li class="on"><a href="javascript:;" class="d_treePark">공원수목</a></li>
									<li class="on"><a href="javascript:;" class="d_tree">가로수</a></li>
									<li class="on"><a href="javascript:;" class="d_crosswalk">횡단보도</a></li>
									<li class="on"><a href="javascript:;" class="d_traffic_light">신호등</a></li>
									<li class="on"><a href="javascript:;" class="d_guide_sign">안내표지</a></li>
									<li class="on"><a href="javascript:;" class="d_safety">안전표지</a></li>
									<li class="on"><a href="javascript:;" class="d_emergency_bell">안전비상벨</a></li>
									<li class="on"><a href="javascript:;" class="d_cctv">CCTV</a></li>
									<li class="on"><a href="javascript:;" class="d_nursery">어린이집</a></li>
									<li class="on"><a href="javascript:;" class="d_children_safety">어린이 보호구역</a></li>
									<li class="on"><a href="javascript:;" class="d_firewater">소방용수시설</a></li>
									<li class="on"><a href="javascript:;" class="d_parking">주차장</a></li>
									<li class="on"><a href="javascript:;" class="d_wifi">무료와이파이</a></li>
								</ul>
							</div>
						</div>
						
					</div>
                    
				</div>
			</div>
			
		</div>

<!-- js 라이브러리 -->
<script src="${pageContext.request.contextPath}/dist/js/common/jquery-ui.min.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/common/interact.min.js"></script>
<%-- 	<script src="${pageContext.request.contextPath}/dist/js/common/d3/d3_v5.min.js"></script> --%>
	<script src="${pageContext.request.contextPath}/dist/js/common/etc/loading/ajax-loading.js"></script>
     <script src="${pageContext.request.contextPath}/pageJs/dashBoard/mainDetail.js"></script>
    	        
    <script src="${pageContext.request.contextPath}/dist/js/common/commonUtil.js"></script>	
    <script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>	
		