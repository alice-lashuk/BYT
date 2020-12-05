import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {

//Test was calling another test which caused problems. That's why I rewrited testWinConditions test
	@Test
	public void testDefaultMove() {
		TicTacToe game = new TicTacToe("XOXOX-OXO");
		assertEquals(5, game.suggestMove('X'));

		game = new TicTacToe("XOXOXOOX-");
		assertEquals(8, game.suggestMove('O'));

		game = new TicTacToe("---------");
		assertEquals(0, game.suggestMove('X'));

		game = new TicTacToe("XXXXXXXXX");
		assertEquals(-1, game.suggestMove('X'));
	}
	@Test
	public void testFindWinningMove() {
		TicTacToe game = new TicTacToe("XO-XX-OO-");
		assertEquals(5, game.suggestMove('X'));
		assertEquals(8, game.suggestMove('O'));
	}
	@Test
	public void testWinConditions() {
		char x = 'X';
		char o ='O';
		char d = '-';
		TicTacToe game = new TicTacToe("---XXX---");
		assertEquals(x, game.winner());

		game = new TicTacToe("XXX------");
		assertEquals(x, game.winner());

		game = new TicTacToe("------XXX");
		assertEquals(x, game.winner());

		game = new TicTacToe("X--X--X--");
		assertEquals(x, game.winner());

		game = new TicTacToe("-X--X--X-");
		assertEquals(x, game.winner());

		game = new TicTacToe("--X--X--X");
		assertEquals(x, game.winner());

		game = new TicTacToe("X---X---X");
		assertEquals(x, game.winner());

		game = new TicTacToe("--X-X-X--");
		assertEquals(x, game.winner());

		game = new TicTacToe("---OOO---");
		assertEquals(o, game.winner());

		game = new TicTacToe("OOO------");
		assertEquals(o, game.winner());

		game = new TicTacToe("------OOO");
		assertEquals(o, game.winner());

		game = new TicTacToe("O--O--O--");
		assertEquals(o, game.winner());

		game = new TicTacToe("-O--O--O-");
		assertEquals(o, game.winner());

		game = new TicTacToe("--O--O--O");
		assertEquals(o, game.winner());

		game = new TicTacToe("O---O---O");
		assertEquals(o, game.winner());

		game = new TicTacToe("--O-O-O--");
		assertEquals(o, game.winner());

		game = new TicTacToe("---------");
		assertEquals(d, game.winner());

		game = new TicTacToe("XXOOOXXOO");
		assertEquals(d, game.winner());
	}
//	@Test
//	private void assertWinner(String s, char w) {
//		TicTacToe game = new TicTacToe(s);
//		assertEquals(w, game.winner());
//	}
}