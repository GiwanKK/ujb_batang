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
			<h2>주요업무 등록</h2>
			<div class="search_wrap">
				<ul>
					<li class="wd40">
						<span class="sch_title">구분</span>
						<select id="selectBusiName" class="select_sch wd85">
							<option value=""></option>
						</select>
					</li>
					<li class="wd7"><a href="#" id="btnBusiSearch" class="sch_button">검색</a></li>
				</ul>
			</div>
			
			<div class="admin_content">
				<div class="left_area">
					<h3>희망도시</h3>
					<div class="grid">
						<table class="admin_list" summary="업무등록을 위한 업무리스트">
							<caption>업무등록을 위한 리스트테이블</caption>
							<colgroup>
								<col width="10%" />
								<col width=" " />
								<col width="15%" />
								<col width="15%" />
							</colgroup>
							<thead>
								<tr>
									<th>번호</th>
									<th>공약사업명</th>
									<th>총사업비(백만원)</th>
									<th>추진실적(진도율)</th>
								</tr>
							</thead>
							<tbody id="busiDetailList">
								<tr class="on">
									<td>1</td>
									<td>도시재생지원센터</td>
									<td>768억</td>
									<td>70%</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				
				<div class="right_area">
					<h3>세부내용</h3>
					<div id="readData" class="grid" style="">
						<table class="admin_view" summary="주요업무 상세내용">
							<caption>주요업무 상세내용 테이블</caption>
							<colgroup>
								<col width="30%" />
								<col width=" " />
							</colgroup>
							<tbody id="tblBusiData">
								<tr>
									<th>구분</th>
									<td><p id="busiName"></p>
									
									</td>
								</tr>
								<tr>
									<th>공약사업명</th>
									<td><p id="goalName"></p></td>
								</tr>
								<tr>
									<th>공약추진기간</th>
									<td><p id="term"></p></td>
								</tr>
								<tr>
									<th>공약사업내용</th>
									<td><p id="contents"></p></td>
								</tr>
								<tr>
									<th>소요예산</th>
									<td><p id="subCost"></p></td>
								</tr>
								<tr>
									<th>총사업비(백만원)</th>
									<td><p id="totalCost"></p></td>
								</tr>
								<tr>
									<th>기대효과</th>
									<td><p id="effect"></p></td>
								</tr>
								<tr>
									<th>정책목표</th>
									<td><p id="goal"></p></td>
								</tr>
								<tr>
									<th>부서</th>
									<td><p id="dept"></p></td>
								</tr>
								<tr>
									<th>추진실적(진도율)</th>
									<td><p id="rate"></p></td>
								</tr>
								<tr>
									<th>관련문서 다운로드</th>
									<td><p id="downloadFile" style="cursor: pointer;">도시재생지원센터.pdf</p>
										<input type="hidden" id="fileNo" value="">
									</td>
								</tr>
							</tbody>
						</table>
						
						<p class="admin_btns">
							<a href="#" id="btnBusiReg" class="bt_md b_blue">등록</a>
							<a href="#" id="btnBusiUpdate" class="bt_md b_green">수정</a>
							<a href="#" id="btnBusiDelete" class="bt_md b_gray">삭제</a>
						</p>
					</div> 
					
					<div id="writeData" class="grid" style="display: none;">
						<table class="admin_write" summary="권한정보 내용 등록 및 수정">
							<caption>권한정보 내용 등록 및 수정하여 저장하기 위한 테이블</caption>
							<colgroup>
								<col width="30%" />
								<col width=" " />
							</colgroup>
							<tbody id="tblBusiData">
								<tr>
									<th><span style="color:red;'">*</span> 구분</th>
									<td>
										<select id="busiName1" class="select_sch wd85">
											<option value=""></option>
										</select>	
									</td>
								</tr>
								<tr>
									<th><span style="color:red;'">*</span> 공약사업명</th>
									<td><input type="text" id="goalName1" class="input_basic" />
										<input type="hidden" id="busiSeq" value="">
									</td>
								</tr>
								<tr>
									<th><span style="color:red;'">*</span> 공약추진기간</th>
									<td><input type="text" id="term1" class="input_basic" /></td>
								</tr>
								<tr>
									<th><span style="color:red;'">*</span> 공약사업내용</th>
									<td><textarea id="contents1" class="textarea_basic"></textarea></td>
								</tr>
								<tr>
									<th><span style="color:red;'">*</span> 소요예산</th>
									<td><input type="text" id="subCost1" class="input_basic" /></td>
								</tr>
								<tr>
									<th><span style="color:red;'">*</span> 총사업비(백만원)</th>
									<td><input type="text" id="totalCost1" class="input_basic"  onkeypress="onlyNumber();"/></td>
								</tr>
								<tr>
									<th><span style="color:red;'">*</span> 기대효과</th>
									<td><textarea id="effect1" class="textarea_basic"></textarea></td>
								</tr>
								<tr>
									<th><span style="color:red;'">*</span> 정책목표</th>
									<td><input type="text" id="goal1" class="input_basic" /></td>
								</tr>
								<tr>
									<th><span style="color:red;'">*</span> 부서</th>
									<td><input type="text" id="dept1" class="input_basic" /></td>
								</tr>
								<tr>
									<th><span style="color:red;'">*</span> 추진실적(진도율)</th>
									<td><input type="text" id="rate1" class="input_basic" onkeypress="onlyNumber();"/></td>
								</tr>
								<tr>
									<th>관련문서 다운로드</th>
									<td><input type="file" id="uploadFile" class="input_basic" value="" /></td>
								</tr>
								
							</tbody>
						</table>
						
						<p class="admin_btns">
							<a href="#" id="btnBusiSave" class="bt_md b_blue" val>저장</a>
							<a href="#" id="btnBusiCancle" class="bt_md b_gray">취소</a>
						</p>
					</div>
					
				</div>
			</div>

			
		</section>
		
		<script src="${pageContext.request.contextPath}/pageJs/manager/inDataMng/mainBusi.js"></script>