package kr.go.uijeongbu.dashBoard.calamity.calamityStatus.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 재난 - 재난 현황 service 클래스
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


public interface CalamityStatusService {
	
	
	/**
	 * 대시보드 재난현황 - 의정부시 행정동 데이터 조회
	 * @param param
	 * @return
	 */
	Map<String, Object> selectCalaAdmdMap(Map<String, Object> param);
	
	/**
	 * 대시보드 재난현황 - 재난 돌발상황정보 데이터 조회
	 * @param param
	 * @return
	 */
	Map<String, Object> selectCalaStatusMap(Map<String, Object> param);
	
	/**
	 * 대시보드 재난현황 - 재난 돌발상황정보 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCalaStatusData(Map<String, Object> param);
	
	/**
	 * 대시보드 재난현황 - 재난 유형별 구조수 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCalaCaseCnt(Map<String, Object> param);
	
	/**
	 * 대시보드 재난현황 - 재난 발화장소별 화재 발생 누적현황 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCalaPlaceTotal(Map<String, Object> param);
	
	/**
	 * 대시보드 재난현황 - 재난 발화요인별 화재 발생 누적현황 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCalaFactorTotal(Map<String, Object> param);
	
	
	
	
}
