package kr.go.uijeongbu.dashBoard.economy.card.service;

import java.util.List;
import java.util.Map;

public interface CardEconomyService {
	Map<String, Object> selectCardEconomyMaxDate();
	
	List<Map<String, Object>> selectCardEconomyAgeCategory(Map<String, Object> params);
	List<Map<String, Object>> selectCardEconomyEmd(Map<String, Object> params);
	List<Map<String, Object>> selectCardEconomyWeek(Map<String, Object> params);
	List<Map<String, Object>> selectCardEconomyMonth(Map<String, Object> params);
}
