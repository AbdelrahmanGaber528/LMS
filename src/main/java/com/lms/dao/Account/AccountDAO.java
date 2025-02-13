    package com.lms.dao.Account;

    import com.lms.models.Account;
    import com.lms.util.ColumnName;
    import com.lms.util.LMSFileManager;

    import java.io.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Map;
    import java.util.TreeMap;

    public class AccountDAO {

        private final LMSFileManager accountFileManager ;

        private static int idCounter = 0;

        public AccountDAO() {
            accountFileManager  = new LMSFileManager("src/main/docs/Accounts.txt");
            File file = new File("src/main/docs/idCounter.txt");
            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    idCounter = Integer.parseInt(reader.readLine().trim());
                } catch (IOException e) {
                    System.err.println("Can't read the id from file: " + e.getMessage());
                }
            }
        }

        public void addNewAccount(Account account){
            try{
                int newId = generateId();
                account.setId(String.valueOf(newId)); // Set the generated ID
                accountFileManager.insertRow(createAccountMap(account));
            }catch(IOException e){
                System.err.println("Problem in adding account :"+e.getMessage());
            }
        }

        public void updateAccount(Account account){
            accountFileManager.updateRow(createAccountMap(account));
        }

        public void deleteAccount(Account account){
            accountFileManager.deleteRow(createAccountMap(account));
            System.err.println("Deletion end");
        }

        public void clearAccounts(String role){
            try {
                List<String> accounts = accountFileManager.getAllRows();
                for(String account : accounts){
                    String[] details = account.split("\t");
                    if(details.length >=5 && details[3].trim().equalsIgnoreCase(role.trim()))
                        accountFileManager.deleteRow(createAccountMap(createAccountFromString(account)));
                }
            }catch (IOException e){
                System.err.println("Error in clearing accounts :"+e.getMessage());
            }
        }

        public List<Account> getAllAccounts(){
            List<Account> accounts = new ArrayList<>();
            try{
                List<String> rows = accountFileManager.getAllRows();
                for (int i = 1; i < rows.size(); i++) {
                    String account = rows.get(i);
                    Account account1 = createAccountFromString(account);
                    accounts.add(account1);
                }
            }catch (IOException e ){
                System.err.println("Error in getAllAccounts method :"+e.getMessage());
            }
            return accounts;
        }

        public Account getById(String id){
            List<Account> accounts = getAllAccounts();
            for(Account account : accounts){
                if(account.getAccountID().contains(id))
                    return account;
            }
            return null;
        }



        
        private Map<ColumnName ,String> createAccountMap(Account account){
            Map<ColumnName ,String > accountMap = new TreeMap<>();

            accountMap.put(ColumnName.USER_ID,account.getAccountID());
            accountMap.put(ColumnName.IS_ACTIVE,account.isActive());
            accountMap.put(ColumnName.USER_NAME,account.getUserName());
            accountMap.put(ColumnName.PASSWORD,account.getPassword());
            accountMap.put(ColumnName.ROLE,account.getRole());

            return accountMap;
        }

        private Account createAccountFromString(String account){
            String[] details = account.split("\t");
            Account account1 = new Account();
            account1.setId(details[0]);
            account1.setUserName(details[1]);
            account1.setPassword(details[2]);
            account1.setRole(details[3]);
//            account1.setIsActive(Boolean.valueOf(details[4]));

            return account1;
        }
        public  int generateId() {
            idCounter++;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/docs/idCounter.txt"))) {
                writer.write(String.valueOf(idCounter));
            } catch (IOException e) {
                System.err.println("Can't write new id to file: " + e.getMessage());
            }
            return idCounter;
        }
    }
