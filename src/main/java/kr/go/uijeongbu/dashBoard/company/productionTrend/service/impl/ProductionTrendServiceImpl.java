package kr.go.uijeongbu.dashBoard.company.productionTrend.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.company.productionTrend.service.ProductionTrendService;

@Service("productionTrendService")
public class ProductionTrendServiceImpl implements ProductionTrendService {
	
	@Resource(name = "productionTrendMapper")
	private ProductionTrendMapper productionTrendMapper;

	@Override
	public List<Map<String, Object>> selectProductSales() {
		return productionTrendMapper.selectProductSales();
	}

	@Override
	public List<Map<String, Object>> selectSurvivalRate() {
		return productionTrendMapper.selectSurvivalRate();
	}

	@Override
	public List<Map<String, Object>> selectMonthClosed() {
		return productionTrendMapper.selectMonthClosed();
	}

	@Override
	public List<Map<String, Object>> selectCompanyIndustry() {
		return productionTrendMapper.selectCompanyIndustry();
	}

}
