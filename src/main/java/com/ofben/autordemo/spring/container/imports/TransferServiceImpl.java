package com.ofben.autordemo.spring.container.imports;

/**
 * Bean
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
public class TransferServiceImpl implements TransferService {
    private AccountRepository accountRepository;

    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void transfer(double v, String str1, String str2) {
        System.out.println("TransferServiceImpl + transfer" );
    }
}
