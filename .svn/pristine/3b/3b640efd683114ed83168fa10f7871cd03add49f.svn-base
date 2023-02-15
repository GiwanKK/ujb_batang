package kr.go.uijeongbu.dashBoard.revenue.revenueStatus.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.revenue.revenueStatus.service.RevenueStatusService;

/**
 * 대시보드 사업추진 - 사업추진 현황 ServiceImpl클래스
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

@Service("revenueStatusService")
public class RevenueStatusServiceImpl implements RevenueStatusService {
	
	@Resource(name = "revenueStatusMapper")
	private RevenueStatusMapper RevenueStatusMapper;

	@Override
	public Map<String, Object> selectRevntatusDate() {
		// TODO Auto-generated method stub
		return RevenueStatusMapper.selectRevntatusDate();
	}
	
	@Override
	public List<Map<String, Object>> selectRevnStatusChart(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return RevenueStatusMapper.selectRevnStatusChart(param);
	}

	@Override
	public List<Map<String, Object>> selectRevnStatusChartSub(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return RevenueStatusMapper.selectRevnStatusChartSub(param);
	}
	
	@Override
	public List<Map<String, Object>> selectRevnStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return RevenueStatusMapper.selectRevnStatus(param);
	}

	@Override
	public List<Map<String, Object>> selectRevnStatusYear(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return RevenueStatusMapper.selectRevnStatusYear(param);
	}

	@Override
	public List<Map<String, Object>> selectRevnStatusMain(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return RevenueStatusMapper.selectRevnStatusMain(param);
	}

	@Override
	public List<Map<String, Object>> selectRevnStatusSub(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return RevenueStatusMapper.selectRevnStatusSub(param);
	}





	


}
