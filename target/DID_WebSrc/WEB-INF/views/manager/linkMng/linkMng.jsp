<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : complain_dept.jsp
  * @Description : 부서/직위 권한 관리자 페이지
  * @Modification Information
  *
  *  수정일         수정자         수정내용
  *  -------       -------------   ----------------------
  *  2020.07.03.      전동표          최초 생성
  */
%>	

	<section id="container">
			<h2>연계 상태 검색</h2>
			
			<div class="admin_content">
				<div class="left_area">
					
					<div class="search_wrap mt0">
						<ul>
							<li class="wd85">
								<span class="sch_title">연계 주기</span>
								<select id="cycle" class="select_sch">
									<option value=""></option>
								</select>
							</li>
							<li class="wd7"><a id="btnCycleSearch" href="#" class="sch_button">검색</a></li>
						</ul>
					</div>
					
					<div class="table_area">
						<table class="admin_list" summary="연계상태 검색을 위한 리스트 테이블">
							<caption>연계상태 검색을 위한 현황 리스트</caption>
							<colgroup>
								<col width="10%" />
								<col width=" " />
								<col width="16%" />
								<col width="16%" />
							</colgroup>
							<thead>
								<tr>
									<th>번호</th>
									<th>연계명</th>
									<th>연계 구분</th>
									<th>연계 주기</th>
									<th>연계  정상여부</th>
								</tr>
							</thead>
							<tbody id="cycleDataList">
							</tbody>
						</table>
					</div>
				</div>
				<div class="right_area">
					<div class="search_wrap mt0">
						<ul>
							<li class="wd40">
								<p class="calendar_area" style="position:relative;"><!-- <div style="position:relative;"> -->
									<input type="text" id="targetMonth" class="input_sch dateSelect"  value=""   />
								<!-- </div> -->
								</p>
								<!-- <input type="text" class="input_sch" /> -->
							</li>
							<li class="wd45">
								<span class="sch_title">상태</span>
								<select id="statusList" class="select_sch">
									<option value=""></option>
								</select>
							</li>
							<li class="wd7"><a href="#" id="btnLogSearch" class="sch_button">검색</a></li>
						</ul>
					</div>
					
					<div class="table_area">
						<table class="admin_list" summary="연계상태 검색을 위한 리스트 테이블">
							<caption>연계상태 검색을 위한 현황 리스트</caption>
							<colgroup>
								<col width=" " />
								<col width="16%" />
								<col width="16%" />
								<col width="16%" />
							</colgroup>
							<thead>
								<tr>
									<th>테이블 내용</th>
									<th>테이블 상태</th>
									<th>이벤트 일자</th>
									<th>이벤트 시간</th>
								</tr>
							</thead>
							<tbody id="logList">
								<!-- <tr>
									<td class="t_l lh_160">
										ead_inf_119_mstr연계 연결 실행<br />
										ead_inf_119_mstr 연계 연결 실패<br />
										ead_inf_119_mstr 연계 연결 성공
									</td>
									<td>2021.7.21</td>
									<td>01:00</td>
									<td>사용자</td>
								</tr> -->
							</tbody>
						</table>
					</div>
					
				</div>
			</div>
			
			
		</section>
		
		
		
		<!-- Page 스크립트 -->
	<script src="${pageContext.request.contextPath}/pageJs/manager/linkMng/linkMng.js"></script>
		