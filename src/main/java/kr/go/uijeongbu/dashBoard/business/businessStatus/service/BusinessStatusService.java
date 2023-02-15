package kr.go.uijeongbu.dashBoard.business.businessStatus.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 사업 - 사업추진 현황 service 클래스
 * @author 김부권
 * @since 2021. 08. 09.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 09.	        김 부 권              최초생성
 *   
 * </pre>
 */


public interface BusinessStatusService {
	
	/**
	 * 대시보드 재정 - 신속집행 대시보드 검색기간  조회
	 * @param param
	 * @return
	 */
	Map<String, Object> selectBusiStatusDate();
	
	/**
	 * 대시보드 사업추진 - 희망도시  데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectBusiStatusHoep(Map<String, Object> param);
	
	/**
	 * 대시보드 사업추진 - 선진교통도시 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectBusiStatusTrans(Map<String, Object> param);
	
	/**
	 * 대시보드 사업추진 - 교육선도도시 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectBusiStatusEducation(Map<String, Object> param);
	
	/**
	 * 대시보드 사업추진 - 복지도시 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectBusiStatusWelfare(Map<String, Object> param);
	
	/**
	 * 대시보드 사업추진 - 행정도시 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectBusiStatusPublic(Map<String, Object> param);
	
	/**
	 * 대시보드 사업추진 - 클릭한 정보가져오기
	 * @param param
	 * @return
	 */
	Map<String, Object> selectBusiStatusLoad(Map<String, Object> param);
	
	
	
}
