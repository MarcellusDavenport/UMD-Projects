package model;

/**
 * This class represents the logic of a game where a board is updated on each
 * step of the game animation. The board can also be updated by selecting a
 * board cell.
 * 
 * @author Marcellus Davenport
 */

public abstract class Game {
	protected BoardCell[][] board;
	private int maxRows;
	private int maxCols;

	/**
	 * Defines a board with BoardCell.EMPTY cells.
	 * 
	 * @param maxRows
	 * @param maxCols
	 */
	public Game(int maxRows, int maxCols) {
		this.maxRows = maxRows;
		this.maxCols = maxCols;
		board = new BoardCell[maxRows][maxCols];

		for (int i = 0; i < maxRows; i++) {
			for (int j = 0; j < maxCols; j++) {
				board[i][j] = BoardCell.EMPTY;
			}
		}
	}

	public int getMaxRows() {
		return maxRows;
	}

	public int getMaxCols() {
		return maxCols;
	}
	
	/**
	 * Installs boardCell at desired location.
	 * 
	 * @param rowIndex 
	 * 		int referring to the desired row index
	 * @param colIndex
	 * 		int referring to the desired column index
	 * @param boardCell
	 * 		an object type BoardCell that needs to be added
	 */
	public void setBoardCell(int rowIndex, int colIndex, BoardCell boardCell) {

		board[rowIndex][colIndex] = boardCell;

	}
	
	/**
	 * Returns desired BoardCell.
	 * 
	 * @param rowIndex 
	 * 		int referring to the row of the desired BoardCell
	 * 		int >= 0, but within range.
	 * @param colIndex
	 * 		int referring to the column of the desired BoardCell
	 * 		int >= 0, but within range.
	 * @returns  desired BoardCell 
	 */
	public BoardCell getBoardCell(int rowIndex, int colIndex) {
		
		return this.board[rowIndex][colIndex];
		
	}

	/**
	 * Sets desired row with desired color.
	 * 
	 * @param rowIndex
	 * 		int that designates which row needs to be accessed
	 * @param cell
	 * 		sets row with this BoardCell
	 */
	public void setRowWithColor(int rowIndex, BoardCell cell) {
		for (int col = 0; col < maxCols; col++) {
			this.board[rowIndex][col] = cell;
		}
	}

	/**
	 * Sets desired column with desired color.
	 * 
	 * @param colIndex
	 * 		int that designates which column needs to be accessed
	 * 		int >= 0, but within range.
	 * @param cell
	 * 		sets column with this BoardCell
	 */
	public void setColWithColor(int colIndex, BoardCell cell) {
		for (int row = 0; row < maxRows; row++) {
			board[row][colIndex] = cell;
		}
	}

	/**
	 * Sets whole board with desired color.
	 * 
	 * @param cell
	 * 		sets the whole board with the color of this BoardCell
	 */
	public void setBoardWithColor(BoardCell cell) {
		for (int i = 0; i < maxRows; i++) {
			setRowWithColor(i, cell);
		}
	}
	
	/**
	 * The game is over when the last board row (row with index board.length - 1) is different from empty row.
	 */
	public abstract boolean isGameOver();

	/**
	 * Returns the current score as an int >= 0.
	 */
	public abstract int getScore();

	/**
	 * This method will attempt to insert a row of random 
	 * BoardCell objects if the last board row (row with index board.length
     * - 1) corresponds to the empty row; otherwise no operation will take place.
	 */
	public abstract void nextAnimationStep();

	/**
	 * This method will turn the selected cell to BoardCell.EMPTY and any adjacent 
	 * surrounding cells in the vertical, horizontal, and diagonal directions that 
	 * have the same color. The clearing of adjacent cells will continue as long as 
	 * cells have a color that corresponds to the selected cell.
	 * 
	 * @param rowIndex
	 * 		int >= 0, but within range.
	 * @param colIndex
	 * 		int >= 0, but within range.
	 */
	public abstract void processCell(int rowIndex, int colIndex);
}