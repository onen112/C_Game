#pragma warning(disable:4996)
#ifndef HEADER_FILE
#define HEADER_FILE
#endif
#include<stdio.h>
#include<Windows.h>
#include<stdlib.h>
#include<time.h>
#define ROW 10
#define COL 10
#define mineNuber 20
int isEnd(char board[][COL], int x, int y);
void begin();
void menu();
void generateMines(char board[][COL+2],int row,int col);
void show(char board[][COL+2]);
void play(char board[][COL+2], char showBoard[][COL+2], int row, int col);