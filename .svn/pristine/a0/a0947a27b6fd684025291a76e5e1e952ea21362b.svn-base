package kr.go.uijeongbu.dashBoard.economy.card.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

@Repository("cardEconomyMapper")
public class CardEconomyMapper extends ComAbstractDAO {
	
	public Map<String, Object> selectCardEconomyMaxDate() {
		return selectOne("CardEconomyMapper.selectCardEconomyMaxDate");
	}

	public List<Map<String, Object>> selectCardEconomyAgeCategory(Map<String, Object> params) {
		return selectList("CardEconomyMapper.selectCardEconomyAgeCategory", params);
	}

	public List<Map<String, Object>> selectCardEconomyAge(Map<String, Object> params) {
		return selectList("CardEconomyMapper.selectCardEconomyAge", params);
	}

	public List<Map<String, Object>> selectCardEconomyEmd(Map<String, Object> params) {
		return selectList("CardEconomyMapper.selectCardEconomyEmd", params);
	}

	public List<Map<String, Object>> selectCardEconomyWeek(Map<String, Object> params) {
		return selectList("CardEconomyMapper.selectCardEconomyWeek", params);
	}

	public List<Map<String, Object>> selectCardEconomyMonth(Map<String, Object> params) {
		return selectList("CardEconomyMapper.selectCardEconomyMonth", params);
	}
}
