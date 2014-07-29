import java.awt.Color;
import CMSC131GridTools.DrawingGrid;

public class LetterMaker {

	public static void drawLetter(DrawingGrid grid, char letter, Color color) {
		if (letter == 'L') {
			int size = grid.getScale();
			for (int row = 0; row < size; row++ ) {
				for (int col = 0; col <= 2; col++) {
					grid.setColor(row, col, color);
				}
				while ((row > size - 4) && (row < size)) {
					for (int col = 0; col < size; col++) {
						grid.setColor(row, col, color);
					}
					row++;
				}
			}
		}

		if (letter == 'O') {
			int size = grid.getScale();
			for (int row = 0; row <= size; row++) {
				while ((row >= 0) && (row < 3)) {
					for (int col = 0; col < size; col++) {
						grid.setColor(row, col, color);
					}
					row++;
				}
				while ((row > 2) && (row < size - 3)) {
					int col = 0;
					while ((col >= 0) && (col < 3)) {
						grid.setColor(row, col, color);
						col++;
					}
					int col2 = size - 3;
					while (col2 < size) {
						grid.setColor(row, col2, color);
						col2++;
					}
					row++;
				}
				while ((row > size - 4) && (row < size)) {
					for (int col = 0; col < size; col++) {
						grid.setColor(row, col, color);
					}
					row++;
				}
			}
		}

		if (letter == 'J') {
			int size = grid.getScale();
			for (int row = 0; row <= size; row++) {
				while ((row > size / 2) && (row < size)) {
					for (int col = 0; col < 3; col++) {
						grid.setColor(row, col, color);
					}
					row++;
				}
			}
			for (int row = 0; row < size; row++) {
				while ((row >= size - 3) && (row < size)) {
					for (int col = 0; col < size; col++) {
						grid.setColor(row, col, color);
					}
					row++;
				}
			}
			for (int row = 0; row < size; row++) {
				for (int col = size - 3; col < size; col++) {
					grid.setColor(row, col, color);
				}
			}
		}

		if (letter == 'H') {
			int size = grid.getScale();
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					while ((col >= 0) && (col < 3)) {
						grid.setColor(row, col, color);
						col++;
					}
				}
			}
			for (int row = 0; row < size; row++) {
				while ((row > size/2 - 2) && (row < size/2 + 2)) {
					for (int col = 0; col < size; col++) {
						grid.setColor(row, col, color);
					}
					row++;
				}
			}
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					while ((col > size - 4) && (col < size)) {
						grid.setColor(row, col, color);
						col++;
					}
				}
			}
		}
		if (letter == 'X') {
			int size = grid.getScale();
			for (int row = 0; row < size; row++) {
				if (row == 0) {
					int colLeft = 0;
					int colRight = size - 2;
					for (int i = 0; i < 2; i++) {
						grid.setColor(row, colLeft, color);
						grid.setColor(row, colRight, color);
						colLeft++;
						colRight++;
					}
				}

				if (row == size - 1) {
					int colLeft = 0;
					int colRight = size - 2;
					for (int i = 0; i < 2; i++) {
						grid.setColor(row, colLeft, color);
						grid.setColor(row, colRight, color);
						colLeft++;
						colRight++;
					}
				}
			}

			int col = 0;
			for (int row = 1; row < size - 1; row++) {
				for (int i = 1; i <= 3; i++) {
					grid.setColor(row, col, color);
					col++;
				}
				col -= 2;
			}

			int col1 = size - 3;
			for (int row = 1; row < size - 1; row++) {
				for (int i = 1; i <= 3; i++) {
					grid.setColor(row, col1, color);
					col1++;
				}
				col1 -= 4;
			}


		}

		if (letter == 'Y') {
			int size = grid.getScale();
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					if ((row > size / 2 - 2) && (row < size) &&
							(col > size / 2 - 2) && (col < size / 2 + 2)) {
						grid.setColor(row, col, color);
					}
				}
			}
			int col = 0;
			for (int row = 0; row < size; row++) {
				if ((row > 0) && (row < size / 2)) {
					for (int i = 1; i <= 3; i++) {
						grid.setColor(row, col, color);
						col++;
					}
					col -= 2;
				}
			}

			int col1 = size - 3;
			for (int row = 0; row < size; row++) {
				if ((row > 0) && (row < size / 2)) {
					for (int i = 1; i <= 3; i++) {
						grid.setColor(row, col1, color);
						col1++;
					}
					col1 -= 4;
				}
			}

			for (int row = 0; row < size; row++) {
				if (row == 0) {
					int colLeft = 0;
					int colRight = size - 2;
					for (int i = 0; i < 2; i++) {
						grid.setColor(row, colLeft, color);
						grid.setColor(row, colRight, color);
						colLeft++;
						colRight++;
					}
				}
			}

		}
	}	
}
