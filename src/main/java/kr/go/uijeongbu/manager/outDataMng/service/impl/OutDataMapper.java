package kr.go.uijeongbu.manager.outDataMng.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 관리자 > Upload 데이터 관리용 Mapper 클래스
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
@Repository("outDataMapper")
public class OutDataMapper extends ComAbstractDAO {

	/**
	 * Upload 데이터 목록 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public List<Map<String, Object>> selectUploadDataList(Map<String, Object> param) throws IOException, SQLException {
		return selectList("OutDataMngDAO.selectUploadDataList", param);
	}
	
	
	/**
	 * Upload 데이터 History 목록 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public List<Map<String, Object>> selectUploadDataHisList(Map<String, Object> param) throws IOException, SQLException {
		return selectList("OutDataMngDAO.selectUploadDataHisList", param);
	}
	

	/**
	 * Upload 데이터 정보 저장하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertFileUploadInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("OutDataMngDAO.insertFileUploadInfo", param);
	}
	
	
	/**
	 * 데이터 생성 정보 변경하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	/*
	public int updateCreateDataInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("UploadDataMngDAO.updateCreateDataInfo", param);
	}
	*/
	
	
	/**
	 * 통계 생성 정보 변경하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	/*
	public int updateCreateAnalysisInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("UploadDataMngDAO.updateCreateAnalysisInfo", param);
	}
	*/
	
	
	
	/**
	 * Upload 데이터 History 저장하기 : 업로드
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertFileUploadHistory(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("OutDataMngDAO.insertFileUploadHistory", param);
	}
	
	
	/**
	 * Upload File 정보 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public Map<String, Object> selectUpliadFileInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return selectOne("OutDataMngDAO.selectUpliadFileInfo", param);
	}
	
	
	/**
	 * 테이블명 중복 체크
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public Map<String, Object> checkDupTableName(Map<String, Object> param) throws IOException, SQLException {
		
		return selectOne("OutDataMngDAO.checkDupTableName", param);
	}
	
	
	/**
	 * 50셀단위 성연령별 유동인구 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createPopGenderAge(Map<String, Object> param) throws IOException, SQLException {

		return update("OutDataMngDAO.createPopGenderAge", param);
	}
	
	/**
	 * 50셀단위 성연령별 유동인구 테이블 데이터 추가하기
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertPopGenderAge(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.insertPopGenderAge", param);
	}

	/**
	 * 50셀단위 성연령별 유동인구 임시 테이블 삭제하기 (IF)	
	 * iff_agender_50cell_if
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deletePopGenderAge(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.deletePopGenderAge", param);
	}
	

	/**
	 * 행정동별 일자별 외국인 생활인구 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createPopDongForgService(Map<String, Object> param) throws IOException, SQLException {

		return update("OutDataMngDAO.createPopDongForgService", param);
	}
	
	/**
	 * 행정동별 일자별 외국인 생활인구 테이블 데이터 추가하기
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertPopDongForgService(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.insertPopDongForgService", param);
	}

	/**
	 * 행정동별 일자별 외국인 생활인구 임시 테이블 삭제하기 (IF)	
	 * iff_forn_if
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deletePopDongForgService(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.deletePopDongForgService", param);
	}
	

	/**
	 * 50셀단위 시간대별 유동인구 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createPopTimeFlow(Map<String, Object> param) throws IOException, SQLException {

		return update("OutDataMngDAO.createPopTimeFlow", param);
	}
	
	/**
	 * 50셀단위 시간대별 유동인구 테이블 데이터 추가하기
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertPopTimeFlow(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.insertPopTimeFlow", param);
	}

	/**
	 * 50셀단위 시간대별 유동인구 임시 테이블 삭제하기 (IF)	
	 * iff_hourly_50cell_if
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deletePopTimeFlow(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.deletePopTimeFlow", param);
	}
	

	/**
	 * 행정동별 성연령별 생활인구 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createPopDongGenderAge(Map<String, Object> param) throws IOException, SQLException {

		return update("OutDataMngDAO.createPopDongGenderAge", param);
	}
	
	/**
	 * 행정동별 성연령별 생활인구 테이블 데이터 추가하기
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertPopDongGenderAge(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.insertPopDongGenderAge", param);
	}

	/**
	 * 행정동별 성연령별 생활인구 임시 테이블 삭제하기 (IF)	
	 * iff_hourly_50cell_if
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deletePopDongGenderAge(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.deletePopDongGenderAge", param);
	}
	

	/**
	 * 행정동 성연령별 유입지 조합 생활인구 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createPopGenderAgeService(Map<String, Object> param) throws IOException, SQLException {

		return update("OutDataMngDAO.createPopGenderAgeService", param);
	}
	
	/**
	 * 행정동 성연령별 유입지 조합 생활인구 테이블 데이터 추가하기
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertPopGenderAgeService(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.insertPopGenderAgeService", param);
	}

	/**
	 * 행정동 성연령별 유입지 조합 생활인구 임시 테이블 삭제하기 (IF)	
	 * iff_sex_age_time_if
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deletePopGenderAgeService(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.deletePopGenderAgeService", param);
	}
	
	/**
	 * 행정동별 유입지별 생활인구 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createPopFlowService(Map<String, Object> param) throws IOException, SQLException {

		return update("OutDataMngDAO.createPopFlowService", param);
	}
	
	/**
	 * 행정동별 유입지별 생활인구 테이블 데이터 추가하기
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertPopFlowService(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.insertPopFlowService", param);
	}

	/**
	 * 행정동별 유입지별 생활인구 임시 테이블 삭제하기 (IF)	
	 * iff_time_if
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deletePopFlowService(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.deletePopFlowService", param);
	}
	

	/**
	 * 법인매출 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createSaleCorp(Map<String, Object> param) throws IOException, SQLException {

		return update("OutDataMngDAO.createSaleCorp", param);
	}
	
	/**
	 * 법인매출 테이블 데이터 추가하기
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertSaleCorp(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.insertSaleCorp", param);
	}

	/**
	 * 법인매출 임시 테이블 삭제하기 (IF)	
	 * ifc_corp_sls_if
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deleteSaleCorp(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.deleteSaleCorp", param);
	}
	

	/**
	 * 외국인 매출 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createSaleForeigner(Map<String, Object> param) throws IOException, SQLException {

		return update("OutDataMngDAO.createSaleForeigner", param);
	}
	
	/**
	 * 외국인 매출 테이블 데이터 추가하기
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertSaleForeigner(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.insertSaleForeigner", param);
	}

	/**
	 * 외국인 매출 임시 테이블 삭제하기 (IF)	
	 * ifc_corp_sls_if
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deleteSaleForeigner(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.deleteSaleForeigner", param);
	}
	

	/**
	 * 일별/시간대별 매출 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createSaleDayTime(Map<String, Object> param) throws IOException, SQLException {

		return update("OutDataMngDAO.createSaleDayTime", param);
	}
	
	/**
	 * 일별/시간대별 매출 테이블 데이터 추가하기
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertSaleDayTime(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.insertSaleDayTime", param);
	}

	/**
	 * 일별/시간대별 매출 임시 테이블 삭제하기 (IF)	
	 * ifc_hr_sls_if
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deleteSaleDayTime(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.deleteSaleDayTime", param);
	}

	/**
	 * 월별/유입지별 매출 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createSaleMonthFlow(Map<String, Object> param) throws IOException, SQLException {

		return update("OutDataMngDAO.createSaleMonthFlow", param);
	}
	
	/**
	 * 월별/유입지별 매출 테이블 데이터 추가하기
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertSaleMonthFlow(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.insertSaleMonthFlow", param);
	}

	/**
	 * 월별/유입지별 매출 임시 테이블 삭제하기 (IF)	
	 * ifc_inflow_sls
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deleteSaleMonthFlow(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.deleteSaleMonthFlow", param);
	}

	/**
	 * 일별/성별/연령대별 매출 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createSaleDayGenderAge(Map<String, Object> param) throws IOException, SQLException {

		return update("OutDataMngDAO.createSaleDayGenderAge", param);
	}
	
	/**
	 * 일별/성별/연령대별 매출 테이블 데이터 추가하기
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertSaleDayGenderAge(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.insertSaleDayGenderAge", param);
	}

	/**
	 * 일별/성별/연령대별 매출 임시 테이블 삭제하기 (IF)	
	 * ifc_inflow_sls
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deleteSaleDayGenderAge(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.deleteSaleDayGenderAge", param);
	}

	/**
	 * 의정부시민 매출 임시 테이블 생성
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createSaleCitizen(Map<String, Object> param) throws IOException, SQLException {

		return update("OutDataMngDAO.createSaleCitizen", param);
	}
	
	/**
	 * 의정부시민 매출 테이블 데이터 추가하기
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertSaleCitizen(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.insertSaleCitizen", param);
	}

	/**
	 * 의정부시민 매출 임시 테이블 삭제하기 (IF)	
	 * ifc_ujb_ctzn_sls_if
	 * @param param
	 * @param codeId
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deleteSaleCitizen(Map<String, Object> param) throws IOException, SQLException {

		return delete("OutDataMngDAO.deleteSaleCitizen", param);
	}
}
