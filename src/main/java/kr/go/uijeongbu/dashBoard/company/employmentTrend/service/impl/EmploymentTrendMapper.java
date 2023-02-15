package kr.go.uijeongbu.dashBoard.company.employmentTrend.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

@Repository("employmentTrendMapper")
public class EmploymentTrendMapper extends ComAbstractDAO {

	public String selectEmdEmploymentLastYear() {
		return selectOne("EmploymentTrendMapper.selectEmdEmploymentLastYear");
	}
	public Map<String, Object> selectEmdEmploymentMinMaxYear() {
		return selectOne("EmploymentTrendMapper.selectEmdEmploymentMinMaxYear");
	}
	public List<Map<String, Object>> selectEmdEmploymentRange(Map<String, Object> params) {
		return selectList("EmploymentTrendMapper.selectEmdEmploymentRange", params);
	}
	public Map<String, Object> selectEmdEmploymentDefaultMap() {
		return selectOne("EmploymentTrendMapper.selectEmdEmploymentDefaultMap");
	}
	public Map<String, Object> selectEmdEmploymentCnt(Map<String, Object> params) {
		return selectOne("EmploymentTrendMapper.selectEmdEmploymentCnt", params);
	}
	public List<Map<String, Object>> selectEmployeeCnt() {
		return selectList("EmploymentTrendMapper.selectEmployeeCnt");
	}
	public List<Map<String, Object>> selectIndustryAvgPay() {
		return selectList("EmploymentTrendMapper.selectIndustryAvgPay");
	}
	public List<Map<String, Object>> selectEntrantRetirees() {
		return selectList("EmploymentTrendMapper.selectEntrantRetirees");
	}
	public List<Map<String, Object>> selectYearAvgPay() {
		return selectList("EmploymentTrendMapper.selectYearAvgPay");
	}
}
