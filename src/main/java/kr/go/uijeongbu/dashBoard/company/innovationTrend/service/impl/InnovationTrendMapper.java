package kr.go.uijeongbu.dashBoard.company.innovationTrend.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

@Repository("innovationTrendMapper")
public class InnovationTrendMapper extends ComAbstractDAO {
	
	public List<Map<String, Object>> selectCompanyInnovation() {
		return selectList("InnovationTrendMapper.selectCompanyInnovation");
	}
	public List<Map<String, Object>> selectCompanyInvestment() {
		return selectList("InnovationTrendMapper.selectCompanyInvestment");
	}
	public List<Map<String, Object>> selectCompanyRnd() {
		return selectList("InnovationTrendMapper.selectCompanyRnd");
	}
}
