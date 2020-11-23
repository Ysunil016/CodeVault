package medium

import org.junit.Assert
import org.junit.Test

class ValidateBSTTest {

    @Test
    fun validateBst() {
        var bstMedium = ValidateBST.BST(10)
        bstMedium.left = ValidateBST.BST(5)
        bstMedium.right = ValidateBST.BST(30)

        Assert.assertTrue(ValidateBST().validateBst(bstMedium))
    }

    @Test
    fun validateBst_() {
        var bstMedium = ValidateBST.BST(50)
        bstMedium.left = ValidateBST.BST(55)
        bstMedium.right = ValidateBST.BST(70)

        Assert.assertFalse(ValidateBST().validateBst(bstMedium))
    }

    @Test
    fun validateBst__() {
        var bstMedium = ValidateBST.BST(2)
        bstMedium.left = ValidateBST.BST(1)
        bstMedium.right = ValidateBST.BST(6)

        Assert.assertTrue(ValidateBST().validateBst(bstMedium))
    }

    @Test
    fun validateBst___() {
        var bstMedium = ValidateBST.BST(45)
        bstMedium.left = ValidateBST.BST(55)

        Assert.assertFalse(ValidateBST().validateBst(bstMedium))
    }
}