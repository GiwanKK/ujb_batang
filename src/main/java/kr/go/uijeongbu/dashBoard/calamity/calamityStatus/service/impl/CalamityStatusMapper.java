package kr.go.uijeongbu.dashBoard.calamity.calamityStatus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 재난현황 - 재난 현황 mapper 클래스
 * @author 김부권
 * @since 2021. 08. 17.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 17.	        김 부 권              최초생성
 *   
 * </pre>
 */

@Repository("calamityStatusMapper")
public class CalamityStatusMapper extends ComAbstractDAO {
	
	
	/**
	 * 대시보드 재난현황 - 의정부시 행정동 데이터 조회
	 * @return
	 */
	public Map<String, Object> selectCalaAdmdMap(Map<String, Object> param) {
		return selectOne("CalamityStatusMapper.selectCalaAdmdMap", param);
	}
	
	/**
	 * 대시보드 재난현황 - 재난 돌발상황정보 데이터 조회
	 * @return
	 */
	public Map<String, Object> selectCalaStatusMap(Map<String, Object> param) {
		return selectOne("CalamityStatusMapper.selectCalaStatusMap", param);
	}
	
	
	/**
	 * 대시보드 재난현황 - 재난 돌발상황정보 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectCalaStatusData(Map<String, Object> param) {
		return selectList("CalamityStatusMapper.selectCalaStatusData", param);
	}
	
	/**
	 * 대시보드 재난현황 - 재난 유형별 구조수 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectCalaCaseCnt(Map<String, Object> param) {
		return selectList("CalamityStatusMapper.selectCalaCaseCnt", param);
	}
	
	
	/**
	 * 대시보드 재난현황 - 재난 발화장소별 화재 발생 누적현황 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectCalaPlaceTotal(Map<String, Object> param) {
		return selectList("CalamityStatusMapper.selectCalaPlaceTotal", param);
	}
	
	
	/**
	 * 대시보드 재난현황 - 재난 발화요인별 화재 발생 누적현황 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectCalaFactorTotal(Map<String, Object> param) {
		return selectList("CalamityStatusMapper.selectCalaFactorTotal", param);
	}
	
	
	

}
