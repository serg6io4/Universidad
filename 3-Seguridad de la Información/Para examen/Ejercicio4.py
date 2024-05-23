print("#========================")
print("# PREGUNTA 4 (2,5 puntos)")
print("#========================")
# Enunciado
#----------
# Implementar el siguiente protocolo:
# - A: Mostrar por pantalla M
# - A: Cipher_M = Cifrado_Publica_B(M)
# - A: HMAC_M = HMAC(M, SHA256, K_AB)
# - A->B: Cipher_M, HMAC_M
# - B: Texto_M = Descifrado_Privada_B(Cipher_M)
# - B: Si HMAC_M se verifica con HMAC(Texto_M, SHA256, K_AB)
# -    Mostrar por pantalla Texto_M
#
# (cuya version simplificada siguiendo el formato de las transparencias es:
# - A->B: Cifrado_Publica_B(M), HMAC_SHA256(M,K_AB)
# )
#
# utilizando las variables "private" (clave privada RSA de B), "public" (clave publica RSA de B, 
# correspondiente a la clave privada contenida en la variable "private"), y "K_AB" (una clave
# compartida entre A y B).
# Para el cifrado se utilizara PKCS1_OAEP, y para el HMAC se utilizara SHA256.

# Ejercicio
#----------
private = RSA.import_key(b'-----BEGIN RSA PRIVATE KEY-----\nMIIEowIBAAKCAQEAniD6Hta5ks4B3fyzfFPD5DdoC09O8MGC6HcaeqiA+CsQrao9\nL4VOQlzAuD2+HuHtznLTXp+Svq7g3T+k88D7JTd1KpaP254rrMS/pJy4wCCNwVks\nLqeKin6Onh9ybQFuSPURXSj3+V02qC7IlrD3zoBIOQhJTVeU3pKRgOAJz4VQAmBh\nmicIgIKrfBtDhiI9wf7GgIq5Kd8ajRbfTi7Yo9gYaiwpEUYPLB2P57dKgDh8xEw4\nWRKMfjhvgHn7eJ9AW4/iTYi/GdEvqyINoSsW9U0mxkRhlBtwUAKnmMyhm71MNJwE\nlkFEce+xd8QVDZxZ/M37l5GrtS3lNmboJP0ZWwIDAQABAoIBAEDyb3jaHbdHyKmK\nAJhIeVVTUncOuHAXMvLS9Hu7mNkVKxEBModBm96S5Q7nQR7DEd7w95LOPMH35uDI\norIBKcXj7Mo0s9pysSKRXts4CYPT+xUWUJjK9JKkn2Qfq2pNI6Rwj5SxXoQ7vla+\nfGG0Rtu4gbF3D1Bmb/0ouv1xR2ZFiEqgkS1CMJwt+DiV8RYQ/9+BOFafPtISYYgM\nwk7qo7n88N/SfIK3AiQZbPg6vJIeKfj8yYtb9DaO14phXevRaoixrbCptDUPIK4m\n5C9G9tyjEZRaRCD/kng41j4YMWb+8dBO/o06th1hKKee75FfOCWW96QhLU0JmmfW\nwmRspXECgYEAx5vXOraKk0XJ9hoyZ73asavFHY6LpLiyUDLb6XQ2lrZj7B8elJz2\nfKeMFIduyrA/HNDx5h1louj9DU5lamwvWTh6dPz+YREMTGo2tAhLf4qQa8e8qt1y\ngY/crl7Nl1lOq5C3WdIXL2+HRIFrMQy0aM/XF7UUjqcFLVQ70MH9eRECgYEAys02\ngJ4zInq6CUPRE2ZgjQ6N2UeE5znYcMJSB47ze1xJvjhtj9b99YCmOUkvVN5yaiPD\nhZMKDthaIo3A2hjoMFkgFa0tzqVlH7C/lEtsQrShSlyWCqHL7oT/1ivdPCGIKQ1g\nYHLigdjgpedsoMLWZlQMAZIqF4XcEZGEcgjhi6sCgYAxnkCTPLsXvtpkTcDH3v7U\n+ZDnNv7pdGwG2Y2m65eCQVZ3ZIjygk4XUILWu4/D3KnjnOD0xcv1AhudSiaVnMzs\nTcjK+fS15kn7WM++Uu2Jh8U8tYrlomSLZlqCEdjjTXTr2u5o6nuO9BdY5R7jM3hJ\nMZkTMJUqnMQBr5Wq3/4FMQKBgHqu1g/MpCZxk+VS70ILJtFuQoV07INszPC5vSHx\nan3wAHRgcncXmh5QKz5wdX+j6hcnd3pwzx7X5v8MPeQyORQ2dmBmmVVvXNNk+yBc\n2CsqVoBDrkjURCgQsSwA8R8VMeeTvf/awAfJCW2TqHVAKK9SnMi+gVQlmFHQdA0A\nLmFtAoGBALN6kyvF+fPP/b698Q9N5be+X43elEROreLSf03L2g66mXq9xdHBj/4w\nylkMTlUbVv2dzBRfeL8Vj8/760Vi9SngbhC+xuvRsVbv/8u1UPcPajhhHLVtD760\nwn6ji09dDmUHh6ADfGtwhD3mOjtHZA4I8peUbA6DXYkQF206Yzkr\n-----END RSA PRIVATE KEY-----', passphrase="password")
public = RSA.import_key(b'-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAniD6Hta5ks4B3fyzfFPD\n5DdoC09O8MGC6HcaeqiA+CsQrao9L4VOQlzAuD2+HuHtznLTXp+Svq7g3T+k88D7\nJTd1KpaP254rrMS/pJy4wCCNwVksLqeKin6Onh9ybQFuSPURXSj3+V02qC7IlrD3\nzoBIOQhJTVeU3pKRgOAJz4VQAmBhmicIgIKrfBtDhiI9wf7GgIq5Kd8ajRbfTi7Y\no9gYaiwpEUYPLB2P57dKgDh8xEw4WRKMfjhvgHn7eJ9AW4/iTYi/GdEvqyINoSsW\n9U0mxkRhlBtwUAKnmMyhm71MNJwElkFEce+xd8QVDZxZ/M37l5GrtS3lNmboJP0Z\nWwIDAQAB\n-----END PUBLIC KEY-----')
M = "Texto del cuarto apartado, cifrado RSA y HMAC (12/11/2018), formato String (cadena)"
K_AB = b'01234567890ABCDEF'
BLOCK_SIZE_8 = 16
# A: Mostrar por pantalla M #
print(M)

# A ######### A realizar por el alumno ##
RSACifrado = PKCS1_OAEP.new(public)
Cipher_M = RSACifrado.encrypt(M.encode("utf-8"))
# Aquí ya tenemos el texto cifrado
# print(Cipher_M)
hma = HMAC.new(K_AB, M.encode("utf-8"), digestmod=SHA256)
HMAC_M = hma.digest()
# print(HMAC_M)

# A-> B ##### No cambiar este codigo ####
file_out = open("encrypted.bin", "wb")
[ file_out.write(x) for x in (HMAC_M, Cipher_M) ]
file_out.close()
HMAC_M = None
Cipher_M = None
file_in = open("encrypted.bin", "rb")
msg_HMAC_M, msg_Cipher_M = [ file_in.read(x) for x in (32, -1) ]

# B ######### A realizar por el alumno ##

RSADescifrado = PKCS1_OAEP.new(private)
Descipher_M = RSADescifrado.decrypt(msg_Cipher_M)

HMAC_MA = HMAC.new(K_AB, Descipher_M, digestmod=SHA256)
resultado = HMAC_MA.digest()

try:
    HMAC_MA.verify(msg_HMAC_M)
    print(Descipher_M.decode("utf-8"))
except (ValueError, TypeError):
    print("No corresponden los HMAC")