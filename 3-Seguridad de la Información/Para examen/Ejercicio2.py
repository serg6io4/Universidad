print("#========================")
print("# PREGUNTA 2 (2,5 puntos)")
print("#========================")
# Enunciado
#----------
# Se proporcionan las variables "private" (clave privada RSA), "public" (clave publica RSA, 
# correspondiente a la clave privada contenida en la variable "private"), "cipherRSA" (cifrado
# del texto en claro usando RSA PKCS1_OAEP y la clave publica), y "signatureRSA" (firma del texto 
# en claro utilizando RSASSA-PSS y la clave privada).
# Se pide descifrar el texto cifrado, y mostrar el texto en claro por pantalla utilizando print()
# si el hash SHA256 de ese texto en claro puede ser verificado con la variable "signatureRSA".

# Ejercicio
#----------
private = RSA.import_key(b'-----BEGIN RSA PRIVATE KEY-----\nMIIEowIBAAKCAQEAniD6Hta5ks4B3fyzfFPD5DdoC09O8MGC6HcaeqiA+CsQrao9\nL4VOQlzAuD2+HuHtznLTXp+Svq7g3T+k88D7JTd1KpaP254rrMS/pJy4wCCNwVks\nLqeKin6Onh9ybQFuSPURXSj3+V02qC7IlrD3zoBIOQhJTVeU3pKRgOAJz4VQAmBh\nmicIgIKrfBtDhiI9wf7GgIq5Kd8ajRbfTi7Yo9gYaiwpEUYPLB2P57dKgDh8xEw4\nWRKMfjhvgHn7eJ9AW4/iTYi/GdEvqyINoSsW9U0mxkRhlBtwUAKnmMyhm71MNJwE\nlkFEce+xd8QVDZxZ/M37l5GrtS3lNmboJP0ZWwIDAQABAoIBAEDyb3jaHbdHyKmK\nAJhIeVVTUncOuHAXMvLS9Hu7mNkVKxEBModBm96S5Q7nQR7DEd7w95LOPMH35uDI\norIBKcXj7Mo0s9pysSKRXts4CYPT+xUWUJjK9JKkn2Qfq2pNI6Rwj5SxXoQ7vla+\nfGG0Rtu4gbF3D1Bmb/0ouv1xR2ZFiEqgkS1CMJwt+DiV8RYQ/9+BOFafPtISYYgM\nwk7qo7n88N/SfIK3AiQZbPg6vJIeKfj8yYtb9DaO14phXevRaoixrbCptDUPIK4m\n5C9G9tyjEZRaRCD/kng41j4YMWb+8dBO/o06th1hKKee75FfOCWW96QhLU0JmmfW\nwmRspXECgYEAx5vXOraKk0XJ9hoyZ73asavFHY6LpLiyUDLb6XQ2lrZj7B8elJz2\nfKeMFIduyrA/HNDx5h1louj9DU5lamwvWTh6dPz+YREMTGo2tAhLf4qQa8e8qt1y\ngY/crl7Nl1lOq5C3WdIXL2+HRIFrMQy0aM/XF7UUjqcFLVQ70MH9eRECgYEAys02\ngJ4zInq6CUPRE2ZgjQ6N2UeE5znYcMJSB47ze1xJvjhtj9b99YCmOUkvVN5yaiPD\nhZMKDthaIo3A2hjoMFkgFa0tzqVlH7C/lEtsQrShSlyWCqHL7oT/1ivdPCGIKQ1g\nYHLigdjgpedsoMLWZlQMAZIqF4XcEZGEcgjhi6sCgYAxnkCTPLsXvtpkTcDH3v7U\n+ZDnNv7pdGwG2Y2m65eCQVZ3ZIjygk4XUILWu4/D3KnjnOD0xcv1AhudSiaVnMzs\nTcjK+fS15kn7WM++Uu2Jh8U8tYrlomSLZlqCEdjjTXTr2u5o6nuO9BdY5R7jM3hJ\nMZkTMJUqnMQBr5Wq3/4FMQKBgHqu1g/MpCZxk+VS70ILJtFuQoV07INszPC5vSHx\nan3wAHRgcncXmh5QKz5wdX+j6hcnd3pwzx7X5v8MPeQyORQ2dmBmmVVvXNNk+yBc\n2CsqVoBDrkjURCgQsSwA8R8VMeeTvf/awAfJCW2TqHVAKK9SnMi+gVQlmFHQdA0A\nLmFtAoGBALN6kyvF+fPP/b698Q9N5be+X43elEROreLSf03L2g66mXq9xdHBj/4w\nylkMTlUbVv2dzBRfeL8Vj8/760Vi9SngbhC+xuvRsVbv/8u1UPcPajhhHLVtD760\nwn6ji09dDmUHh6ADfGtwhD3mOjtHZA4I8peUbA6DXYkQF206Yzkr\n-----END RSA PRIVATE KEY-----', passphrase="password")
public = RSA.import_key(b'-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAniD6Hta5ks4B3fyzfFPD\n5DdoC09O8MGC6HcaeqiA+CsQrao9L4VOQlzAuD2+HuHtznLTXp+Svq7g3T+k88D7\nJTd1KpaP254rrMS/pJy4wCCNwVksLqeKin6Onh9ybQFuSPURXSj3+V02qC7IlrD3\nzoBIOQhJTVeU3pKRgOAJz4VQAmBhmicIgIKrfBtDhiI9wf7GgIq5Kd8ajRbfTi7Y\no9gYaiwpEUYPLB2P57dKgDh8xEw4WRKMfjhvgHn7eJ9AW4/iTYi/GdEvqyINoSsW\n9U0mxkRhlBtwUAKnmMyhm71MNJwElkFEce+xd8QVDZxZ/M37l5GrtS3lNmboJP0Z\nWwIDAQAB\n-----END PUBLIC KEY-----')
cipherRSA = b"m\xdfsuZ\x02\x9cb\xaf\r\xfe\xbc\x9a8\x0e\xac\xe2\x10H$\xea\xc5\x0b\xd5\x1d-\xa3\x82?d'\xf0\xfd^\xe4^8\x80\xed\xfd8\x9bd\x1e\xa0\x13p\xe8|CG)8\x90ms\x9aZ\x0c\x13s\xc1\xd0\xa4\xf1p\xb7\xdc\x8fQ\xb9\x11\xfb\xa7\x8a\x98\xfe\xdeFt\x95)O\x89\xf2\xd7\x9f\xa9\xf0\xf1\x9c\x8b\x9f\x10\xc51\xaa\x1al\xd8\x06\x96\xbb\xf6\x1cy\xe6\x0e\x12\xb7\xe2\xa1\xc2\x08\x92\xbd\xf0B\x02\xed]\xa5[\\f\xe6X#t^T\xaaeP2\xfc\xaa[\x92\xc4\x90\xe8)k\t?\x11\xcc\x8e*\xf1\xc4\xe0|\x042\xd5\x00\x95\xcc\xc9\x85+`JY\xc3t\xbe\xdd\xe6\x14[\xc0;\xc2\x0bM\xcdB\x08\x95H[\xf8\xc7\x0f\x1b\xf0r&\xea\xfa\x14v\xde\xd0 \xde\xc4Co\xd8\xceH\xb3a!*\x04\xf8{\xb0\xd9\x86\x90\x90>\x8f\x1a\xf2)m\xabf\xb7\xdeA\x87$\xb0\xc9l\x80\xa5\xa5\xcb\xef\xb9\x1a\xdd\x02\x9bL\x03&a\xcf\xfb.\xc7\xc9#\xe8~+"
signatureRSA = b'\x0b\xe7`\xeb\xdd+\x80F\xf0\x13^\x18M\xc5\x13v\x9aUa\xd5\xea\x9e\x16\x01\x08`;#G\x82\xcd\xbf\x86|%=\xddY\x06\xd2[q\xba\x842\x8ak\x1f\xeb1\xe3(6bk"\xa5-\xe2\x05QU\t#\x83; \x98\x97K\x17\xc4\x89*\xa6Pj\xf2sG]\xd5\x95/\xc3\xa0\x99\xd7\x0e\x15\xd9\x8f/\xff\t\xf9\x9bw\xa2!%\xed\xa9y\t\xae\xc4\xfc\xb6\xe5\xa9\xf7\x13\xa8\xcd\xf2\xb0\xca\xeci\x82c\xf1\x95ZP\xc5\x9d\xe3\x18\xff\xa9K\x93\xc7^b30\xce\x9ab\xc7+h\x88\\\xe1\x05\x1fHv\x14\x01\xf0_6\xeb2b\xcdyd0~)U\xa8X\xf8\xf2\xfc\xe8"\x81x\x81\xd1\xa9\xe7~0\xc1 WL\x92\xef\x1d\xe7\nf\x81oq\'Z\xfb\x8b\x0e\xb7\x13\xc8\xf3\xa0 a\xb1\xbe\x8f\x9brB\x060\x80@j\x1b\x1b\xd2\x17\xe6CN\xc8\xfej\xb6\xe7\xbf\x91\xcdd\x08\x8d\x0f\xa6\xe8\xe6\xfd`3YQ#\xabL\x08\xb1/\xf9\xf8\x1a\xe3\xd0'

engineRSADescifrado = PKCS1_OAEP.new(private)
datos = engineRSADescifrado.decrypt(cipherRSA)
cadena = datos.decode("utf-8")
# Aquí tenemos la cadena descifrada
# print(cadena)
# Procedemos a comprobar la firma
h = SHA256.new(cadena.encode("utf-8")) 
verificador = pss.new(public)
try:
    verificador.verify(h, signatureRSA)
    print(cadena)
except (ValueError, TypeError):
    print("La firma no se verifica")