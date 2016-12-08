class VigenereCipher(object):
    """
    Author: Jungreithmeir Jakob, 5BHIT
    Version: 1.0, 08-12-2016

    Small class which uses the Vigenère cipher in order to encrypt basic messages. This cipher technique simply uses
    multiple Caeser ciphers, each one shifted one letter. This results in a cipher square which is used for encryption
    and decryption.
    Sources:
    https://de.wikipedia.org/wiki/Vigen%C3%A8re-Chiffre
    https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher

    The original assignment was to reconstruct the program, which you can see at the end of file. But I still wrote this
    class in order to make the implementation readable, compared to the ugly chunk of code which used binary integers...
    """
    def __init__(self, key):
        """
        Sets the key for further use.

        :param key: eg 'advent'
        """
        self.key = key

    def encrypt(self, message):
        """
        Encrypts the text. The foundation for the encryption square is the unicode table, or at least part of it.
        The first 126 characters of the Python unicode implementation are supported.

        The algorithm simply iterates over every character of the message and translates it into it's unicode integer
        representation. After this the character needs to be shifted. When this algorithm is done by hand one has to
        repeat the key until it has the same length as the message, this is achieved through the modulo operator in
        conjunction with the index based access. After the horizontal shift, the vertical shift is applied by using
        the modulo operator with the length of the square side.
        To reverse the encryption the horizontal shift has to be applied by subtracting the key unicode representation
        and by applying the vertical shift with the modulo operator.

        :param message: Message to be obfuscated
        """
        cipher_text = ''

        for index, char in enumerate(message):
            cipher_text += chr((ord(char) + ord(self.key[index % len(self.key)])) % 126)

        return cipher_text

    def decrypt(self, cipher_text):
        """
        Decrypts the given cipher text. The foundation for the encryption square is the unicode table, or at least part
        of it. The first 126 characters of the Python unicode implementation are supported.
        For more information regarding the concrete implementation please read the documentation of the encrypt method.

        :param message: Secret message
        """
        plaintext = ''

        for index, char in enumerate(cipher_text):
            plaintext += chr((ord(char) - ord(self.key[index % len(self.key)])) % 126)

        return plaintext


if __name__ == '__main__':
    v = VigenereCipher("advent")
    print(v.decrypt(v.encrypt("Testing successful.")))
    print(v.decrypt("<UmceO\]Kc\h\jpOK"))

def a(b,c="advent",d=""):
    for e,f in enumerate(b):
        d+=chr((ord(f)+ord(c[e%len(c)]))%int(0b1111110))
    return d