package kr.go.uijeongbu.dashBoard.revenue.revenueOverdue.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.revenue.revenueOverdue.service.RevenueOverdueService;

/**
 * 대시보드 세입현황 - 체납 및  수납 현황 ServiceImpl클래스
 * @author 김부권
 * @since 2021. 08. 09.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  ----------9.	        김 부 권              최초생성
 *   
 * </pre>
 */

@Service("revenueOverdueService")
public class RevenueOverdueServiceImpl implements RevenueOverdueService {
	
	@Resource(name = "revenueOverdueMapper")
	private RevenueOverdueMapper revenueOverdueMapper;

	@Override
	public Map<String, Object> selectRevnOverdueDate() {
		// TODO Auto-generated method stub
		return revenueOverdueMapper.selectRevnOverdueDate();
	}
	
	@Override
	public List<Map<String, Object>> selectRevnOverdueMapRange(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return revenueOverdueMapper.selectRevnOverdueMapRange(param);
	}

	@Override
	public List<Map<String, Object>> selectRevnOverdueYear(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return revenueOverdueMapper.selectRevnOverdueYear(param);
	}

	@Override
	public Map<String, Object> selectRevnOverdueMap(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return revenueOverdueMapper.selectRevnOverdueMap(param);
	}

	@Override
	public List<Map<String, Object>> selectRevnOverdueStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return revenueOverdueMapper.selectRevnOverdueStatus(param);
	}
	
	@Override
	public List<Map<String, Object>> selectRevnOverdueTable(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return revenueOverdueMapper.selectRevnOverdueTable(param);
	}


	


}
