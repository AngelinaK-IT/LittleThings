#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

//#include "funktionenPoint.h"

//Symbolische KonstantenA
#define MAX_NAME_LENGHT 100
#define MAX_ROWS 10
#define MAX_COLS 10

//Globale Variablen
int numPoints;

//Strukturen für Polygonzug(verkettete Liste)
//Tapendefinition Strucktur Point
typedef struct point2D{
	char name[MAX_NAME_LENGHT];
	float x;
	float y;
} Point2D;

typedef struct point3D{
	char name[MAX_NAME_LENGHT];
	float x;
	float y;
	float z;
} Point3D;

//Typendefinition struct Listelement
typedef struct Listelement2D{
	Point2D pnt;							//Strucktur in Strucktur
	struct Listelement2D *next;
} Le2D;

typedef struct Listelement3D{
	Point3D pnt;							//Strucktur in Strucktur
	struct Listelement3D *next;
} Le3D;

//Typendefinition eines Aliases
typedef Le2D *Polygon2D;
typedef Le3D *Polygon3D;

//Struktur für User Bennenung von Arrays
typedef struct {
	char name[MAX_NAME_LENGHT];
	float x;
	float y;
} Vector2D;

typedef struct {
	char name[MAX_NAME_LENGHT];
	float x;
	float y;
	float z;
} Vector3D;

typedef struct {
	char name[MAX_NAME_LENGHT];
    int rows;
    int cols;
    float data[MAX_ROWS][MAX_COLS];
} Matrix2x2;

// Struktur zur Darstellung einer linearen Funktion
typedef struct {
    float slope;    // Steigung
    float intercept;    // Y-Achsenabschnitt
} LinearFunction;

// Struktur zur Darstellung einer quadratischen Funktion
typedef struct {
    float a;    // Koeffizient von x^2
    float b;    // Koeffizient von x
    float c;    // Konstante
} QuadraticFunction;

// Struktur zur Darstellung einer kubischen Funktion
typedef struct {
    float a;    // Koeffizient von x^3
    float b;    // Koeffizient von x^2
    float c;    // Koeffizient von x
    float d;    // Konstante
} CubicFunction;

//Operations
//Erstellen eines Punktes
Point2D createPoint2D(float x, float y) {
    Point2D temp;
	printf("Bitte geben Sie den Namen des Punktes ein: \n");
	fgets(temp.name, MAX_NAME_LENGHT, stdin);
	if (temp.name[strlen(temp.name) - 1] == '\n') {
		
		temp.name[strlen(temp.name) - 1] = '\0';
		
	}
    temp.x = x;
    temp.y = y;
    return temp;
}

Point3D createPoint3D(float x, float y, float z) {
    Point3D p;
	printf("Bitte geben Sie den Namen des Punktes ein: \n");
	fgets(p.name, MAX_NAME_LENGHT, stdin);
	if (p.name[strlen(p.name) - 1] == '\n') {
		
		p.name[strlen(p.name) - 1] = '\0';
		
	}
    p.x = x;
    p.y = y;
	p.z = z;
    return p;
}

Vector2D createVector2D() {
		Vector2D temp;
		printf("Bitte geben Sie den Namen des temp geladenden Vectors ein: \n");
		fgets(temp.name, MAX_NAME_LENGHT, stdin);
		if (temp.name[strlen(temp.name) - 1] == '\n') {
		
			temp.name[strlen(temp.name) - 1] = '\0';
		
		}
		return temp;
}

Vector3D createVector3D() {
		Vector3D temp;
		printf("Bitte geben Sie den Namen des Vectors(Array) ein: \n");
		fgets(temp.name, MAX_NAME_LENGHT, stdin);
		if (temp.name[strlen(temp.name) - 1] == '\n') {
		
			temp.name[strlen(temp.name) - 1] = '\0';
		
		}
		return temp;
}

Matrix2x2 createMatrix(int rows, int cols) {
    Matrix2x2 mat;
	printf("Bitte geben Sie den Namen der Matrix ein: \n");
		fgets(mat.name, MAX_NAME_LENGHT, stdin);
		if (mat.name[strlen(mat.name) - 1] == '\n') {
		
			mat.name[strlen(mat.name) - 1] = '\0';
		
		}
    mat.rows = rows; //Zeilen
    mat.cols = cols; //Spalten
    // Initialisierung der Matrix mit Nullen
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            mat.data[i][j] = 0;
        }
    }
    return mat;
}
//Vorwärtsdeklaration -- Menues
void print_mainmenu();
void print_submenu();
void print_2DMenu();
void print_PointMenu();
void print_PolygonMenu();
void print_LinearAlgebra();
void print_OtherFunctionsMenu();
void print_GeometricFunctionsMenu();

//Constructor Funtkions
Vector2D createVector2D();
Vector3D createVector3D();
Matrix2x2 createMatrix(int rows, int cols);
Matrix2x2 addCalculate(Vector2D vec, Matrix2x2 mat);
Matrix2x2 addMatrix(Matrix2x2 mat1, Matrix2x2 mat2);
Matrix2x2 multMatrix(Matrix2x2 mat1, Matrix2x2 mat2);
Matrix2x2 skalMultMatrix(float skalar, Matrix2x2 mat);

//Functions
void create2DPointAndArray(float param1, float param2); 
void move2DPointDirekt(float param1, float param2);
void move2DPointTemp(float param1, float param2);
void append2DPointAndArray(float param1, float param2);

long getFileSize(char *filename);
void copyLines(char *sourceFile, char *tempFile, int lineNumber);

void transformVectToPoint(char *sourceFile);
void createPolygon2DAndAppend(char *sourceFile);
void append2DPointToPolygon(Polygon2D *head, Point2D pnt);
void writePolygonToFile(FILE *outFileWrite, Polygon2D *polygon, const char *listName);
void printPolygon2D(char *sourceFile);
void pretty_print(Polygon2D bsp);
void insert2DPointAtPosition(char *sourceFilePoints, char *sourcheFilePolygon);
void insertAtPosition(Polygon2D *temphead, int position, Point2D pnt);

void transformPointToVect(char *sourceFile);
void freeVector(Vector2D *na);
void vectAdd(char *sourceFile);
void skalMultVec(char *sourceFile);
void printVectors(Vector2D vectors[], int numVectors);
void straightPosition(char *sourceFile);
void createMatrix2D(char *sourceFile);
void printMatrix(Matrix2x2 mat);
void calculateVecMat(char *sourceFileVector, char *sourceFileMatrix);
void printMatrix(Matrix2x2 mat);
void writeMatrixToFile(Matrix2x2 mat, char* destFile);

float calculateRectangleArea(float width, float heigth);
float calculateCirclePerimeter(float radius);
float calculateDistance(float x1, float y1, float x2, float y2);
float calculateSphereVolume(float radius); 
float calculateHypotenuse(float a, float b);
// ------------------- //
// MAIN PROGRAMM START //
// ------------------- //
int main() {
	// -------------- //
	// MainMenu Start //
	// -------------- //
    int mainChoice;
    do {
		
        print_mainmenu();
        scanf("%d", &mainChoice);
        getchar();
        switch (mainChoice) {
            case 1:
				// ------------- //
				// 2D Menu Start //
				// ------------- //
				int subMenuChoice;
				do {
					
					print_2DMenu();
					scanf("%d", &subMenuChoice);
					getchar();
					switch (subMenuChoice) {
						case 1:
							// ---------------- //
							// Point Menu Start //
							// ---------------- //
							/*
							1. Point Menu
							-create2DPointAndArray(float param1, float param2); 
							-move2DPointDirekt(float param1, float param2);
							-move2DPointTemp(float param1, float param2);
							-append2DPointAndArray(float param1, float param2);

							void print_PointMenu(); {
								printf("********************************************\n");
								printf("**\t 1. Point Menu \t\t\t****\n");
								printf("**\t -create2DPointAndArray \t****\n");
								printf("**\t -move2DPointDirekt \t\t****\n");
								printf("**\t -move2DPointTemp \t\t****\n");
								printf("**\t -append2DPointAndArray \t****\n");
								printf("**\t -back \t\t\t\t****\n");
								printf("**\t Please enter your choice: \t****\n");
								printf("********************************************\n");
							}
							*/
							int exitFlag1 = 0;
							do {
							
								print_PointMenu();
								//print_submenu();
								char input[MAX_NAME_LENGHT];
								printf("Select your function: ");
								fgets(input, sizeof(input), stdin);

								// Prüfen, ob das Eingabeformat korrekt ist
								if (input[0] == '-' && strlen(input) > 1) {
								
									char functionName[50];
									char parameters[50][50];
									int parameterCount = 0;

									// Trennen des Funktionsnamens und der Parameter
									sscanf(input, "-%s %[^\n]", functionName, parameters[parameterCount]);
									
									// CHECKED //
									// Verarbeiten des Funktionsnamens und Aufruf der entsprechenden Funktion
									if (strcmp(functionName, "create2DPointAndArray") == 0) {
							
										float param1, param2;
										sscanf(parameters[parameterCount], "%f, %f", &param1, &param2);
										create2DPointAndArray(param1, param2);
								
									// CHECKED //
									} else if (strcmp(functionName, "move2DPointDirekt") == 0) {
							
										float param1, param2;
										sscanf(parameters[parameterCount], "%f %f", &param1, &param2);
										move2DPointDirekt(param1, param2);
			
									// CHECKED //
									} else if (strcmp(functionName, "move2DPointTemp") == 0) {
							
										float param1, param2;
										sscanf(parameters[parameterCount], "%f %f", &param1, &param2);
										move2DPointTemp(param1, param2);
									
									// CHECKED //
									} else if (strcmp(functionName, "append2DPointAndArray") == 0) {
							
										float param1, param2;
										sscanf(parameters[parameterCount], "%f %f", &param1, &param2);
										append2DPointAndArray(param1, param2);
									
									// CHECKED //
									} else if (strcmp(functionName, "back") == 0) {
										
										break;
										/*
										char sourceFile[MAX_NAME_LENGHT];
										char destFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s %s", sourceFile, destFile);
										insert2DPointAtPosition(sourceFile, destFile);	
										*/
										
									} else {
							
										printf("Ungueltige Funktion\n");
	
									}
								} else {
						
									printf("Invalid input\n");
									
								}
		
								// Überprüfen, ob das Programm beendet werden soll
								printf("Moechten Sie weitere Funktionen eingeben? (1 = Ja, 0 = Nein): ");
								int continueFlag;
								scanf("%d", &continueFlag);
								getchar();

								if (!continueFlag) {
						
									exitFlag1 = 1;
						
								}
							// -------------- //
							// Point Menu End //
							// -------------- //	
							} while (!exitFlag1);
							break;
							
						case 2:
							// ------------------ //
							// Polygon Menu Start //
							// ------------------ //
							/*
							2. Polygon Menu
							-transformVectToPoint(char *sourceFile);
							-createPolygon2DAndAppend(char *sourceFile);
							-append2DPointToPolygon(Polygon2D *head, Point2D pnt);
							-writePolygonToFile(FILE *outFileWrite, Polygon2D *polygon, const char *listName);
							-printPolygon2D(char *sourceFile);
							-pretty_print(Polygon2D bsp);
							-insert2DPointAtPosition(char *sourceFilePoints, char *sourcheFilePolygon);
							-insertAtPosition(Polygon2D *temphead, int position, Point2D pnt);

							void print_PolygonMenu(); {
								printf("********************************************\n");
								printf("**\t 2. Polygon Menu \t\t\t****\n");
								printf("**\t -transformVectToPoint \t****\n");
								printf("**\t -createPolygon2DAndAppend \t\t****\n");
								printf("**\t -append2DPointToPolygon \t****\n");
								printf("**\t -insert2DPointAtPosition \t****\n");
								printf("**\t -insertAtPosition \t\t****\n");
								printf("**\t -pretty_print \t\t****\n");
								printf("**\t -printPolygon2D \t****\n");
								printf("**\t -writePolygonToFile \t\t****\n");
								printf("**\t -back \t\t\t\t****\n");
								printf("**\t Please enter your choice: \t****\n");
								printf("********************************************\n");
							}
							*/
							int exitFlag2 = 0;
							do {
							
								print_PolygonMenu();
								//print_submenu();
								char input[MAX_NAME_LENGHT];
								printf("Select your function: ");
								fgets(input, sizeof(input), stdin);

								// Prüfen, ob das Eingabeformat korrekt ist
								if (input[0] == '-' && strlen(input) > 1) {
								
									char functionName[50];
									char parameters[50][50];
									int parameterCount = 0;

									// Trennen des Funktionsnamens und der Parameter
									sscanf(input, "-%s %[^\n]", functionName, parameters[parameterCount]);
									
									// -transformVectToPoint == CHECKED //
									if (strcmp(functionName, "transformVectToPoint") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										transformVectToPoint(sourceFile);
									
									// -createPolygon2DAndAppend == CHECKED //
									} else if (strcmp(functionName, "createPolygon2DAndAppend") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										createPolygon2DAndAppend(sourceFile);
									
									// -printPolygon2D == CHECKED //
									} else if (strcmp(functionName, "printPolygon2D") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										printPolygon2D(sourceFile);	
									
									// -insert2DPointAtPosition == CHECKED //
									} else if (strcmp(functionName, "insert2DPointAtPosition") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										char destFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s %s", sourceFile, destFile);
										insert2DPointAtPosition(sourceFile, destFile);	
										
									/*
									// Verarbeiten des Funktionsnamens und Aufruf der entsprechenden Funktion
									if (strcmp(functionName, "create2DPointAndArray") == 0) {
							
										float param1, param2;
										sscanf(parameters[parameterCount], "%f, %f", &param1, &param2);
										create2DPointAndArray(param1, param2);
							
									} else if (strcmp(functionName, "move2DPointDirekt") == 0) {
							
										float param1, param2;
										sscanf(parameters[parameterCount], "%f %f", &param1, &param2);
										move2DPointDirekt(param1, param2);
			
									} else if (strcmp(functionName, "move2DPointTemp") == 0) {
							
										float param1, param2;
										sscanf(parameters[parameterCount], "%f %f", &param1, &param2);
										move2DPointTemp(param1, param2);
			
									} else if (strcmp(functionName, "getFileSize") == 0) {
							
										char filename[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", filename);
										//getFileSize(filename);
										//const char* filename = "datenbank1.txt";
										long size = getFileSize(filename);
										if (size >= 0) {
											printf("Die Datei '%s' hat eine Groesse von %ld Bytes.\n", filename, size);
										}
							
									} else if (strcmp(functionName, "append2DPointAndArray") == 0) {
							
										float param1, param2;
										sscanf(parameters[parameterCount], "%f %f", &param1, &param2);
										append2DPointAndArray(param1, param2);
							
									} else if (strcmp(functionName, "copyLines") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										char tempFile[MAX_NAME_LENGHT];
										int lineNumber;
										sscanf(parameters[parameterCount], "%s %s %i", sourceFile, tempFile, &lineNumber);
										copyLines(sourceFile, tempFile, lineNumber);
									
									} else if (strcmp(functionName, "transformPointToVect") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										transformPointToVect(sourceFile);
							
									} else if (strcmp(functionName, "vectAdd") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										vectAdd(sourceFile);
							
									} else if (strcmp(functionName, "skalMultVec") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										skalMultVec(sourceFile);
							
									} else if (strcmp(functionName, "straightPosition") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										straightPosition(sourceFile);
									*/
									
									// CHECKED //
									} else if (strcmp(functionName, "back") == 0) {
										
										break;
										/*
										char sourceFile[MAX_NAME_LENGHT];
										char destFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s %s", sourceFile, destFile);
										insert2DPointAtPosition(sourceFile, destFile);	
										*/
										
									} else {
							
										printf("Ungueltige Funktion\n");
	
									}
								} else {
						
									printf("Invalid input\n");
									
								}
		
								// Überprüfen, ob das Programm beendet werden soll
								printf("Moechten Sie weitere Funktionen eingeben? (1 = Ja, 0 = Nein): ");
								int continueFlag;
								scanf("%d", &continueFlag);
								getchar(); 

								if (!continueFlag) {
						
									exitFlag2 = 1; 
						
								}
							// ---------------- //
							// Polygon Menu End //
							// ---------------- //	
							} while (!exitFlag2);
							//printf("No functions implemented yet.\n");
							break;
				
						case 3:
							// ------------------------ //
							// LinearAlgebra Menu Start //
							// ------------------------ //
							/*
							3. Linear Algebra
							-transformPointToVect(char *sourceFile);
							-freeVector(Vector2D *na);
							-vectAdd(char *sourceFile);
							-skalMultVec(char *sourceFile);
							-printVectors(Vector2D vectors[], int numVectors);
							-straightPosition(char *sourceFile);
							-printMatrix(Matrix2x2 mat);
							-calculateVecMat(char *sourceFileVector, char *sourceFileMatrix);
							-writeMatrixToFile(Matrix2x2 mat, char* destFile);
							
							void print_LinearAlgebra(); {
								printf("********************************************\n");
								printf("**\t 3. Linear Algebra \t\t\t****\n");
								printf("**\t -transformPointToVect \t****\n");
								printf("**\t -freeVector \t\t****\n");
								printf("**\t -vectAdd \t****\n");
								printf("**\t -skalMultVec \t****\n");
								printf("**\t -printVectors \t\t****\n");
								printf("**\t -straightPosition \t\t****\n");
								printf("**\t -printMatrix \t****\n");
								printf("**\t -calculateVecMat \t\t****\n");
								printf("**\t -writeMatrixToFile \t\t****\n");
								printf("**\t Please enter your choice: \t****\n");
								printf("********************************************\n");
							}
							*/
							int exitFlag3 = 0;
							do {
							
								print_LinearAlgebra();
								//print_submenu();
								char input[MAX_NAME_LENGHT];
								printf("Select your function: ");
								fgets(input, sizeof(input), stdin);

								// Prüfen, ob das Eingabeformat korrekt ist
								if (input[0] == '-' && strlen(input) > 1) {
								
									char functionName[50];
									char parameters[50][50];
									int parameterCount = 0;

									// Trennen des Funktionsnamens und der Parameter
									sscanf(input, "-%s %[^\n]", functionName, parameters[parameterCount]);
									
									// CHECKED //
									if (strcmp(functionName, "transformPointToVect") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										transformPointToVect(sourceFile);
							
									// CHECKED //
									} else if (strcmp(functionName, "vectAdd") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										vectAdd(sourceFile);
									
									// CHECKED //
									} else if (strcmp(functionName, "skalMultVec") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										skalMultVec(sourceFile);
										
									/*
									// CHECKED //
									} else if (strcmp(functionName, "printVectors") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										printVectors(sourceFile);
									*/
									
									// CHECKED //
									} else if (strcmp(functionName, "straightPosition") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										straightPosition(sourceFile);
									
									
									} else if (strcmp(functionName, "createMatrix2D") == 0) {
										
										char destFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", destFile);
										createMatrix2D(destFile);//->2396
									
									/*
									// NOT YET CHECKED //
									} else if (strcmp(functionName, "printMatrix") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										printMatrix(sourceFile);
									
									
									} else if (strcmp(functionName, "calculateVecMat") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										calculateVecMat(sourceFile);
									
									
									// NOT YET CHECKED //
									*/
									
									// CHECKED //
									} else if (strcmp(functionName, "back") == 0) {
										
										break;
										/*
										char sourceFile[MAX_NAME_LENGHT];
										char destFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s %s", sourceFile, destFile);
										insert2DPointAtPosition(sourceFile, destFile);	
										*/
										
									} else {
							
										printf("Ungueltige Funktion\n");
	
									}
								} else {
						
									printf("Invalid input\n");
									
								}
		
								// Überprüfen, ob das Programm beendet werden soll
								printf("Moechten Sie weitere Funktionen eingeben? (1 = Ja, 0 = Nein): ");
								int continueFlag;
								scanf("%d", &continueFlag);
								getchar();

								if (!continueFlag) {
						
									exitFlag3 = 1; 
						
								}
							// ---------------------- //
							// LinearAlgebra Menu End //
							// ---------------------- //	
							} while (!exitFlag3);
							
							break;
							
						case 4:
							// -------------------------- //
							// Other Functions Menu Start //
							// -------------------------- //
							/*
							4. Other FunctionsMenu
							-getFileSize(char *filename);
							-copyLines(char *sourceFile, char *tempFile, int lineNumber);

							void print_OtherFunctionsMenu(); {
								printf("********************************************\n");
								printf("**\t 4. Other FunctionsMenu \t\t\t****\n");
								printf("**\t -getFileSize \t****\n");
								printf("**\t -copyLines \t\t****\n");
								printf("**\t Please enter your choice: \t****\n");
								printf("********************************************\n");
							}
							*/
							int exitFlag4 = 0;
							do {
							
								print_OtherFunctionsMenu();
								//print_submenu();
								char input[MAX_NAME_LENGHT];
								printf("Select your function: ");
								fgets(input, sizeof(input), stdin);

								// Prüfen, ob das Eingabeformat korrekt ist
								if (input[0] == '-' && strlen(input) > 1) {
								
									char functionName[50];
									char parameters[50][50];
									int parameterCount = 0;

									// Trennen des Funktionsnamens und der Parameter
									sscanf(input, "-%s %[^\n]", functionName, parameters[parameterCount]);
									
									// -getFileSize == CHECKED //
									if (strcmp(functionName, "getFileSize") == 0) {
							
										char filename[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", filename);
										//getFileSize(filename);
										//const char* filename = "datenbank1.txt";
										long size = getFileSize(filename); // ->Line 2387
										if (size >= 0) {
											printf("Die Datei '%s' hat eine Groesse von %ld Bytes.\n", filename, size);
										}
							
									// -copyLines == CHECKED //
									} else if (strcmp(functionName, "copyLines") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										char tempFile[MAX_NAME_LENGHT];
										int lineNumber;
										sscanf(parameters[parameterCount], "%s %s %i", sourceFile, tempFile, &lineNumber);
										copyLines(sourceFile, tempFile, lineNumber);
									
									/*
									// CHECKED //
									if (strcmp(functionName, "transformPointToVect") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										transformPointToVect(sourceFile);
							
									// CHECKED //
									} else if (strcmp(functionName, "vectAdd") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										vectAdd(sourceFile);
									
									// CHECKED //
									} else if (strcmp(functionName, "skalMultVec") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										skalMultVec(sourceFile);
									
									// CHECKED //
									} else if (strcmp(functionName, "straightPosition") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										straightPosition(sourceFile);
									
									// Verarbeiten des Funktionsnamens und Aufruf der entsprechenden Funktion
									} else if (strcmp(functionName, "create2DPointAndArray") == 0) {
							
										float param1, param2;
										sscanf(parameters[parameterCount], "%f, %f", &param1, &param2);
										create2DPointAndArray(param1, param2);
							
									} else if (strcmp(functionName, "move2DPointDirekt") == 0) {
							
										float param1, param2;
										sscanf(parameters[parameterCount], "%f %f", &param1, &param2);
										move2DPointDirekt(param1, param2);
			
									} else if (strcmp(functionName, "move2DPointTemp") == 0) {
							
										float param1, param2;
										sscanf(parameters[parameterCount], "%f %f", &param1, &param2);
										move2DPointTemp(param1, param2);
									
									} else if (strcmp(functionName, "append2DPointAndArray") == 0) {
							
										float param1, param2;
										sscanf(parameters[parameterCount], "%f %f", &param1, &param2);
										append2DPointAndArray(param1, param2);
							
									} else if (strcmp(functionName, "transformVectToPoint") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										transformVectToPoint(sourceFile);
									
									
									} else if (strcmp(functionName, "createPolygon2DAndAppend") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										createPolygon2DAndAppend(sourceFile);
							
									} else if (strcmp(functionName, "printPolygon2D") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s", sourceFile);
										printPolygon2D(sourceFile);	
						
									} else if (strcmp(functionName, "insert2DPointAtPosition") == 0) {
							
										char sourceFile[MAX_NAME_LENGHT];
										char destFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s %s", sourceFile, destFile);
										insert2DPointAtPosition(sourceFile, destFile);	
									*/	
									
									// -back == CHECKED //
									} else if (strcmp(functionName, "back") == 0) {
										
										break;
										/*
										char sourceFile[MAX_NAME_LENGHT];
										char destFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s %s", sourceFile, destFile);
										insert2DPointAtPosition(sourceFile, destFile);	
										*/
										
									} else {
							
										printf("Invalid Input\n");
	
									}
								} else {
						
									printf("Invalid input\n");
									
								}
		
								// Überprüfen, ob das Programm beendet werden soll
								printf("Do you want to enter more functions? (1 = Yes, 0 = No): ");
								int continueFlag;
								scanf("%d", &continueFlag);
								getchar();

								if (!continueFlag) {
						
									exitFlag4 = 1; 
						
								}
							// ------------------------ //
							// Other Functions Menu End //
							// ------------------------ //	
							} while (!exitFlag4);
							
							//printf("No functions implemented yet.\n");
							break;
				
						case 5:
							// -------------------------- //
							// 5. Geometric Menu Start //
							// -------------------------- //
							/*
							float calculateRectangleArea(float width, float height) 
							float calculateCirclePerimeter(float radius) 
							float calculateDistance(float x1, float y1, float x2, float y2) 
							float calculateSphereVolume(float radius) 
							float calculateHypotenuse(float a, float b)
							
							void print_GeometricFunctionsMenu() {
							printf("********************************************\n");
							printf("**\t 5. Geometric FunctionsMenu \t****\n");
							printf("**\t -calculateRectangleArea \t\t\t****\n");
							printf("**\t -calculateCirclePerimeter \t\t\t****\n");
							printf("**\t -calculateDistance \t\t\t****\n");
							printf("**\t -calculateSphereVolume \t\t\t****\n");
							printf("**\t -calculateHypotenuse \t\t\t****\n");
							//printf("**\t -calculateCirclePerimeter \t\t\t****\n");
							printf("**\t -back \t\t\t\t****\n");
							printf("**\t Please enter your choice: \t****\n");
							printf("********************************************\n");
							*/
							int exitFlag5 = 0;
							do {
							
								print_GeometricFunctionsMenu();
								//print_submenu();
								char input[MAX_NAME_LENGHT];
								printf("Select your function: ");
								fgets(input, sizeof(input), stdin);

								// Prüfen, ob das Eingabeformat korrekt ist
								if (input[0] == '-' && strlen(input) > 1) {
								
									char functionName[50];
									char parameters[50][50];
									int parameterCount = 0;

									// Trennen des Funktionsnamens und der Parameter
									sscanf(input, "-%s %[^\n]", functionName, parameters[parameterCount]);
									
									// -calculateRectangleArea == CHECKED //
									if (strcmp(functionName, "calculateRectangleArea") == 0) {
										
										float width, height;
										sscanf(parameters[parameterCount], "%f %f", &width, &height);
										float tempArea = calculateRectangleArea(width, height);
										printf("Size of Area: %.2f\n", tempArea);
							
									// -calculateCirclePerimeter == CHECKED //
									} else if (strcmp(functionName, "calculateCirclePerimeter") == 0) {
							
										float radius;
										sscanf(parameters[parameterCount], "%f", &radius);
										float circlePerimeter = calculateCirclePerimeter(radius);
										printf("Lenght of CirclePerimeter: %.2f\n", circlePerimeter);
									
									// -calculateDistance == CHECKED //
									} else if (strcmp(functionName, "calculateDistance") == 0) {
									
										float x1,x2,y1,y2;
										sscanf(parameters[parameterCount], "%f %f %f %f", &x1, &y1, &x2, &y2);
										float tempDistance = calculateDistance(x1, y1, x2, y2); 
										printf("Distance of Coordinates: %.2f\n", tempDistance);
									
									// -calculateSphereVolume == CHECKED //
									} else if (strcmp(functionName, "calculateSphereVolume") == 0) {
							
										float radius;
										sscanf(parameters[parameterCount], "%f", &radius);
										float volumne = calculateSphereVolume(radius);
										printf("Volumne of Sphere: %.2f\n", volumne);
										
									// -calculateHypotenuse == CHECKED //
									} else if (strcmp(functionName, "calculateHypotenuse") == 0) {
							
										float a, b;
										sscanf(parameters[parameterCount], "%f %f", &a, &b);
										float lengthHypothenuse = calculateHypotenuse(a, b);
										printf("Lenght of Hypothenuse: %.2f\n", lengthHypothenuse);
									
									// -back == CHECKED //
									} else if (strcmp(functionName, "back") == 0) {
										
										break;
										/*
										char sourceFile[MAX_NAME_LENGHT];
										char destFile[MAX_NAME_LENGHT];
										sscanf(parameters[parameterCount], "%s %s", sourceFile, destFile);
										insert2DPointAtPosition(sourceFile, destFile);	
										*/
										
									} else {
							
										printf("Invalid Input\n");
	
									}
								} else {
						
									printf("Invalid input\n");
									
								}
		
								// Überprüfen, ob das Programm beendet werden soll
								printf("Do you want to enter more functions? (1 = Yes, 0 = No): ");
								int continueFlag;
								scanf("%d", &continueFlag);
								getchar();

								if (!continueFlag) {
						
									exitFlag5 = 1; 
						
								}
							// ------------------------ //
							// Other Functions Menu End //
							// ------------------------ //	
							} while (!exitFlag5);
							
							//printf("No functions implemented yet.\n");
							break;
				
						case 6:
							printf("No functions implemented yet.\n");
							break;
				
						case 7:
							printf("No functions implemented yet.\n");
							break;
							
						case 8:// Zurück zum Hauptmenue
							printf("Go Back to Main Menu...\n");
							break;
				
						default://Fehlerhalfte Eingabe
							printf("Invalid choice. Please try again.\n");
							break;
					}
		
				} while (subMenuChoice != 8);
				// ------------- //
				// 2D Menu Ende //
				// ------------- //
				
            case 2:
                printf("No functions implemented yet.\n");
                break;
				
            case 3:
                printf("Program will be terminated\n");
                break;
				
            default:
                printf("Invalid choice. Please try again.\n");
                break;
        }
		
    } while (mainChoice != 3);
    // ------------ //
	// MainMenu End //
	// ------------ //
    return 0;
}
// ----------------- //
// MAIN PROGRAMM END //
// ----------------- //

// ------------ //
// Menues Start //
// ------------ //

void print_mainmenu() {
	printf("********************************************\n");
	printf("**\t MainMenu \t\t\t****\n");
    printf("**\t 1. 2D Menu \t\t\t****\n");
    printf("**\t 2. 3D Menu \t\t\t****\n");
	printf("**\t 3. Exit \t\t\t****\n");
    printf("**\t Please enter your choice: \t****\n");
	printf("********************************************\n");
}


void print_submenu() {
	printf("********************************************\n");
	printf("**\t SubMenu \t\t\t****\n");
    printf("**\t -create2DPointAndArray \t****\n");
    printf("**\t -move2DPointDirekt \t\t****\n");
	printf("**\t -move2DPointTemp \t\t****\n");
	printf("**\t -getFileSize \t\t\t****\n");
	printf("**\t -append2DPointAndArray \t****\n");
	printf("**\t -transformPointToVect \t\t****\n");
	printf("**\t -vectAdd \t\t\t****\n");
	printf("**\t -skalMultVec \t\t\t****\n");
	printf("**\t -straightPosition \t\t****\n");
	printf("**\t -transformVectToPoint \t\t****\n");
	printf("**\t -createPolygon2DAndAppend \t****\n");
	printf("**\t -printPolygon2D \t\t****\n");
	printf("**\t -back \t\t\t\t****\n");
    printf("**\t Please enter your choice: \t****\n");
	printf("********************************************\n");
}


void print_2DMenu() {
	printf("********************************************\n");
	printf("**\t 2D Menu \t\t\t****\n");
    printf("**\t 1. Point Menu \t\t\t****\n");
	printf("**\t 2. Polygon Menu \t\t****\n");
	printf("**\t 3. Linear Algebra \t\t****\n");
	printf("**\t 4. Other Functions \t\t****\n");
	printf("**\t 5. Geometric Menu \t\t****\n");
	printf("**\t 6. Trigonometric Menu \t\t****\n");
	printf("**\t 7. Functions R^n \t\t****\n");
	printf("**\t 8. Back to MainMenu \t\t****\n");
	printf("**\t Please enter your choice: \t****\n");
	printf("********************************************\n");
}


void print_PointMenu() {
	printf("********************************************\n");
	printf("**\t 1. Point Menu \t\t\t****\n");
    printf("**\t -create2DPointAndArray \t****\n");
    printf("**\t -move2DPointDirekt \t\t****\n");
	printf("**\t -move2DPointTemp \t\t****\n");
	printf("**\t -append2DPointAndArray \t****\n");
	printf("**\t -back \t\t\t\t****\n");
    printf("**\t Please enter your choice: \t****\n");
	printf("********************************************\n");
}


void print_PolygonMenu() {
	printf("********************************************\n");
	printf("**\t 2. Polygon Menu \t\t****\n");
    printf("**\t -transformVectToPoint \t\t****\n");
    printf("**\t -createPolygon2DAndAppend \t****\n");
	printf("**\t -append2DPointToPolygon \t****\n");
	printf("**\t -insert2DPointAtPosition \t****\n");
    printf("**\t -insertAtPosition \t\t****\n");
	printf("**\t -pretty_print \t\t\t****\n");
	printf("**\t -printPolygon2D \t\t****\n");
	printf("**\t -writePolygonToFile \t\t****\n");
	printf("**\t -back \t\t\t\t****\n");
    printf("**\t Please enter your choice: \t****\n");
	printf("********************************************\n");
}


void print_LinearAlgebra() {
	printf("********************************************\n");
	printf("**\t 3. Linear Algebra \t\t****\n");
    printf("**\t -transformPointToVect \t\t****\n");
    //printf("**\t -freeVector \t\t\t****\n");
	printf("**\t -vectAdd \t\t\t****\n");
	printf("**\t -skalMultVec \t\t\t****\n");
    printf("**\t -printVectors \t\t\t****\n");
	printf("**\t -straightPosition \t\t****\n");
	printf("**\t -createMatrix2D \t\t****\n");
	printf("**\t -printMatrix \t\t\t****\n");
	printf("**\t -calculateVecMat \t\t****\n");
	//printf("**\t -writeMatrixToFile \t\t****\n");
	printf("**\t -back \t\t\t\t****\n");
    printf("**\t Please enter your choice: \t****\n");
	printf("********************************************\n");
}


void print_OtherFunctionsMenu() {
	printf("********************************************\n");
	printf("**\t 4. Other FunctionsMenu \t****\n");
    printf("**\t -getFileSize \t\t\t****\n");
    printf("**\t -copyLines \t\t\t****\n");
	printf("**\t -back \t\t\t\t****\n");
    printf("**\t Please enter your choice: \t****\n");
	printf("********************************************\n");
}


void print_GeometricFunctionsMenu() {
	printf("********************************************\n");
	printf("**\t 5. Geometric FunctionsMenu \t****\n");
    printf("**\t -calculateRectangleArea \t****\n");
    printf("**\t -calculateCirclePerimeter \t****\n");
	printf("**\t -calculateDistance \t\t****\n");
    printf("**\t -calculateSphereVolume \t****\n");
	printf("**\t -calculateHypotenuse \t\t****\n");
	printf("**\t -back \t\t\t\t****\n");
    printf("**\t Please enter your choice: \t****\n");
	printf("********************************************\n");
}

// HIER BERARBEITEN!!!!
void print_R^nFunctionsMenu() {
	printf("********************************************\n");
	printf("**\t 5. Geometric FunctionsMenu \t****\n");
    printf("**\t -calculateRectangleArea \t****\n");
    printf("**\t -calculateCirclePerimeter \t****\n");
	printf("**\t -calculateDistance \t\t****\n");
    printf("**\t -calculateSphereVolume \t****\n");
	printf("**\t -calculateHypotenuse \t\t****\n");
	printf("**\t -back \t\t\t\t****\n");
    printf("**\t Please enter your choice: \t****\n");
	printf("********************************************\n");
}

// ---------- //
// Menues End //
// ---------- //

/*5. Geometric Menu
float calculateRectangleArea(float width, float height) 
float calculateCirclePerimeter(float radius) 
float calculateDistance(float x1, float y1, float x2, float y2) 
float calculateSphereVolume(float radius) 
float calculateHypotenuse(float a, float b)
 6. Trigonometric Menu
float calculateSin(float angleInRadians) 
float calculateCos(float angleInRadians) 
float calculateTan(float angleInRadians) 
float convertDegreesToRadians(float degrees) 
7. Functions R^n           
LinearFunction createLinearFunction(float slope, float intercept) 
float calculateLinearFunctionValue(LinearFunction function, float x) 
void printLinearFunction(LinearFunction function) {
QuadraticFunction createQuadraticFunction(float a, float b, float c) 
float calculateQuadraticFunctionValue(QuadraticFunction function, float x) 
void printQuadraticFunction(QuadraticFunction function) 
CubicFunction createCubicFunction(float a, float b, float c, float d) 
float calculateCubicFunctionValue(CubicFunction function, float x) 
void printCubicFunction(CubicFunction function)






*/
// ------------------------ //
// Functions Implementation //
// ------------------------ //
// ----------------- //
// Point Menu Beginn //
// ----------------- //

void create2DPointAndArray(float param1, float param2) {
    numPoints = 0;
	int pointIndex = 0;
	printf("Anzahl der Punkte eingeben: ");
	scanf("%d", &numPoints);
	getchar();
	// Dynamisches Array für Punkte erstellen
	Point2D *pointArray = malloc(numPoints * sizeof(Point2D));
	// Benutzereingabe für jeden Punkt durchlaufen
	for (int i = 0; i < numPoints; i++) {
							
		printf("Koordinaten fuer Punkt %d eingeben:\n", i+1);
		printf("x: ");
		scanf("%f", &param1);
		printf("y: ");
		scanf("%f", &param2);

		// Neuen Punkt erstellen und im Array speichern
		Point2D p = createPoint2D(param1, param2);
		strcpy(pointArray[i].name, p.name);
		pointArray[i] = p;
		pointIndex++;				
	}
	// Array mit Punkten ausgeben
	printf("Eingegebene Punkte:\n");
	for (int i = 0; i < numPoints; i++) {
								
		printf("Punkt %s: x = %5.5f, y = %5.5f\n", pointArray[i].name, pointArray[i].x, pointArray[i].y);
							
	}
	char input[MAX_NAME_LENGHT];
	printf("Geben Sie einen Dateinamen an: ");
	char temp[MAX_NAME_LENGHT];
	fgets(temp, sizeof(temp), stdin); 
	fgets(input, sizeof(input), stdin);
	// Entferne das Zeilenumbruchzeichen am Ende des Dateinamens
    if (input[strlen(input) - 1] == '\n') {
		
        input[strlen(input) - 1] = '\0';
    
	}
    // Überprüfe die Dateiendung
    const char* fileExtension = ".txt";
    if (strstr(input, fileExtension) == NULL) {
		
        // Dateiendung nicht vorhanden, füge sie hinzu
        strcat(input, fileExtension);
		
    }
	/*
	char saveDecide;
	printf("Save temp pointArray for later?: 'y' = Save array, 'n' = Further, 'c' = abort.\n");
	scanf("%c", &saveDecide);
	switch(saveDecide) {
		case 'y':
			printf("Save...\n");
			tempArray = malloc(numPoints * sizeof(Point2D));
			for(int i = 0; i < numPoints; i++) {
				tempArray[i].name = pointArray[i].name;
				tempArray[i].x = pointArrray[i].x;
				tempArray[i].y = pointArrray[i].y;
			}
			break;
		case 'n':
			printf("Further...\n");
			break;
		default:
			break;
	}
	*/
	char switchChar;
	printf("Welche Optionen moechten Sie ausfuehren? 'a' = write, 'b' = append, 'c' = abort.\n");
	scanf("%c", &switchChar);
	switch(switchChar) {
		case 'a':
			printf("Write.\n");
			// Datei öffnen
			FILE* outFileWrite = fopen(input, "w");
			if (outFileWrite == NULL) {
				
				printf("Fehler beim Oeffnen der Datei zum Schreiben.\n");
				return;
				
			}
			// Vektor in Datei schreiben
			fprintf(outFileWrite, "Punkt %s: x = %.5f, y = %.5f\n", pointArray[pointIndex].name, pointArray[pointIndex].x, pointArray[pointIndex].y);
			// Datei schließen
			fclose(outFileWrite);
			printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
			free(pointArray);
			break;
		case 'b':
			printf("Append.\n");
			// Datei öffnen
			FILE* outFileAppend = fopen(input, "a");
			if (outFileAppend == NULL) {
				
				printf("Fehler beim Oeffnen der Datei zum Schreiben.\n");
				return;
				
			}
			// Vektor in Datei schreiben
			fprintf(outFileAppend, "Punkt %s: x = %.5f, y = %.5f\n", pointArray[pointIndex].name, pointArray[pointIndex].x, pointArray[pointIndex].y);
			// Datei schließen
			fclose(outFileAppend);
			printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
			free(pointArray);
			break;
		case 'c':
            printf("Back to the SubMenu.\n");
            break;
        default:
            printf("Invalid choice. Please try again.\n");
            break; 
	}
	/*
    FILE* file = fopen(input, "w");
	if (file == NULL) {
								
		printf("Fehler beim Oeffnen der Datei.\n");
							
	}
	for(int i = 0; i < numPoints; i++) {
		
		fprintf(file, "Punkt %d: x = %.2f, y = %.2f\n", i+1, pointArray[i].x, pointArray[i].y);
							
	}
	//fprintf(file, "Zahl: %d\n", 42);
	//fprintf(file, "Float: %.2f\n", 3.14);
	fclose(file);
	printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
	free(pointArray);
	*/
}


void move2DPointDirekt(float param1, float param2) {
	char filename[MAX_NAME_LENGHT];
    printf("Geben Sie den Dateinamen ein: ");
    fgets(filename, sizeof(filename), stdin);
	if (filename[strlen(filename) - 1] == '\n') {
		
		filename[strlen(filename) - 1] = '\0';
		
	}	
    // Überprüfen der Dateiendung
    char* extension = strrchr(filename, '.');
    if (extension == NULL || strcmp(extension, ".txt") != 0) {
		
        printf("Ungueltige Dateiendung. Es werden nur .txt-Dateien unterstützt.\n");
		
    }
	//Testen des Datei Öffnen
    FILE* file = fopen(filename, "r+");
    if (file == NULL) {
		
        printf("Fehler beim Oeffnen der Datei.\n");
		
    }
    // Filtern des gesuchten Vektors
	int arrayIndexToEdit;  // Index des zweiten Arrays
	int pointIndexToEdit;  // Index des dritten Punkts
	printf("Geben Sie an welcher Vektor bearbeitet werden soll.\n");
	printf("Welcher Vektor?.\n");
	scanf("%d", &arrayIndexToEdit);
	printf("Welcher Index aus den zuvorgewaehlten Vector.\n");
	scanf("%d", &pointIndexToEdit);
	Point2D *pointArray = malloc(numPoints * sizeof(Point2D));
	// Berechne die Position des gewünschten Punkts im Datei-Offset
	long offset = arrayIndexToEdit * sizeof(Point2D) * numPoints + pointIndexToEdit * sizeof(Point2D);
	// Setze den Dateizeiger an die berechnete Position
	fseek(file, offset, SEEK_SET);
	// Lese den gewünschten Punkt aus der Datei
	Point2D point;
	if (fread(&point, sizeof(Point2D), 1, file) != 1) {
		
        printf("Fehler beim Lesen des Punkts aus der Datei.\n");
        fclose(file);
        free(pointArray);
        return;
		
    }
	// Bearbeite den Punkt
	point.x = param1;
	point.y = param2;
	// Setze den Dateizeiger erneut an die berechnete Position
	fseek(file, offset, SEEK_SET);
	// Schreibe den bearbeiteten Punkt in die Datei
	//fwrite(&point, sizeof(point), 1, file);
    fprintf(file, "Punkt %d: x = %.2f, y = %.2f\n", pointIndexToEdit + 1, point.x, point.y);
    fclose(file);
    free(pointArray);
    printf("Die Datei '%s' wurde erfolgreich geoeffnet und verarbeitet.\n", filename);
}


void move2DPointTemp(float param1, float param2) {
    char filename[MAX_NAME_LENGHT];
    printf("Geben Sie den Dateinamen ein: ");
    fgets(filename, sizeof(filename), stdin);
    if (filename[strlen(filename) - 1] == '\n') {
		
        filename[strlen(filename) - 1] = '\0';
		
    }
    // Überprüfen der Dateiendung
    char* extension = strrchr(filename, '.');
    if (extension == NULL || strcmp(extension, ".txt") != 0) {
		
        printf("Ungueltige Dateiendung. Es werden nur .txt-Dateien unterstuetzt.\n");
        return;
		
    }
    // Datei öffnen
    FILE* file = fopen(filename, "r+");
    if (file == NULL) {
		
        printf("Fehler beim Oeffnen der Datei.\n");
        return;
		
    }
    // Filtern des gesuchten Vektors
    int arrayIndexToEdit;  // Index des zweiten Arrays
    int pointIndexToEdit;  // Index des dritten Punkts
    printf("Geben Sie an, welcher Vektor bearbeitet werden soll: ");
    scanf("%d", &arrayIndexToEdit);
    printf("Geben Sie an, welcher Index aus den zuvor ausgewaehlten Vektor bearbeitet werden soll: ");
    scanf("%d", &pointIndexToEdit);
    getchar();  // Leert den Puffer für das folgende fgets()
    // Lese alle Punkte aus der Datei in ein temporäres Array
    Point2D pointArray[MAX_NAME_LENGHT];  // Annahme: Maximal 100 Punkte im Array
    int numPoints = 0;
    Point2D tempPoint;
    while (fscanf(file, "Punkt %*d: x = %f, y = %f\n", &(tempPoint.x), &(tempPoint.y)) == 2) {
		
        pointArray[numPoints] = tempPoint;
        numPoints++;
		
    }
    // Überprüfen, ob der angegebene Index gültig ist
    if (arrayIndexToEdit < 0 || arrayIndexToEdit >= numPoints || pointIndexToEdit < 0 || pointIndexToEdit >= numPoints) {
		
        printf("Ungueltiger Index. Der angegebene Punkt existiert nicht.\n");
        fclose(file);
        return;
		
    }
    // Bearbeite den Punkt im temporären Array
    pointArray[arrayIndexToEdit].x = param1;
    pointArray[arrayIndexToEdit].y = param2;
    // Setze den Dateizeiger ans Anfang der Datei
    rewind(file);
    // Schreibe den aktualisierten Inhalt des temporären Arrays in die Datei
    for (int i = 0; i < numPoints; i++) {
		
        fprintf(file, "Punkt %d: x = %.2f, y = %.2f\n", i+1, pointArray[i].x, pointArray[i].y);
    
	}
    fclose(file);
    printf("Die Datei '%s' wurde erfolgreich geoeffnet und verarbeitet.\n", filename);
}


void append2DPointAndArray(float param1, float param2) {
    numPoints = 0;
	printf("Anzahl der Punkte eingeben: ");
	scanf("%d", &numPoints);
	getchar();
	// Dynamisches Array für Punkte erstellen
	Point2D *pointArray = malloc(numPoints * sizeof(Point2D));
	// Benutzereingabe für jeden Punkt durchlaufen
	for (int i = 0; i < numPoints; i++) {
							
		printf("Koordinaten fuer Punkt %d eingeben:\n", i+1);
		printf("x: ");
		scanf("%f", &param1);
		printf("y: ");
		scanf("%f", &param2);

		// Neuen Punkt erstellen und im Array speichern
		Point2D p = createPoint2D(param1, param2);
		pointArray[i] = p;
							
	}
	// Array mit Punkten ausgeben
	printf("Eingegebene Punkte:\n");
	for (int i = 0; i < numPoints; i++) {
								
		printf("Punkt %d: x = %5.5f, y = %5.5f\n", i+1, pointArray[i].x, pointArray[i].y);
							
	}
	char input[MAX_NAME_LENGHT];
	printf("Geben Sie einen Dateinamen an: ");
	char temp[MAX_NAME_LENGHT];
	fgets(temp, sizeof(temp), stdin); 
	fgets(input, sizeof(input), stdin);
	// Entferne das Zeilenumbruchzeichen am Ende des Dateinamens
    if (input[strlen(input) - 1] == '\n') {
		
        input[strlen(input) - 1] = '\0';
    
	}
    // Überprüfe die Dateiendung
    const char* fileExtension = ".txt";
    if (strstr(input, fileExtension) == NULL) {
		
        // Dateiendung nicht vorhanden, füge sie hinzu
        strcat(input, fileExtension);
		
    }
    FILE* file = fopen(input, "a+");
	if (file == NULL) {
								
		printf("Fehler beim Oeffnen der Datei.\n");
							
	}
	// Setze den Dateizeiger an das Ende der Datei
	fseek(file, 0, SEEK_END);
	for(int i = 0; i < numPoints; i++) {
		
		fprintf(file, "Punkt %d: x = %.2f, y = %.2f\n", i+1, pointArray[i].x, pointArray[i].y);
							
	}
	//fprintf(file, "Zahl: %d\n", 42);
	//fprintf(file, "Float: %.2f\n", 3.14);
	fclose(file);
	printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
	free(pointArray);
}

// ------------------- //
// Polygon2D Functions //
// ------------------- //

void createPolygon2DAndAppend(char *sourceFile) {
	// Open file with points2D
	FILE* file = fopen(sourceFile, "r");
    if (file == NULL) {
		
        printf("Error opening the file.\n");
    }
	// Choose of Name of the list
	char listName[MAX_NAME_LENGHT];
    printf("Specify the name of list: ");
    fgets(listName, sizeof(listName), stdin);
    if (listName[strlen(listName) - 1] == '\n') {
		
        listName[strlen(listName) - 1] = '\0';
		
    }
	// Create head of Point2D
	Polygon2D tempHead = NULL;
    // Use the list to append points at the head of list
    printf("Name of the list: %s\n", listName);
	// Load dynamic points 
	int countOfPoints;
	printf("Specify the amount of points to be loaded.\n");
	scanf("%d", &countOfPoints);
	getchar();
	int pointIndex = 0;
	//Point2D *pointArray = malloc(countOfPoints * sizeof(Point2D));
	for(pointIndex = 0; pointIndex < countOfPoints; pointIndex++){
		/*
		//Nach Namen filtern
		char searchingPointName[MAX_NAME_LENGHT];
		printf("Geben Sie den gesuchten Punkt Namen ein: ");
		fgets(searchingPointName, sizeof(searchingPointName), stdin);
		if (searchingPointName[strlen(searchingPointName) - 1] == '\n') {
		
			searchingPointName[strlen(searchingPointName) - 1] = '\0';
		
		}
		// Filtern des gesuchten PunktIndex
		int pointIndexToEdit;  // Index des dritten Punkts
		printf("Welcher Index aus den zuvorgewaehlten Vector?\n");
		scanf("%d", &pointIndexToEdit);
		getchar();
		*/
		
		// Load all points from Data
		char line[100];
		while (fgets(line, sizeof(line), file) != NULL) {
			
            if (strstr(line, "Punkt") != NULL) {
				
                char name[MAX_NAME_LENGHT];
                float x, y;
                sscanf(line, "Punkt %[^:]:x = %f, y = %f", name, &x, &y);
                printf("Selected point %s: x = %5.5f, y = %5.5f\n", name, x, y);
				// Create Point and save into array
				Point2D pnt = createPoint2D(x, y);
				strcpy(pnt.name, name);
				//pointArray[pointIndex] = pnt;
				pointIndex++;
				append2DPointToPolygon(&tempHead, pnt);
            }
        }
	}
	// Create Polygon2D(LinkedList)
	// createLinkedList(pointArray, countOfPoints);
	// Type the filename for save
    char filename[MAX_NAME_LENGHT];
    printf("Specify the name of data for save: ");
    fgets(filename, sizeof(filename), stdin);
    if (filename[strlen(filename) - 1] == '\n') {
		
        filename[strlen(filename) - 1] = '\0';
		
    }
    // Check the end of file
    char* extension = strrchr(filename, '.');
    if (extension == NULL || strcmp(extension, ".txt") != 0) {
		
        printf("Invalid file extension. Only '.txt' files are supported.\n");
        return;
		
    }
	// Other operations
	char switchChar;
	printf("Which options do you want to execute? 'a' = write, 'b' = append, 'c' = abort.\n");
	scanf("%c", &switchChar);
	switch(switchChar) {
		case 'a':
			printf("Write...\n");
			// Open file
			FILE* outFileWrite = fopen(filename, "w");
			if (outFileWrite == NULL) {
				
				printf("Error opening the file to write.\n");
				return;
				
			}
			// Write vec into data
			writePolygonToFile(outFileWrite, &tempHead, listName);
			fclose(outFileWrite);
			printf("Data was successfully written to the file.\n");
			break;
		case 'b':
			printf("Append...\n");
			// Open file
			FILE* outFileAppend = fopen(filename, "a");
			if (outFileAppend == NULL) {
				
				printf("Error opening the file to write.\n");
				return;
				
			}
			// Append vec into data
			writePolygonToFile(outFileAppend, &tempHead, listName);
			fclose(outFileAppend);
			printf("Data was successfully written to the file.\n");
			break;
		case 'c':
            printf("Back to the SubMenu.\n");
            break;
        default:
            printf("Invalid choice. Please try again.\n");
            break; 
	}
}


void append2DPointToPolygon(Polygon2D *tempHead, Point2D pnt) {
	// Append all points from array into Polygon
	Le2D *new = malloc(sizeof(Le2D));
	new->pnt = pnt;
	new->next = NULL;
	if(*tempHead == NULL){
			
		*tempHead = new;
			
	} else {
			
		Le2D *tmp = *tempHead;
		Le2D *last;
		while(tmp != NULL){
				
			last = tmp;
			tmp = tmp->next;
				
		}
		
		last->next = new;
			
	}
	
}


void writePolygonToFile(FILE *outFileWrite, Polygon2D *polygon, const char *listName) {
	// Write complete Polygon2D into data
    fprintf(outFileWrite, "Polygon2D %s\n", listName);
    Le2D *current = *polygon;
    while (current != NULL) {
		
        fprintf(outFileWrite, "Punkt %s: x = %.2f, y = %.2f\n", current->pnt.name, current->pnt.x, current->pnt.y);
        current = current->next;
		
    }
}


void printPolygon2D(char *sourceFile) {
	//Open file with (2DPoints)
	FILE* file = fopen(sourceFile, "r");
    if (file == NULL) {
		
        printf("Fehler beim Oeffnen der Datei.\n");
    }
	char line[100];
	while (fgets(line, sizeof(line), file) != NULL) {
			
        if (strstr(line, "Punkt") != NULL) {
				
            char name[MAX_NAME_LENGHT];
            float x, y;
            sscanf(line, "Punkt %[^\n]:x = %f, y = %f", name, &x, &y);
            printf("Punkt %s: x = %5.5f, y = %5.5f\n", name, x, y);
			
        }
    }
	fclose(file);
}

// Polygon2D Print Function //
void pretty_print(Polygon2D bsp) {
	if(bsp == NULL) {										//Wenn bsp == NULL(Leer)
		printf("Ein leerer Polygonzug.\n");
	} 
	else { 
		printf("-------------------\nStart Polygonzug:\n");
		while(bsp != NULL){
			printf("(%5.5f,%5.5f)\n", bsp->pnt.x, bsp->pnt.y);
			bsp = bsp->next;
		}
		printf("Ende Polgonzug\n-------------------\n");
	}
}

// Function to insert 2D points arbitrarily in polygon //
void insert2DPointAtPosition(char *sourceFilePoints, char *sourcheFilePolygon) {
	// Create temp Polygon2D
	Polygon2D tempHead = NULL;
	// To load Polygon2D (PRETTY PRINT)
	// Open file with points2D (SOURCEFILE) for working
	FILE *file2DPolygon = fopen(sourcheFilePolygon, "r");
    if (file2DPolygon == NULL) {
		
        printf("Error opening the file.\n");
		
    }
	char line[100];
	while (fgets(line, sizeof(line), file2DPolygon) != NULL) {
			
        if (strstr(line, "Punkt") != NULL) {
				
            char name[MAX_NAME_LENGHT];
            float x, y;
            sscanf(line, "Punkt %[^\n]:x = %f, y = %f", name, &x, &y);
			Point2D pnt = createPoint2D(x, y);
			strcpy(pnt.name, name);
            //printf("Punkt %s: x = %5.5f, y = %5.5f\n", name, x, y);
			// Append all points to Polygon2D
			append2DPointToPolygon(&tempHead, pnt);
			
        }
    }
	// Function for print Polygon2D //
	pretty_print(tempHead);
	// Open file with points2D (SOURCEFILE) for working
	FILE *file2DPoint = fopen(sourceFilePoints, "r");
    if (file2DPoint == NULL) {
		
        printf("Error opening the file.\n");
		
    }
	// Load dynamic points 
	int countOfPoints;
	printf("Specify the amount of points to be loaded.\n");
	scanf("%d", &countOfPoints);
	getchar();
	int pointIndex = 0;
	Point2D *tempPointArray = malloc(countOfPoints * sizeof(Point2D));
	for(pointIndex = 0; pointIndex < countOfPoints; pointIndex++){
		
		char line[100];
		while (fgets(line, sizeof(line), file2DPoint) != NULL) {
			
            if (strstr(line, "Punkt") != NULL) {
				
                char name[MAX_NAME_LENGHT];
                float x, y;
                sscanf(line, "Punkt %[^:]:x = %f, y = %f", name, &x, &y);
                printf("Selected point %s: x = %5.5f, y = %5.5f\n", name, x, y);
				// Create Point and save into array
				Point2D pnt = createPoint2D(x, y);
				//create2DPointAndArray(float param1, float param2) 
				strcpy(tempPointArray[pointIndex].name, pnt.name);
				tempPointArray[pointIndex] = pnt;
				pointIndex++;
				//einfügen des punktes
				int position;
				printf("Waehlen Sie die Position\n");
				scanf("%d", &position);
				insertAtPosition(&tempHead, position, pnt);
            }
        }
	}
	// Type the name for the Polygon2D //
	char listName[MAX_NAME_LENGHT];
    printf("Specify the name of list: ");
    fgets(listName, sizeof(listName), stdin);
    if (listName[strlen(listName) - 1] == '\n') {
		
        listName[strlen(listName) - 1] = '\0';
		
    }
	// Functions to save data 
	// Type the filename
    char filename[MAX_NAME_LENGHT];
    printf("Specify the name of data for save: ");
    fgets(filename, sizeof(filename), stdin);
    if (filename[strlen(filename) - 1] == '\n') {
		
        filename[strlen(filename) - 1] = '\0';
		
    }
    // Check the end of file
    char* extension = strrchr(filename, '.');
    if (extension == NULL || strcmp(extension, ".txt") != 0) {
		
        printf("Invalid file extension. Only '.txt' files are supported.\n");
        return;
		
    }
	// Open file
	FILE* outFileWrite = fopen(filename, "w");
	if (outFileWrite == NULL) {
				
		printf("Error opening the file to write.\n");
		return;
				
	}
	// Write Polygon2D into data
	writePolygonToFile(outFileWrite, &tempHead, listName);
	fclose(outFileWrite);
	printf("Data was successfully written to the file.\n");
	free(tempPointArray);
	
	/*
	// Options for further 
	char switchChar;
	printf("Which options do you want to execute? 'a' = write, 'b' = append, 'c' = abort.\n");
	scanf("%c", &switchChar);
	switch(switchChar) {
		case 'a':
			printf("Write...\n");
			// Open file
			FILE* outFileWrite = fopen(filename, "w");
			if (outFileWrite == NULL) {
				
				printf("Error opening the file to write.\n");
				return;
				
			}
			// Write vec into data
			writePolygonToFile(outFileWrite, &head, listName);
			fclose(outFileWrite);
			printf("Data was successfully written to the file.\n");
			free(pointArray);
			break;
		case 'b':
			printf("Append...\n");
			// Open file
			FILE* outFileAppend = fopen(filename, "a");
			if (outFileAppend == NULL) {
				
				printf("Error opening the file to write.\n");
				return;
				
			}
			// Append vec into data
			writePolygonToFile(outFileAppend, &head, listName);
			fclose(outFileAppend);
			printf("Data was successfully written to the file.\n");
			free(pointArray);
			break;
		case 'c':
            printf("Back to the SubMenu.\n");
            break;
        default:
            printf("Invalid choice. Please try again.\n");
            break; 
	}
	*/
}

// Insertion an Point into Polygon2D //
void insertAtPosition(Polygon2D *temphead, int position, Point2D pnt) {	

	if (*temphead == NULL) {
			
		printf("Liste ist leer!\n");
		return;
			
	}
	// Finde den Vorgängerknoten des Einfügepunkts
	Polygon2D current = *temphead;
	for (int i = 1; i < position; i++) {
			
		if (current == NULL) {
				
			printf("Ungültige Position!\n");
			return;
				
		}
			
		current = current->next;
			
	}
	// Erstelle einen neuen Knoten
	Le2D *new = malloc(sizeof(Le2D));
	new->pnt = pnt;
	new->next = NULL;
	// Setze den nächsten Zeiger des neuen Knotens auf den Nachfolgeknoten des Vorgängerknotens
	new->next = current->next;
	// Setze den nächsten Zeiger des Vorgängerknotens auf den neuen Knoten
	current->next = new;
	
}


// ------------------------- //
// LinearAlgebra Menu Beginn //
// ------------------------- //

void transformPointToVect(char *sourceFile) {
    // Datei öffnen
    FILE* file = fopen(sourceFile, "r");
    if (file == NULL) {
        printf("Fehler beim Oeffnen der Datei.\n");
        return;
    }
    // Filtern der gesuchten Punkte
	int arrayIndexToEdit;  // Index des Arrays
	int pointIndexToEdit;  // Index des Punkts
	printf("Geben Sie an, welcher Punkt bearbeitet werden soll: ");
	scanf("%d", &arrayIndexToEdit);
	printf("Geben Sie an, welcher Index aus der zuvor ausgewaehlten Liste bearbeitet werden soll: ");
	scanf("%d", &pointIndexToEdit);
	getchar();  // Puffer leeren für fgets()
	// Den gewünschten Punkt finden und in ein separates Array kopieren
	float pointArray[2];
	int numPoints = 0;
	char line[100];
	while (fgets(line, sizeof(line), file) != NULL) {
		if (strstr(line, "Punkt") != NULL) {
			int pointNumber;
			float x, y;
			sscanf(line, "Punkt %d: x = %f, y = %f", &pointNumber, &x, &y);
			if (pointNumber == arrayIndexToEdit && numPoints == pointIndexToEdit) {
				pointArray[0] = x;
				pointArray[1] = y;
				break;
			}
			numPoints++;
		}
	}
    // Schließe die Datei
    fclose(file);
    // Zeige den ausgewählten Punkt als Vektor an
    printf("Ausgewaehlter Punkt als Vektor: x = %5.5f, y = %5.5f\n", pointArray[0], pointArray[1]);
    // Vektor in eine Datei speichern
    Vector2D temp = createVector2D();
    temp.x = pointArray[0];
    temp.y = pointArray[1];
    // Dateinamen eingeben
    char filename[MAX_NAME_LENGHT];
    printf("Geben Sie den Dateinamen zum Speichern ein: ");
    fgets(filename, sizeof(filename), stdin);
    if (filename[strlen(filename) - 1] == '\n') {
		
        filename[strlen(filename) - 1] = '\0';
		
    }
    // Überprüfen der Dateiendung
    char* extension = strrchr(filename, '.');
    if (extension == NULL || strcmp(extension, ".txt") != 0) {
		
        printf("Ungueltige Dateiendung. Es werden nur .txt-Dateien unterstuetzt.\n");
        return;
		
    }
	// Other operations
	char switchChar;
	printf("Welche Optionen moechten Sie ausfuehren? 'a' = write, 'b' = append, 'c' = abort.\n");
	scanf("%c", &switchChar);
	switch(switchChar) {
		case 'a':
			printf("Write.\n");
			// Datei öffnen
			FILE* outFileWrite = fopen(filename, "w");
			if (outFileWrite == NULL) {
				
				printf("Fehler beim Oeffnen der Datei zum Schreiben.\n");
				return;
				
			}
			// Vektor in Datei schreiben
			fprintf(outFileWrite, "Vektor %s: [%.5f %.5f]\n", temp.name, temp.x, temp.y);
			// Datei schließen
			fclose(outFileWrite);
			printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
			break;
		case 'b':
			printf("Append.\n");
			// Datei öffnen
			FILE* outFileAppend = fopen(filename, "a");
			if (outFileAppend == NULL) {
				
				printf("Fehler beim Oeffnen der Datei zum Schreiben.\n");
				return;
				
			}
			// Vektor in Datei schreiben
			fprintf(outFileAppend, "Vektor %s: [%.5f %.5f]\n", temp.name, temp.x, temp.y);
			// Datei schließen
			fclose(outFileAppend);
			printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
			break;
		case 'c':
            printf("Back to the SubMenu.\n");
            break;
        default:
            printf("Invalid choice. Please try again.\n");
            break; 
	}
}

void skalMultVec(char *sourceFile) {
	//File öffnen
	FILE* file = fopen(sourceFile, "r");
    if (file == NULL) {
		
        printf("Fehler beim Oeffnen der Datei.\n");
    }
	//Nach Namen filtern
	char searchingVecName[MAX_NAME_LENGHT];
	printf("Geben Sie den gesuchten Vector Namen ein: ");
	fgets(searchingVecName, sizeof(searchingVecName), stdin);
    if (searchingVecName[strlen(searchingVecName) - 1] == '\n') {
		
        searchingVecName[strlen(searchingVecName) - 1] = '\0';
		
    }
	//Vektor aus Datei laden und temporär speichern
	Vector2D temp;
	Vector2D vectors[5];
    int numVectors = 0;
    char line[200];
    while (fgets(line, sizeof(line), file) != NULL) {
		
        if (strstr(line, "Vektor") != NULL) {
			
            sscanf(line, "Vektor %[^:]:[%f %f]", vectors[numVectors].name, &vectors[numVectors].x, &vectors[numVectors].y);
			printf("Vektor %s: [%.5f %.5f]\n", vectors[numVectors].name, vectors[numVectors].x, vectors[numVectors].y);
			
			if (strcmp(searchingVecName, vectors[numVectors].name) == 0) {
				
				temp = createVector2D();
				strcpy(temp.name, vectors[numVectors].name);
				temp.x = vectors[numVectors].x;
				temp.y = vectors[numVectors].y;
				break;
				
			}
        }
		numVectors++;
    }
	//Überprüfung größe Array
	if (numVectors >= sizeof(vectors) / sizeof(vectors[0])) {
		
		printf("Die Anzahl der Vektoren in der Datei ist größer als die Größe des Arrays.\n");
		return;
		
	}
	//Überprüfung Indexbereich
	if (numVectors >= 0 && numVectors < sizeof(vectors) / sizeof(vectors[0])) {
		
		// Zugriff auf den Vektor
		printf("Ausgewaehlter Vektor: Vektor %s: [%.5f %.5f]\n", temp.name, temp.x, temp.y);
		
	} else {
		
		printf("Ungültiger Index für den Vektor.\n");
		return;
		
	}
	//skalare Berechnung des temporär geladenen Vectors
	float skalar;
	printf("Waehlen Sie ein skalar.\n");
	scanf("%f", &skalar);
    temp.x *= skalar;
    temp.y *= skalar;
	getchar();
    printf("Ergebnis der Vektoraddition: [%.5f %.5f]\n", temp.x, temp.y);
	//Dateinamen eingeben
    char filename[MAX_NAME_LENGHT];
    printf("Geben Sie den Dateinamen zum Speichern ein: ");
    fgets(filename, sizeof(filename), stdin);
    if (filename[strlen(filename) - 1] == '\n') {
		
        filename[strlen(filename) - 1] = '\0';
		
    }
    // Überprüfen der Dateiendung
    char* extension = strrchr(filename, '.');
    if (extension == NULL || strcmp(extension, ".txt") != 0) {
		
        printf("Ungueltige Dateiendung. Es werden nur .txt-Dateien unterstuetzt.\n");
        return;
		
    }
	// Other operations
	char switchChar;
	printf("Welche Optionen moechten Sie ausfuehren? 'a' = write, 'b' = append, 'c' = abort.\n");
	scanf("%c", &switchChar);
	switch(switchChar) {
		case 'a':
			printf("Write.\n");
			// Datei öffnen
			FILE* outFileWrite = fopen(filename, "w");
			if (outFileWrite == NULL) {
				
				printf("Fehler beim Oeffnen der Datei zum Schreiben.\n");
				return;
				
			}
			// Vektor in Datei schreiben
			fprintf(outFileWrite, "Vektor %s: [%.5f %.5f]\n", temp.name, temp.x, temp.y);
			fclose(outFileWrite);
			printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
			break;
		case 'b':
			printf("Append.\n");
			// Datei öffnen
			FILE* outFileAppend = fopen(filename, "a");
			if (outFileAppend == NULL) {
				
				printf("Fehler beim Oeffnen der Datei zum Schreiben.\n");
				return;
				
			}
			// Vektor in Datei schreiben
			fprintf(outFileAppend, "Vektor %s: [%.5f %.5f]\n", temp.name, temp.x, temp.y);
			fclose(outFileAppend);
			printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
			break;
		case 'c':
            printf("Back to the SubMenu.\n");
            break;
        default:
            printf("Invalid choice. Please try again.\n");
            break; 
	}
}

void vectAdd(char *sourceFile){
	//File öffnen
	FILE* file = fopen(sourceFile, "r");
    if (file == NULL) {
		
        printf("Fehler beim Oeffnen der Datei.\n");
    }
	//Auswahl der Anzahl von Vektoren 
	int numbersOfVectors;
	printf("Geben Sie die Menge an Vektoren an die geladen werden sollen.\n");
	scanf("%d", &numbersOfVectors);
	getchar();
	Vector2D vectors[numbersOfVectors];
	int numVectors = 0;
	for(int i = 0; i < numbersOfVectors; i++) {
		//Nach Namen filtern
		char searchingVecName[MAX_NAME_LENGHT];
		printf("Geben Sie den gesuchten Vector Namen ein: ");
		fgets(searchingVecName, sizeof(searchingVecName), stdin);
		if (searchingVecName[strlen(searchingVecName) - 1] == '\n') {
		
			searchingVecName[strlen(searchingVecName) - 1] = '\0';
		
		}
		//Vektor aus Datei laden und temporär speichern
		Vector2D temp;
		char line[200];
		while (fgets(line, sizeof(line), file) != NULL) {
		
			if (strstr(line, "Vektor") != NULL) {
			
				sscanf(line, "Vektor %[^:]:[%f %f]", vectors[numVectors].name, &vectors[numVectors].x, &vectors[numVectors].y);
				printf("Vektor %s: [%.5f %.5f]\n", vectors[numVectors].name, vectors[numVectors].x, vectors[numVectors].y);
			
				if (strcmp(searchingVecName, vectors[numVectors].name) == 0) {
				
					temp = createVector2D();
					strcpy(temp.name, vectors[numVectors].name);
					temp.x = vectors[numVectors].x;
					temp.y = vectors[numVectors].y;
					break;
					
				}
			}
			
		}
		numVectors++;
	}
	// Vektoren addieren
	printf("... createResultVektor...\n");
    Vector2D resultVector = createVector2D();
	for(int i = 0; i < numbersOfVectors; i++){
		
		resultVector.x += vectors[i].x;
		resultVector.y += vectors[i].y;
		
    }
	printf("Ergebnis der Vektoraddition: [%.5f %.5f]\n", resultVector.x, resultVector.y);
	// Dateinamen eingeben
    char filename[MAX_NAME_LENGHT];
    printf("Geben Sie den Dateinamen zum Speichern ein: ");
    fgets(filename, sizeof(filename), stdin);
    if (filename[strlen(filename) - 1] == '\n') {
		
        filename[strlen(filename) - 1] = '\0';
		
    }
    // Überprüfen der Dateiendung
    char* extension = strrchr(filename, '.');
    if (extension == NULL || strcmp(extension, ".txt") != 0) {
		
        printf("Ungueltige Dateiendung. Es werden nur .txt-Dateien unterstuetzt.\n");
        return;
		
    }
	// Other operations
	char switchChar;
	printf("Welche Optionen moechten Sie ausfuehren? 'a' = write, 'b' = append, 'c' = abort.\n");
	scanf("%c", &switchChar);
	switch(switchChar) {
		case 'a':
			printf("Write\n");
			// Datei öffnen
			FILE* outFileWrite = fopen(filename, "w");
			if (outFileWrite == NULL) {
				
				printf("Fehler beim Oeffnen der Datei zum Schreiben.\n");
				return;
				
			}
			// Vektor in Datei schreiben
			fprintf(outFileWrite, "Vektor %s: [%.5f %.5f]\n", resultVector.name, resultVector.x, resultVector.y);
			// Datei schließen
			fclose(outFileWrite);
			printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
			break;
		case 'b':
			printf("Append\n");
			// Datei öffnen
			FILE* outFileAppend = fopen(filename, "a");
			if (outFileAppend == NULL) {
				
				printf("Fehler beim Oeffnen der Datei zum Schreiben.\n");
				return;
				
			}
			// Vektor in Datei schreiben
			fprintf(outFileAppend, "Vektor %s: [%.5f %.5f]\n", resultVector.name, resultVector.x, resultVector.y);
			// Datei schließen
			fclose(outFileAppend);
			printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
			break;
		case 'c':
            printf("Back to the SubMenu.\n");
            break;
        default:
            printf("Invalid choice. Please try again.\n");
            break; 
	}
}

void straightPosition(char *sourceFile){
	//File öffnen
	FILE* file = fopen(sourceFile, "r");
    if (file == NULL) {
		
        printf("Fehler beim Oeffnen der Datei.\n");
    }
	//Auswahl der Anzahl von Vektoren 
	int numbersOfVectors = 2;
	Vector2D vectors[numbersOfVectors];
	int numVectors = 0;
	for(int i = 0; i < numbersOfVectors; i++) {
		//Nach Namen filtern
		char searchingVecName[MAX_NAME_LENGHT];
		printf("Geben Sie den gesuchten Vector Namen (No.:%d), ein: ", i);
		fgets(searchingVecName, sizeof(searchingVecName), stdin);
		if (searchingVecName[strlen(searchingVecName) - 1] == '\n') {
		
			searchingVecName[strlen(searchingVecName) - 1] = '\0';
		
		}
		//Vektor aus Datei laden und temporär speichern
		char line[200];
		Vector2D temp;
		while (fgets(line, sizeof(line), file) != NULL) {
		
			if (strstr(line, "Vektor") != NULL) {
			
				sscanf(line, "Vektor %[^:]:[%f %f]", vectors[numVectors].name, &vectors[numVectors].x, &vectors[numVectors].y);
				printf("Vektor %s: [%.5f %.5f]\n", vectors[numVectors].name, vectors[numVectors].x, vectors[numVectors].y);
			
				if (strcmp(searchingVecName, vectors[numVectors].name) == 0) {
				
					temp = createVector2D(); //->119
					strcpy(temp.name, vectors[numVectors].name);
					temp.x = vectors[numVectors].x;
					temp.y = vectors[numVectors].y;
					break;
					
				}
			}
		}
		numVectors++;
	}
	//skalare Berechnung des temporär geladenen Vectors
	float skalar;
	printf("Waehlen Sie ein skalar.\n");
	scanf("%f", &skalar);
	getchar();
	// Vektoren addieren
	printf("... create ResultVektor...\n");
    Vector2D resultVector = createVector2D();//->119
	printf("... calculate straight...\n");
	resultVector.x = vectors[0].x + (skalar * vectors[0].x);
	resultVector.y = vectors[0].y + (skalar * vectors[1].y);
	printf("Result of the Vectors: [%.5f %.5f]\n", resultVector.x, resultVector.y);
	// Dateinamen eingeben
    char filename[MAX_NAME_LENGHT];
    printf("Geben Sie den Dateinamen zum Speichern ein: ");
    fgets(filename, sizeof(filename), stdin);
    if (filename[strlen(filename) - 1] == '\n') {
		
        filename[strlen(filename) - 1] = '\0';
		
    }
    // Überprüfen der Dateiendung
    char* extension = strrchr(filename, '.');
    if (extension == NULL || strcmp(extension, ".txt") != 0) {
		
        printf("Ungueltige Dateiendung. Es werden nur .txt-Dateien unterstuetzt.\n");
        return;
		
    }
	// Other operations
	char switchChar;
	printf("Welche Optionen moechten Sie ausfuehren? 'a' = write, 'b' = append, 'c' = abort.\n");
	scanf("%c", &switchChar);
	switch(switchChar) {
		case 'a':
			printf("Write\n");
			// Datei öffnen
			FILE* outFileWrite = fopen(filename, "w");
			if (outFileWrite == NULL) {
				
				printf("Fehler beim Oeffnen der Datei zum Schreiben.\n");
				return;
				
			}
			// Vektor in Datei schreiben
			fprintf(outFileWrite, "Vektor %s: [%.5f %.5f]\n", resultVector.name, resultVector.x, resultVector.y);
			fclose(outFileWrite);
			printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
			break;
		case 'b':
			printf("Append\n");
			// Datei öffnen
			FILE* outFileAppend = fopen(filename, "a");
			if (outFileAppend == NULL) {
				
				printf("Fehler beim Oeffnen der Datei zum Schreiben.\n");
				return;
				
			}
			// Vektor in Datei schreiben
			fprintf(outFileAppend, "Vektor %s: [%.5f %.5f]\n", resultVector.name, resultVector.x, resultVector.y);
			fclose(outFileAppend);
			printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
			break;
		case 'c':
            printf("Back to the SubMenu.\n");
            break;
        default:
            printf("Invalid choice. Please try again.\n");
            break; 
	}
}

// Create new Matrix
void createMatrix2D(char *destFile) {
	int rows, cols;
	printf("Geben Sie die Anzahl der Zeilen und Spalten der Matrix ein: ");
    scanf("%d %d", &rows, &cols);
	getchar();
	Matrix2x2 newTemp = createMatrix(rows, cols);
	writeMatrixToFile(newTemp, destFile);

}

void transformVectToPoint(char *sourceFile){
	//File öffnen
	FILE* file = fopen(sourceFile, "r");
    if (file == NULL) {
		
        printf("Fehler beim Oeffnen der Datei.\n");
    }
	//Auswahl der Anzahl von Vektoren 
	int numVectors = 0;
	int numbersOfVectors;
	printf("Geben Sie die Menge an Vektoren an die geladen werden sollen.\n");
	scanf("%d", &numbersOfVectors);
	getchar();
	Vector2D vectors[numbersOfVectors];
	Point2D *pointArray = malloc(numbersOfVectors * sizeof(Point2D));
	for(int i = 0; i < numbersOfVectors; i++) {
		//Nach Namen filtern
		char searchingVecName[MAX_NAME_LENGHT];
		printf("Geben Sie den gesuchten Vector Namen ein: ");
		fgets(searchingVecName, sizeof(searchingVecName), stdin);
		if (searchingVecName[strlen(searchingVecName) - 1] == '\n') {
		
			searchingVecName[strlen(searchingVecName) - 1] = '\0';
		
		}
		//Vektor aus Datei laden und temporär speichern
		char line[200];
		Vector2D temp;
		while (fgets(line, sizeof(line), file) != NULL) {
		
			if (strstr(line, "Vektor") != NULL) {
			
				sscanf(line, "Vektor %[^:]:[%f %f]", vectors[numVectors].name, &vectors[numVectors].x, &vectors[numVectors].y);
				
				if (strcmp(searchingVecName, vectors[numVectors].name) == 0) {
					
					printf("Vektor %s: [%.5f %.5f]\n", vectors[numVectors].name, vectors[numVectors].x, vectors[numVectors].y);
					temp = createVector2D();
					strcpy(temp.name, vectors[numVectors].name);
					temp.x = vectors[numVectors].x;
					temp.y = vectors[numVectors].y;
					Point2D temp = createPoint2D(vectors[numVectors].x, vectors[numVectors].y);
					pointArray[numbersOfVectors] = temp;
					break;
					
				}
			}
		}
		numVectors++;
	}
	// Dateinamen eingeben
    char filename[MAX_NAME_LENGHT];
    printf("Geben Sie den Dateinamen zum Speichern ein: ");
    fgets(filename, sizeof(filename), stdin);
    if (filename[strlen(filename) - 1] == '\n') {
		
        filename[strlen(filename) - 1] = '\0';
		
    }
    // Überprüfen der Dateiendung
    char* extension = strrchr(filename, '.');
    if (extension == NULL || strcmp(extension, ".txt") != 0) {
		
        printf("Invalid file extension. Only .txt files are supported.\n");
        return;
		
    }
	// Other operations
	char switchChar;
	printf("Which options do you want to execute? 'a' = write, 'b' = append, 'c' = abort.\n");
	scanf("%c", &switchChar);
	switch(switchChar) {
		case 'a':
			printf("Write\n");
			// Datei öffnen
			FILE* outFileWrite = fopen(filename, "w");
			if (outFileWrite == NULL) {
				
				printf("Error opening the file to write.\n");
				return;
				
			}
			// Vektor in Datei schreiben
			fprintf(outFileWrite, "Punkt %d: x = %.2f, y = %.2f\n", numbersOfVectors+1, pointArray[numbersOfVectors].x, pointArray[numbersOfVectors].y);
			fclose(outFileWrite);
			printf("Data was successfully written to the file.\n");
			free(pointArray);
			break;
		case 'b':
			printf("Append\n");
			// Datei öffnen
			FILE* outFileAppend = fopen(filename, "a");
			if (outFileAppend == NULL) {
				
				printf("Error opening the file to write.\n");
				return;
				
			}
			// Write vec into data
			fprintf(outFileAppend, "Punkt %d: x = %.2f, y = %.2f\n", numbersOfVectors+1, pointArray[numbersOfVectors].x, pointArray[numbersOfVectors].y);
			fclose(outFileAppend);
			printf("Data was successfully written to the file.\n");
			free(pointArray);
			break;
		case 'c':
            printf("Back to the SubMenu.\n");
            break;
        default:
            printf("Invalid choice. Please try again.\n");
            break; 
	}
}

// --------------------------- //
// Other Functions Menu Beginn //
// --------------------------- //

long getFileSize(char *filename) {
    FILE* file = fopen(filename, "r+");
    if (file == NULL) {
        printf("Fehler beim Oeffnen der Datei.\n");
        return -1; // Fehlerwert zurückgeben
    }
    fseek(file, 0, SEEK_END); // Den Dateizeiger ans Ende der Datei setzen
    long fileSize = ftell(file); // Die aktuelle Position des Dateizeigers abrufen (entspricht der Dateigröße)
    fclose(file); // Die Datei schließen
    return fileSize;
}


void copyLines(char *sourceFile, char *tempFile, int lineNumber) {
	//FILE* sourceFile = fopen("source.txt", "r");
    //FILE* tempFile = fopen("temp.txt", "w");
	FILE* sourceFile1 = fopen(sourceFile, "r+");
    if (sourceFile1 == NULL) {
		
        printf("Fehler beim Oeffnen der Datei.\n");
        
    }
	FILE* tempFile2 = fopen(tempFile, "w+");
    if (tempFile2 == NULL) {
		
        printf("Fehler beim Oeffnen der Datei.\n");
        
    }
    printf("Geben Sie die Zeilennummer ein, die kopiert werden soll: ");
    scanf("%d", &lineNumber);
    char line[MAX_NAME_LENGHT];
    int currentLine = 1;
    // Zeilen aus der Quelldatei lesen und überprüfen
    while (fgets(line, sizeof(line), sourceFile1) != NULL) {
		
        // Überprüfen, ob die aktuelle Zeile die gewünschte Zeilennummer hat
        if (currentLine == lineNumber) {
			
            // Zeile in die temporäre Datei schreiben
            fputs(line, tempFile2);
            break;  // Die gewünschte Zeile wurde gefunden und kopiert, Schleife beenden
			
        }
        currentLine++;
    }
	//copyLines(sourceFile1, tempFile2, lineNumber);
    printf("Die Zeile wurde erfolgreich kopiert.\n");
    fclose(sourceFile1);
    fclose(tempFile2);
	remove(sourceFile);
	//Die temporäre Datei umbenennen, um die ursprüngliche Datei zu ersetzen
	rename(tempFile, sourceFile);
}

// ------------------------ //
// Linear Algebra Functions //
// ------------------------ //
// Function for Calculate Vec with Matrix //
void calculateVecMat(char *sourceFileVector, char *sourceFileMatrix) {
	Matrix2x2 tempMat = createMatrix(2, 2);
	Vector2D tempVec = createVector2D();
	Matrix2x2 result; 
	//Load or create new? (Vector2D) Optionsmenu
	char switchChar;
	printf("Which options do you want to execute? 'a' = load, 'b' = create, 'c' = abort.\n");
	scanf("%c", &switchChar);
	switch(switchChar) {
		case 'a':
			printf("Load Vector2D...\n");
			// Open file
			FILE* outFileRead = fopen(sourceFileVector, "r");
			if (outFileRead == NULL) {
				
				printf("Error opening the file to write.\n");
				return;
				
			}
			// Muss noch implementiert werden
			
			break;
		case 'b':
			printf("Create Vector2D...\n");
			// Create new Vector2D
			float x, y;
			printf("Please choose your Values for Vector\n");
			scanf("%f", &x);
			getchar();
			scanf("%f", &y);
			getchar();
			
			tempVec.x = x;
			tempVec.y = y;
			 // Dateinamen eingeben
			char filename[MAX_NAME_LENGHT];
			printf("Geben Sie den Dateinamen zum Speichern ein: ");
			fgets(filename, sizeof(filename), stdin);
			if (filename[strlen(filename) - 1] == '\n') {
		
				filename[strlen(filename) - 1] = '\0';
		
			}
			// Überprüfen der Dateiendung
			char* extension = strrchr(filename, '.');
			if (extension == NULL || strcmp(extension, ".txt") != 0) {
		
				printf("Ungueltige Dateiendung. Es werden nur .txt-Dateien unterstuetzt.\n");
				return;
		
			}
			printf("Write.\n");
			// Datei öffnen
			FILE* outFileWrite = fopen(filename, "w");
			if (outFileWrite == NULL) {
				
				printf("Fehler beim Oeffnen der Datei zum Schreiben.\n");
				return;
				
			}
			// Vektor in Datei schreiben
			fprintf(outFileWrite, "Vektor %s: [%.5f %.5f]\n", tempVec.name, tempVec.x, tempVec.y);
			// Datei schließen
			printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
			fclose(outFileWrite);
			break;
		case 'c':
            printf("Back to the SubMenu.\n");
            break;
        default:
            printf("Invalid choice. Please try again.\n");
            break; 
	}
	//Load or create new2 (Matrix2x2) Optionsmenu
	getchar();
	printf("Which options do you want to execute? 'a' = load, 'b' = create, 'c' = abort.\n");
	scanf("%c", &switchChar);
	switch(switchChar) {
		case 'a':
			/*
			printf("Load Matrix2x2...\n");
			// Open file
			FILE* outFileWrite = fopen(sourceFileMatrix, "r");
			if (outFileWrite == NULL) {
				
				printf("Error opening the file to write.\n");
				return;
				
			}
			// Muss noch implementiert werden
			
			//
			break;
			*/
		case 'b':
			// Create new Matrix2x2
			printf("Create Matrix2x2...\n");
			
			for(int i = 0; i < tempMat.rows; i++) {
				for(int j = 0; j < tempMat.cols; j++) {
					printf("Choose you Values\n");
					scanf("%f", &tempMat.data[i][j]);
				}
			}
			
			result = addCalculate(tempVec, tempMat);
			printMatrix(result);
			break;
		case 'c':
            printf("Back to the SubMenu.\n");
            return;
        default:
            printf("Invalid choice. Please try again.\n");
            break; 
	}
	// Type the filename
    char filename[MAX_NAME_LENGHT];
    printf("Specify the name of data for save: ");
    fgets(filename, sizeof(filename), stdin);
    if (filename[strlen(filename) - 1] == '\n') {
		
        filename[strlen(filename) - 1] = '\0';
		
    }
    // Check the File extension
    char* extension = strrchr(filename, '.');
    if (extension == NULL || strcmp(extension, ".txt") != 0) {
		
        printf("Invalid file extension. Only '.txt' files are supported.\n");
        return;
		
    }
	writeMatrixToFile(result, filename);
}


Matrix2x2 addCalculate(Vector2D vec, Matrix2x2 mat) {

	Matrix2x2 result;
	/*
	
	*/
	for(int i = 0; i < mat.rows; i++) {
		
		for(int j = 0; j < mat.cols; j++) {
			
				result.data[i][j] = mat.data[i][j] + vec.x + vec.y;
				
		}
	}
	return result;
	
}

// Function for Addition of Matrix
Matrix2x2 addMatrix(Matrix2x2 mat1, Matrix2x2 mat2) {
	
	Matrix2x2 result;
	for(int i = 0; i < mat1.rows; i++) {
		
		for(int j = 0; j < mat2.cols; j++) {
			
				result.data[i][j] = mat1.data[i][j] + mat2.data[i][j];
				
		}
	}
	return result;	
		
}


Matrix2x2 skalMultMatrix(float skalar, Matrix2x2 mat) {
	
	Matrix2x2 result; 
	for(int i = 0; i < mat.rows; i++) {
		
		for(int j = 0; i < mat.cols; j++) {
			
				result.data[i][j] = skalar * mat.data[i][j];
				
		}
	}
	return result;
}


Matrix2x2 multMatrix(Matrix2x2 mat1, Matrix2x2 mat2) {
	
	Matrix2x2 result; 
	// check for compality
	if(mat1.rows != mat2.cols) {
		
		printf("Not Compatibly. Calculate not possible\n");
		
	}
	for(int i = 0; i < mat1.rows; i++) {
		
		for(int j = 0; i < mat2.cols; j++) {
		
			result.data[i][j] = 0;
			for(int k = 0; k < mat1.cols; k++) {
			
				result.data[i][j] += mat1.data[i][j] * mat2.data[i][j];	
			
			}
		}
		
	
	}
	return result;
}

// Function for Print Matrix2x2 //
void printMatrix(Matrix2x2 mat) {
	
	printf("[");
    for (int i = 0; i < mat.rows; i++) {
		
		printf("[\n");
        for (int j = 0; j < mat.cols; j++) {
            printf("%5.5f ", mat.data[i][j]);
			if(i < mat.cols){
				
				printf("\t ");
				
			}
        } 
        printf("]\n");
    }
	printf("]\n");
	
}

// -------------------- //
// HELPING SUBFUNCTIONS //
// -------------------- //
// Function for write Matrix in File
void writeMatrixToFile(Matrix2x2 mat, char* destFile) {
	
	// Open File for write
    FILE* file = fopen(destFile, "w");
    if (file == NULL) {
		
        printf("Fehler beim Öffnen der Datei.\n");
        return;
		
    }
    // Write
    //fprintf(file, "%d %d\n", mat.rows, mat.cols);
	//fprintf(outFileWrite, "Vektor %s: [%.5f %.5f]\n", resultVector.name, resultVector.x, resultVector.y);
	fprintf(file, "Matrix2D %s: [", mat.name);
    for (int i = 0; i < mat.rows; i++) {
		
		fprintf(file, "[");
        for (int j = 0; j < mat.cols; j++) {
			
            fprintf(file, "%5.5f ", mat.data[i][j]);
			if(i < mat.cols){
				
				fprintf(file, "\t ");
				
			}
        }
        fprintf(file, "]");
		
    }
	fprintf(file, "]\n");
    fclose(file);
	printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
	
	
	/*
	// NOCH ZU ÄNDERN
	// Dateinamen eingeben
    char filename[MAX_NAME_LENGHT];
    printf("Geben Sie den Dateinamen zum Speichern ein: ");
    fgets(filename, sizeof(filename), stdin);
    if (filename[strlen(filename) - 1] == '\n') {
		
        filename[strlen(filename) - 1] = '\0';
		
    }
    // Überprüfen der Dateiendung
    char* extension = strrchr(filename, '.');
    if (extension == NULL || strcmp(extension, ".txt") != 0) {
		
        printf("Ungueltige Dateiendung. Es werden nur .txt-Dateien unterstuetzt.\n");
        return;
		
    }
	// Other operations
	char switchChar;
	printf("Welche Optionen moechten Sie ausfuehren? 'a' = write, 'b' = append, 'c' = abort.\n");
	scanf("%c", &switchChar);
	switch(switchChar) {
		case 'a':
			printf("Write\n");
			// Datei öffnen
			FILE* outFileWrite = fopen(filename, "w");
			if (outFileWrite == NULL) {
				
				printf("Fehler beim Oeffnen der Datei zum Schreiben.\n");
				return;
				
			}
			// Vektor in Datei schreiben
			fprintf(outFileWrite, "Vektor %s: [%.5f %.5f]\n", resultVector.name, resultVector.x, resultVector.y);
			// Datei schließen
			fclose(outFileWrite);
			printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
			break;
		case 'b':
			printf("Append\n");
			// Datei öffnen
			FILE* outFileAppend = fopen(filename, "a");
			if (outFileAppend == NULL) {
				
				printf("Fehler beim Oeffnen der Datei zum Schreiben.\n");
				return;
				
			}
			// Vektor in Datei schreiben
			fprintf(outFileAppend, "Vektor %s: [%.5f %.5f]\n", resultVector.name, resultVector.x, resultVector.y);
			// Datei schließen
			fclose(outFileAppend);
			printf("Daten wurden erfolgreich in die Datei geschrieben.\n");
			break;
		case 'c':
            printf("Back to the SubMenu.\n");
            break;
        default:
            printf("Invalid choice. Please try again.\n");
            break; 
	}
	
	*/
}

// ------------------- //
// Geometric Functions //
// ------------------- //
// rectangle Area (RechteckFläche)
float calculateRectangleArea(float width, float height) {

    float area = width * height;
    return area;
	
}

// circle perimeter (Kreis Umfang)
float calculateCirclePerimeter(float radius) {

    float perimeter = 2 * 3.14159 * radius;
    return perimeter;
	
}

// calculate distance between two Points
float calculateDistance(float x1, float y1, float x2, float y2) {

    float distance = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    return distance;
	
}


float calculateSphereVolume(float radius) {

    float volume = (4.0 / 3.0) * 3.14159 * pow(radius, 3);
    return volume;
	
}


float calculateHypotenuse(float a, float b) {

    float hypotenuse = sqrt(pow(a, 2) + pow(b, 2));
    return hypotenuse;
	
}

// ----------------------- //
// Trigonometric Functions //
// ----------------------- //

float calculateSin(float angleInRadians) {

    float sinValue = sin(angleInRadians);
    return sinValue;
	
}


float calculateCos(float angleInRadians) {

    float cosValue = cos(angleInRadians);
    return cosValue;
	
}


float calculateTan(float angleInRadians) {

    float tanValue = tan(angleInRadians);
    return tanValue;
	
}


float convertDegreesToRadians(float degrees) {	
	
    float radians = degrees * (3.14159 / 180.0);
    return radians;
	
}

// ---------------- //
// Linear Functions //
// ---------------- //
// Funktion zum Erstellen einer linearen Funktion
LinearFunction createLinearFunction(float slope, float intercept) {

    LinearFunction function;
    function.slope = slope;
    function.intercept = intercept;
    return function;
}

// Funktion zum Berechnen des Funktionswerts einer linearen Funktion an einer bestimmten x-Koordinate
float calculateLinearFunctionValue(LinearFunction function, float x) {		
	
    float y = function.slope * x + function.intercept;
    return y;
}

// Funktion zum Ausdrucken einer linearen Funktion
void printLinearFunction(LinearFunction function) {	
	
    printf("f(x) = %.2fx + %.2f\n", function.slope, function.intercept);
	
}

// ------------------- //
// Quadratic Functions //
// ------------------- //
// Funktion zum Erstellen einer quadratischen Funktion
QuadraticFunction createQuadraticFunction(float a, float b, float c) {

    QuadraticFunction function;
    function.a = a;
    function.b = b;
    function.c = c;
    return function;
	
}

// Funktion zum Berechnen des Funktionswerts einer quadratischen Funktion an einer bestimmten x-Koordinate
float calculateQuadraticFunctionValue(QuadraticFunction function, float x) {
	
    float y = function.a * pow(x, 2) + function.b * x + function.c;
    return y;
}

// Funktion zum Ausdrucken einer quadratischen Funktion
void printQuadraticFunction(QuadraticFunction function) {
	
    printf("f(x) = %.2fx^2 + %.2fx + %.2f\n", function.a, function.b, function.c);
	
}

// --------------- //
// Cubic Functions //
// --------------- //
// Funktion zum Erstellen einer kubischen Funktion
CubicFunction createCubicFunction(float a, float b, float c, float d) {

    CubicFunction function;
    function.a = a;
    function.b = b;
    function.c = c;
    function.d = d;
    return function;
	
}

// Funktion zum Berechnen des Funktionswerts einer kubischen Funktion an einer bestimmten x-Koordinate
float calculateCubicFunctionValue(CubicFunction function, float x) {
	
    float y = function.a * pow(x, 3) + function.b * pow(x, 2) + function.c * x + function.d;
    return y;
	
}

// Funktion zum Ausdrucken einer kubischen Funktion
void printCubicFunction(CubicFunction function) {
	
    printf("f(x) = %.2fx^3 + %.2fx^2 + %.2fx + %.2f\n", function.a, function.b, function.c, function.d);
	
}

// ---------------------------- //
// Functions Implementation END //
// ---------------------------- //

// ------------------------------ //
// Müssen noch implentiert werden //
// ------------------------------ //
/*
int delete_head(Polygon *head){
	if(*head == NULL){
		return -1;
	}
	else {
		Polygon temp = *head;			//Speichern des ersten Elements -- Kopiert *pzptr -> POLYGON old
		*head = temp->next;				//Aktualisieren des Zeigers auf das nächste Element
		free(temp);
		return 0;
	}
}

int shorten(Polygon *ptr){
	if(*ptr == NULL){
		return -1;
	}
	
	Le *tmp = *ptr;
	if(tmp->next == NULL){
		free(tmp);
		*ptr = NULL;
		return 0;
	}
	Le *last;
	while(tmp->next != NULL){
		last = tmp;
		tmp = tmp->next;
	}
	free(tmp);
	last->next = NULL;
	return 0;
}
*/

// ----- //
// Reste //
// ----- //
/*
	//Nach Namen filtern
	char searchingPointName[MAX_NAME_LENGHT];
	printf("Geben Sie den gesuchten Punkt Namen ein: ");
	fgets(searchingPointName, sizeof(searchingPointName), stdin);
	if (searchingPointName[strlen(searchingPointName) - 1] == '\n') {
		
		searchingPointName[strlen(searchingPointName) - 1] = '\0';
		
	}
	// Filtern des gesuchten PunktIndex
	int pointIndexToEdit;  // Index des dritten Punkts
	printf("Welcher Index aus den zuvorgewaehlten Vector?\n");
	scanf("%d", &pointIndexToEdit);
	getchar();
		
	append2DPointToPolygon(Polygon2D *head, Point2D *pointArray, int countOfPoints)
	append2DPointToPolygon(Polygon2D *temphead, int position, Point2D *tempPointArray, int countOfPoints);
	
	float pointArray[2];
	int numPoints = 0;
	char line[100];
	while (fgets(line, sizeof(line), file) != NULL) {
		if (strstr(line, "Punkt") != NULL) {
			int pointNumber;
			float x, y;
			sscanf(line, "Punkt %d: x = %f, y = %f", &pointNumber, &x, &y);
			if (pointNumber == arrayIndexToEdit && numPoints == pointIndexToEdit) {
				pointArray[0] = x;
				pointArray[1] = y;
				break;
			}
			numPoints++;
		}
	}

    if ((strcmp(searchingPointName, name) == 0) && pointIndex == pointIndexToEdit) {
		printf("Ausgewählter Punkt %s: x = %5.5f, y = %5.5f\n", name, x, y);
         pointArray[pointIndex] = createPoint2D(x, y);
        //strcpy(pointArray[pointIndex].name, temp.name);
		pointIndex++;
                    
        break;
    }
     
	int countOfPoints;
	int pointIndex = 0;
	printf("Geben Sie die Anzahl der zu ladenden Punkte an:\n");
	scanf("%d", &countOfPoints);
	getchar();

	Point2D *pointArray = malloc(countOfPoints * sizeof(Point2D));

	for (int i = 0; i < countOfPoints; i++) {
		// Nach Namen filtern
		char searchingPointName[MAX_NAME_LENGTH];
		printf("Geben Sie den Namen des gesuchten Punkts ein: ");
		fgets(searchingPointName, sizeof(searchingPointName), stdin);
		if (searchingPointName[strlen(searchingPointName) - 1] == '\n') {
			searchingPointName[strlen(searchingPointName) - 1] = '\0';
		}

		// Filtern des gewünschten Punkts
		int pointIndexToEdit;
		printf("Welcher Index aus den zuvor gewählten Punkten soll bearbeitet werden?\n");
		scanf("%d", &pointIndexToEdit);
		getchar();

		char line[100];

		while (fgets(line, sizeof(line), file) != NULL) {
			if (strstr(line, "Punkt") != NULL) {
				char name[MAX_NAME_LENGTH];
				float x, y;
				sscanf(line, "Punkt %[^:]:x = %f, y = %f", name, &x, &y);
				printf("Ausgewählter Punkt %s: x = %5.5f, y = %5.5f\n", name, x, y);

				if ((strcmp(searchingPointName, name) == 0) && pointIndex == pointIndexToEdit) {
					Point2D temp = createPoint2D(x, y);
					strcpy(temp.name, name);
					pointArray[pointIndex] = temp;
					break;
				}
			}
		}

		pointIndex++;
	}

	// Weitere Verarbeitung des pointArray (z. B. Anlegen eines Polygons)...
	int numbersOfVectors;
	int numVectors = 0;
	printf("Geben Sie die Menge an Vektoren an die geladen werden sollen.\n");
	scanf("%d", &numbersOfVectors);
	getchar();
	Vector2D vectors[numbersOfVectors];
	Point2D *pointArray = malloc(numbersOfVectors * sizeof(Point2D));
	for(int i = 0; i < numbersOfVectors; i++) {
		//Nach Namen filtern
		char searchingVecName[MAX_NAME_LENGHT];
		printf("Geben Sie den gesuchten Vector Namen ein: ");
		fgets(searchingVecName, sizeof(searchingVecName), stdin);
		if (searchingVecName[strlen(searchingVecName) - 1] == '\n') {
		
			searchingVecName[strlen(searchingVecName) - 1] = '\0';
		
		}
		//Vektor aus Datei laden und temporär speichern
		char line[200];
		Vector2D temp;
		while (fgets(line, sizeof(line), file) != NULL) {
		
			if (strstr(line, "Vektor") != NULL) {
			
				sscanf(line, "Vektor %[^:]:[%f %f]", vectors[numVectors].name, &vectors[numVectors].x, &vectors[numVectors].y);
				printf("Vektor %s: [%.5f %.5f]\n", vectors[numVectors].name, vectors[numVectors].x, vectors[numVectors].y);
			
				if (strcmp(searchingVecName, vectors[numVectors].name) == 0) {
					
					temp = createVector2D();
					strcpy(temp.name, vectors[numVectors].name);
					temp.x = vectors[numVectors].x;
					temp.y = vectors[numVectors].y;
					Point2D temp = createPoint2D(vectors[numVectors].x, vectors[numVectors].y);
					pointArray[numbersOfVectors] = temp;
					break;
				
				}
			}
		}
		numVectors++;
	}
*/	
