package kr.go.uijeongbu.dashBoard.economy.card.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.economy.card.service.CardEconomyService;

@Service("cardEconomyService")
public class CardEconomyServiceImpl implements CardEconomyService {

	@Resource(name = "cardEconomyMapper")
	private CardEconomyMapper cardEconomyMapper;

	@Override
	public Map<String, Object> selectCardEconomyMaxDate() {
		return cardEconomyMapper.selectCardEconomyMaxDate();
	}

	@Override
	public List<Map<String, Object>> selectCardEconomyAgeCategory(Map<String, Object> params) {
		return cardEconomyMapper.selectCardEconomyAgeCategory(params);
	}

	@Override
	public List<Map<String, Object>> selectCardEconomyEmd(Map<String, Object> params) {
		return cardEconomyMapper.selectCardEconomyEmd(params);
	}

	@Override
	public List<Map<String, Object>> selectCardEconomyWeek(Map<String, Object> params) {
		return cardEconomyMapper.selectCardEconomyWeek(params);
	}

	@Override
	public List<Map<String, Object>> selectCardEconomyMonth(Map<String, Object> params) {
		return cardEconomyMapper.selectCardEconomyMonth(params);
	}

}
