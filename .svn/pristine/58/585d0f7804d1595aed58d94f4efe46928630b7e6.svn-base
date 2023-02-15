package kr.go.uijeongbu.dashBoard.company.productionTrend.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

@Repository("productionTrendMapper")
public class ProductionTrendMapper extends ComAbstractDAO {

	/**
	 * 대시보드 기업 동향 - 연간 업종별 기업부채비율
	 * @return
	 */
	public List<Map<String, Object>> selectProductSales() {
		return selectList("ProductionTrendMapper.selectProductSales");
	}

	/**
	 * 대시보드 기업 동향 - 신생기업 생존율
	 * @return
	 */
	public List<Map<String, Object>> selectSurvivalRate() {
		return selectList("ProductionTrendMapper.selectSurvivalRate");
	}

	/**
	 * 대시보드 기업 동향 - 신생기업 생존율
	 * @return
	 */
	public List<Map<String, Object>> selectMonthClosed() {
		return selectList("ProductionTrendMapper.selectMonthClosed");
	}

	/**
	 * 대시보드 기업 동향 - 신생기업 생존율
	 * @return
	 */
	public List<Map<String, Object>> selectCompanyIndustry() {
		return selectList("ProductionTrendMapper.selectCompanyIndustry");
	}
	
}
