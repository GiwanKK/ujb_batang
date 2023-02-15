<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : populationStatic.jsp
  * @Description : 대시보드 - 인구 통계 페이지
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
					<li class="current_page">인구 통계</li>
				</ul>
				<%-- <p class="search_box">
					<input type='text' class="form-control dateSelect" name="startDate" id="startDate" value="${date.max }" />
					<span class="search_tip">(보유 데이터 : ${date.min } ~ ${date.max })</span>
					<input type="hidden" id="start" value="${date.min }" >
					<input type="hidden" id="end" value="${date.max }" >
					<!-- <input type="text" class="base_ipt" placeholder="검색일자를 선택하세요" /> -->
				</p> --%>
				<span class="add_note" id="maxDate"></span>
			</div>
			
			<div class="content_wrap">
				<div class="content">
					
					<div class="col3_2 coline_r">
						<div class="popl_total">
							<h3 class="did_title">인구현황 <span class="add_note">(합계단위: 명, 전월대비 단위: 명)</span></h3>
							<div class="conlist_wrap">
								
								<div class="con_box">
									<dl class="top_b_box">
										<dt>총 인구</dt>
										<dd id="popTotal" class="c_yellow">516</dd>
									</dl>
									<dl class="bottom_s_box">
										<dt>성비</dt>
										<dd id="popGenderRate">100.5</dd>
									</dl>
									<dl class="bottom_s_box">
										<dt>성장률</dt>
										<dd><img class="rateImg" src="/dist/images/population/ico_up.png" alt="그래프예시" /><span id="popTotalIncrease" class="rate_up">9.0</span> <span class="txt_unit">%</span></dd>
									</dl>
								</div>
								
								<div class="con_box">
									<dl class="top_b_box">
										<dt>남성</dt>
										<dd id="popMan">259</dd>
									</dl>
									<dl class="bottom_s_box">
										<dt>전월대비</dt>
										<dd id="popManMonth">90,140</dd>
									</dl>
									<dl class="bottom_s_box">
										<dt>성장률</dt>
										<dd><img class="rateImg" src="/dist/images/population/ico_up.png" alt="그래프예시" /><span id="popManIncrease" class="rate_up">3.8</span> <span class="txt_unit">%</span></dd>
									</dl>
								</div>
								
								<div class="con_box">
									<dl class="top_b_box">
										<dt>여성</dt>
										<dd id="popWoman">258</dd>
									</dl>
									<dl class="bottom_s_box">
										<dt>전월대비</dt>
										<dd id="popWomanMonth">97,865</dd>
									</dl>
									<dl class="bottom_s_box">
										<dt>성장률</dt>
										<dd><img class="rateImg" src="/dist/images/population/ico_up.png" alt="그래프예시" /><span id="popWomanIncrease" class="rate_up">5.0</span> <span class="txt_unit">%</span></dd>
									</dl>
								</div>
								
								<div class="con_box">
									<dl class="top_b_box">
										<dt>전입</dt>
										<dd id="popIncome" class="c_aqua">19</dd>
									</dl>
									<dl class="bottom_s_box">
										<dt>전월대비</dt>
										<dd id="popIncomeMonth">0</dd>
									</dl>
									<dl class="bottom_s_box">
										<dt>성장률</dt>
										<dd><img class="rateImg" src="/dist/images/population/ico_up.png" alt="그래프예시" /><span id="popIncomeIncrease" class="rate_0">0</span> <span class="txt_unit">%</span></dd>
									</dl>
								</div>
								
								<div class="con_box">
									<dl class="top_b_box">
										<dt>전출</dt>
										<dd id="popOut" class="c_orange">16</dd>
									</dl>
									<dl class="bottom_s_box">
										<dt>전월대비</dt>
										<dd id="popOutMonth">3,189</dd>
									</dl>
									<dl class="bottom_s_box">
										<dt>성장률</dt>
										<dd><img class="rateImg" src="/dist/images/population/ico_up.png" alt="그래프예시" /><span id="popOutIncrease" class="rate_down">2.7</span> <span class="txt_unit">%</span></dd>
									</dl>
								</div>
								
							</div>
						</div>
					</div>
					
					<div class="col3">
						<div class="popl_course">
							<h3 class="did_title">총 인구 추이 <span class="add_note">(단위: 명)</span></h3>
							<div class="chart_wrap">
								<!-- <p class="remark"><span class="rm_man">남성</span> <span class="rm_woman">여성</span></p> -->
								<div id="popTotalTrend" class="graph_221"></div>
							</div>
						</div>
					</div>

					<div class="col3_2 coline_t coline_r">
						<div class="popl_age">
							<h3 class="did_title">연령별 인구현황 <span class="add_note">(단위: 명, *성비: 인구의 성별)</span></h3>
							<div class="data_wrap">
								<div class="data_left">
									<table id="popAgeStatusGrid" class="list_table" summary="연령별 인구현황 리스트">
										
									</table>
								</div>
								<div id="popAgeStatus" class="data_right">
								</div>
							</div>
						</div>
					</div>
					
					<div class="col3 coline_t">
						<div class="popl_sex">
							<h3 class="did_title">연령별 남녀구성</h3>
							<div class="chart_wrap">
								<div class="popManStatusTitle">- 남성</div>
								<div id="popManStatus" class="sex_graph grp_m"></div>
								<div class="popWomanStatusTitle">- 여성</div>
								<div id="popWomanStatus" class="sex_graph grp_w"></div>
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
    <script src="${pageContext.request.contextPath}/dist/js/common/grid.js"></script>	
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/population/populationStatic.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquer.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.mockjax.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.orgchart.js"></script>
     --%>
     