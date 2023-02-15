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
package kr.go.uijeongbu.manager.outDataMng.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.go.uijeongbu.manager.outDataMng.service.AnalysisDataService;

/**
 * 관리자 > 데이터 관리 : 통계 생성용 Service Implement 클래스
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

@Service("analysisDataService")
public class AnalysisDataServiceImpl extends EgovAbstractServiceImpl implements AnalysisDataService {
	
	@Resource(name = "analysisDataMapper")
	private AnalysisDataMapper analysisDataMapper;

	
	/**
	 * 통계 유형에 따라 이전 데이터 삭제하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	@Override
	public int deleteAnalysisData(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.deleteAnalysisData(param);
	}
	

	/**
	 * 통계 데이터 만들기 : 성연령별 유동인구(mart.pdt_po_sexd_age_flow)
	 */
	@Override
	public int createGenderAgePop(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createGenderAgePop(param);
	}
	
	
	/**
	 * 집계 테이블 데이터 만들기 : 성연령별 유동인구 스택 업데이트
	 */
	@Override
	public int createGenderAgePopStatic(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createGenderAgePopStatic(param);
	}
	
	/**
	 * 마트 테이블 만들기 : 행정동별 유동인구 테이블 생성
	 */
	@Override
	public int createAdmFlowPop(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createAdmFlowPop(param);
	}
	
	/**
	 * 마트 테이블 만들기 : 요일별 유동인구
	 */
	@Override
	public int createDayFlowPop(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createDayFlowPop(param);
	}
	
	/**
	 * 통계 테이블 만들기 : 요일별 유동인구 스택 업데이트
	 */
	@Override
	public int createDayFlowPopStatic(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createDayFlowPopStatic(param);
	}
	
	/**
	 * 마트 테이블 만들기 : 거주지별 생활인구/서비스인구(mart.pdt_po_resi_lvng)
	 */
	@Override
	public int createResiServicePop(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createResiServicePop(param);
	}
	
	/**
	 * 마트 테이블 만들기 : 월별 카드매출 현황(mart.bda_mm_sls_sttu)
	 */
	@Override
	public int createMonthCardSale(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createMonthCardSale(param);
	}
	
	/**
	 * 통계 테이블 만들기 : 월별 카드매출 현황 스택 업데이트
	 */
	@Override
	public int createMonthCardSaleStatic(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createMonthCardSaleStatic(param);
	}
	
	/**
	 * 통계 테이블 만들기 : 거주지별 생활인구/서비스인구 스택 업데이트
	 */
	@Override
	public int createResiServicePopStatic(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createResiServicePopStatic(param);
	}
	
	/**
	 * 마트 테이블 만들기 : 성연령별 업종별 카드매출 현황(mart.bda_sexd_age_toi_sls_sttu)
	 */
	@Override
	public int createGenderAgeSortSale(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createGenderAgeSortSale(param);
	}
	
	/**
	 * 통계 테이블 만들기 : 성연령별 업종별 카드매출 현황 스택 업데이트
	 */
	@Override
	public int createGenderAgeSortSaleStatic(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createGenderAgeSortSaleStatic(param);
	}
	/**
	 * 마트 테이블 만들기 : 행정동별 카드매출 현황(mart.bda_dong_sls)
	 */
	@Override
	public int createAdmdCardSale(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createAdmdCardSale(param);
	}
	
	
	/**
	 * 통계 테이블 만들기 : 행정동별 카드매출 현황 스택 업데이트
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	@Override
	public int createAdmdCardSaleStatic(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createAdmdCardSaleStatic(param);
	}
	
	
	/**
	 * 통계 테이블 만들기 : 요일별 시간대별 카드매출 현황 스택 업데이트
	 */
	@Override
	public int createDayTimeCardSaleStatic(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createDayTimeCardSaleStatic(param);
	}
	
	/**
	 * 마트 테이블 만들기 : 요일별 시간대별 카드매출 현황(mart.bda_ddwk_sls_sttu)
	 */
	@Override
	public int createDayTimeCardSale(Map<String, Object> param) throws IOException, SQLException {
		return analysisDataMapper.createDayTimeCardSale(param);
	}


	
	
}
