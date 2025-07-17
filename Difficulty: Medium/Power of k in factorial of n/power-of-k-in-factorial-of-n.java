import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * Helper function to calculate the exponent of a prime 'p' in n! (n factorial)
     * using Legendre's Formula.
     * Legendre's Formula: v_p(n!) = sum_{j=1 to infinity} floor(n / p^j)
     *
     * @param n The number for which factorial is considered.
     * @param p The prime number whose exponent in n! is to be found.
     * @return The highest power of 'p' that divides 'n!'.
     */
    private int getExponentOfPrimeInFactorial(int n, int p) {
        // According to constraints (k >= 2), 'p' will always be a prime number >= 2.
        int count = 0;
        long powerOfP = p; // Use long to avoid potential overflow when calculating p^j (powerOfP * p)

        // The loop calculates floor(n/p) + floor(n/p^2) + floor(n/p^3) + ...
        // It continues as long as p^j (represented by powerOfP) is less than or equal to n.
        while (powerOfP <= n) {
            count += n / powerOfP;

            // This is a crucial check to prevent overflow of 'powerOfP * p'.
            // If 'powerOfP' is already so large that multiplying it by 'p' would exceed
            // 'n' (or the maximum value for a long), then any further terms (n / (p^j+1))
            // would be 0. So, we can stop the loop.
            // The condition 'powerOfP > n / p' is equivalent to 'powerOfP * p > n' but
            // avoids direct multiplication that could overflow.
            if (powerOfP > n / p) {
                break;
            }
            powerOfP *= p;
        }
        return count;
    }

    /**
     * Determines the highest value of 'x' such that k^x divides n! (n factorial) completely.
     *
     * @param n The number for which factorial is considered (1 <= n <= 10^5).
     * @param k The base number (2 <= k <= 10^5).
     * @return The highest integer 'x'.
     */
    public int maxKPower(int n, int k) {
        // Constraints: 1 <= n <= 10^5, 2 <= k <= 10^5.
        // No need for explicit checks for n < 1 or k < 2 as per problem constraints.

        // Step 1: Prime factorize 'k'.
        // We store prime factors of 'k' and their respective exponents in a HashMap.
        // For example, if k = 12, primeFactorsK will be {2: 2, 3: 1} (since 12 = 2^2 * 3^1).
        Map<Integer, Integer> primeFactorsK = new HashMap<>();
        int tempK = k; // Use a temporary variable to factorize 'k' without changing the original 'k'

        // Iterate from 2 up to sqrt(tempK) to find prime factors.
        for (int i = 2; i * i <= tempK; i++) {
            while (tempK % i == 0) { // If 'i' divides 'tempK', then 'i' is a prime factor
                primeFactorsK.put(i, primeFactorsK.getOrDefault(i, 0) + 1); // Increment its count
                tempK /= i; // Divide 'tempK' by 'i' to continue finding factors
            }
        }
        // If after the loop, 'tempK' is still greater than 1, it means 'tempK' itself is a prime factor
        // (e.g., if k = 7, after the loop tempK will be 7).
        if (tempK > 1) {
            primeFactorsK.put(tempK, primeFactorsK.getOrDefault(tempK, 0) + 1);
        }

        // Initialize 'minX' to a very large value.
        // 'minX' will store the minimum 'x' calculated for each prime factor of 'k'.
        // This is because the overall 'x' (for k^x) is limited by the prime factor that runs out first in n!.
        int minX = Integer.MAX_VALUE;

        // Step 2 & 3: For each prime factor 'p' (with exponent 'a') of 'k':
        // 1. Calculate the exponent of 'p' in n! using Legendre's Formula (let's call it v_p(n!)).
        // 2. The maximum power of 'k' that can be formed due to this prime 'p' is floor(v_p(n!) / a).
        // 3. We take the minimum of these values across all prime factors.
        for (Map.Entry<Integer, Integer> entry : primeFactorsK.entrySet()) {
            int prime = entry.getKey();         // Current prime factor of 'k'
            int exponentInK = entry.getValue(); // Its exponent in the prime factorization of 'k'

            // Calculate the total count of 'prime' in n!
            int exponentInNFactorial = getExponentOfPrimeInFactorial(n, prime);

            // If a prime factor of 'k' is not present at all in n! (its count in n! is 0),
            // then k^x cannot divide n! even once, so the highest power 'x' must be 0.
            // This happens if 'prime' > 'n'.
            if (exponentInNFactorial == 0) {
                 return 0;
            }

            // Calculate the current possible value of 'x' based on this specific prime factor.
            // This is the number of times this prime factor, with its required exponent from 'k',
            // can be formed from the prime factors available in n!.
            int currentX = exponentInNFactorial / exponentInK;

            // Update 'minX' with the smallest 'currentX' found so far.
            minX = Math.min(minX, currentX);
        }

        // After iterating through all prime factors of 'k', 'minX' will hold the overall highest
        // value of 'x' such that k^x completely divides n!.
        // Since k >= 2, primeFactorsK will never be empty, and minX will always be updated
        // to a valid non-negative integer (including 0 if k cannot divide n! at all).
        return minX;
    }
}