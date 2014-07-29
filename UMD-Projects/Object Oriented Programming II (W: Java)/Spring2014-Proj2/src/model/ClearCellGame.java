package model;

import java.awt.Color;
import java.util.Random;

/* This class must extend Game */
public class ClearCellGame extends Game {

	private int score = 0;
	private Random random;

	public ClearCellGame(int maxRows, int maxCols, Random random, int strategy) {
		super(maxRows, maxCols);
		this.random = random;
	}

	@Override
	public boolean isGameOver() {
		return !isRowEmpty(getMaxRows() - 1);
	}

	@Override
	public int getScore() {
		return score;
	}

	private boolean isRowEmpty(int rowIndex) {
		for (int col = 0; col < getMaxCols(); col++) {
			if (board[rowIndex][col] != BoardCell.EMPTY) {
				return false;
			}
		}
		return true;
	}

	// call this method after each click in processCell method
	private void collapseRow() {
		for (int i = 0; i < getMaxRows(); i++) {
			if (isRowEmpty(i)) {
				for (int row = i + 1; row < getMaxRows(); row++) {
					for (int col = 0; col < getMaxCols(); col++) {
						board[row - 1][col] = board[row][col];
					}
				}
			}
		}
	}

	@Override
	public void nextAnimationStep() {
		for (int row = 0; row < getMaxRows(); row++) {
			// finds empty row to move all the rows down one unit
			if (isRowEmpty(row)) {
				for (int i = row; i > 0; i--) {
					for (int j = 0; j < getMaxCols(); j++) {
						board[i][j] = board[i - 1][j];
					}
				}
				break; // makes sure the process only happens once at the first
						// empty row
			}
		}
		// creates row full of random elements
		for (int col = 0; col < getMaxCols(); col++) {
			board[0][col] = BoardCell.getNonEmptyRandomBoardCell(random);
		}
	}

	@Override
	public void processCell(int rowIndex, int colIndex) {

		// creates cell to test
		BoardCell testCell = this.board[rowIndex][colIndex];

		// turns clicked cell to an empty cell
		board[rowIndex][colIndex] = BoardCell.EMPTY;
		score++;

		if (!isGameOver()) {

			// top rows
			if (rowIndex - 1 >= 0) {
				int row = rowIndex - 1;
				while (row >= 0) {
					if (board[row][colIndex] != testCell) {
						break;
					} else {
						board[row][colIndex] = BoardCell.EMPTY;
						score++;
						row--;
					}
				}

			}

			// bottom rows
			if (rowIndex + 1 < getMaxRows()) {
				int row = rowIndex + 1;
				while (row < getMaxRows()) {
					if (board[row][colIndex] != testCell) {
						break;
					} else {
						board[row][colIndex] = BoardCell.EMPTY;
						score++;
						row++;
					}
				}
			}

			// left rows
			if (colIndex - 1 >= 0) {
				int col = colIndex - 1;
				while (col >= 0) {
					if (board[rowIndex][col] != testCell) {
						break;
					} else {
						board[rowIndex][col] = BoardCell.EMPTY;
						score++;
						col--;
					}
				}
			}

			// right rows
			if (colIndex + 1 < getMaxCols()) {
				int col = colIndex + 1;
				while (col < getMaxCols()) {
					if (board[rowIndex][col] != testCell) {
						break;
					} else {
						board[rowIndex][col] = BoardCell.EMPTY;
						score++;
						col++;
					}
				}
			}

			// top-right rows
			if (rowIndex - 1 >= 0 && colIndex + 1 < getMaxCols()) {
				int row = rowIndex - 1;
				int col = colIndex + 1;
				while (row >= 0 && col < getMaxCols()) {
					if (board[row][col] != testCell) {
						break;
					} else {
						board[row][col] = BoardCell.EMPTY;
						score++;
						row--;
						col++;
					}
				}
			}

			// top-left rows
			if (rowIndex - 1 >= 0 && colIndex - 1 >= 0) {
				int row = rowIndex - 1;
				int col = colIndex - 1;
				while (row >= 0 && col >= 0) {
					if (board[row][col] != testCell) {
						break;
					} else {
						board[row][col] = BoardCell.EMPTY;
						score++;
						row--;
						col--;
					}
				}
			}

			// bottom-right rows
			if (rowIndex + 1 < getMaxRows() && colIndex + 1 < getMaxCols()) {
				int row = rowIndex + 1;
				int col = colIndex + 1;
				while (row < getMaxRows() && col < getMaxCols()) {
					if (board[row][col] != testCell) {
						break;
					} else {
						board[row][col] = BoardCell.EMPTY;
						score++;
						row++;
						col++;
					}
				}
			}

			// bottom-left rows
			if (rowIndex + 1 < getMaxRows() && colIndex - 1 >= 0) {
				int row = rowIndex + 1;
				int col = colIndex - 1;
				while (row < getMaxRows() && col >= 0) {
					if (board[row][col] != testCell) {
						break;
					} else {
						board[row][col] = BoardCell.EMPTY;
						score++;
						row++;
						col--;
					}
				}
			}

			collapseRow();

		}
	}
}