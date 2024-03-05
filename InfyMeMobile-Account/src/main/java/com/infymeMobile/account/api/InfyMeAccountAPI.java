package com.infymeMobile.account.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infymeMobile.account.dto.BankAccountDTO;
import com.infymeMobile.account.dto.TransactionDTO;
import com.infymeMobile.account.exception.InfyMeMobileGlobalHandlerException;
import com.infymeMobile.account.service.BankAccountService;
import com.infymeMobile.account.service.DigitalBankAccountService;
import com.infymeMobile.account.service.TransactionService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;

@RestController
@Validated
@RequestMapping("/infymemobile/account")
public class InfyMeAccountAPI {

	@Autowired
	BankAccountService bankaccountservice;

	@Autowired
	DigitalBankAccountService digitalBankAccountService;

	@Autowired
	TransactionService transactionService;

	@Autowired
	Environment environment;

	@PostMapping()
	public ResponseEntity<String> createAccont(@RequestBody @Validated BankAccountDTO bankaccountDTO)
			throws InfyMeMobileGlobalHandlerException {

		String bankAcc = bankaccountservice.createAccount(bankaccountDTO);
		return new ResponseEntity<String>(bankAcc, HttpStatus.CREATED);
	}

	@GetMapping("/{MobileNumber}")
	public ResponseEntity<List<BankAccountDTO>> listAccounts(
			@PathVariable @Digits(fraction = 0, integer = 10, message = "{bankaccount.mobilenumber.invalid}") Long mobileNumber)
			throws InfyMeMobileGlobalHandlerException {

		List<BankAccountDTO> list1 = bankaccountservice.listAccounts(mobileNumber);
		return new ResponseEntity<List<BankAccountDTO>>(list1, HttpStatus.OK);
	}

	@PostMapping("/{mobileNumber}/{accountNumber}")
	public ResponseEntity<String> linkAccount(
			@PathVariable @Digits(fraction = 0, integer = 10, message = "{bankaccount.mobilenumber.invalid}") Long mobileNumber,
			@PathVariable @Min(value = 7, message = "{bankaccount.accountnumber.invalid}") Long accountNumber,
			@PathVariable Integer otp) throws InfyMeMobileGlobalHandlerException {

		String linked1 = digitalBankAccountService.linkAccount(mobileNumber, accountNumber, otp);
		return new ResponseEntity<String>(linked1, HttpStatus.CREATED);
	}

	@GetMapping("/balance/{mobileNumber}/{accountNumber}")
	public ResponseEntity<Double> checkBalance(
			@PathVariable @Digits(fraction = 0, integer = 10, message = "{bankaccount.mobilenumber.invalid}") Long mobileNumber,
			@PathVariable @Min(value = 7, message = "{bankaccount.accountnumber.invalid}") Long accountNumber)
			throws InfyMeMobileGlobalHandlerException {

		Double bal = bankaccountservice.checkBalance(mobileNumber, accountNumber);
		return new ResponseEntity<Double>(bal, HttpStatus.OK);
	}

	@PutMapping("/fundtransfer")
	public ResponseEntity<String> fundTransfer(@RequestBody @Valid TransactionDTO transactionDTO)
			throws InfyMeMobileGlobalHandlerException {

		String trans = transactionService.fundTransfer(transactionDTO);
		return new ResponseEntity<String>(trans, HttpStatus.OK);
	}

	@GetMapping("/statement/{MobileNumber}")
	public ResponseEntity<List<TransactionDTO>> accountStatement(
			@PathVariable @Digits(fraction = 0, integer = 10, message = "{bankaccount.mobilenumber.invalid}") Long mobileNumber)
			throws InfyMeMobileGlobalHandlerException {

		List<TransactionDTO> list2 = transactionService.accountStatement(mobileNumber);
		return new ResponseEntity<List<TransactionDTO>>(list2, HttpStatus.OK);
	}

}
