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
import java.util.Map;

/**
  * 관리자 > 데이터 관리 : 통계 생성용 Service 클래스
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
public interface AnalysisDataService {

	
	/**
	 * 통계 유형에 따라 이전 데이터 삭제하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int deleteAnalysisData(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 통계 데이터 만들기 : 성연령별 유동인구(mart.pdt_po_sexd_age_flow)
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createGenderAgePop(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 집계 테이블 데이터 만들기 : 성연령별 유동인구 스택 업데이트
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createGenderAgePopStatic(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 마트 테이블 만들기 : 행정동별 유동인구 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createAdmFlowPop(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 마트 테이블 만들기 : 요일별 유동인구
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createDayFlowPop(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 통계 테이블 만들기 : 요일별 유동인구 스택 업데이트
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createDayFlowPopStatic(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 마트 테이블 만들기 : 거주지별 생활인구/서비스인구(mart.pdt_po_resi_lvng)
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createResiServicePop(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 마트 테이블 만들기 : 월별 카드매출 현황(mart.bda_mm_sls_sttu)
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createMonthCardSale(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 통계 테이블 만들기 : 월별 카드매출 현황 스택 업데이트
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createMonthCardSaleStatic(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 통계 테이블 만들기 : 거주지별 생활인구/서비스인구 스택 업데이트
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createResiServicePopStatic(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 마트 테이블 만들기 : 성연령별 업종별 카드매출 현황(mart.bda_sexd_age_toi_sls_sttu)
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createGenderAgeSortSale(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 통계 테이블 만들기 : 성연령별 업종별 카드매출 현황 스택 업데이트
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createGenderAgeSortSaleStatic(Map<String, Object> param) throws IOException, SQLException;
	/**
	 * 마트 테이블 만들기 : 행정동별 카드매출 현황(mart.bda_dong_sls)
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createAdmdCardSale(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 통계 테이블 만들기 : 행정동별 카드매출 현황 스택 업데이트
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createAdmdCardSaleStatic(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 통계 테이블 만들기 : 요일별 시간대별 카드매출 현황 스택 업데이트 
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createDayTimeCardSaleStatic(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 마트 테이블 만들기 : 요일별 시간대별 카드매출 현황(mart.bda_ddwk_sls_sttu)
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	int createDayTimeCardSale(Map<String, Object> param) throws IOException, SQLException;
	

}
