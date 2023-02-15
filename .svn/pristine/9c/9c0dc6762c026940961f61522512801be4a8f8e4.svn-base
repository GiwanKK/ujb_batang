package kr.go.uijeongbu.dashBoard.finance.financeStatus.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 재정 - 재정 현황 service 클래스
 * @author 김부권
 * @since 2021. 08. 03.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 03.	        김 부 권              최초생성
 *   
 * </pre>
 */
public interface FinanceStatusService {
	
	/**
	 * 대시보드 재정 - 재정분석 날짜 조회
	 * @param param
	 * @return
	 */
	Map<String, Object> selectFinStatusDate();
	
	/**
	 * 대시보드 재정 - 부서별 예산 현황 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectFinanceStatusDept(Map<String, Object> param);
	
	/**
	 * 대시보드 대시보드 재정 - 분야 부문별 예산 현황 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectFinStatusSort(Map<String, Object> param);
	
	/**
	 * 대시보드 재정 - 부서별집행현황 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectFinStatusExecution(Map<String, Object> param);
	
	/**
	 * 대시보드 재정현황 - 부서별 계약현황 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectFinStatusContract(Map<String, Object> param);
	/**
	 * 대시보드 재정현황 - 부서별 계약현황 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectFinStatusContractList(Map<String, Object> param);
	
	
}
