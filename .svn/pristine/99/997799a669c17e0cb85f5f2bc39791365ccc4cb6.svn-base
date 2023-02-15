package kr.go.uijeongbu.dashBoard.welfare.welfareStatus.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 복지현황 - service 클래스
 * @author 김혜림
 * @since 2021. 08. 05.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 05.	        김 혜 림              최초생성
 *   
 * </pre>
 */
public interface WelfareStatusService {

	//의정부 행정동 경계 조회
	List<Map<String, Object>> selectAdmdArea(Map<String, Object> params);
	
	//배경지도 조회
	Map<String, Object> selectDefaultMap(Map<String, Object> params);
	
	//데이터 존재하는 기간 조회
	Map<String, Object> selectWfStatusDate();
	
	//보육시설 현황 조회
	List<Map<String, Object>> selectChildFacilStatus(Map<String, Object> params);

	//노인복지시설 현황 조회
	List<Map<String, Object>> selectOldWfFacilStatus(Map<String, Object> params);
	
	//노인복지시설 종류별 비율 조회
	List<Map<String, Object>> selectOldWfFacilRatio(Map<String, Object> params);

	//유형별 유치원 정원 수 조회
	List<Map<String, Object>> selectKndgnLimit(Map<String, Object> params);

	//유형별 어린이집 정원 수 조회
	List<Map<String, Object>> selectNurseryLimit(Map<String, Object> params);

	//장애 정도별 수급자 수 조회
	List<Map<String, Object>> selectDisDegreeCnt(Map<String, Object> params);

	//연령별 수급자 수 조회
	List<Map<String, Object>> selectDisAgeCnt(Map<String, Object> params);
	
}
