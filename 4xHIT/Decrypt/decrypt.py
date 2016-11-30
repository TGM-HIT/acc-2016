"""
Author: Markus Reichl
Version: 30.11.2016
"""

defa(b,c="advent",d=""):fore,finenumerate(b):d+=chr((ord(f)+ord(c[e%len(c)]))%int(0b1111110))returnd\n<UmceO\]Kc\h\jpOK

# START SOLVED
def decrypt(message, key):
    __crypt = ""

    for i, char in enumerate(message):
        key_char = ord(key[i % len(key)])
        __crypt += chr((ord(char) - key_char) % 126)

    return __crypt


if __name__ == "__main__":
    decrypted = "You solved my puzzle!"

    ec = a(decrypted, "advent")
    print(ec)

    dc = decrypt(encrypted, "advent")
    print(dc)
# END SOLVED
