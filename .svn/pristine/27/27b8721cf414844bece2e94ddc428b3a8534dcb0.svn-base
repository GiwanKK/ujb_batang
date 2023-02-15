package kr.go.uijeongbu.dashBoard.finance.financeStatus.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.finance.financeStatus.service.FinanceStatusService;

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

@Service("financeStatusService")
public class FinanceStatusServiceImpl implements FinanceStatusService {
	
	@Resource(name = "financeStatusMapper")
	private FinanceStatusMapper financeStatusMapper;

	@Override
	public Map<String, Object> selectFinStatusDate() {
		// TODO Auto-generated method stub
		return financeStatusMapper.selectFinStatusDate();
	}

	@Override
	public List<Map<String, Object>> selectFinanceStatusDept(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return financeStatusMapper.selectFinanceStatusDept(param);
	}

	@Override
	public List<Map<String, Object>> selectFinStatusSort(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return financeStatusMapper.selectFinStatusSort(param);
	}

	@Override
	public List<Map<String, Object>> selectFinStatusExecution(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return financeStatusMapper.selectFinStatusExecution(param);
	}

	@Override
	public List<Map<String, Object>> selectFinStatusContract(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return financeStatusMapper.selectFinStatusContract(param);
	}
	
	@Override
	public List<Map<String, Object>> selectFinStatusContractList(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return financeStatusMapper.selectFinStatusContractList(param);
	}



}
