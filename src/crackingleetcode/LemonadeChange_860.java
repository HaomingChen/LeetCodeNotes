package crackingleetcode;

/**
 * At a lemonade stand, each lemonade costs $5.
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct
 * change to each customer, so that the net transaction is that the customer pays $5.
 * Note that you don't have any change in hand at first.
 * Return true if and only if you can provide every customer with correct change.
 *
 * @author 58212
 * @date 2020-01-25 21:35
 */
public class LemonadeChange_860 {

    public boolean lemonadeChange(int[] bills) {
        int[] billCount = new int[2];
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                billCount[0] += 1;
            }else if(bills[i] == 10){
                billCount[0] -= 1;
                billCount[1] += 1;
                if(billCount[0] < 0){
                    return false;
                }
            }else{
                if(billCount[1] > 0 && billCount[0] > 0){
                    billCount[1] -= 1;
                    billCount[0] -= 1;
                }else if(billCount[0] > 3){
                    billCount[0] -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

}
