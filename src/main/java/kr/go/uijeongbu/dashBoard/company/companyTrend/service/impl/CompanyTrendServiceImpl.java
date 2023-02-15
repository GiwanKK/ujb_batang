package kr.go.uijeongbu.dashBoard.company.companyTrend.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.company.companyTrend.service.CompanyTrendService;

@Service("companyTrendService")
public class CompanyTrendServiceImpl implements CompanyTrendService {

	@Resource(name = "companyTrendMapper")
	private CompanyTrendMapper companyTrendMapper;

	@Override
	public List<Map<String, Object>> selectEmdCompanyRange() {
		return companyTrendMapper.selectEmdCompanyRange();
	}

	@Override
	public Map<String, Object> selectEmdCompanyDefaultMap() {
		return companyTrendMapper.selectEmdCompanyDefaultMap();
	}

	@Override
	public Map<String, Object> selectEmdCompanyCnt() {
		return companyTrendMapper.selectEmdCompanyCnt();
	}

	@Override
	public List<Map<String, Object>> selectYearCompanySales(Map<String, Object> param) {
		return companyTrendMapper.selectYearCompanySales(param);
	}

	@Override
	public List<Map<String, Object>> selectEmdCompanyStats() {
		return companyTrendMapper.selectEmdCompanyStats();
	}

	@Override
	public List<Map<String, Object>> selectIndustryRate() {
		return companyTrendMapper.selectIndustryRate();
	}

	@Override
	public List<Map<String, Object>> selectIndustryProfit() {
		return companyTrendMapper.selectIndustryProfit();
	}
	
}
