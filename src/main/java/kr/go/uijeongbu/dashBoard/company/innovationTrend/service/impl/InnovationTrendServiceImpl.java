package kr.go.uijeongbu.dashBoard.company.innovationTrend.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.company.innovationTrend.service.InnovationTrendService;

@Service("innovationTrendService")
public class InnovationTrendServiceImpl implements InnovationTrendService {

	@Resource(name = "innovationTrendMapper")
	private InnovationTrendMapper innovationTrendMapper;

	@Override
	public List<Map<String, Object>> selectCompanyInnovation() {
		return innovationTrendMapper.selectCompanyInnovation();
	}

	@Override
	public List<Map<String, Object>> selectCompanyInvestment() {
		return innovationTrendMapper.selectCompanyInvestment();
	}

	@Override
	public List<Map<String, Object>> selectCompanyRnd() {
		return innovationTrendMapper.selectCompanyRnd();
	}

}
