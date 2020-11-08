#include"game.h"

void menu() {
	system("cls");
	int qute = 0;
	printf("**********************\n");
	printf("1  开始游戏!\n");
	printf("2  退出游戏!\n");
	printf("**********************\n");
	scanf_s("%d",&qute);

	switch (qute)
	{
	case 1:begin(); break;
	case 2:printf("再见！"); return;
	default: menu();
	}
}

void begin() {
	int row = ROW + 2;
	int col = COL + 2;
	char show_board[ROW + 2][COL + 2];
	char logic_board[ROW + 2][COL + 2];

	for (int i = 0; i < row; i++) {
		for (int j = 0; j < col; j++) {
			show_board[i][j] = '*';
			logic_board[i][j] = '0';
		}
	}

	generateMines(logic_board,row,col);
	play(logic_board,show_board,row,col);
}
void show(char board[][COL+2]) {
	for (int i = 1; i <= ROW; i++) {
		for (int j = 1; j <= COL; j++) {
			printf("%c ", board[i][j]);
		}
		printf("\n");
	}
}
void generateMines(char board[][COL+2], int row, int col) {
	srand((unsigned)time(NULL));
	for (int i = 0; i < mineNuber; i++) {
		int x = (rand()%10)+1;
		int y = (rand()%10)+1;
		while (board[x][y] != '0') {
			x = (rand()%10)+1;
			y = (rand()%10)+1;
		}
		board[x][y] = '1';
	}
	
}
void play(char board[][COL+2],char showBoard[][COL+2], int row, int col) {
	
	int count = COL * ROW - mineNuber;
	while (count) {
		system("cls");
		show(showBoard);
		show(board);
		int x, y;
		do{
		scanf("%d %d", &x, &y);
		if (x < 1 || y < 1 || x > 10 || y > 10 ||showBoard[x][y] != '*') {
			printf("该位置无效，请重新输入！\n");
		}
		}while (x < 1 || y < 1 || x > 10 || y > 10 || showBoard[x][y] != '*');
		int ret = isEnd(board, x, y);
		printf("%d\n",ret);
		if (ret != -1) {		
			showBoard[x][y] = ret + '0';
			printf("%d %d", x, y);
			count--;
		}
		else {
			system("cls");
			show(board, row, col);
			printf("游戏结束,你死了！\n");
			system("pause");
			menu();
		}
	}

	printf("恭喜你，赢了！\n");
	system("pause");
	menu();
}

int isEnd(char board[][COL+2],int x,int y){
	if (board[x][y] == '1') {
		return -1;
	}else{
		return board[x - 1][y - 1] + board[x - 1][y] + board[x - 1][y + 1] + board[x][y - 1] + board[x][y + 1] + board[x + 1][y - 1] + board[x + 1][y] + board[x + 1][y + 1] - 8 * '0';
	}
}