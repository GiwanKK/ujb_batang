<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : businessStatus.jsp
  * @Description : 대시보드 - 사업현황 페이지
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
			<li><span class="pt2">사업 추진 현황</span></li>
			<li class="current_page">사업 추진 현황</li>
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
                	<p class="business_tip">* 하단의 메뉴를 누르시면 해당 사업추진 현황을 보실 수 있습니다.</p>
					
					<div class="left_tab">
                    	<ul class="left_tab_area">
                        	<li class="tab_url on" data-tab="tab-1" onClick="return false;">희망도시</li>
							<li class="tab_url"  data-tab="tab-2" onClick="return false;">선진교통도시</li>
							<li class="tab_url"  data-tab="tab-3" onClick="return false;">교육선도도시</li>
							<li class="tab_url"  data-tab="tab-4" onClick="return false;">복지도시</li>
                            <li class="tab_url"  data-tab="tab-5" onClick="return false;">행정도시</li>
                        </ul>
                    </div>
                    
                    <div id="tab-1" class="tab_business on">
                    	<div id="busiHope" class="push_list">
                        
                        	
                            
                        </div>
                        
                        <div class="push_desc">
                        	<!-- <p class="subtitle">상세현황</p> -->
                            <ul id="busiHopeList" class="desc_state">
                            	<!-- <li>
                                	<span class="sm_title">1. 추진단계</span>
                                    <span class="sm_area">정상완료</span>
                                </li>
                                <li>
                                	<span class="sm_title">2. 사업기간</span>
                                    <span class="sm_area">2020.12~2021.12</span>
                                </li>
                                <li>
                                	<span class="sm_title">3. 사업예산</span>
                                    <span class="sm_area">총 765억</span>
                                </li>
                                <li>
                                	<span class="sm_title">4. 주관부서</span>
                                    <span class="sm_area">도시재생과</span>
                                </li>
                                <li>
                                	<span class="sm_title">5. 첨부파일</span>
                                    <span class="sm_area"><a href="#"><img src="/dist/images/business/ico_download.png" /> 도시재생지원센터.hwp</a></span>
                                </li> -->
                            </ul>
                        </div>
                    </div>
                    
                    <div id="tab-2" class="tab_business">
                    	<div id="busiTrans" class="push_list">
                        
                        	
                            
                        </div>
                        
                        <div class="push_desc">
                        	<!-- <p class="subtitle">상세현황</p> -->
                            <ul id="busiTransList" class="desc_state">
                            	<!-- <li>
                                	<span class="sm_title">1. 추진단계</span>
                                    <span class="sm_area">정상완료</span>
                                </li>
                                <li>
                                	<span class="sm_title">2. 사업기간</span>
                                    <span class="sm_area">2020.12~2021.12</span>
                                </li>
                                <li>
                                	<span class="sm_title">3. 사업예산</span>
                                    <span class="sm_area">총 765억</span>
                                </li>
                                <li>
                                	<span class="sm_title">4. 주관부서</span>
                                    <span class="sm_area">도시재생과</span>
                                </li>
                                <li>
                                	<span class="sm_title">5. 첨부파일</span>
                                    <span class="sm_area"><a href="#"><img src="/dist/images/business/ico_download.png" /> 도시재생지원센터.hwp</a></span>
                                </li> -->
                            </ul>
                        </div>
                    </div>
                    
                    <div id="tab-3" class="tab_business">
                    	<div id="busiEducation" class="push_list">
                        
                        	
                            
                        </div>
                        
                        <div class="push_desc">
                        	<!-- <p class="subtitle">상세현황</p> -->
                            <ul id="busiEducationList" class="desc_state">
                            	<!-- <li>
                                	<span class="sm_title">1. 추진단계</span>
                                    <span class="sm_area">정상완료</span>
                                </li>
                                <li>
                                	<span class="sm_title">2. 사업기간</span>
                                    <span class="sm_area">2020.12~2021.12</span>
                                </li>
                                <li>
                                	<span class="sm_title">3. 사업예산</span>
                                    <span class="sm_area">총 765억</span>
                                </li>
                                <li>
                                	<span class="sm_title">4. 주관부서</span>
                                    <span class="sm_area">도시재생과</span>
                                </li>
                                <li>
                                	<span class="sm_title">5. 첨부파일</span>
                                    <span class="sm_area"><a href="#"><img src="/dist/images/business/ico_download.png" /> 도시재생지원센터.hwp</a></span>
                                </li> -->
                            </ul>
                        </div>
                    </div>
                    
                    <div id="tab-4" class="tab_business">
                    	<div id="busiWelfare" class="push_list">
                        
                        	
                            
                        </div>
                        
                        <div class="push_desc">
                        	<!-- <p class="subtitle">상세현황</p> -->
                            <ul id="busiWelfareList" class="desc_state">
                            	<!-- <li>
                                	<span class="sm_title">1. 추진단계</span>
                                    <span class="sm_area">정상완료</span>
                                </li>
                                <li>
                                	<span class="sm_title">2. 사업기간</span>
                                    <span class="sm_area">2020.12~2021.12</span>
                                </li>
                                <li>
                                	<span class="sm_title">3. 사업예산</span>
                                    <span class="sm_area">총 765억</span>
                                </li>
                                <li>
                                	<span class="sm_title">4. 주관부서</span>
                                    <span class="sm_area">도시재생과</span>
                                </li>
                                <li>
                                	<span class="sm_title">5. 첨부파일</span>
                                    <span class="sm_area"><a href="#"><img src="/dist/images/business/ico_download.png" /> 도시재생지원센터.hwp</a></span>
                                </li> -->
                            </ul>
                        </div>
                    </div>
                    
                    <div id="tab-5" class="tab_business">
                    	<div id="busiPublic" class="push_list">
                        
                        	
                            
                        </div>
                        
                        <div class="push_desc">
                        	<!-- <p class="subtitle">상세현황</p> -->
                            <ul id="busiPublicList" class="desc_state">
                            	<!-- <li>
                                	<span class="sm_title">1. 추진단계</span>
                                    <span class="sm_area">정상완료</span>
                                </li>
                                <li>
                                	<span class="sm_title">2. 사업기간</span>
                                    <span class="sm_area">2020.12~2021.12</span>
                                </li>
                                <li>
                                	<span class="sm_title">3. 사업예산</span>
                                    <span class="sm_area">총 765억</span>
                                </li>
                                <li>
                                	<span class="sm_title">4. 주관부서</span>
                                    <span class="sm_area">도시재생과</span>
                                </li>
                                <li>
                                	<span class="sm_title">5. 첨부파일</span>
                                    <span class="sm_area"><a href="#"><img src="/dist/images/business/ico_download.png" /> 도시재생지원센터.hwp</a></span>
                                </li> -->
                            </ul>
                        </div>
                    </div>
                    
                    <!-- 20210804 tab스크립트 -->
					<script>
                       
                    </script>
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
<script src="${pageContext.request.contextPath}/dist/js/common/etc/loading/ajax-loading.js"></script>
    	        
    <script src="${pageContext.request.contextPath}/dist/js/common/commonUtil.js"></script>	
    <script src="${pageContext.request.contextPath}/dist/js/common/commonChart.js"></script>
    <script src="${pageContext.request.contextPath}/pageJs/dashBoard/business/businessStatus.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquer.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.mockjax.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/common/OrgChart-3.1.1/js/jquery.orgchart.js"></script>
     --%>
     