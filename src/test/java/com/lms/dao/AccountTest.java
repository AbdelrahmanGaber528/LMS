    package com.lms.dao;

    import com.lms.dao.Account.AccountDAO;
    import com.lms.models.Account;
    import org.junit.jupiter.api.Test;

    import java.util.List;

    public class AccountTest {
            AccountDAO accountDAO = new AccountDAO();
        Account account = new Account("Mohammed","0000","Admin");
//        Account a2 = new Account("Ahmed","0000","Admin");
//        Account a3 = new Account("Ahmed","0000","Admin");
//        Account a4 = new Account("Ahmed","0000","Admin");
//        Account a5 = new Account("Ahmed","0000","Admin");
//        Account a6 = new Account("Ahmed","0000","Admin");
//        Account a7 = new Account("Mohammed","0000","Admin");

            @Test
            public void testInsert(){
                accountDAO.addNewAccount(account);
                System.out.println("Inserted Account ID: " + account.getAccountID());

//                accountDAO.addNewAccount(a2);
//                System.out.println("Inserted Account ID: " + a2.getAccountID());
//
//                accountDAO.addNewAccount(a3);
//                System.out.println("Inserted Account ID: " + a3.getAccountID());
//
//                accountDAO.addNewAccount(a4);
//                System.out.println("Inserted Account ID: " + a4.getAccountID());
//
//                accountDAO.addNewAccount(a5);
//                System.out.println("Inserted Account ID: " + a5.getAccountID());
//
//                accountDAO.addNewAccount(a6);
//                System.out.println("Inserted Account ID: " + a6.getAccountID());
            }
        @Test
        public void testDelete(){
            AccountDAO dao = new AccountDAO();

            // Load existing accounts
            List<Account> accounts = dao.getAllAccounts();

            // Check and delete the first account
            if (!accounts.isEmpty()) {
                Account account = accounts.getFirst();
                System.out.println("Loaded Account ID: " + account.getAccountID());

                // Delete the account
                dao.deleteAccount(account);
                System.out.println("Deleted Account ID: " + account.getAccountID());
            } else {
                System.out.println("No accounts found for deletion.");
            }
        }
//        @Test
//        public void testGetValidate(){
//                Account mohammed = accountDAO.getValidateAccount("3");
//                accountDAO.deleteAccount(mohammed);
//            System.out.println("The id for deleted : " + mohammed.getAccountID());
//        }
    }
