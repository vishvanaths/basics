import java.util.*;

public class AccountsMerge_L721 {
    public static void main(String[] args) {
        String[][]accountsArr = {{"John", "johnsmith@mail.com", "john00@mail.com"},
                {"John", "johnnybravo@mail.com"},
                {"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}};
        List<List<String>> accounts = new ArrayList<>();
        for(int i=0; i<accountsArr.length; i++){
            List<String> accountInfo = new ArrayList<>();
            for(int j=0; j< accountsArr[i].length; j++){
                accountInfo.add(accountsArr[i][j]);
            }
            accounts.add(accountInfo);
        }
        System.out.println(accountsMerge(accounts));
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();


        createRelations(accounts, emailToName, graph);

        List<List<String>> results = mergeAccounts(graph, emailToName);

        return results;
    }

    private static List<List<String>> mergeAccounts(Map<String, Set<String>> graph, Map<String, String> emailToName) {
        Set<String> seen = new HashSet<>();
        List<List<String>> results = new ArrayList<>();
        for(String emailKey : graph.keySet()){
            if(!seen.contains(emailKey)){
                List<String> account = new ArrayList<>();
                dfs(emailKey, account, seen, graph);
                Collections.sort(account);
                account.add(0,emailToName.get(emailKey));
                results.add(account);
            }
        }
        return results;
    }

    private static void dfs(String emailKey, List<String> account, Set<String> seen, Map<String, Set<String>> graph) {
        if(seen.add(emailKey)){
            account.add(emailKey);
            for(String neighbour : graph.get(emailKey)){
                dfs(neighbour,account,seen,graph);
            }
        }
    }

    private static void createRelations(List<List<String>> accounts, Map<String, String> emailToName, Map<String, Set<String>> graph) {
        for(List<String> accountInfo : accounts){
            String name = accountInfo.get(0);
            for(int i=1; i<accountInfo.size(); i++){
                final String email = accountInfo.get(i);
                emailToName.put(email, name);
                graph.putIfAbsent(email, new HashSet<>());

                if(i!=1){
                    String previousEmail = accountInfo.get(i-1);
                    graph.get(previousEmail).add(email);
                    graph.get(email).add(previousEmail);
                }
            }
        }
    }
}


/***
 * 721. Accounts Merge
 * Medium
 *
 * 1666
 *
 * 327
 *
 * Add to List
 *
 * Share
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 *
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Note:
 *
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 **/