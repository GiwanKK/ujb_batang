package kr.go.uijeongbu.dashBoard.finance.financeExecution.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.finance.financeExecution.service.FinanceExecutionService;

/**
 * 대시보드 재정 - 재정 현황 ServiceImpl클래스
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

@Service("financeExecutionService")
public class FinanceExecutionServiceImpl implements FinanceExecutionService {
	
	@Resource(name = "financeExecutionMapper")
	private FinanceExecutionMapper financeExecutionMapper;

	@Override
	public Map<String, Object> selectFinExecutionDate() {
		// TODO Auto-generated method stub
		return financeExecutionMapper.selectFinExecutionDate();
	}

	@Override
	public List<Map<String, Object>> selectFinExecutionDept(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return financeExecutionMapper.selectFinExecutionDept(param);
	}

	@Override
	public List<Map<String, Object>> selectFinExecutionSort(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return financeExecutionMapper.selectFinExecutionSort(param);
	}


	


}
