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
package kr.go.uijeongbu.manager.outDataMng.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
  * 관리자 > Upload 데이터 관리용 Service 클래스
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
public interface OutDataService {

	
	/**
	 * Upload 데이터 목록 조회하기
	 * @param searchVO
	 * @return
	 * @throws IOException, SQLException
	 */
	List<Map<String, Object>> selectUploadDataList(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * Upload 데이터 History 목록 조회하기
	 * @param searchVO
	 * @return
	 * @throws IOException, SQLException
	 */
	List<Map<String, Object>> selectUploadDataHisList(Map<String, Object> param) throws IOException, SQLException;

		
	/**
	 * Upload 데이터 정보 저장하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int insertFileUploadInfo(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 데이터 생성 정보 변경하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	//int updateCreateDataInfo(Map<String, Object> param) throws IOException, SQLException;
	

	
	/**
	 * 통계 생성 정보 변경하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	//int updateCreateAnalysisInfo(Map<String, Object> param) throws IOException, SQLException;
	
	
	
	/**
	 * Upload 데이터 History 저장하기 : 업로드
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int insertFileUploadHistory(Map<String, Object> param) throws IOException, SQLException;

	
	/**
	 * Upload File 정보 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	Map<String, Object> selectUpliadFileInfo(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 테이블명 중복 체크
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	Map<String, Object> checkDupTableName(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 50셀단위 성연령별 유동인구 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createPopGenderAge(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 50셀단위 성연령별 유동인구 테이블 데이터 추가하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int insertPopGenderAge(Map<String, Object> param) throws IOException, SQLException;
	
	
	
	/**
	 * 50셀단위 성연령별 유동인구 임시 테이블 삭제하기 (IF)	
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	int deletePopGenderAge(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 행정동별 일자별 외국인 생활인구 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createPopDongForgService(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 행정동별 일자별 외국인 생활인구 테이블 데이터 추가하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int insertPopDongForgService(Map<String, Object> param) throws IOException, SQLException;
	
	
	
	/**
	 * 행정동별 일자별 외국인 생활인구 임시 테이블 삭제하기 (IF)	
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	int deletePopDongForgService(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 50셀단위 시간대별 유동인구 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createPopTimeFlow(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 50셀단위 시간대별 유동인구 테이블 데이터 추가하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int insertPopTimeFlow(Map<String, Object> param) throws IOException, SQLException;
	
	
	
	/**
	 * 50셀단위 시간대별 유동인구 임시 테이블 삭제하기 (IF)	
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	int deletePopTimeFlow(Map<String, Object> param) throws IOException, SQLException;
	

	/**
	 * 행정동별 성연령별 생활인구 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createPopDongGenderAge(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 행정동별 성연령별 생활인구 테이블 데이터 추가하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int insertPopDongGenderAge(Map<String, Object> param) throws IOException, SQLException;
	
	
	
	/**
	 * 행정동별 성연령별 생활인구 임시 테이블 삭제하기 (IF)	
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	int deletePopDongGenderAge(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 행정동 성연령별 유입지 조합 생활인구 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createPopGenderAgeService(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 행정동 성연령별 유입지 조합 생활인구 테이블 데이터 추가하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int insertPopGenderAgeService(Map<String, Object> param) throws IOException, SQLException;
	
	
	
	/**
	 * 행정동 성연령별 유입지 조합 생활인구 임시 테이블 삭제하기 (IF)		
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	int deletePopGenderAgeService(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 행정동별 유입지별 생활인구 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createPopFlowService(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 행정동별 유입지별 생활인구 테이블 데이터 추가하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int insertPopFlowService(Map<String, Object> param) throws IOException, SQLException;
	
	
	
	/**
	 * 행정동별 유입지별 생활인구 임시 테이블 삭제하기 (IF)		
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	int deletePopFlowService(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 법인매출 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createSaleCorp(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 법인매출 테이블 데이터 추가하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int insertSaleCorp(Map<String, Object> param) throws IOException, SQLException;
	
	
	
	/**
	 * 법인매출 임시 테이블 삭제하기 (IF)	
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	int deleteSaleCorp(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 외국인 매출 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createSaleForeigner(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 외국인 매출 테이블 데이터 추가하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int insertSaleForeigner(Map<String, Object> param) throws IOException, SQLException;
	
	
	
	/**
	 * 외국인 매출 임시 테이블 삭제하기 (IF)	
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	int deleteSaleForeigner(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 일별/시간대별 매출 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createSaleDayTime(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 일별/시간대별 매출 테이블 데이터 추가하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int insertSaleDayTime(Map<String, Object> param) throws IOException, SQLException;
	
	
	
	/**
	 * 일별/시간대별 매출 임시 테이블 삭제하기 (IF)	
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	int deleteSaleDayTime(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 월별/유입지별 매출 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createSaleMonthFlow(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 월별/유입지별 매출 테이블 데이터 추가하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int insertSaleMonthFlow(Map<String, Object> param) throws IOException, SQLException;
	
	
	
	/**
	 * 월별/유입지별 매출 임시 테이블 삭제하기 (IF)	
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	int deleteSaleMonthFlow(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 일별/성별/연령대별 매출 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createSaleDayGenderAge(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 일별/성별/연령대별 매출 테이블 데이터 추가하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int insertSaleDayGenderAge(Map<String, Object> param) throws IOException, SQLException;
	
	
	
	/**
	 * 일별/성별/연령대별 매출 임시 테이블 삭제하기 (IF)	
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	int deleteSaleDayGenderAge(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 의정부시민 매출 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createSaleCitizen(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 의정부시민 매출 테이블 데이터 추가하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int insertSaleCitizen(Map<String, Object> param) throws IOException, SQLException;
	
	
	
	/**
	 * 의정부시민 매출 임시 테이블 삭제하기 (IF)	
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	int deleteSaleCitizen(Map<String, Object> param) throws IOException, SQLException;
	
	
}
