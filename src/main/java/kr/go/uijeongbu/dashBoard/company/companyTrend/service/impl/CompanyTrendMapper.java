package kr.go.uijeongbu.dashBoard.company.companyTrend.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

@Repository("companyTrendMapper")
public class CompanyTrendMapper extends ComAbstractDAO {

	public List<Map<String, Object>> selectEmdCompanyRange() {
		return selectList("CompanyTrendMapper.selectEmdCompanyRange");
	}
	public Map<String, Object> selectEmdCompanyDefaultMap() {
		return selectOne("CompanyTrendMapper.selectEmdCompanyDefaultMap");
	}
	public Map<String, Object> selectEmdCompanyCnt() {
		return selectOne("CompanyTrendMapper.selectEmdCompanyCnt");
	}
	public List<Map<String, Object>> selectYearCompanySales(Map<String, Object> param) {
		return selectList("CompanyTrendMapper.selectYearCompanySales", param);
	}
	public List<Map<String, Object>> selectEmdCompanyStats() {
		return selectList("CompanyTrendMapper.selectEmdCompanyStats");
	}
	public List<Map<String, Object>> selectIndustryRate() {
		return selectList("CompanyTrendMapper.selectIndustryRate");
	}
	public List<Map<String, Object>> selectIndustryProfit() {
		return selectList("CompanyTrendMapper.selectIndustryProfit");
	}
}
