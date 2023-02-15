package kr.go.uijeongbu.dashBoard.economy.local.service;

import java.util.List;
import java.util.Map;

public interface LocalEconomyService {
	
	Map<String, Object> selectLocalEconomyMaxDate();

	List<Map<String, Object>> selectLocalEconomyRange();
	Map<String, Object> selectLocalEconomyDefaultMap();
	Map<String, Object> selectLocalEconomyCnt();
	
	List<Map<String, Object>> selectLocalEconomyList();
	List<Map<String, Object>> selectEmdEconomy(Map<String, Object> params);
	List<Map<String, Object>> selectEmdStore(Map<String, Object> params);
	List<Map<String, Object>> selectTypeStore(Map<String, Object> params);

	Map<String, Object> selectEmdEconomyDate(Map<String, Object> params);
	Map<String, Object> selectEmdStoreDate(Map<String, Object> params);
	Map<String, Object> selectTypeStoreDate(Map<String, Object> params);

	Map<String, Object> selectLocalEconomyListDate(Map<String, Object> params);
}
