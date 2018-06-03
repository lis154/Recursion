package com.company.Recursion;

public class Recursion {

    private static void iterPrint(int i) {
        while (i >= 0)
            System.out.print(i-- + " ");
        System.out.print("we are done");
    }
    //1 РІРІРµРґРµРЅРёРµ РІ РґРёРЅР°РјРёС‡РµСЃРєРѕРµ РїСЂРѕРіСЂР°РјРјРёСЂРѕРІР°РЅРёРµ:
    // РїРѕРёСЃРє РІСЃРµС… РјР°СЂС€СЂСѓС‚РѕРІ, 8 С„РµСЂР·СЏС…
    //2 С…Р°РЅРѕР№СЃРєР°СЏ Р±Р°С€РЅСЏ + РѕР±С…РѕРґ С€Р°С…РјР°С‚РЅС‹Рј РєРѕРЅС‘Рј

    private static void recuPrint(int i) {
        if (i >= 0) {
            System.out.print(i + " ");
            recuPrint(--i);
        }
        System.out.print(" rec: " + i);
    }

// rP(1){1-1 -> rP(0){0-1 -> rP(-1) { sout-1; } sout-1 } sout0 }

    // routes(x, y) = 0, <- if (x && y) == 0;
    // routes(x, y) = 1, <= if (x ^ y) == 0;
    // routes(x, y) = routes(x, y-1) + routes(x-1, y);

    private static int routes(int x, int y) {
        if (x == 0 && y == 0)
            return 0;
        else if (x == 0 || y == 0)
            return 1;
        else
            return routes(x - 1, y) + routes(x, y - 1);
    }

    static int X = 8;
    static int Y = 8;
    static int QUEENS = 8;
    static int board[][] = new int[Y][X];

    static void init() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                board[i][j] = 0;
            }
        }
    }

    static void printBoard() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean checkQueen(int x, int y) {

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (board[i][j] != 0) // если не пусто
                    if (!(i == x && j == y)) { // сли это не мы
                        if (i - x == 0 || j - y == 0) return false; // если бъется значит false
                        if (Math.abs(i - x) == Math.abs(j - y)) return false; //проверка диагоналей
                    }
            }
        }
        return true;
    }

    static boolean checkBoard() { // проверка все доски на обстрел другим ферзем
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (board[i][j] != 0) // если по координатам не пусто то
                    if (!checkQueen(i, j)) // проверка попадаем ли под бой ферзя с этими координатами
                        return false;
            }
        }
        return true;
    }

    static int queens(int n) { // принимаем текущийн омер ферзя, который нужно поставить
        if (!checkBoard()) return 0; // если не прошли проверку доски то возвращаем 0 (попали под удар другого ферзя)
        if (n == QUEENS + 1) return 1; // если n больше кол-во ферзей для выйгрыша, то успех

        for (int i = 0; i < Y; i++) { // идем циклом по доске
            for (int j = 0; j < X; j++) {
                if (board[i][j] == 0) { // если место свободно
                    board[i][j] = n; // ставим туда ферзя
                    if (queens(n + 1) != 0) // если дальнейшие вызоввы  не равны нулю, т.е. вернули 1, то возвращаем 1
                        return 1;
                    board[i][j] = 0; // если что то не так, то возвращаем 0 на место.
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        init();
        queens(1);
        printBoard();

//        iterPrint(5);
//        System.out.println();
//        recuPrint(1);

//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                System.out.print(String.format("%5d", routes(j, i)));
//            }
//            System.out.println();
//        }

    }
}