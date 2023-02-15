package kr.go.uijeongbu.dashBoard.company.innovationTrend.service;

import java.util.List;
import java.util.Map;

public interface InnovationTrendService {
	List<Map<String, Object>> selectCompanyInnovation();
	List<Map<String, Object>> selectCompanyInvestment();
	List<Map<String, Object>> selectCompanyRnd();
}
