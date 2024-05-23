# Enunciado
#----------
# Se proporcionan las variables "key" (clave de 128 bits), "ciphertext" (texto cifrado con esa
# clave de 128 bits), y "hash" (hash del texto en claro, utilizando SHA256).
# Se pide descifrar el texto cifrado utilizando el modo de operacion ECB, y mostrar el texto en
# claro por pantalla utilizando print() si el hash de ese texto en claro y la variable "hash" coinciden.
# La primitiva de criptografia simetrica utilizada en este ejercicio debera ser deducida por el 
# alumno en base a la informacion proporcionada.

# Ejercicio
#----------
BLOCK_SIZE = 16 
key = b'0123456789ABCDEF' # Que mecanismo criptografico usa 128 bits como clave secreta...
ciphertext = b"'\xa8\x08\x89(\xe2\x81\x9c9\x98\xeb\xb0n\x16<\x04\x93:\xdaBX\xb8dP\x99\x9a?s\x85u&\xa6\xaf\xecx\xfeoo\xc2\xa4\xc4\xc2I\t&\xb0t\xafn&\x04\x9e\xfb'\xbd\x9e\xaaw\x0f\xe3Jq\xc5\xae@\x82p\x82:86\xf5k\xc3\xae\xda\x01UD!"
hash = b'*\x9f\xa7\xffv\xc3\xf1\xcc\xe2\xc3R\xd1M\nT\x9bS\x94\x87j\xab\xbeI\xd43\xdb\xde\x01\x9c}\xd0\xd9'

decipher_aes = AES.new(key, AES.MODE_ECB)
descif = unpad(decipher_aes.decrypt(ciphertext), BLOCK_SIZE).decode("utf-8", "ignore")
ha = SHA256.new(data=descif.encode("utf-8"))
# print(descif)
# Hasta aquí mostramos el texto descifrado.

# Comprobamos el hash
if hash == ha.digest():
    print(descif)

#print(ha.hexdigest())
#print(descif)