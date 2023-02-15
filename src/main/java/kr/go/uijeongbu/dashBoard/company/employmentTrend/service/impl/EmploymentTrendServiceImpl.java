package kr.go.uijeongbu.dashBoard.company.employmentTrend.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.company.companyTrend.service.impl.CompanyTrendMapper;
import kr.go.uijeongbu.dashBoard.company.employmentTrend.service.EmploymentTrendService;

@Service("employmentTrendService")
public class EmploymentTrendServiceImpl implements EmploymentTrendService {

	@Resource(name = "employmentTrendMapper")
	private EmploymentTrendMapper employmentTrendMapper;

	@Override
	public String selectEmdEmploymentLastYear() {
		return employmentTrendMapper.selectEmdEmploymentLastYear();
	}

	@Override
	public List<Map<String, Object>> selectEmdEmploymentRange(Map<String, Object> params) {
		return employmentTrendMapper.selectEmdEmploymentRange(params);
	}

	@Override
	public Map<String, Object> selectEmdEmploymentDefaultMap() {
		return employmentTrendMapper.selectEmdEmploymentDefaultMap();
	}
	
	@Override
	public Map<String, Object> selectEmdEmploymentMinMaxYear() {
		return employmentTrendMapper.selectEmdEmploymentMinMaxYear();
	}

	@Override
	public Map<String, Object> selectEmdEmploymentCnt(Map<String, Object> params) {
		return employmentTrendMapper.selectEmdEmploymentCnt(params);
	}
	
	@Override
	public List<Map<String, Object>> selectEmployeeCnt() {
		return employmentTrendMapper.selectEmployeeCnt();
	}

	@Override
	public List<Map<String, Object>> selectIndustryAvgPay() {
		return employmentTrendMapper.selectIndustryAvgPay();
	}

	@Override
	public List<Map<String, Object>> selectEntrantRetirees() {
		return employmentTrendMapper.selectEntrantRetirees();
	}

	@Override
	public List<Map<String, Object>> selectYearAvgPay() {
		return employmentTrendMapper.selectYearAvgPay();
	}

}
