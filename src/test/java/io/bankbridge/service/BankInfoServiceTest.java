package io.bankbridge.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;

import io.bankbridge.model.BankModel;
import io.bankbridge.util.CacheUtils;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(io.bankbridge.service.BankInfoService.class)
class BankInfoServiceTest {

	private static List<BankModel> banksList;

	@BeforeEach
	public void setUp(){
		banksList = new ArrayList<>();
	}

	@Test
	void testGetBanksFromCache() throws IOException {
		/*PowerMockito.mockStatic(BankInfoService.class);		
		PowerMockito.mockStatic(CacheService.class);
		PowerMockito.mockStatic(CacheUtils.class);*/
		
		BankModel bank1 = new BankModel("1234", "Royal Bank of Boredom", "GB", "OAUTH");
		BankModel bank2 = new BankModel("5678", "Credit Sweets", "CH", "OpenID");
		BankModel bank3 = new BankModel("9870", "Banco de espiritu santo", "PT", "SSL");
		banksList.add(bank1);
		banksList.add(bank2);
		banksList.add(bank3);
		//ms.when(BankInfoService::getBanks).thenReturn(banksList);
		List<BankModel> banks = BankInfoService.getBanks();
		assertNotNull(banks);
		assertEquals(3, banks.size());
	}

}
