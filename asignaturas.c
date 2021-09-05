#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//Definimos las estructuras
typedef struct Fecha
{
    int dia;
    int hora;
    int minuto;
} Fecha;

//NODO
typedef struct Asignatura
{
    char nombreAsignatura[50];
    struct Fecha *horarioEntrada;
    struct Fecha *horarioSalida;
    struct Asignatura *next;
} Asignatura;

void print_ll(Asignatura *head);
Asignatura *createAsignatura();
void FillAsignatura(Asignatura *newAsignatura, int diaEntrada, int horaEntrada, int minEntrada, int diaSalida, int horaSalida, int minSalida);
void ASortList(Asignatura **head, Asignatura *newAsignatura);
void DSortList(Asignatura **head, Asignatura *newAsignatura);
void printAsignatura(Asignatura *asignatura);

int main()
{
    Asignatura *listaMateriasA; //cabeza vacia

    //Primera materia

    Asignatura *POO_Dos = createAsignatura();
    strcpy(POO_Dos->nombreAsignatura, "POO");
    FillAsignatura(POO_Dos, 3, 11, 0, 3, 12, 30);
    ASortList(&listaMateriasA, POO_Dos);
    //printAsignatura(POO_Dos);

    Asignatura *POO_Uno = createAsignatura();
    strcpy(POO_Uno->nombreAsignatura, "POO");
    FillAsignatura(POO_Uno, 2, 10, 30, 2, 12, 0);
    ASortList(&listaMateriasA, POO_Uno);

    Asignatura *POO_tres = createAsignatura();
    strcpy(POO_tres->nombreAsignatura, "POO");
    FillAsignatura(POO_tres, 5, 12, 0, 5, 1, 30);
    //printAsignatura(POO_tres);
    ASortList(&listaMateriasA, POO_tres);

    // se manda solo la cabeza
    print_ll(listaMateriasA);

    printf("------------------------------------------------------");

    Asignatura *listaMateriasD;

    Asignatura *POO_dos_D = createAsignatura();
    strcpy(POO_dos_D->nombreAsignatura, "POO");
    FillAsignatura(POO_dos_D, 3, 11, 0, 3, 12, 30);
    DSortList(&listaMateriasD, POO_dos_D);
    //printAsignatura(POO_dos_D);

    Asignatura *POO_uno_D = createAsignatura();
    strcpy(POO_uno_D->nombreAsignatura, "POO");
    FillAsignatura(POO_uno_D, 2, 10, 30, 2, 12, 0);
    DSortList(&listaMateriasD, POO_uno_D);

    Asignatura *POO_tres_D = createAsignatura();
    strcpy(POO_tres_D->nombreAsignatura, "POO");
    FillAsignatura(POO_tres_D, 5, 12, 0, 5, 1, 30);
    //printAsignatura(POO_tres_D);
    DSortList(&listaMateriasD, POO_tres_D);

    //se manda solo la cabeza
    print_ll(listaMateriasD);

    return 0;
}

void printAsignatura(Asignatura *asignatura)
{
    printf("%s: \n El dia %d de la semana: \n De %d:%d a %d:%d\n\n", asignatura->nombreAsignatura, asignatura->horarioEntrada->dia, asignatura->horarioEntrada->hora, asignatura->horarioEntrada->minuto, asignatura->horarioSalida->hora, asignatura->horarioSalida->minuto);
}

void print_ll(Asignatura *head)
{
    printAsignatura(head);
    Asignatura *current = head;
    while (current->next != NULL)
    {
        current = current->next;
        printAsignatura(current);
    }
}

Asignatura *createAsignatura()
{
    Asignatura *newAsignatura = (Asignatura *)malloc(sizeof(Asignatura));
    newAsignatura->next = NULL;
    return newAsignatura;
}

void FillAsignatura(Asignatura *newAsignatura, int diaEntrada, int horaEntrada, int minEntrada, int diaSalida, int horaSalida, int minSalida)
{
    //newAsignatura->nombreAsignatura = nombreAsignatura;

    //Creamos el horario
    //Entrada
    Fecha *nuevoHorarioEntrada = (Fecha *)malloc(sizeof(Fecha));
    nuevoHorarioEntrada->dia = diaEntrada;
    nuevoHorarioEntrada->hora = horaEntrada;
    nuevoHorarioEntrada->minuto = minEntrada;

    newAsignatura->horarioEntrada = nuevoHorarioEntrada;

    //Salida
    Fecha *nuevoHorarioSalida = (Fecha *)malloc(sizeof(Fecha));
    nuevoHorarioSalida->dia = diaSalida;
    nuevoHorarioSalida->hora = horaSalida;
    nuevoHorarioSalida->minuto = minSalida;

    newAsignatura->horarioSalida = nuevoHorarioSalida;
}

void ASortList(Asignatura **head, Asignatura *newAsignatura) //Ascendente
{
    //Asignatura *current = head;
    Asignatura *aux;

    if ((*head) == NULL)
    {
        (*head) = newAsignatura; //para hacer referencia al primer puntero
        (*head)->next = NULL;
    }
    else
    {
        if ((*head)->horarioEntrada->dia > newAsignatura->horarioEntrada->dia)
        {
            newAsignatura->next = (*head);
            (*head) = newAsignatura;
        }
        else
        {
            aux = (*head);
            while ((aux->next != NULL) && (aux->next->horarioEntrada->dia <= newAsignatura->horarioEntrada->dia))
            {
                aux = aux->next;
            }
            newAsignatura->next = aux->next;
            aux->next = newAsignatura;
        }
    }
}

void DSortList(Asignatura **head, Asignatura *newAsignatura) //Descendente
{
    //Asignatura *current = head;
    Asignatura *aux;

    if ((*head) == NULL)
    {
        (*head) = newAsignatura; //para hacer referencia al primer puntero
        (*head)->next = NULL;
    }
    else
    {
        if ((*head)->horarioEntrada->dia <= newAsignatura->horarioEntrada->dia)
        {
            newAsignatura->next = (*head);
            (*head) = newAsignatura;
        }
        else
        {
            aux = (*head);
            while ((aux->next != NULL) && (aux->next->horarioEntrada->dia > newAsignatura->horarioEntrada->dia))
            {
                aux = aux->next;
            }
            newAsignatura->next = aux->next;
            aux->next = newAsignatura;
        }
    }
}