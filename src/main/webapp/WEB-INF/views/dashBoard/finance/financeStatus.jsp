<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : financeStatus.jsp
  * @Description : 대시보드 - 재정 현황 페이지
  * @Modification Information
  *
  *  수정일         수정자         수정내용
  *  -------       -------------   ----------------------
  *  2021.08.03.      김부권          최초 생성
  */
%>	


<div id="container">
	<div class="location">
		<ul class="page_navi">
			<li><span class="pt2">재정 현황</span></li>
			<li class="current_page">재정 현황</li>
		</ul>
		<p class="search_box">
			<input type='text' class="form-control dateSelect" name="startDate" id="startDate" value="${date.max }" />
			<span class="search_tip">(보유 데이터 : ${date.min+1 } ~ ${date.max })</span>
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
					
					<!-- tab -->
					<div class="tab_area">
						<ul class="tab_all">
							<li class="tab_link on" data-tab="tab-1">부서별 예산 현황</li>
							<li class="tab_link"  data-tab="tab-2">분야별 부문별 예산 현황</li>
							<li class="tab_link"  data-tab="tab-3">부서별 집행 현황</li>
							<li class="tab_link"  data-tab="tab-4">부서별 계약 현황</li>
						</ul>
					</div>
					
					<p class="finance_tip">* 그래프 상의 항목은 축약된 단어로 정확한 명칭은 하단의 재정 항목 안내에서 확인하실 수 있습니다.</p>
					
					<div id="tab-1" class="tab_content on">
						<div id="finStatusDept" class="graph_460"></div>
						<div class="finance_desc">
						
							<div class="fnc_all">
								<p class="subtitle">재정 현황 상세</p>
								<ul id="sortList" class="list_title">
									<li style="width:6%">No.</li>
									<li style="width:11%">부서명</li>
									<li style="width:11%">예산액 <span class="tiny_12">(억원)</span></li>
									<li style="width:11%">원인행위액 <span class="tiny_12">(억원)</span></li>
									<li style="width:10.5%">지출결의액 <span class="tiny_12">(억원)</span></li>
									<li style="width:6%">No.</li>
									<li style="width:11%">부서명</li>
									<li style="width:11%">예산액 <span class="tiny_12">(억원)</span></li>
									<li style="width:11.1%">원인행위액 <span class="tiny_12">(억원)</span></li>
									<li style="width:11%">지출결의액 <span class="tiny_12">(억원)</span></li>
								</ul>
								<div class="fnc_list">
									<table id="finStatusList" class="sm_table fnc01" summary="재정 항목 설명리스트">
										<!-- 
										
											<tr>
												<td>1</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>2</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>3</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>4</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>5</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>6</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>7</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>8</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>9</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>10</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
										</tbody> -->
									</table>
									<table id="finStatusList2" class="sm_table fnc02" summary="재정 항목 설명리스트">
										<!-- <caption>재정 항목 설명 테이블</caption>
										<colgroup>
											<col width="12.1%" />
											<col width="22.2%" />
											<col width="22.2%" />
											<col width="22.5%" />
											<col width="" />
										</colgroup>
										<tbody>
											<tr>
												<td>11</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>12</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>13</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>14</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>15</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>16</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>7</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>8</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>9</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr>
											<tr>
												<td>10</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="action">65,599,747,000</td>
												<td class="spend">34,315,076,700</td>
											</tr> -->
											
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					
					<div id="tab-2" class="tab_content">
						<div id="finStatusSort" class="graph_460"></div>
						<div class="finance_desc">
							<div class="fnc_left">
								<p class="subtitle">1. 재정 항목 안내</p>
								<ul class="list_title">
									<li style="width:40%">그래프 상 명칭(축약)</li>
									<li style="width:60%">실 명칭</li>
								</ul>
								<div class="fnc_list">
									<table id="finStatusSortName" class="sm_table bt0" summary="재정 항목 설명리스트">
										<!-- <caption>재정 항목 설명 테이블</caption>
										<colgroup>
											<col width="40%" />
											<col width=" " />
										</colgroup>
										<tbody>
											<tr>
												<td class="c_gray">입법</td>
												<td>입법및선거관리</td>
											</tr>
											<tr>
												<td class="c_gray">지방행정</td>
												<td>지방행정,재정 지원</td>
											</tr>
											<tr>
												<td class="c_gray">일반행정</td>
												<td>일반행정</td>
											</tr>
											<tr>
												<td class="c_gray">재난</td>
												<td>재난방재,민방위</td>
											</tr>
											<tr>
												<td class="c_gray">교육</td>
												<td>유아및 초중등교육</td>
											</tr>
											<tr>
												<td class="c_gray">직업</td>
												<td>평생직업교육</td>
											</tr>
											<tr>
												<td class="c_gray">문화</td>
												<td>문화예술</td>
											</tr>
											<tr>
												<td class="c_gray">관광</td>
												<td>관광</td>
											</tr>
										</tbody> -->
									</table>
								</div>
							</div>
							<div class="fnc_right">
								<p class="subtitle">2. 재정 현황 상세</p>
								<ul class="list_title">
									<li style="width:5.2%">No.</li>
									<li style="width:10.2%">대분류</li>
									<li style="width:11.2%">소분류</li>
									<li style="width:12.1%">예산현액</li>
									<li style="width:11.2%">지출액</li>
									<li style="width:5.2%">No.</li>
									<li style="width:10.2%">대분류</li>
									<li style="width:11.2%">소분류</li>
									<li style="width:12.2%">예산현액</li>
									<li style="width:11.2%">지출액</li>
								</ul>
								<div class="fnc_list">
									<table id="finStatusSortList" class="sm_table fnc01" summary="재정 항목 설명리스트">
										<!-- <caption>재정 항목 설명 테이블</caption>
										<colgroup>
											<col width="8%" />
											<col width="18%" />
											<col width="20%" />
											<col width=" " />
											<col width="20%" />
											<col width="11%" />
										</colgroup>
										<tbody>
											<tr>
												<td>1</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>2</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>3</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>4</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>5</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>6</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>7</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>8</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>9</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>10</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
										</tbody> -->
									</table>
									<table id="finStatusSortList2" class="sm_table fnc02" summary="재정 항목 설명리스트">
										<!-- <caption>재정 항목 설명 테이블</caption>
										<colgroup>
											<col width="8%" />
											<col width="18%" />
											<col width="20%" />
											<col width=" " />
											<col width="20%" />
											<col width="11%" />
										</colgroup>
										<tbody>
											<tr>
												<td>11</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>12</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>13</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>14</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>15</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>16</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>17</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>18</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>19</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
											<tr>
												<td>20</td>
												<td>유아 및 초중등교육</td>
												<td>유아 및 초중등교육</td>
												<td class="budget">￦65,599,747,000</td>
												<td class="spend">￦34,315,076,700</td>
												<td class="execute">0.37</td>
											</tr>
										</tbody> -->
									</table>
								</div>
							</div>
						</div>
					</div>
					
					<div id="tab-3" class="tab_content">
						<div id="finStatusExecution" class="graph_460"></div>
						<div class="finance_desc">
						
							<div class="fnc_all">
								<p class="subtitle">재정 현황 상세</p>
								<ul class="list_title">
									<li style="width:9%">No.</li>
									<li style="width:13.7%">부서명</li>
									<li style="width:13.6%">예산현액 <span class="tiny_12">(억원)</span></li>
									<li style="width:13.6%">지출액 <span class="tiny_12">(억원)</span></li>
									<li style="width:9%">No.</li>
									<li style="width:13.7%">부서명</li>
									<li style="width:13.6%">예산현액 <span class="tiny_12">(억원)</span></li>
									<li style="width:13.6%">지출액 <span class="tiny_12">(억원)</span></li>
								</ul>
								<div class="fnc_list">
									<table id="finExecutionList" class="sm_table fnc01" summary="재정 항목 설명리스트">
										<!-- <caption>재정 항목 설명 테이블</caption>
										<colgroup>
											<col width="12.1%" />
											<col width="22.2%" />
											<col width="22.2%" />
											<col width="22.5%" />
											<col width="" />
										</colgroup>
										<tbody>
											<tr>
												<td>1</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>2</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>3</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>4</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>5</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>6</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>7</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>8</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>9</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>10</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
										</tbody> -->
									</table>
									<table id="finExecutionList2" class="sm_table fnc02" summary="재정 항목 설명리스트">
										<!-- <caption>재정 항목 설명 테이블</caption>
										<colgroup>
											<col width="12.1%" />
											<col width="22.2%" />
											<col width="22.2%" />
											<col width="22.5%" />
											<col width="" />
										</colgroup>
										<tbody>
											<tr>
												<td>11</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>12</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>13</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>14</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>15</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>16</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>17</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>8</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>9</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											<tr>
												<td>10</td>
												<td>부서부서부서부서부</td>
												<td class="budget">65,599,747,000</td>
												<td class="spend">65,599,747,000</td>
												<td class="execute">34,315,076,700</td>
											</tr>
											
										</tbody> -->
									</table>
								</div>
							</div>
						</div>
					</div>
					
					<div id="tab-4" class="tab_content">
						<div id="finContract" class="graph_460"></div>
						<div class="finance_desc">
						
							<div class="fnc_all">
								<p class="subtitle">재정 현황 상세</p>
								<ul class="list_title">
									<li style="width:3%">No.</li>
									<li style="width:5.8%">부서명</li>
									<li style="width:10.4%">계약명</li>
									<li style="width:4%">계약분류</li>
									<li style="width:4%">계약방법</li>
									<li style="width:7.3%">계약기간</li>
									<li style="width:5%">계약일자</li>
									<li style="width:4%">진행일</li>
									<li style="width:6%">계약금</li>
									<li style="width:3%">No.</li>
									<li style="width:5.8%">부서명</li>
									<li style="width:10.4%">계약명</li>
									<li style="width:4%">계약분류</li>
									<li style="width:4%">계약방법</li>
									<li style="width:7.3%">계약기간</li>
									<li style="width:5%">계약일자</li>
									<li style="width:4%">진행일</li>
									<li style="width:6%">계약금</li>
								</ul>
								<div class="fnc_list">
									<table id="finContracList" class="sm_table fnc01" summary="재정 항목 설명리스트">
										<!-- <caption>재정 항목 설명 테이블</caption>
										<colgroup>
											<col width="6%" />
											<col width="12%" />
											<col width=" " />
											<col width="8%" />
											<col width="8%" />
											<col width="15%" />
											<col width="10%" />
											<col width="8%" />
											<col width="12%" />
										</colgroup>
										<tbody>
											<tr>
												<td>1</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>2</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>3</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>4</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>5</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>6</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>7</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>8</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>9</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>10</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
										</tbody> -->
									</table>
									<table id="finContracList2" class="sm_table fnc02" summary="재정 항목 설명리스트">
										<!-- <caption>재정 항목 설명 테이블</caption>
										<colgroup>
											<col width="6%" />
											<col width="12%" />
											<col width=" " />
											<col width="8%" />
											<col width="8%" />
											<col width="15%" />
											<col width="10%" />
											<col width="8%" />
											<col width="12%" />
										</colgroup>
										<tbody>
											<tr>
												<td>11</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>12</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>13</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>14</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>15</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>16</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>17</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>18</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>19</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
											<tr>
												<td>10</td>
												<td>가능동</td>
												<td>가능동 조경 유지관리 용역 계약</td>
												<td>용역</td>
												<td>단년</td>
												<td>20210506~20211130</td>
												<td>20210504</td>
												<td>208</td>
												<td class="t_r">21000000</td>
											</tr>
										</tbody> -->
									</table>
								</div>
							</div>
						</div>
					</div>
					

				
				<!-- 20210804 tab스크립트 -->
				<script>
					/* $('.tab_link').click(function () {
						var tab_id = $(this).attr('data-tab');

						$('.tab_link').removeClass('on');
						$('.tab_content').removeClass('on');

						$(this).addClass('on');
						$("#" + tab_id).addClass('on');

					}); */
				</script>
					
				</div>
			</div>
	
	<!-- <div class="content_wrap">
		<div class="content">
			<div style="width: 60%; height: 30%; min-height: 280px; float: left;">
				<div style="width:100%; height: 100%;">
					<div style="width: 100%; height: 30px;">
						<h2 id="" style="display: inline-block; float : left; font-size:16px;">2021년 4월 민원 접수 현황</h2><span style="display: inline-block; float : left; font-size:12px; padding-top: 3px;"></span>
						
					</div>
					chart영역
					<div id="" style="width: 100%; height: 100%; min-height: 280px;">
						<div style="padding: 10px;min-height:280px; width: 50%; height: 100%; float: left;margin-top: 5px; margin-bottom: 5px;">
							<div style="position: relative;color: #64ff61;text-align:center; margin-bottom: 10px;min-height:50px;background-color: #000000; width: 100%; float: left;">
								<span style="font-size: 16px;font-weight:600; position: absolute;left: 50%; top:50%;transform: translate(-50%,-50%);text-align: center;display: inline-block;">
									여권 민원실
								</span>
							</div>
							<div style="position: relative;color: #64ff61;text-align:center;min-height:180px;background-color: #000000; width: 49%; float: left;">
								<span style="display: inline-block;margin-top: 5px;margin-bottom: 5px;">여권 신청</span>
								<hr style="width:100%;height: 2px;" align="center" color="#444444" size="2">
								<span style="color:#ffffff;position: absolute;left: 20%; top:50%;transform: translate(-50%,-50%);display: inline-block;margin-top: 5px;float:left;text-align:left;margin-bottom: 5px;">누적 민원수</span>
								<span id="spnText1" style="font-size:20px;position: absolute;right: 20%; top:50%;transform: translate(50%,-50%);display: inline-block;margin-top: 5px;float:left;text-align:left;margin-bottom: 5px;">수</span>
							</div>
							<div style="position: relative;color: #64ff61;text-align:center;min-height:180px;background-color: #000000; width: 49%; float:right;">
								<span style="display: inline-block;margin-top: 5px;margin-bottom: 5px;">여권 교부</span>
								<hr style="width:100%;height: 2px;" align="center" color="#444444" size="2">
								<span style="color:#ffffff;position: absolute;left: 20%; top:50%;transform: translate(-50%,-50%);display: inline-block;margin-top: 5px;float:left;text-align:left;margin-bottom: 5px;">누적 민원수</span>
								<span id="spnText2" style="font-size:20px;position: absolute;right: 20%; top:50%;transform: translate(50%,-50%);display: inline-block;margin-top: 5px;float:left;text-align:left;margin-bottom: 5px;"></span>
							</div>
						</div>
							
						<div style="padding: 10px;min-height:380px;width: 50%; height: 100%; float: right; margin-top: 5px; margin-bottom: 5px;">
							<div style="position: relative;color: #36d3ff;text-align:center;margin-bottom: 10px;min-height:50px;background-color: #000000; width: 100%; float: left;">
								<span style="font-size: 16px;font-weight:600; position: absolute;left: 50%; top:50%;transform: translate(-50%,-50%);text-align: center;display: inline-block;">
									시청 민원실
								</span>
							</div>
							<div style="position: relative;color: #36d3ff;text-align:center;min-height:180px;background-color: #000000; width: 49%; float: left;">
								<span style="display: inline-block;margin-top: 5px;margin-bottom: 5px;">일반 민원</span>
								<hr style="width:100%;height: 2px;" align="center" color="#444444" size="2">
								<span style="color:#ffffff;position: absolute;left: 20%; top:50%;transform: translate(-50%,-50%);display: inline-block;margin-top: 5px;float:left;text-align:left;margin-bottom: 5px;">누적 민원수</span>
								<span id="spnText3" style="font-size:20px;position: absolute;right: 20%; top:50%;transform: translate(50%,-50%);display: inline-block;margin-top: 5px;float:left;text-align:left;margin-bottom: 5px;">수</span>
							</div>
							<div style="position: relative;color: #36d3ff;text-align:center;min-height:180px;background-color: #000000; width: 49%; float:right;">
							<span style="display: inline-block;margin-top: 5px;margin-bottom: 5px;">가족 관계 등록</span>
								<hr style="width:100%;height: 2px;" align="center" color="#444444" size="2">
								<span style="color:#ffffff;position: absolute;left: 20%; top:50%;transform: translate(-50%,-50%);display: inline-block;margin-top: 5px;float:left;text-align:left;margin-bottom: 5px;">누적 민원수</span>
								<span id="spnText4" style="font-size:20px;position: absolute;right: 20%; top:50%;transform: translate(50%,-50%);display: inline-block;margin-top: 5px;float:left;text-align:left;margin-bottom: 5px;"></span>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div style="width: 40%; height: 60%; min-height: 780px; float: right;">
				<div style="width:100%; height: 100%;">
					<div style="width: 100%; height: 30px;">
						<h2 style="display: inline-block; float : left; font-size:16px;">시정뉴스</h2><span style="display: inline-block; float : left; font-size:12px; padding-top: 3px;"></span>
					</div>
					
					<div id="" style="width: 100%; height: 100%; min-height: 600px;">
						<div id="newsList" style="width: 100%; height: 70%; min-height: 400px;">
						
						</div>
						
						<div id="newsContents" style="display:none;width: 100%; height: 30%; min-height: 200px;">
						
						</div>
					</div>
				</div>
			</div>
			
			<div style="width: 60%; height: 30%; min-height: 430px; float: left;">
				<div style="width:100%; height: 100%;">
					<div style="width: 100%; height: 30px;">
						<h2 style="display: inline-block; float : left; font-size:16px;">각 동 주민센터 일반민원 접수 현황</h2>
					</div>
					
					<div id="" style=";width: 100%; height: 100%; min-height: 400px;">
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
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/finance/finaceStatus.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/map/mapUtil.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquer.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.mockjax.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.orgchart.js"></script>
     --%>
     