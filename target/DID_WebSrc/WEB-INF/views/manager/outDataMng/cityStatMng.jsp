<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : uploadDataMain.jsp
  * @Description : 관리자 > 도시통계 데이터 관리
  * @Modification Information
  *
  *  수정일			수정자			수정내용
  *  -------    	-------------   ----------------------
  *  2022.08.10.   	권기완                     최초 생성
  */
%>


	<section id="container">
			<h2>데이터 등록</h2>
			
			<div class="admin_content">
			<div class="left_area">
					<div class="tab_area">
					</div>
					<div id="tab-1" class="tab_content on">
						<table class="admin_view" summary="데이터 정보 내용 입력">
							<caption>데이터 정보를 저장하기 위한 테이블</caption>
							<colgroup>
								<col width="30%" />
								<col width=" " />
							</colgroup>
							<tbody>
								<tr>
									<th>대상 년도</th>
									<td>
										<div style="position: relative">
											<input type="text" id="targetMonth" class="form-control dateSelect"  value="" />
										</div>
									</td>
								</tr>
								<tr>
									<th>업로드 파일</th>
									<td><input type="file" id="uploadFiles" name="uploadFiles" class="input_basic" />
									<p>xlsx, xls 또는 csv 파일을 업로드 해주세요.</p>
									<p>업로드 시 해당 년도에 데이터는 지워진 후 업로드 됩니다.</p>
									</td>
								</tr>
							</tbody>
						</table>
						<p class="admin_btns">
							<a href="#" id="btnCreateData" class="bt_md b_blue">데이터 업로드</a>
							<!-- <a href="#" class="bt_md b_gray">저장</a> -->
						</p>
					</div>
				</div>
				<div class="right_area">
					<h3>데이터 목록</h3>
					<div data-ax5grid="upload-data-grid" data-ax5grid-config='{name:"upload-data-grid"}' class="grid">
					</div>
				</div>
			</div>
			
		 <!-- 20210804 tab스크립트 -->
			<script>
				$('.tab_link').click(function () {
					var tab_id = $(this).attr('data-tab');

					$('.tab_link').removeClass('on');
					$('.tab_content').removeClass('on');

					$(this).addClass('on');
					$("#" + tab_id).addClass('on');

				});
			</script> 
			
		</section>
    <!-- /.content -->
    
	<!-- Page 스크립트 -->
	<script src="${pageContext.request.contextPath}/pageJs/manager/outDataMng/cityStatMng.js"></script>
