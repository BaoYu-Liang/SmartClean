Funcion estado <- ClasificarNivel(nivel)
    Definir estado Como Cadena
	
    Si nivel < 25 Entonces
        estado <- "BAJO"
    Sino
        Si nivel < 50 Entonces
            estado <- "MEDIO"
        Sino
            Si nivel < 75 Entonces
                estado <- "ALTO"
            Sino
                estado <- "REQUIERE RECOLECCION"
            FinSi
        FinSi
    FinSi
FinFuncion


SubProceso MostrarEstado(nivel)
    Escribir "Estado: ", ClasificarNivel(nivel)
FinSubProceso


Algoritmo SmartClean
	
    Definir niveles Como Real
    Definir historial Como Real
    Definir opcion, i, j, numero, ronda Como Entero
    Definir contador, bajo, medio, alto, recoleccion Como Entero
    Definir suma, promedio, porcentaje Como Real
	
    Dimension niveles[5]
    Dimension historial[100,5]
	
    ronda <- 0
	
    // INICIALIZAR LOS CONTENEDORES
    Para i <- 1 Hasta 5 Hacer
        niveles[i] <- 0
    FinPara
	
    // MENU PRINCIPAL
    Repetir
		
        Escribir ""
        Escribir "          SISTEMA SMARTCLEAN"
        Escribir "     MONITOREO DE CONTENEDORES"
        Escribir "1. Registrar niveles de llenado"
        Escribir "2. Consultar un contenedor"
        Escribir "3. Mostrar estado de contenedores"
        Escribir "4. Identificar recoleccion"
        Escribir "5. Mostrar historial"
        Escribir "6. Mostrar estadisticas"
        Escribir "7. Salir"
        Escribir "Seleccione una opcion:"
        Leer opcion
		
        Segun opcion Hacer
			
            1:
                Si ronda < 100 Entonces
					
                    ronda <- ronda + 1
					
                    Para i <- 1 Hasta 5 Hacer
						
                        Escribir "Ingrese el porcentaje del contenedor ", i
                        Leer porcentaje
						
                        Mientras porcentaje < 0 O porcentaje > 100 Hacer
                            Escribir "Valor incorrecto. Ingrese un valor entre 0 y 100:"
                            Leer porcentaje
                        FinMientras
						
                        niveles[i] <- porcentaje
                        historial[ronda,i] <- porcentaje
						
                    FinPara
					
                    Escribir "Registro guardado correctamente."
					
                Sino
                    Escribir "Se alcanzo el limite de registros."
                FinSi
				
            2:
                Escribir "Ingrese el numero del contenedor (1-5):"
                Leer numero
				
                Si numero >= 1 Y numero <= 5 Entonces
					
                    Escribir "Contenedor: ", numero
                    Escribir "Nivel de llenado: ", niveles[numero], "%"
					
                    MostrarEstado(niveles[numero])
					
                Sino
                    Escribir "Numero de contenedor no valido."
                FinSi
				
            3:
                Escribir "======= ESTADO DE CONTENEDORES ======="
				
                Para i <- 1 Hasta 5 Hacer
					
                    Escribir "Contenedor ", i, ": ", niveles[i], "%"
					
                    MostrarEstado(niveles[i])
					
                FinPara
				
            4:
                contador <- 0
				
                Escribir "=== CONTENEDORES PARA RECOLECCION ==="
				
                Para i <- 1 Hasta 5 Hacer
					
                    Si niveles[i] >= 75 Entonces
                        Escribir "Contenedor ", i, " requiere recoleccion."
                        contador <- contador + 1
                    FinSi
					
                FinPara
				
                Si contador = 0 Entonces
                    Escribir "No hay contenedores pendientes de recoleccion."
                Sino
                    Escribir "Total de contenedores pendientes: ", contador
                FinSi
				
            5:
                Si ronda = 0 Entonces
                    Escribir "Todavia no existen registros."
                Sino
					
                    Para i <- 1 Hasta ronda Hacer
						
                        Escribir "Registro numero ", i
						
                        Para j <- 1 Hasta 5 Hacer
                            Escribir "Contenedor ", j, ": ", historial[i,j], "%"
                        FinPara
						
                    FinPara
					
                FinSi
				
            6:
                bajo <- 0
                medio <- 0
                alto <- 0
                recoleccion <- 0
                suma <- 0
				
                Para i <- 1 Hasta 5 Hacer
					
                    suma <- suma + niveles[i]
					
                    Si niveles[i] < 25 Entonces
                        bajo <- bajo + 1
                    Sino
                        Si niveles[i] < 50 Entonces
                            medio <- medio + 1
                        Sino
                            Si niveles[i] < 75 Entonces
                                alto <- alto + 1
                            Sino
                                recoleccion <- recoleccion + 1
                            FinSi
                        FinSi
                    FinSi
					
                FinPara
				
                promedio <- suma / 5
				
                Escribir "======= ESTADISTICAS ======="
                Escribir "Promedio de llenado: ", promedio, "%"
                Escribir "Nivel bajo: ", bajo
                Escribir "Nivel medio: ", medio
                Escribir "Nivel alto: ", alto
                Escribir "Requieren recoleccion: ", recoleccion
				
                // ESTRUCTURA SEGUN
                Segun recoleccion Hacer
                    0:
                        Escribir "Prioridad: NORMAL"
                    1, 2:
                        Escribir "Prioridad: MEDIA"
                    3, 4, 5:
                        Escribir "Prioridad: ALTA"
                FinSegun
				
            7:
                Escribir "Gracias por utilizar SMARTCLEAN."
                Escribir "Sistema finalizado."
				
            De Otro Modo:
                Escribir "Opcion incorrecta. Intente nuevamente."
				
        FinSegun
		
    Hasta Que opcion = 7
	
FinAlgoritmo
