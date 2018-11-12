# Java-Cryptography
Security and cryptography examples in Java.

**Symmetric Cryptography:**
- ```AES.java```:  Encryption and decryption of a text string using [Advanced Encryption Standard (AES)](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard).

- ```DES.java```: Encryption and decryption of a text string using [Data Encryption Standard (DES)](https://en.wikipedia.org/wiki/Data_Encryption_Standard).

**Asymmetric Cryptography:**
- ```RSA.java```: Encryption and decryption of a text string using [RSA](https://en.wikipedia.org/wiki/RSA_(cryptosystem)).

**Digital Signatures:**
- ```DSA.java```: Signing and verifying a message using [Digital Signature Algorithm (DSA)](https://en.wikipedia.org/wiki/Digital_Signature_Algorithm).

**Hash Functions:**
- ```HashingTextString.java```: Computes either the [MD5](https://en.wikipedia.org/wiki/MD5), [SHA-1](https://en.wikipedia.org/wiki/SHA-1) or [SHA-256](https://en.wikipedia.org/wiki/SHA-2) hash of a user-supplied input string.
- ```HashingSalt.java```: Given a password chosen by the user, generates a [salt](https://en.wikipedia.org/wiki/Salt_(cryptography)) of equal length and concatenates it to the password. Then computer the SHA-256 hash of this concatenated string.
