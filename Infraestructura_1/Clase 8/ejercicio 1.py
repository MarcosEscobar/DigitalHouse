#encoding:UTF-8
import random
puntajeUsuario = 0
puntajePc = 0
puntajeTotal = 0

ganaUsuario = open('puntajeUsuario.txt', 'a+')
ganaPc = open('puntajePC.txt', 'a+')

try:
    puntajeUsuario = int(ganaUsuario.read())
    puntajePc = int(ganaPc.read())
except ValueError:
    puntajeUsuario = 0
    puntajePc = 0

def porcentaje():
    if puntajeTotal > 0:
        x = ((puntajeTotal - puntajePc) / puntajeTotal) * 100
        return x
    elif puntajeTotal == 0:
        x = 0
    return x

while True: 
    aleatorio = random.randrange(0, 4)
    elijePc = ""
    print("1)Piedra")
    print("2)Papel")
    print("3)Tijera")
    print("4)Lagarto")
    print("5)Spock")
    print("6)Mostrar Puntajes")
    print("7)Salir del Programa")

    try:
        opcion = int(input("Que eliges: "))
    except ValueError:
        print("Eso no es un número")
        continue
    
    if opcion == 1:
        eligeUsuario = "piedra"
    elif opcion == 2:
        eligeUsuario = "papel"
    elif opcion == 3:
        eligeUsuario = "tijera"
    elif opcion == 4:
        eligeUsuario = "Lagarto"
    elif opcion == 5:
        eligeUsuario = "Spock"
    elif opcion == 6:
        print("Puntajes: ")
        print("Usuario: ", puntajeUsuario)
        print("Pc: ", puntajePc)
        print("Porcentaje de victorias: ", porcentaje(), "%")
        continue
    elif opcion == 7:
        print ("Nos vemos!")
        break
    else:
        print ("Valor Invalido")
        continue
    
    print("Tu eliges: ", eligeUsuario)   
    if aleatorio == 0:
        eligePc = "piedra"
    elif aleatorio == 1:
        eligePc = "papel"
    elif aleatorio == 2:
        eligePc = "tijera"
    elif aleatorio == 3:
        eligePc = "Lagarto"
    elif aleatorio == 4:
        eligePc = "Spock"
    print("PC eligio: ", eligePc)
    print("...")
    #-----------------------------------------------------------Piedra

    if eligePc == "piedra" and eligeUsuario == "tijera":
        print("Perdiste, Piedra rompe tijeras")
        puntajePc = 1
    elif eligePc == "piedra" and eligeUsuario == "Lagarto":
        print("Perdiste, Piedra aplasta lagarto")
        puntajePc = 1
    elif eligePc == "piedra" and eligeUsuario == "Spock":
        print("Ganaste, Spock vaporiza piedra")
        puntajeUsuario = 1
    elif eligePc == "piedra" and eligeUsuario == "papel":
        print("Ganaste, Papel envuelve a piedra")
        puntajeUsuario = 1
    #---------------------------------------------------------- Papel
    elif eligePc == "papel" and eligeUsuario == "Spock":
        print("Perdiste, papel desautoriza a Spock")
        puntajePc = 1
    elif eligePc == "papel" and eligeUsuario == "piedra":
        print("Perdiste, Papel envuelve a piedra")
        puntajePc = 1
    elif eligePc == "papel" and eligeUsuario == "Lagarto":
        print("Ganaste, Lagarto se come al papel")
        puntajeUsuario = 1
    elif eligePc == "papel" and eligeUsuario == "tijera":
        print("Ganaste, tijera corta papel")
        puntajeUsuario = 1
    #-----------------------------------------------------------Tijera
    elif eligePc == "tijera" and eligeUsuario == "Lagarto":
        print("Perdiste, tijera decapita a lagarto")
        puntajePc = 1
    elif eligePc == "tijera" and eligeUsuario == "papel":
        print("Perdiste, Tijera corta papel")
        puntajePc = 1
    elif eligePc == "tijera" and eligeUsuario == "Spock":
        print("Ganaste, Spock rompe tijeras")
        puntajeUsuario = 1
    elif eligePc == "tijera" and eligeUsuario == "piedra":
        print("Ganaste, Piedra rompe tijeras")
        puntajeUsuario = 1
    #-----------------------------------------------------------Lagarto
    elif eligePc == "Lagarto" and eligeUsuario == "papel":
        print("Perdiste, Lagarto come papel")
        puntajePc = 1
    elif eligePc == "Lagarto" and eligeUsuario == "Spock":
        print("Perdiste, Lagarto envenena a Spock")
        puntajePc = 1
    elif eligePc == "Lagarto" and eligeUsuario == "piedra":
        print("Ganste, Piedra aplasta lagarto")
        puntajeUsuario = 1
    elif eligePc == "Lagarto" and eligeUsuario == "tijera":
        print("Ganaste, Tijera decapita a Lagarto")
        puntajeUsuario = 1
    #-----------------------------------------------------------Lagarto
    elif eligePc == "Spock" and eligeUsuario == "tijera":
        print("Perdiste, Spock rompe tijera")
        puntajePc = 1
    elif eligePc == "Spock" and eligeUsuario == "piedra":
        print("Perdiste, Spock vaporiza piedra")
        puntajePc = 1
    elif eligePc == "Spock" and eligeUsuario == "papel":
        print("Ganaste, Papel desautoriza a Spock")
        puntajeUsuario = 1
    elif eligePc == "Spock" and eligeUsuario == "Lagarto":
        print("Ganste, Lagarto envenena a Spock")
        puntajeUsuario = 1

    elif eligePc == eligeUsuario:
        print("Empate")
        puntajePc = 1
        puntajeUsuario = puntajeUsuario +1
    again = input("Jugamos de nuevo? Si/No: ")
    if 'si' in again:
        puntajeTotal = puntajeTotal + 1
        continue
    elif 'no' in again:
        print("Puntajes: ")
        print("Usuario: ", puntajeUsuario)
        print("Pc: ", puntajePc)
        print("Porcentaje de victorias: ", porcentaje(), "%")
        with open('./puntajeUsuario.txt', 'w') as f:
            f.write(str(puntajeUsuario))
        with open('./puntajePC.txt', 'w') as f:
            f.write(str(puntajePc))
        print("Nos vemos!")
        break
    else:
        print("Valor Invalido")
        

# Si el usuario ingresa un valor no valido pero que corresponde al tipo de valor esperado, el programa vuelve a empezar.
# Si el usuario ingresa un valor no valido y que no corresponda al tipo de valor esperado, python se detiene e informa el siguiente error: ValueError: invalid literal for int() with base 10: '2.3'. Para eso hicimos un handler. 
# Porque no se puede dividir por 0, si no estuviera, podría colapsar el programa.
# Hay varios métodos disponibles, pero para este caso guardamos los puntajes en un archivo txt. 