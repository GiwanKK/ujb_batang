/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kr.go.uijeongbu.manager.outDataMng.web;


import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import kr.go.uijeongbu.cmm.service.ComFileMngUtil;
import kr.go.uijeongbu.cmm.util.CommonUtil;
import kr.go.uijeongbu.cmm.vo.LoginVO;
import kr.go.uijeongbu.manager.logMng.service.LogService;
import kr.go.uijeongbu.manager.outDataMng.UploadDataUtil;
import kr.go.uijeongbu.manager.outDataMng.service.AnalysisDataService;
import kr.go.uijeongbu.manager.outDataMng.service.OutDataService;

/**
 * 관리자 > Upload 데이터 관리 Controller 클래스
 * @author 김부권
 * @since 2021. 08. 25.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일			수정자			수정내용
 *  -------    		-------------   ----------------------
 *  2021.08.25.   	김부권          최초 생성
 *   
 * </pre>
 */
@Controller
public class OutDataController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OutDataController.class);
	
	@Autowired
	private MappingJackson2JsonView jsonView;				// Json 데이터를 Return 받기위해 Controller 마다 선언해준다
	
	@Resource(name = "outDataService")
	private OutDataService outDataService;			// DB 서비스 호출 데이터 생성
	
	
	@Resource(name = "analysisDataService")
	private AnalysisDataService analysisDataService;		// DB 서비스 호출 통계 생성
	

	@Resource(name = "logService")
	private LogService logService;				// DB 서비스 호출
	
	@Resource(name = "ComFileMngUtil")
	private ComFileMngUtil fileUtil;
	
	
	static final char FILE_SEPARATOR = File.separatorChar;
		
	/**
	 * 관리자 > Upload 데이터 관리 화면
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/outDataMng/outDataMng.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String outDataMng(/*@RequestBody Map<String, Object> params,*/ HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		try {
		//메뉴코드
		String menuCode = "MENU_00057";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
        return "/manager/outDataMng/outDataMng";
		}catch (SQLException e) {
			LOGGER.info("outDataMng SQLException Error");
			return "/common/errorPage/error";
		}catch (Exception e) {
			LOGGER.info("outDataMng Error");
			return "/common/errorPage/error";
		}
    }
	
	
	/**
	 * Upload 데이터 목록 가져오기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/uploadDataMng/getUploadDataList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView getUploadDataList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		try {
		// Json Parameter에서 Map Type으로 변환
		Map<String, Object> paramInfo = CommonUtil.convertMapToJson(params, "paramInfo");

		// Upload 데이터 목록 조회
		List<Map<String, Object>> uploadDataList = outDataService.selectUploadDataList(paramInfo);

		// ModelAndView에 데이터 넣기
		modelAndView.addObject("gridList", uploadDataList);
		}catch (SQLException e) {
			LOGGER.info("getUploadDataList SQLException Error");
		}catch (Exception e) {
			LOGGER.info("getUploadDataList Error");
		}
		return modelAndView;
	}
	
	
	/**
	 * Upload 데이터 History 목록 가져오기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/uploadDataMng/getUploadDataHisList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView getUploadDataHisList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		try {
		// Json Parameter에서 Map Type으로 변환
		Map<String, Object> paramInfo = CommonUtil.convertMapToJson(params, "paramInfo");

		// Upload 데이터 History 목록 조회
		List<Map<String, Object>> uploadDataList = outDataService.selectUploadDataHisList(paramInfo);

		// ModelAndView에 데이터 넣기
		modelAndView.addObject("gridList", uploadDataList);
		}catch (SQLException e) {
			LOGGER.info("getUploadDataHisList SQLException Error");
		}catch (Exception e) {
			LOGGER.info("getUploadDataHisList Error");
		}
		return modelAndView;
	}
	
	
	
	/**
	 * Upload 데이터 정보 저장하기
	 * @param multiRequest
	 * @param request
	 * @return
	 * @throws Exception
	 */
	//@RequestMapping(value = "/mamager/uploadDataMng/fileDataUpload.do")
	@RequestMapping(value = "/mamager/uploadDataMng/createUploadData.do")
	public ModelAndView createUploadData(final MultipartHttpServletRequest multiRequest, HttpServletRequest request) throws SQLException, Exception {
		
		//int resultCnt = 0;
		String resultValue = "Y";
		String resultMsg = "";
		
		try{
			
			// DB 처리 Parameter 객체
			Map<String, Object> paramInfo = new HashMap<String, Object>();
			
			String strStartDateTime = "";
			String strEndDateTime = "";
			
			strStartDateTime = CommonUtil.getDataTimeForLog();			// 처리 시작 시간
			
			// 화면 데이터 받아오기
			String codeId = multiRequest.getParameter("codeId");
			String targetMonth = multiRequest.getParameter("targetMonth");
			
			// Parameter 설정
			paramInfo.put("codeId", codeId);
			paramInfo.put("targetMonth", targetMonth);
			paramInfo.put("createStartDate", strStartDateTime);
			paramInfo.put("createEndDate", strStartDateTime);
			
			// 세션의 로그인 사용자 정보 가져오기
			LoginVO loginVO = CommonUtil.getLoginInfo();
			
			paramInfo.put("loginId", loginVO.getId());
			
			
			// 첨부파일 데이터 받아오기
			final Map<String, MultipartFile> files = multiRequest.getFileMap();
			
			// 파일 업로드 처리하기
			Map<String, Object> resultFileUpload = new HashMap<String, Object>();
			resultFileUpload = fileDataUpload(paramInfo, files);
			
			// 파일 업로드 처리 결과 받아오기
			if( resultFileUpload.get("resultValue") != null )  resultValue = resultFileUpload.get("resultValue").toString();
			if( resultFileUpload.get("resultMsg") != null ) resultMsg = resultFileUpload.get("resultMsg").toString();
			// 에러가 업으면 데이터 생성
			if(resultValue == "Y") {

				// 데이터 생성 프로세스
				Map<String, Object> resultCreateData = new HashMap<String, Object>();
				resultCreateData = createUploadData(paramInfo);
				
				if( resultCreateData.get("resultValue") != null ) resultValue = resultCreateData.get("resultValue").toString();
				if( resultCreateData.get("resultMsg") != null ) resultMsg = resultCreateData.get("resultMsg").toString();
			}
			
			
			// 에러가 없으면 통계 생성
			if(resultValue == "Y") {
				
				Map<String, Object> resultAnalysisData = new HashMap<String, Object>();
				resultAnalysisData = createAnalysisData(paramInfo);
				
				if( resultAnalysisData.get("resultValue") != null ) resultValue = resultAnalysisData.get("resultValue").toString();
				if( resultAnalysisData.get("resultMsg") != null ) resultMsg = resultAnalysisData.get("resultMsg").toString();
			}
			
			strEndDateTime = CommonUtil.getDataTimeForLog();			// 처리 종료 시간
			paramInfo.put("createEndDate", strEndDateTime);
			// 업로드 데이터 정보 저장
			//outDataService.insertFileUploadInfo(paramInfo);
			
		}catch(FileNotFoundException ex) {
			
			resultValue = "N";
			resultMsg = "오류가 발생하였습니다.";
			
		}catch(Exception ex) {
			
			resultValue = "N";
			resultMsg = "오류가 발생하였습니다.";
			
		}finally {
			
			//System.out.println("============================================ Start Date Time : " + strStartDateTime + "============================================");
			//System.out.println("============================================   End Date Time : " + strEndDateTime + "============================================");
		}
		
		
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);

		//modelAndView.addObject("atchFileId", uploadFileId);
		//modelAndView.addObject("resultCnt", resultCnt);
		modelAndView.addObject("resultValue", resultValue);
		modelAndView.addObject("resultMsg", resultMsg);
		
		return modelAndView;
	}
	
	
	/**
	 * 파일 업로드
	 * @param paramInfo
	 * @param files
	 * @return
	 */
	private Map<String, Object> fileDataUpload(Map<String, Object> paramInfo, Map<String, MultipartFile> files) {
	
		// 처리결과 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String resultValue = "Y";			// 처리 완료 여부
		String resultMsg = "";				// 처리 결과 메시지
		
		String strProcStartTime = "";		// 처리 시작 시간
		String strProcEndTime = "";			// 처리 종료 시간
		
		try {
			
			strProcStartTime = CommonUtil.getDataTimeForLog();			// 처리 시작 시간
			
			// 파일 업로드 처리
			String uploadFileId = fileUtil.uploadFiles(files, "");
			// 업로드 된 파일 ID 가져오기
			paramInfo.put("atchFileId", uploadFileId);
			
			strProcEndTime = CommonUtil.getDataTimeForLog();			// 처리 종료 시간
			
			paramInfo.put("procTypeCd", "U");
			paramInfo.put("procDesc", "파일 업로드 완료");
			paramInfo.put("resultMsg", "");
			paramInfo.put("procStartTime", strProcStartTime);
			paramInfo.put("procEndTime", strProcEndTime);
			paramInfo.put("totCnt", 0);
			paramInfo.put("suTotCnt", 0);
			// 업로드 데이터 정보 저장
			outDataService.insertFileUploadInfo(paramInfo);
			
			// 업로드 데이터 History 정보 저장
			outDataService.insertFileUploadHistory(paramInfo);
			
		}catch(FileNotFoundException ex) {
			
			resultValue = "N";
			resultMsg = "오류가 발생하였습니다.";
			
		}catch(Exception ex) {
			
			resultValue = "N";
			resultMsg = "오류가 발생하였습니다.";

		}
		
		resultMap.put("resultValue", resultValue);
		resultMap.put("resultMsg", resultMsg);
		
		return resultMap;
	}
	
	
	/**
	 * 데이터 생성
	 * @param params
	 * @return
	 */
	private Map<String, Object> createUploadData(Map<String, Object> paramInfo) {
		
		// 처리결과 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 데이터 생성 클래스 생성
		UploadDataUtil uploadDataUtil = new UploadDataUtil();
		
		// DB Insert 처리 결과 객체
		Map<String, Object> resultUploadMap = new HashMap<String, Object>();					
		
		String resultValue = "Y";			// 처리 완료 여부
		String resultMsg = "";				// 처리 결과 메시지
		
		String strProcStartTime = "";		// 처리 시작 시간
		String strProcEndTime = "";			// 처리 종료 시간
		
		String procDesc = "";			// 처리 결과 설명
		String procResultMsg = "";		// 처리 결과 메시지
		
		int procInsertCnt = 0;			// 본 Table Insert Count
		int tableIfCnt = 0;			// 임시 Table 생성여부
		
		try {
			
			strProcStartTime = CommonUtil.getDataTimeForLog();			// 처리 시작 시간
			
			// Upload 파일 정보 조회하기
			Map<String, Object> uploadFileInfo = outDataService.selectUpliadFileInfo(paramInfo);
			
			// 파일 경로 구하기
			String filePath = uploadFileInfo.get("fileStreCours").toString() + uploadFileInfo.get("streFileNm").toString();
			
			// 데이터 유형 코드 
			String strCodeId = paramInfo.get("codeId").toString().trim();
			
			// 데이터 유형에 따라 프로세스 분리
			switch(strCodeId.trim().toUpperCase()) {
				//50셀단위 성연령별 유동인구
				case "POPL_00001":
					
					//outDataService.deletePoSvcDdagIf(paramInfo);				// IF 이전 데이터 삭제
					tableIfCnt = outDataService.createPopGenderAge(paramInfo);
					resultUploadMap = uploadDataUtil.makePopGenderAge(filePath);	// IF 데이터 생성
					
					//outDataService.deletePoSvcDdag(paramInfo);				// 대상 Table 데이터 삭제
					
					procInsertCnt = outDataService.insertPopGenderAge(paramInfo);				// 데이터 추가 IF -> 대상 데이블
					outDataService.deletePopGenderAge(paramInfo);
					break;
					
				//행정동별 일자별 외국인 생활인구	
				case "POPL_00002":
					
					tableIfCnt = outDataService.createPopDongForgService(paramInfo);			// IF 테이블 생성
					
					resultUploadMap = uploadDataUtil.makePopDongForgService(filePath);	// IF 데이터 생성
					
					procInsertCnt = outDataService.insertPopDongForgService(paramInfo);				// 데이터 추가 IF -> 대상 데이블
					
					outDataService.deletePopDongForgService(paramInfo);				// 대상 Table 데이터 삭제
					
					break;
				
				//	50셀단위 시간대별 유동인구
				case "POPL_00003":

					//String targetMonth = paramInfo.get("targetMonth").toString().replace("-", "");
					//String tableName = "dsu_po_svc_infl_" + targetMonth;
					
					//paramInfo.put("tableName", tableName);
					tableIfCnt = outDataService.createPopTimeFlow(paramInfo);			// IF 테이블 생성
					
					resultUploadMap = uploadDataUtil.makePopTimeFlow(filePath);		// IF 데이터 생성
					
					procInsertCnt = outDataService.insertPopTimeFlow(paramInfo);					// 데이터 추가 IF -> 대상 데이블
					
					outDataService.deletePopTimeFlow(paramInfo);					// IF 이전 데이터 삭제
					
					break;
				//행정동별 성연령별 생활인구	
				case "POPL_00004":
					tableIfCnt = outDataService.createPopDongGenderAge(paramInfo);			// IF 테이블 생성
					
					resultUploadMap = uploadDataUtil.makePopDongGenderAge(filePath);	// IF 데이터 생성
					
					procInsertCnt = outDataService.insertPopDongGenderAge(paramInfo);				// 데이터 추가 IF -> 대상 데이블
					
					outDataService.deletePopDongGenderAge(paramInfo);				// 대상 Table 데이터 삭제
					
					break;
				//행정동 성연령별 유입지 조합 생활인구
				case "POPL_00005":
					tableIfCnt = outDataService.createPopGenderAgeService(paramInfo);			// IF 테이블 생성
					
					resultUploadMap = uploadDataUtil.makePopGenderAgeService(filePath);		// IF 데이터 생성
					
					procInsertCnt = outDataService.insertPopGenderAgeService(paramInfo);					// 데이터 추가 IF -> 대상 데이블
					
					outDataService.deletePopGenderAgeService(paramInfo);					// 대상 Table 데이터 삭제
					
					break;
				//행정동별 유입지별 생활인구	
				case "POPL_00006":
					tableIfCnt = outDataService.createPopFlowService(paramInfo);			// IF 테이블 생성
					
					resultUploadMap = uploadDataUtil.makePopFlowService(filePath);		// IF 데이터 생성
					
					procInsertCnt = outDataService.insertPopFlowService(paramInfo);					// 데이터 추가 IF -> 대상 데이블
					
					outDataService.deletePopFlowService(paramInfo);					// 대상 Table 데이터 삭제
					
					break;
					
				//법인매출	
				case "SALE_00001":
					tableIfCnt = outDataService.createSaleCorp(paramInfo);			// IF 테이블 생성
					
					resultUploadMap = uploadDataUtil.makeSaleCorp(filePath);		// IF 데이터 생성
					
					procInsertCnt = outDataService.insertSaleCorp(paramInfo);					// 데이터 추가 IF -> 대상 데이블
					
					outDataService.deleteSaleCorp(paramInfo);					// 대상 Table 데이터 삭제
					
					break;
				//외국인 매출	
				case "SALE_00002":
					tableIfCnt = outDataService.createSaleForeigner(paramInfo);			// IF 테이블 생성
					
					resultUploadMap = uploadDataUtil.makeSaleForeigner(filePath);	// IF 데이터 생성
					
					procInsertCnt = outDataService.insertSaleForeigner(paramInfo);				// 데이터 추가 IF -> 대상 데이블
					
					outDataService.deleteSaleForeigner(paramInfo);				// 대상 Table 데이터 삭제
					
					break;
				//일별/시간대별 매출	
				case "SALE_00003":
					tableIfCnt = outDataService.createSaleDayTime(paramInfo);			// IF 테이블 생성
					
					resultUploadMap = uploadDataUtil.makeSaleDayTime(filePath);	// IF 데이터 생성
					
					procInsertCnt = outDataService.insertSaleDayTime(paramInfo);				// 데이터 추가 IF -> 대상 데이블
					
					outDataService.deleteSaleDayTime(paramInfo);				// 대상 Table 데이터 삭제
					
					break;
				//월별/유입지별 매출	
				case "SALE_00004":
					tableIfCnt = outDataService.createSaleMonthFlow(paramInfo);			// IF 테이블 생성
					
					resultUploadMap = uploadDataUtil.makeSaleMonthFlow(filePath);	// IF 데이터 생성
					
					procInsertCnt = outDataService.insertSaleMonthFlow(paramInfo);				// 데이터 추가 IF -> 대상 데이블
					
					outDataService.deleteSaleMonthFlow(paramInfo);				// 대상 Table 데이터 삭제
					
					break;
				//일별/성별/연령대별 매출	
				case "SALE_00005":
					tableIfCnt = outDataService.createSaleDayGenderAge(paramInfo);			// IF 테이블 생성
					
					resultUploadMap = uploadDataUtil.makeSaleDayGenderAge(filePath);	// IF 데이터 생성
					
					procInsertCnt = outDataService.insertSaleDayGenderAge(paramInfo);				// 데이터 추가 IF -> 대상 데이블
					
					outDataService.deleteSaleDayGenderAge(paramInfo);				// 대상 Table 데이터 삭제
					
					break;
				//	의정부시민 매출
				case "SALE_00006":
					tableIfCnt = outDataService.createSaleCitizen(paramInfo);			// IF 테이블 생성
					
					resultUploadMap = uploadDataUtil.makeSaleCitizen(filePath);		// IF 데이터 생성
					
					procInsertCnt = outDataService.insertSaleCitizen(paramInfo);					// 데이터 추가 IF -> 대상 데이블
					
					outDataService.deleteSaleCitizen(paramInfo);					// 대상 Table 데이터 삭제
					
					break;
					
			}
			
			
			
			// 데이터 Error Count
			int resultErrorCnt = 0; 
			// 데이터 Count
			Double dbProcDataCnt = 0.0;
			
			if( resultUploadMap != null ) {
				
				if( resultUploadMap.get("errorCnt") != null )  resultErrorCnt = Integer.parseInt(resultUploadMap.get("errorCnt").toString());
				
				if( resultUploadMap.get("dataCnt") != null ) dbProcDataCnt = Double.parseDouble(resultUploadMap.get("dataCnt").toString());
				
				// 콤마 Format
				DecimalFormat dc = new DecimalFormat("###,###,###,###");   
				String procDataCnt = dc.format(dbProcDataCnt);
				
				if(resultErrorCnt == 0) {
					procDesc = "데이터 생성 완료 : " + procDataCnt + " 건";
					//procDesc = "데이터 생성 완료 : " + procDataCnt + " 건, Copy : " + procInsertCnt + "건";
				}else {
					procDesc = "데이터 오류 : " + resultErrorCnt + "건";
				}
				
				if( resultUploadMap.get("errorMsg") != null ) procResultMsg = resultUploadMap.get("errorMsg").toString();
				
			}else {
				procResultMsg = "데이터가 없습니다.";
			}
			strProcEndTime = CommonUtil.getDataTimeForLog();			// 처리 종료 시간
			
			
			
		}catch(FileNotFoundException ex) {
			
			resultValue = "N";
			resultMsg = "파일을 찾을 수 없습니다.";
			
		}catch(SQLException ex) {
			
			resultValue = "N";
			resultMsg = "오류가 발생하였습니다.";
			
		}catch(Exception ex) {
			
			resultValue = "N";
			resultMsg = "오류가 발생하였습니다.";
			
			procDesc = "데이터 생성 실패";
			procResultMsg = "데이터 생성 실패";
			
		}finally {
			
			uploadDataUtil = null;
			int resultErrorCnt = 0;
			Double dbProcDataCnt = 0.0;
			if( resultUploadMap != null ) {
				
				// 데이터 Error Count
				if( resultUploadMap.get("errorCnt") != null ) resultErrorCnt = Integer.parseInt(resultUploadMap.get("errorCnt").toString());
				// 데이터 Count
				if( resultUploadMap.get("dataCnt") != null ) dbProcDataCnt = Double.parseDouble(resultUploadMap.get("dataCnt").toString());
			}
			
			
			try{
				strProcEndTime = CommonUtil.getDataTimeForLog();			// 처리 종료 시간
				
				paramInfo.put("procTypeCd", "D");
				paramInfo.put("procDesc", procDesc);
				paramInfo.put("resultMsg", procResultMsg);
				paramInfo.put("procStartTime", strProcStartTime);
				paramInfo.put("procEndTime", strProcEndTime);
				paramInfo.put("totCnt", dbProcDataCnt);
				paramInfo.put("suTotCnt", (dbProcDataCnt-resultErrorCnt));
				
				// 업로드 데이터 History 정보 저장
				outDataService.insertFileUploadHistory(paramInfo);
				
			}catch(SQLException ex) {
				
				resultValue = "N";
				resultMsg = "오류가 발생하였습니다.";
				
			}catch(Exception e) {
				
				resultValue = "N";
				resultMsg = "오류가 발생하였습니다.";
			}
		}
		
		resultMap.put("resultValue", resultValue);
		resultMap.put("resultMsg", resultMsg);
		
		return resultMap;
	}
	
	
	/**
	 * 통계 데이터 생성
	 * @param paramInfo
	 * @return
	 */
	private Map<String, Object> createAnalysisData(Map<String, Object> paramInfo) {
		
		// 처리결과 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String resultValue = "Y";			// 처리 완료 여부
		String resultMsg = "";				// 처리 결과 메시지
		
		String strProcStartTime = "";		// 처리 시작 시간
		String strProcEndTime = "";			// 처리 종료 시간
		
		String strProcDesc = "";
		
		try {
			
			strProcStartTime = CommonUtil.getDataTimeForLog();			// 처리 시작 시간
			
			// 데이터 유형 코드 
			String strCodeId = paramInfo.get("codeId").toString().trim();
			
			switch(strCodeId.trim().toUpperCase()) {
				
				case "POPL_00001":
					
					paramInfo.put("analysisCode", "PO_FLO_002");
					paramInfo.put("staticTable", "data.stac_po_data");
					analysisDataService.deleteAnalysisData(paramInfo);		// 
					analysisDataService.createGenderAgePop(paramInfo);		// 서비스 인구 > 월별 분석 : 월별 조회시
					analysisDataService.createGenderAgePopStatic(paramInfo);		// 서비스 인구 > 연령별 분석 : 남성 서비스 인구
					
					
					strProcDesc = "통계 생성 완료";
					break;
					
				case "POPL_00002":
					
					strProcDesc = "통계 생성 미 적용 데이터";
					
					break;
					
				case "POPL_00003":
					
					String targetMonth = paramInfo.get("targetMonth").toString().replace("-", "");
					
					paramInfo.put("analysisCode", "PO_FLO_001");
					paramInfo.put("staticTable", "data.stac_po_data");
					analysisDataService.deleteAnalysisData(paramInfo);		// 삭제
					analysisDataService.createAdmFlowPop(paramInfo);		// 서비스 인구 > 주중/주말 분석 : 주말 인구
					analysisDataService.createDayFlowPop(paramInfo);		// 마트 테이블 만들기 : 요일별 유동인구
					analysisDataService.createDayFlowPopStatic(paramInfo);		// 통계 테이블 만들기 : 요일별 유동인구 스택 업데이트
					
					strProcDesc = "통계 생성 완료";
					break;
					
				case "POPL_00004":
					
					strProcDesc = "통계 생성 미 적용 데이터";
					break;
					
				case "POPL_00005":
					
					strProcDesc = "통계 생성 미 적용 데이터";
					break;
					
				case "POPL_00006":
					
					paramInfo.put("analysisCode", "PO_FLO_003");
					paramInfo.put("staticTable", "data.stac_po_data");
					analysisDataService.deleteAnalysisData(paramInfo);			//
					analysisDataService.createResiServicePop(paramInfo);	// 마트 테이블 만들기 : 거주지별 생활인구/서비스인구(mart.pdt_po_resi_lvng)
					analysisDataService.createResiServicePopStatic(paramInfo);	// 통계 테이블 만들기 : 거주지별 생활인구/서비스인구 스택 업데이트

					strProcDesc = "통계 생성 완료";
					break;
					
				case "SALE_00001":
					
					strProcDesc = "통계 생성 미 적용 데이터";
					break;
					
				case "SALE_00002":
					
					strProcDesc = "통계 생성 미 적용 데이터";
					break;
					
				case "SALE_00003":
					paramInfo.put("analysisCode", "BD_SAL_004");
					paramInfo.put("staticTable", "data.stac_bd_data");
					analysisDataService.deleteAnalysisData(paramInfo);		//
					analysisDataService.createDayTimeCardSale(paramInfo);		// 마트 테이블 만들기 : 요일별 시간대별 카드매출 현황(mart.bda_ddwk_sls_sttu) 
					analysisDataService.createMonthCardSale(paramInfo);		// 마트 테이블 만들기 : 월별 카드매출 현황(mart.bda_mm_sls_sttu) 
					paramInfo.remove("analysisCode");
					paramInfo.put("analysisCode", "BD_SAL_003");
					analysisDataService.deleteAnalysisData(paramInfo);		//
					analysisDataService.createDayTimeCardSaleStatic(paramInfo);		// 통계 테이블 만들기 : 요일별 시간대별 카드매출 현황 스택 업데이트 
					analysisDataService.createMonthCardSaleStatic(paramInfo);		// 통계 테이블 만들기 : 월별 카드매출 현황 스택 업데이트 
					
					
					strProcDesc = "통계 생성 완료";
					break;
					
				case "SALE_00004":
					
					strProcDesc = "통계 생성 미 적용 데이터";
					break;
					
				case "SALE_00005":
					
					paramInfo.put("analysisCode", "BD_SAL_001");
					paramInfo.put("staticTable", "data.stac_bd_data");
					analysisDataService.deleteAnalysisData(paramInfo);		//
					analysisDataService.createGenderAgeSortSale(paramInfo);		// 마트 테이블 만들기 : 성연령별 업종별 카드매출 현황(mart.bda_sexd_age_toi_sls_sttu)
					analysisDataService.createGenderAgeSortSaleStatic(paramInfo);		// 통계 테이블 만들기 : 성연령별 업종별 카드매출 현황 스택 업데이트
					
					paramInfo.remove("analysisCode");
					paramInfo.put("analysisCode", "BD_SAL_002");
					analysisDataService.deleteAnalysisData(paramInfo);		//
					analysisDataService.createAdmdCardSale(paramInfo);		// 마트 테이블 만들기 : 행정동별 카드매출 현황(mart.bda_dong_sls)
					analysisDataService.createAdmdCardSaleStatic(paramInfo);		// 통계 테이블 만들기 : 행정동별 카드매출 현황 스택 업데이트
					
					strProcDesc = "통계 생성 완료";
					break;
					
				case "SALE_00006":
					
					strProcDesc = "통계 생성 미 적용 데이터";
					
					break;
			}
			
			
			strProcEndTime = CommonUtil.getDataTimeForLog();			// 처리 종료 시간
			
			
						
		}catch(SQLException ex) {
			
			resultValue = "N";
			resultMsg = "오류가 발생하였습니다.";
			
		}catch(Exception ex) {
			
			resultValue = "N";
			resultMsg = "오류가 발생하였습니다.";
			
			strProcDesc = "통계 생성 실패";
			
		}finally {
			
			try {
				
				paramInfo.put("procTypeCd", "A");
				paramInfo.put("procDesc", strProcDesc);
				//paramInfo.put("resultMsg", resultUploadMap.get("errorMsg"));
				paramInfo.put("procStartTime", strProcStartTime);
				paramInfo.put("procEndTime", strProcEndTime);
				
				// 업로드 데이터 History 정보 저장
				outDataService.insertFileUploadHistory(paramInfo);
				
			}catch(SQLException ex) {
				
				resultValue = "N";
				resultMsg = "오류가 발생하였습니다.";
				
			}catch(Exception e) {
				
				resultValue = "N";
				resultMsg = "오류가 발생하였습니다.";
			}
		}
		
		resultMap.put("resultValue", resultValue);
		resultMap.put("resultMsg", resultMsg);
		
		return resultMap;
	}
	
}
