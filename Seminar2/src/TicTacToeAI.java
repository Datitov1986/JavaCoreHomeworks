import java.util.*;

/**
 * Основной класс игры крестики-нолики
 */
public class TicTacToeAI {
    // Размер игрового поля
    private static final int BOARD_SIZE = 3;
    private static final int SIZE_X = 3;
    private static final int SIZE_Y = 3;

    // Значения для пустой ячейки, крестика и нолика
    private static final char DOT_EMPTY = '-';
    private static final char DOT_AI = '0';
    private static final char DOT_HUMAN = 'X';
    private static char[][] field;
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Структура, представляющая ход
     */
    public static class Move {
        int row, col;
    }

    /**
     * Точка входа в программу
     * @param args стандартные аргументы
     */
    public static void main(String[] args) {
        initialize(); // инициализация игры
        printField(); // вывод на экран игрового поля

        while (isMovesLeft(field)) {
            humanTurn(); // вызов метода, реализующего ход игрока

            if (gameCheck(DOT_HUMAN, "Ура! Победа!!!")) break; // проверка после хода игрока на победу

            aiTurn(); // вызов метода, реализующего ход компьютера

            if (gameCheck(DOT_AI, "Поздравляю, тебя уделал бот!")) break; // проверка после хода компьютера на победу
        }
    }

    /**
     * Метод проверяющий валидность хода
     * @param playerRow строка
     * @param playerCol столбец
     */
    private static void isCellValid(int playerRow, int playerCol) {
        while (playerRow < 0 || playerRow >= BOARD_SIZE || playerCol < 0 || playerCol >= BOARD_SIZE ||
                field[playerRow][playerCol] != DOT_EMPTY) {
            System.out.println("Некорректный ход. Попробуйте ещё раз.");
            System.out.println("Введите номер строки (0-2):");
            playerRow = SCANNER.nextInt();
            System.out.println("Введите номер столбца (0-2):");
            playerCol = SCANNER.nextInt();
        }
    }

    /**
     * Метод, реализующий ход игрока
     */
    private static void humanTurn() {
        System.out.println("Ваш ход. Введите номер строки (0-2):");
        int playerRow = SCANNER.nextInt();
        System.out.println("Введите номер столбца (0-2):");
        int playerCol = SCANNER.nextInt();

        isCellValid(playerRow, playerCol);

        field[playerRow][playerCol] = DOT_HUMAN;
        System.out.println("Ваш ход:");
        printField();
    }

    /**
     * Метод, реализующий ход компьютера, использует методы:
     * findBestMove, printField
     */
    private static void aiTurn() {
        Move bestMove = findBestMove(field);
        field[bestMove.row][bestMove.col] = DOT_AI;
        System.out.println("Ход компьютера:");
        printField();
    }

    /**
     * Метод, проверяющий состояние игры, определяющий победителя или ничью
     * @param symbol символ ходящего игрока (крестик или нолик)
     * @param message сообщение победителю
     * @return булевый тип, возвращает true если игра завершилась или false, если игра еще продолжается
     */
    private static boolean gameCheck(char symbol, String message) {
        if (checkWin(symbol) == 10) {
            System.out.println(message);
            return true;
        } else if (checkWin(symbol) == -10) {
            System.out.println(message);
            return true;
        }
        if (checkDraw(symbol)) {
            System.out.println("Ничья тоже результат");
            return true;
        }
        return false;
    }

    /**
     * Метод, для проверки ничьей
     * @param symbol символ ходящего игрока
     * @return если есть пустые клетки, возвращает false, если все клетки заняты возвращает true
     */
    private static boolean checkDraw(char symbol) {
        for (int x = 0; x < SIZE_X; x++) {
            for (int y = 0; y < SIZE_Y; y++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    /**
     * Метод, проверяющий пустая клетка или нет
     * @param x строка
     * @param y столбец
     * @return возвращает true или false
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Метод для проверки, что на поле есть свободные ячейки
     * @param board символы с поля
     * @return возвращает true или false
     */
    private static boolean isMovesLeft(char[][] board) {
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                if (board[i][j] == DOT_EMPTY) return true;
            }
        }
        return false;
    }

    /**
     * Метод для определения победителя игры, передает целочисленное значение,
     * проверяет строки, столбцы, диагонали.
     * @param symbol символ ходящего игрока
     * @return возвращает числовое значение
     * 10 (победа компьютера), -10 (победа игрока), 0 (ничья)
     */
    private static int checkWin(char symbol) {
        // Проверка строк
        for (int row = 0; row < SIZE_X; row++) {
            if (field[row][0] == symbol &&
                    field[row][1] == symbol &&
                    field[row][2] == symbol) {
                if (symbol == DOT_AI) return 10;
                else if (symbol == DOT_HUMAN) return -10;
            }
        }

        // Проверка столбцов
        for (int col = 0; col < SIZE_Y; col++) {
            if (field[0][col] == symbol &&
                    field[1][col] == symbol &&
                    field[2][col] == symbol) {
                if (symbol == DOT_AI) return 10;
                else if (symbol == DOT_HUMAN) return -10;
            }
        }

        // Проверка диагоналей
        if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol) {
            if (symbol == DOT_AI) return 10;
            else if (symbol == DOT_HUMAN) return -10;
        }

        if (field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol) {
            if (symbol == DOT_AI) return 10;
            else if (symbol == DOT_HUMAN) return -10;
        }
        // Возвращаем 0 в случае ничьей
        return 0;
    }

    /**
     * Рекурсивный метод для поиска лучшего хода
     * @param symbol символ
     * @param depth счетчик ходов
     * @param isMaximizer значение true указывает на ход компьютера
     * @return возвращает числовое значение для выбора хода
     */
    private static int minimax(char symbol, int depth, boolean isMaximizer) {
        int score = checkWin(symbol);

        // Если выигрыш или проигрыш достигнут, возвращаем оценку
        if (score == 10)
            return score;
        if (score == -10)
            return score;

        // Если нет свободных ячеек и никто не победил, возвращаем ничью
        if (!isMovesLeft(field))
            return 0;

        // Если текущий ход - ход компьютера
        if (isMaximizer) {
            int best = -1000;

            // Пробуем каждую свободную ячейку
            for (int i = 0; i < SIZE_X; i++) {
                for (int j = 0; j < SIZE_Y; j++) {
                    if (field[i][j] == DOT_EMPTY) {
                        // Сделать ход
                        field[i][j] = DOT_AI;

                        // Рекурсивный вызов для оценки хода
                        best = Math.max(best, minimax(DOT_AI, depth + 1, !isMaximizer));

                        field[i][j] = DOT_EMPTY;
                    }
                }
            }
            return best;
        } else {
            int best = 1000;

            // Пробуем каждую свободную ячейку
            for (int i = 0; i < SIZE_X; i++) {
                for (int j = 0; j < SIZE_Y; j++) {
                    if (field[i][j] == DOT_EMPTY) {
                        // Сделать ход
                        field[i][j] = DOT_HUMAN;

                        // Рекурсивный вызов для оценки хода
                        best = Math.min(best, minimax(DOT_HUMAN, depth + 1, !isMaximizer));

                        field[i][j] = DOT_EMPTY;
                    }
                }
            }
            return best;
        }
    }

    /**
     * Метод для наилучшего хода компьютера
     * @param board координаты на поле
     * @return возвращает координату для наилучшего хода
     */
    private static Move findBestMove(char[][] board) {
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        // Пробуем каждую свободную ячейку
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                if (board[i][j] == DOT_EMPTY) {
                    // Сделать ход
                    board[i][j] = DOT_AI;
                    // Оценить ход и сохранить его, если лучше
                    int moveVal = minimax(DOT_AI, 0, false);
                    board[i][j] = DOT_EMPTY;

                    if (moveVal > bestVal) {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        return bestMove;
    }

    /**
     * Метод инициализации игры
     */
    private static void initialize() {
        field = new char[SIZE_X][SIZE_Y];
        for (int x = 0; x < SIZE_X; x++) {
            for (int y = 0; y < SIZE_Y; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Метод вывода на экран игрового поля
     */
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < SIZE_X * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? "-" : i / 2);
        }
        System.out.println();

        for (int i = 0; i < SIZE_X; i++) {
            System.out.print(i + "|");

            for (int j = 0; j < SIZE_Y; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i < SIZE_X * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}


