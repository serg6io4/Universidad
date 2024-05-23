print("#========================")
print("# PREGUNTA 3 (2,5 puntos)")
print("#========================")
# Enunciado
#----------
# Implementar el siguiente protocolo:
#
# - A: Mostrar por pantalla M
# - A: K_AT(M) = Cifrar_K_AT(M) 
# - A->T: K_AT(M) 
# - T: M = Descifrar_K_AT(K_AT(M))
# - T: K_BT(M) = Cifrar_K_BT(M) 
# - T->B: K_BT(M)
# - B: M = Descifrar_K_BT(K_BT(M))
# - B: Mostrar por pantalla M
#
# (cuya version simplificada siguiendo el formato de las transparencias es:
# - A->T: K_AT(M)
# - T->B: K_BT(M)
# )
#
# utilizando las claves DES "K_AT" y "K_BT", y el texto en claro "M" mostrado en el codigo fuente. 
# La clave K_AT se comparte entre A y T, y la clave K_BT se comparte entre B y T.
# El mensaje se cifra y descifra con el modo de operacion ECB de DES.
# El codigo para "transmitir" el mensaje se proporcionara en el codigo fuente de la practica.

# Ejercicio
#----------

M = "Este es el texto del tercer apartado (12/11/2018), formato string (cadena)"
K_AT = b'01234567'
K_BT = b'76543210'
BLOCK_SIZE_8 = 8

# A: Mostrar por pantalla M #
print(M)

# A ######### A realizar por el alumno ##
# A: K_AT(M) = CifrarK_AT(M)
cipherDES = DES.new(K_AT, DES.MODE_ECB)
cifrado_K_AT = cipherDES.encrypt(pad(M.encode("utf-8"), BLOCK_SIZE_8))
print(cifrado_K_AT)

# A-> T ##### No cambiar este codigo ####
M = None
# A envia: cifrado_K_AT
file_out = open("a_t.bin", "wb")
file_out.write(cifrado_K_AT)
file_out.close()
cifrado_K_AT = None
# T recibe: msg_K_AT
file_in = open("a_t.bin", "rb")
msg_K_AT = file_in.read()
file_in.close()

# T ######### A realizar por el alumno ##
descipherDES = DES.new(K_AT, DES.MODE_ECB)
descifrado_K_AT = unpad(descipherDES.decrypt(msg_K_AT), BLOCK_SIZE_8).decode("utf-8")
# Descifrando msg_K_AT
print(descifrado_K_AT)

print("1-------------------")

cifradoDES = DES.new(K_BT, DES.MODE_ECB)
cifrado_K_BT = cifradoDES.encrypt(pad(descifrado_K_AT.encode("utf-8"), BLOCK_SIZE_8))
print(cifrado_K_BT)

# T -> B #### No cambiar este codigo ##
descifrado_K_AT = None
# T envia: cifrado_K_BT
file_out = open("t_b.bin", "wb")
file_out.write(cifrado_K_BT)
file_out.close()
cifrado_K_BT = None
# B recibe: msg_K_BT
file_in = open("t_b.bin", "rb")
msg_K_BT = file_in.read()
file_in.close()

# B ######### A realizar por el alumno ##
descifradoDES = DES.new(K_BT, DES.MODE_ECB)
descifrado_K_BT = unpad(descifradoDES.decrypt(msg_K_BT), BLOCK_SIZE_8).decode("utf-8")
print("2-------------------")
print(descifrado_K_BT)