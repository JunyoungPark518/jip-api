package kr.jip.api.v1.bank;

import kr.jip.api.config.db.annotation.JipDB;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@JipDB
public interface BankMapper {

	@SelectProvider(type = BankProvider.class, method = "selectBankByUserId")
	List<Bank> selectBankByUserId(Map param);

	@InsertProvider(type = BankProvider.class, method = "insertBank")
	Integer insertBank(Map param);

	@DeleteProvider(type = BankProvider.class, method = "removeBank")
	Integer removeBank(Map param);
}
