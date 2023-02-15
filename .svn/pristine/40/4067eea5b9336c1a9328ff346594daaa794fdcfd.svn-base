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
			<h2>데이터 현황 관리</h2>
			<div class="search_wrap">
				<ul>
					<li>
						<span class="sch_title">스키마</span>
						<select id="schmaName" class="select_sch">
							<option value=""></option>
						</select>
					</li>
					<li class="wd60">
						<span class="sch_title">테이블명</span>
						<input id="tableName" type="text" class="input_sch" />
					</li>
					<li class="wd7"><a href="#" id="btnTableSearch" class="sch_button">검색</a></li>
				</ul>
			</div>
			
			<div class="table_area">
				<table class="admin_list tiny_space" summary="데이터 테이블 관리를 위한 리스트">
					<caption>데이터 테이블 관리 테이블</caption>
					<colgroup>
						<col width="30%" />
						<col width="" />
					</colgroup>
					<thead>
						<tr>
							<th>테이블명</th>
							<th>테이블 설명</th>
						</tr>
					</thead>
					<tbody id="schmaTableList">
					</tbody>
				</table>
				<div class="paging" id="paging">
					<!-- <a href="#" class="first">처음페이지</a>
					<a href="#" class="prev">이전페이지</a>
					<a href="#" class="on">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<a href="#">5</a>
					<a href="#" class="next">다음페이지</a>
					<a href="#" class="last">마지막페이지</a> -->
				</div>
			</div>
			<div class="admin_content">
				<h3>데이터 건수</h3>
				<div id="schmaChart" class="graph_250"></div>
			</div>
			
		</section>
		
		<script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
		<script src="${pageContext.request.contextPath}/pageJs/manager/inDataMng/dataStatus.js"></script>