from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP
from Crypto.Signature import pss
from Crypto.Hash import SHA256

class RSA_OBJECT:

    def __init__(self):
        """Inicializa un objeto RSA, sin ninguna clave"""
        # Nota: Para comprobar si un objeto (no) ha sido inicializado, hay
        #   que hacer "if self.public_key is None:" 
        self.public_key = None
        self.private_key = None

    def create_KeyPair(self):
        """Crea un par de claves publico/privada, y las almacena dentro de la instancia"""
        self.private_key = RSA.generate(2048)
        self.public_key = self.private_key.publickey()

    def save_PrivateKey(self, file, password):
        """Guarda la clave privada self.private_key en un fichero file, usando una contraseña password"""
        key_cifrada = self.private_key.export_key(passphrase=password, pkcs=8, protection="scryptAndAES128-CBC")
        file_out = open(file, "wb")
        file_out.write(key_cifrada)
        file_out.close()

    def load_PrivateKey(self, file, password):
        """Carga la clave privada self.private_key de un fichero file, usando una contraseña password"""
        fich = open(file, "rb").read()
        self.private_key = RSA.import_key(fich, passphrase=password)

    def save_PublicKey(self, file):
        """Guarda la clave publica self.public_key en un fichero file"""
        key_pub = self.private_key.publickey().export_key()
        file_out = open(file, "wb")
        file_out.write(key_pub)
        file_out.close()

    def load_PublicKey(self, file):
        """Carga la clave publica self.public_key de un fichero file"""
        keyFile = open(file, "rb").read()
        self.public_key = RSA.import_key(keyFile)

    def cifrar(self, datos):
        """Cifra el parámetro datos (de tipo binario) con la clave self.public_key, y devuelve
           el resultado. En caso de error, se devuelve None"""

        engineRSACifrado = PKCS1_OAEP.new(self.public_key)
        cifrado = engineRSACifrado.encrypt(datos)

        return cifrado

    def descifrar(self, cifrado):
        """Descrifra el parámetro cifrado (de tipo binario) con la clave self.private_key, y devuelve
           el resultado (de tipo binario). En caso de error, se devuelve None"""
        engineRSADescifrado = PKCS1_OAEP.new(self.private_key)
        datos = engineRSADescifrado.decrypt(cifrado)
        cadena = datos

        return cadena

    def firmar(self, datos):
        """Firma el parámetro datos (de tipo binario) con la clave self.private_key, y devuelve el 
           resultado. En caso de error, se devuelve None."""
        h = SHA256.new(datos) # Ya veremos los hash la semana que viene
        print(h.hexdigest())
        signature = pss.new(self.private_key).sign(h)

        return signature

    def comprobar(self, text, signature):
        """Comprueba el parámetro text (de tipo binario) con respecto a una firma signature 
           (de tipo binario), usando para ello la clave self.public_key.
           Devuelve True si la comprobacion es correcta, o False en caso contrario o 
           en caso de error."""
        h = SHA256.new(text) # Ya veremos los hash la semana que viene
        print(h.hexdigest())
        verifier = pss.new(self.public_key)
        try:
            verifier.verify(h, signature)
            return True
        except (ValueError, TypeError):
            return False

# Main
# ====
###########################
# Crea dos personas con sus claves

RSA_A = RSA_OBJECT()
RSA_B = RSA_OBJECT()
RSA_A.create_KeyPair()
RSA_B.create_KeyPair()

# --------------------------------
# Cifrar y Descifrar con PKCS1 OAEP
cadena = "Hola Amigos de la Seguridad"
# CIFRAR CON LA PUBLICA DE B
cifrado = RSA_B.cifrar(cadena.encode("utf-8"))
print(cifrado)
# FIN DEL CIFRADO CON LA PUBLIC KEY DE B
# --------------------------------
# FIRMA CON LA CLAVE PRIVADA DE A
firma = RSA_A.firmar(cifrado)
# FIN DE FIRMA
# --------------------------------
# GUARDAR CIFRADO Y FIRMA EN UN FICHERO Y CARGARLOS POSTERIORMENTE
file_out = open("micifrado.txt", "wb")
file_out.write(cifrado)
file_out.close()
# ---------------------
# COMPROBAR CON PUBLIC DE A (CIFRADO, FIRMA)
RSA_A.comprobar(cifrado, firma)
# ------------------------
# MENSAJE(cifrado) DESCIFRARLO CON LA CLAVE PRIVADA DE B
descifrado = RSA_B.descifrar(cifrado).decode("utf-8")
print(descifrado)