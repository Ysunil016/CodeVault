package easy

import org.junit.Assert
import org.junit.Test


class GenerateDocumentTest{

    @Test
    fun generateDocument(){
        val actualValue = GenerateDocument()
            .generateDocument("Bste!hetsi ogEAxpelrt x ","AlgoExpert is the Best!")
        Assert.assertTrue(actualValue)
    }

    @Test
    fun generateDocument2(){
        val actualValue = GenerateDocument()
            .generateDocument("aheaollabbhb","hello")
        Assert.assertTrue(actualValue)
    }

}