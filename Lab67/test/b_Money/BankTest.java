package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;

	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank", SweBank.getName());
		assertEquals("Nordea", Nordea.getName());
		assertEquals("DanskeBank", DanskeBank.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals("SEK", SweBank.getCurrency().getName());
		assertEquals("DKK", DanskeBank.getCurrency().getName());
		assertEquals("SEK", Nordea.getCurrency().getName());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
        DanskeBank.openAccount("newAcc");
        assertEquals(Integer.valueOf(0), DanskeBank.getBalance("newAcc"));
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", new Money(1000, SEK));
		assertEquals(Integer.valueOf(1000), SweBank.getBalance("Bob"));
        DanskeBank.deposit("Gertrud", new Money(1000, DKK));
        assertEquals(Integer.valueOf(1000), DanskeBank.getBalance("Gertrud"));
	}

	/* Test failed
		error in method withdraw in class Bank
	*/
	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(1000, SEK));
		SweBank.withdraw("Ulrika", new Money(100, SEK));
		assertEquals(Integer.valueOf(900), SweBank.getBalance("Ulrika"));
	}

	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", new Money(1000, SEK));
		assertEquals(Integer.valueOf(1000), SweBank.getBalance("Bob"));
	}

	/* Test failed
	error in method transfer(String fromaccount, String toaccount, Money amount) in class Bank
	 */
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", new Money(1000, SEK));
		SweBank.transfer("Bob", "Ulrika",new Money(100, SEK));
		assertEquals(Integer.valueOf(900), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(100), SweBank.getBalance("Ulrika"));
	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(1000, SEK));
		SweBank.addTimedPayment("Ulrika", "test", 1, 1, new Money(200, SEK),Nordea, "Bob");
		SweBank.tick();
		assertEquals(Integer.valueOf(800), SweBank.getBalance("Ulrika"));
		assertEquals(Integer.valueOf(200), Nordea.getBalance("Bob"));
		SweBank.removeTimedPayment("Ulrika", "test");
		SweBank.tick();
		assertEquals(Integer.valueOf(800), SweBank.getBalance("Ulrika"));
		assertEquals(Integer.valueOf(200), Nordea.getBalance("Bob"));
	}
}
