package kr.jip.api.v1.bank;

import kr.jip.api.model.ResponseMain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static java.util.stream.Collectors.toList;
import static kr.jip.api.v1.bank.EBankAccountStyle.getBankMaskingFormat;

@Slf4j
@Service
public class BankService {

	// Mappers
	@Autowired
	BankMapper bankMapper;

	public ResponseMain list(int userId) {
		return ResponseMain.builder()
				.result("Y")
				.list(bankMapper.selectBankByUserId(new HashMap(){{
					put("userId", userId);
				}})
						.stream()
						.peek(bank -> bank.setMaskAccount(getBankMaskingFormat(bank)))
						.collect(toList()))
				.build();
	}

	public void insertBank(int userId, String bankName, String account) {
		bankMapper.insertBank(new HashMap(){{
			put("userId", userId);
			put("bankName", bankName);
			put("account", account);
		}});
	}

	public void removeBank(int userId, String bankName) {
		bankMapper.removeBank(new HashMap(){{
			put("userId", userId);
			put("bankName", bankName);
		}});
	}


}
