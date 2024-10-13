import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class L2022211801_Solution1_Test {

    private Solution1 solution;



    /**
     * 测试用例设计总体原则：
     * 1. 等价类划分原则：根据输入的分子和分母的不同情况，将输入分为不同的等价类。
     * 2. 边界值分析原则：考虑边界情况，如分子为 0、分母为 1 等。
     * 3. 错误猜测原则：考虑一些可能出错的情况，如负数输入等。
     */

    /**
     * 测试目的：验证正常情况下的分数转换为小数。
     * 测试用例：(1, 2), (-1, 2), (2, 1), (1, 3), (2, 3), (4, 333)
     */
    @Test
    public void testNormalCases() {
        solution = new Solution1();
        int[][] testCases = {
                {1, 2},   // 0.5
                {-1, 2},  // -0.5
                {2, 1},   // 2
                {1, 3},   // 0.(3)
                {2, 3},   // 0.(6)
                {4, 333}  // 0.(012)
        };

        String[] expectedResults = {
                "0.5",
                "-0.5",
                "2",
                "0.(3)",
                "0.(6)",
                "0.(012)"
        };

        for (int i = 0; i < testCases.length; i++) {
            int numerator = testCases[i][0];
            int denominator = testCases[i][1];
            String result = solution.fractionToDecimal(numerator, denominator);
            Assert.assertEquals("Test case " + numerator + "/" + denominator, expectedResults[i], result);
        }
    }

    /**
     * 测试目的：验证分子为 0 的情况。
     * 测试用例：(0, 1), (0, -1), (0, 100)
     */
    @Test
    public void testZeroNumerator() {
        solution = new Solution1();
        int[][] testCases = {
                {0, 1},
                {0, -1},
                {0, 100}
        };

        String[] expectedResults = {
                "0",
                "0",
                "0"
        };

        for (int i = 0; i < testCases.length; i++) {
            int numerator = testCases[i][0];
            int denominator = testCases[i][1];
            String result = solution.fractionToDecimal(numerator, denominator);
            Assert.assertEquals("Test case " + numerator + "/" + denominator, expectedResults[i], result);
        }
    }

    /**
     * 测试目的：验证分母为 1 的情况。
     * 测试用例：(1, 1), (-1, 1), (100, 1)
     */
    @Test
    public void testDenominatorOne() {
        solution = new Solution1();
        int[][] testCases = {
                {1, 1},
                {-1, 1},
                {100, 1}
        };

        String[] expectedResults = {
                "1",
                "-1",
                "100"
        };

        for (int i = 0; i < testCases.length; i++) {
            int numerator = testCases[i][0];
            int denominator = testCases[i][1];
            String result = solution.fractionToDecimal(numerator, denominator);
            Assert.assertEquals("Test case " + numerator + "/" + denominator, expectedResults[i], result);
        }
    }

    /**
     * 测试目的：验证负数的情况。
     * 测试用例：(-1, 2), (1, -2), (-1, -2)
     */
    @Test
    public void testNegativeNumbers() {
        solution = new Solution1();
        int[][] testCases = {
                {-1, 2},
                {1, -2},
                {-1, -2}
        };

        String[] expectedResults = {
                "-0.5",
                "-0.5",
                "0.5"
        };

        for (int i = 0; i < testCases.length; i++) {
            int numerator = testCases[i][0];
            int denominator = testCases[i][1];
            String result = solution.fractionToDecimal(numerator, denominator);
            Assert.assertEquals("Test case " + numerator + "/" + denominator, expectedResults[i], result);
        }
    }

    /**
     * 测试目的：验证循环小数的情况。
     * 测试用例：(1, 3), (2, 3), (4, 333)
     */
    @Test
    public void testRepeatingDecimals() {
        solution = new Solution1();
        int[][] testCases = {
                {1, 3},   // 0.(3)
                {2, 3},   // 0.(6)
                {4, 333}  // 0.(012)
        };

        String[] expectedResults = {
                "0.(3)",
                "0.(6)",
                "0.(012)"
        };

        for (int i = 0; i < testCases.length; i++) {
            int numerator = testCases[i][0];
            int denominator = testCases[i][1];
            String result = solution.fractionToDecimal(numerator, denominator);
            Assert.assertEquals("Test case " + numerator + "/" + denominator, expectedResults[i], result);
        }
    }



}