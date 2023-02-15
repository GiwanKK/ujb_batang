package kr.go.uijeongbu.manager.outDataMng.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 관리자 > 데이터 관리 : 통계 생성용 Mapper 클래스
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
@Repository("analysisDataMapper")
public class AnalysisDataMapper extends ComAbstractDAO {
	
	
	/**
	 * 통계 유형에 따라 이전 데이터 삭제하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deleteAnalysisData(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.deleteAnalysisData", param);
	}
	

	/**
	 * 통계 데이터 만들기 : 성연령별 유동인구(mart.pdt_po_sexd_age_flow)
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createGenderAgePop(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createGenderAgePop", param);
	}
	
	/**
	 * 통계 테이블 데이터 만들기 : 성연령별 유동인구 스택 업데이트
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createGenderAgePopStatic(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createGenderAgePopStatic", param);
	}
	
	/**
	 * 마트 테이블 만들기 : 행정동별 유동인구 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createAdmFlowPop(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createAdmFlowPop", param);
	}
	
	/**
	 * 마트 테이블 만들기 : 요일별 유동인구
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createDayFlowPop(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createDayFlowPop", param);
	}
	
	/**
	 * 통계 테이블 만들기 : 요일별 유동인구 스택 업데이트
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createDayFlowPopStatic(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createDayFlowPopStatic", param);
	}

	/**
	 * 마트 테이블 만들기 : 거주지별 생활인구/서비스인구(mart.pdt_po_resi_lvng)
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createResiServicePop(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createResiServicePop", param);
	}
	/**
	 * 마트 테이블 만들기 : 월별 카드매출 현황(mart.bda_mm_sls_sttu)
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createMonthCardSale(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createMonthCardSale", param);
	}

	/**
	 * 통계 테이블 만들기 : 월별 카드매출 현황 스택 업데이트
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createMonthCardSaleStatic(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createMonthCardSaleStatic", param);
	}
	
	/**
	 * 통계 테이블 만들기 : 거주지별 생활인구/서비스인구 스택 업데이트
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createResiServicePopStatic(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createResiServicePopStatic", param);
	}
	
	/**
	 * 마트 테이블 만들기 : 성연령별 업종별 카드매출 현황(mart.bda_sexd_age_toi_sls_sttu)
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createGenderAgeSortSale(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createGenderAgeSortSale", param);
	}
	
	/**
	 * 통계 테이블 만들기 : 성연령별 업종별 카드매출 현황 스택 업데이트
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createGenderAgeSortSaleStatic(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createGenderAgeSortSaleStatic", param);
	}
	
	/**
	 * 마트 테이블 만들기 : 행정동별 카드매출 현황(mart.bda_dong_sls)
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createAdmdCardSale(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createAdmdCardSale", param);
	}
	
	
	/**
	 * 통계 테이블 만들기 : 행정동별 카드매출 현황 스택 업데이트
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createAdmdCardSaleStatic(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createAdmdCardSaleStatic", param);
	}

	
	/**
	 * 통계 테이블 만들기 : 요일별 시간대별 카드매출 현황 스택 업데이트
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createDayTimeCardSaleStatic(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createDayTimeCardSaleStatic", param);
	}
	
	/**
	 * 마트 테이블 만들기 : 요일별 시간대별 카드매출 현황(mart.bda_ddwk_sls_sttu) 
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createDayTimeCardSale(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("ServicePoplStatsDAO.createDayTimeCardSale", param);
	}
	
	
}
