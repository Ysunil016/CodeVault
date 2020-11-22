package easy

import org.junit.Assert
import org.junit.Test


class RunLengthEncodingTest {

    @Test
    fun runLengthEncoding() {
        var runLengthEncodingTest = RunLengthEncoding()
        var expectedResult = ""

        var actualResult = runLengthEncodingTest.runLengthEncoding("")

        Assert.assertEquals(expectedResult,actualResult)
    }

    @Test
    fun runLengthEncoding_() {
        var runLengthEncodingTest = RunLengthEncoding()
        var expectedResult = "9A4A2B4C2D"

        var actualResult = runLengthEncodingTest.runLengthEncoding("AAAAAAAAAAAAABBCCCCDD")

        Assert.assertEquals(expectedResult,actualResult)
    }

    @Test
    fun runLengthEncoding__() {
        var runLengthEncodingTest = RunLengthEncoding()
        var expectedResult = "1A1B1C1D"

        var actualResult = runLengthEncodingTest.runLengthEncoding("ABCD")

        Assert.assertEquals(expectedResult,actualResult)
    }

}