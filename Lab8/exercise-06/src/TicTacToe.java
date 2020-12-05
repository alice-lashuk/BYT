public class TicTacToe {
	public StringBuffer board;

	public TicTacToe(String s) {
		board = new StringBuffer(s);
	}

	public TicTacToe(String s, int position, char player) {
		board = new StringBuffer(s);
		board.setCharAt(position, player);
	}

	public int suggestMove(char player) {
		for (int i = 0; i < 9; i++) {
			if (board.charAt(i) == '-') {
				TicTacToe game = makeMove(i, player);
				if (game.winner() == player)
					return i;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (board.charAt(i) == '-')
				return i;
		}

		return -1;
	}

	public TicTacToe makeMove(int i, char player) {
		return new TicTacToe(board.toString(), i, player);
	}

	// long method, used Extract method tool and created separate method for each direction
	public char winner() {
		// check for horizontal winner
		Character i1 = checkHorWinner();
		if (i1 != null) return i1;

		// check for vertical winner
		Character i = checkVerWinner();
		if (i != null) return i;

		// check for diagonal winner
		Character x = checkDiagWinner();
		if (x != null) return x;

		// no winner yet
		return '-';
	}

	protected Character checkDiagWinner() {
		if (board.charAt(0) != '-' && board.charAt(4) == board.charAt(0)
				&& board.charAt(8) == board.charAt(0))
			return board.charAt(0);
		if (board.charAt(2) != '-' && board.charAt(4) == board.charAt(2)
				&& board.charAt(6) == board.charAt(2))
			return board.charAt(2);
		return null;
	}

	protected Character checkVerWinner() {
		for (int i = 0; i < 3; ++i) {
			if (board.charAt(i) != '-'
					&& board.charAt(i + 3) == board.charAt(i)
					&& board.charAt(i + 6) == board.charAt(i))
				return board.charAt(i);
		}
		return null;
	}

	protected Character checkHorWinner() {
		for (int i = 0; i < 9; i += 3) {
			if (board.charAt(i) != '-'
					&& board.charAt(i + 1) == board.charAt(i)
					&& board.charAt(i + 2) == board.charAt(i))
				return board.charAt(i);
		}
		return null;
	}
}
