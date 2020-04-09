package bst;

public class NonCommercialAccount extends Account{

  public NonCommercialAccount(String accountNumber, Customer customer){
    // Call parent Constructor
    super(accountNumber, customer);
  }

  @Override
  public int compareTo(Integer integer) {
    return 0;
  }
}
