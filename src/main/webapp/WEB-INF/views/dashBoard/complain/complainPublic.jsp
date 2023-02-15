<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : complainPublic.jsp
  * @Description : 대시보드 - 여론 분석 페이지
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
			<li><span class="pt2">여론 및 민원 현황</span></li>
			<li class="current_page">여론 분석</li>
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
					
					<div class="col1">
						<div class="anal_area01">
							<h3 class="did_title">여론 현황  <span class="add_note">(키워드 TOP10)</span></h3>
							<p class="keyword_tip">* 아래 키워드를 클릭하시면 하단에 관련 데이터를 보실 수 있습니다.</p>
							<div id="compPublicStatus" class="keyword_wrap">
								
								<!-- <div class="keyword_area" >
									<p class="box_num">1</p>
									<div class="keyword_box on" onClick="">
										<dl class="kw_100">
											<dt>주정차</dt>
											<dd>52,421<span class="add_unit">건</span></dd>
										</dl>
										<dl class="kw_50 dotline_r">
											<dt>긍정률</dt>
											<dd class="c_orange">0.1%</dd>
										</dl>
										<dl class="kw_50">
											<dt>부정률</dt>
											<dd class="c_aqua">99.9%</dd>
										</dl>
									</div>
								</div>
								
								<div class="keyword_area">
									<p class="box_num">2</p>
									<div class="keyword_box">
										<dl class="kw_100">
											<dt>주정차</dt>
											<dd>52,421<span class="add_unit">건</span></dd>
										</dl>
										<dl class="kw_50 dotline_r">
											<dt>긍정률</dt>
											<dd class="c_orange">0.1%</dd>
										</dl>
										<dl class="kw_50">
											<dt>부정률</dt>
											<dd class="c_aqua">99.9%</dd>
										</dl>
									</div>
								</div>
								
								<div class="keyword_area">
									<p class="box_num">3</p>
									<div class="keyword_box">
										<dl class="kw_100">
											<dt>주정차</dt>
											<dd>52,421<span class="add_unit">건</span></dd>
										</dl>
										<dl class="kw_50 dotline_r">
											<dt>긍정률</dt>
											<dd class="c_orange">0.1%</dd>
										</dl>
										<dl class="kw_50">
											<dt>부정률</dt>
											<dd class="c_aqua">99.9%</dd>
										</dl>
									</div>
								</div>
								
								<div class="keyword_area">
									<p class="box_num">1</p>
									<div class="keyword_box">
										<dl class="kw_100">
											<dt>주정차</dt>
											<dd>52,421<span class="add_unit">건</span></dd>
										</dl>
										<dl class="kw_50 dotline_r">
											<dt>긍정률</dt>
											<dd class="c_orange">0.1%</dd>
										</dl>
										<dl class="kw_50">
											<dt>부정률</dt>
											<dd class="c_aqua">99.9%</dd>
										</dl>
									</div>
								</div>
								
								<div class="keyword_area">
									<p class="box_num">1</p>
									<div class="keyword_box">
										<dl class="kw_100">
											<dt>주정차</dt>
											<dd>52,421<span class="add_unit">건</span></dd>
										</dl>
										<dl class="kw_50 dotline_r">
											<dt>긍정률</dt>
											<dd class="c_orange">0.1%</dd>
										</dl>
										<dl class="kw_50">
											<dt>부정률</dt>
											<dd class="c_aqua">99.9%</dd>
										</dl>
									</div>
								</div>
								
								<div class="keyword_area">
									<p class="box_num">1</p>
									<div class="keyword_box">
										<dl class="kw_100">
											<dt>주정차</dt>
											<dd>52,421<span class="add_unit">건</span></dd>
										</dl>
										<dl class="kw_50 dotline_r">
											<dt>긍정률</dt>
											<dd class="c_orange">0.1%</dd>
										</dl>
										<dl class="kw_50">
											<dt>부정률</dt>
											<dd class="c_aqua">99.9%</dd>
										</dl>
									</div>
								</div>
								
								<div class="keyword_area">
									<p class="box_num">1</p>
									<div class="keyword_box">
										<dl class="kw_100">
											<dt>주정차</dt>
											<dd>52,421<span class="add_unit">건</span></dd>
										</dl>
										<dl class="kw_50 dotline_r">
											<dt>긍정률</dt>
											<dd class="c_orange">0.1%</dd>
										</dl>
										<dl class="kw_50">
											<dt>부정률</dt>
											<dd class="c_aqua">99.9%</dd>
										</dl>
									</div>
								</div>
								
								<div class="keyword_area">
									<p class="box_num">1</p>
									<div class="keyword_box">
										<dl class="kw_100">
											<dt>주정차</dt>
											<dd>52,421<span class="add_unit">건</span></dd>
										</dl>
										<dl class="kw_50 dotline_r">
											<dt>긍정률</dt>
											<dd class="c_orange">0.1%</dd>
										</dl>
										<dl class="kw_50">
											<dt>부정률</dt>
											<dd class="c_aqua">99.9%</dd>
										</dl>
									</div>
								</div>
								
								<div class="keyword_area">
									<p class="box_num">1</p>
									<div class="keyword_box">
										<dl class="kw_100">
											<dt>주정차</dt>
											<dd>52,421<span class="add_unit">건</span></dd>
										</dl>
										<dl class="kw_50 dotline_r">
											<dt>긍정률</dt>
											<dd class="c_orange">0.1%</dd>
										</dl>
										<dl class="kw_50">
											<dt>부정률</dt>
											<dd class="c_aqua">99.9%</dd>
										</dl>
									</div>
								</div>
								
								<div class="keyword_area">
									<p class="box_num">10</p>
									<div class="keyword_box">
										<dl class="kw_100">
											<dt>주정차</dt>
											<dd>52,421<span class="add_unit">건</span></dd>
										</dl>
										<dl class="kw_50 dotline_r">
											<dt>긍정률</dt>
											<dd class="c_orange">0.1%</dd>
										</dl>
										<dl class="kw_50">
											<dt>부정률</dt>
											<dd class="c_aqua">99.9%</dd>
										</dl>
									</div>
								</div> -->
								
							</div>
						</div>
					</div>
					
					<div class="col1 coline_t pd0">
						
						<div class="col4 coline_r">
							<div class="anal_area02">
								<p class="subtitle">1. 키워드 관련 글</p>
								<ul class="list_title">
									<li style="width:10%">No.</li>
									<li style="width:36%">제목</li>
									<li style="width:16%">원문보기</li>
									<li style="width:20%">수집일자</li>
									<li style="width:16%">미디어</li>
								</ul>
								<div class="kw_list">
									<table id="compPublicKeyword" class="sm_table bt0" summary="키워드 관련 리스트">
										<!-- <caption>키워드 관련 테이블</caption>
										<colgroup>
											<col width="10%" />
											<col width=" " />
											<col width="16%" />
											<col width="20%" />
											<col width="16%" />
										</colgroup> -->
										<!-- <tbody>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
											<tr>
												<td>1</td>
												<td>불법 주정차 신고 방법불법 주정차 신고 방법</td>
												<td><a href="#" class="bt_tbl c_aquab">원문보기</a></td>
												<td>2021.06.23</td>
												<td>블로그</td>
											</tr>
										</tbody> -->
									</table>
								</div>
							</div>
						</div>
						
						<div class="col4_3 pd0">
							
							<div class="col1">
								<div class="anal_area03">
									<p class="subtitle">2. 일별 언급량 추이</p>
									<div id="compPublicDay" class="grp_180"></div>
								</div>
							</div>
							<div class="col2 coline_t coline_r">
								<div class="anal_area04">
									<p class="subtitle">3. 워드 클라우드</p>
									<div id="compPublicWordcloud" class="grp_333"></div>
								</div>
							</div>
							<div class="col2 coline_t">
								<div class="anal_area05">
									<p class="subtitle">4. 연관어 분석</p>
									<div id="compPublicRelate" class="grp_333"></div>
								</div>
							</div>
							
						</div>
					</div>
					
				</div>
			</div>
	
	<!-- <div class="content_wrap">
		<div class="content">
			<div style="width: 100%; height: 30%; min-height: 300px; float: left;">
				<div style="width:100%; height: 100%;">
					<div style="width: 100%; height: 30px;">
						<h2 style="display: inline-block; float : left; font-size:16px;">여론 현황</h2><span style="display: inline-block; float : left; font-size:12px; padding-top: 3px;"></span>
						
					</div>
					chart영역
					<div id="compPublicStatus" style="width: 100%; height: 100%; min-height: 400px;">
					
					</div>
				</div>
			</div>
			
			<div style="width: 30%; height: 30%; min-height: 600px; float: left;">
				<div style="width:100%; height: 100%;">
					<div style="width: 100%; height: 30px;">
						<h2 style="display: inline-block; float : left; font-size:16px;">키워드 관련 글</h2>
					</div>
					chart영역
					<div id="compPublicKeyword" style=";width: 100%; height: 100%; min-height: 600px;">
					
					</div>
				</div>
			</div>
			
			<div style="width: 70%; height: 30%; min-height: 250px; float: right;">
				<div style="width:100%; height: 100%;">
					<div style="width: 100%; height: 30px;">
						<h2 style="display: inline-block; float : left; font-size:16px;">일별 언급량 추이</h2><span style="display: inline-block; float : left; font-size:12px; padding-top: 3px;"></span>
					</div>
					chart영역
					<div id="compPublicDay" style="width: 100%; height: 100%; min-height: 400px;">
					
					</div>
				</div>
			</div>
			
			<div style="width: 70%; height: 30%; min-height: 430px; float: right;">
				<div style="float:left;width:50%; height: 100%; min-height: 430px;">
					<div style="width: 100%; height: 30px;">
						<h2 style="display: inline-block; float : left; font-size:16px;">워드 클라우드</h2><span style="display: inline-block; float : left; font-size:12px; padding-top: 3px;"></span>
					</div>
					chart영역
					<div id="compPublicWordcloud" style="width: 100%; height: 100%; min-height: 400px;">
					
					</div>
					
				</div>
				<div style="float:right;width:50%; height: 100%;">
					<div style="width: 100%; height: 30px;">
						<h2 style="display: inline-block; float : left; font-size:16px;">연관어 분석</h2><span style="display: inline-block; float : left; font-size:12px; padding-top: 3px;"></span>
					</div>
					chart영역
					<div id="compPublicRelate" style="width: 100%; height: 100%; min-height: 400px;">
					
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
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/complain/complainPublic.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/grid.js"></script>	
    <script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquer.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.mockjax.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.orgchart.js"></script>
     --%>
     