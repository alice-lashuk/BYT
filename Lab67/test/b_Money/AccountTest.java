package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;

	/* All tests fail at first because of the null pointer
		it was resolved after changing method open account in class Bank
	 */
	/* All tests fail once again because of accountDoesNotExistException
		was resolved after changing method deposit() in class Bank
	*/
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}

	@Test
	public void testAddRemoveTimedPayment() {
		testAccount.addTimedPayment("test",1,1,new Money(100,SEK),SweBank,"Alice");
		assertTrue(testAccount.timedPaymentExists("test"));
		testAccount.removeTimedPayment("test");
		assertFalse(testAccount.timedPaymentExists("test"));
	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());
		testAccount.addTimedPayment("test",2,1,new Money(1000,SEK),SweBank,"Alice");
		testAccount.tick();
		assertEquals(Integer.valueOf(9999000), testAccount.getBalance().getAmount());
		assertEquals(Integer.valueOf(1001000), SweBank.getBalance("Alice"));
		testAccount.tick();
		testAccount.tick();
		assertEquals(Integer.valueOf(9998000), testAccount.getBalance().getAmount());
		assertEquals(Integer.valueOf(1002000), SweBank.getBalance("Alice"));
	}

	@Test
	public void testAddWithdraw() {
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());
		testAccount.withdraw(new Money(5000000,SEK));
		assertEquals(Integer.valueOf(5000000), testAccount.getBalance().getAmount());
	}

	@Test
	public void testGetBalance() {
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());
	}
}
