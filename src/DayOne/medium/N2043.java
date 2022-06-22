package DayOne.medium;

/**
 * @author hdq
 * @create 2022-03-18 17:15
 */
public class N2043 {
    static class Bank {
        int n;
        long[] balance;
        public Bank(long[] balance) {
            this.balance = balance;
            this.n = balance.length;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (account1 < 1 || account1 > n
                    || account2 < 1 || account2 > n || balance[account1-1] < money) {
                return false;
            }else {
                balance[account1-1] -= money;
                balance[account2-1] += money;
                return true;
            }
        }

        public boolean deposit(int account, long money) {
            if (account < 1 || account > n || money < 0) {
                return false;
            }
            balance[account-1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (account <1 || account > n ||balance[account-1] < money) {
                return false;
            }
            balance[account-1] -= money;
            return true;
        }
    }

    public static void main(String[] args) {
        long[] balance = {92,62,12,81,77,38,71,8,42,38};
        Bank bank = new Bank(balance);
        bank.transfer(3,2,18);
        bank.transfer(29, 3, 99);
        bank.deposit(8, 97);
    }
}
