package kr.go.uijeongbu.dashBoard.finance.financeExecution.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 재정 - 재정 현황 mapper 클래스
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

@Repository("financeExecutionMapper")
public class FinanceExecutionMapper extends ComAbstractDAO {
	
	/**
	 * 대시보드 재정 - 신속집행 대시보드 검색기간  조회
	 * @return
	 */
	public Map<String, Object> selectFinExecutionDate() {
		return selectOne("FinanceExecutionMapper.selectFinExecutionDate");
	}
	
	
	/**
	 * 대시보드 신속집행 - 부서별 신속집행 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectFinExecutionDept(Map<String, Object> param) {
		return selectList("FinanceExecutionMapper.selectFinExecutionDept", param);
	}
	
	
	/**
	 * 대시보드 신속집행 - 부서별 신속집행 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectFinExecutionSort(Map<String, Object> param) {
		return selectList("FinanceExecutionMapper.selectFinExecutionSort", param);
	}
	

	

}
