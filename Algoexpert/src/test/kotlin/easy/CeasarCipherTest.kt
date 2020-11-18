package easy

import org.junit.Assert
import org.junit.Test


class CeasarCipherTest{
    @Test
    fun shouldReturnCipher(){
        var cCipher = CeasarCipher()

        var actualCode = cCipher.caesarCipherEncryptor("abc",2)

        Assert.assertEquals("cde",actualCode)
    }

    @Test
    fun shouldReturnCipher_(){
        var cCipher = CeasarCipher()

        var actualCode = cCipher.caesarCipherEncryptor("zab",1)

        Assert.assertEquals("abc",actualCode)
    }

    @Test
    fun shouldReturnCipher__(){
        var cCipher = CeasarCipher()

        var actualCode = cCipher.caesarCipherEncryptor("zab",0)

        Assert.assertEquals("zab",actualCode)
    }

    @Test
    fun shouldReturnCipher___(){
        var cCipher = CeasarCipher()

        var actualCode = cCipher.caesarCipherEncryptor("abc",52)

        Assert.assertEquals("abc",actualCode)
    }
}