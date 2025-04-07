{-
function gcd(a, b)
    while a =/= b
        if a > b
            a := a - b
        else 
            b := b - a
    return a 
-}

gcd1 :: Int -> Int -> Int
gcd1 a b | a == b   = a 
         | a > b     = gcd1 (a - b) b 
         | otherwise = gcd1 a (b - a)

{-
Example 1: gcd1 48 18

    gcd1 48 18

        48 > 18, so subtract:
        gcd1 (48 - 18) 18 → gcd1 30 18

    gcd1 30 18

        30 > 18, so subtract:
        gcd1 (30 - 18) 18 → gcd1 12 18

    gcd1 12 18

        12 < 18, so subtract:
        gcd1 12 (18 - 12) → gcd1 12 6

    gcd1 12 6

        12 > 6, so subtract:
        gcd1 (12 - 6) 6 → gcd1 6 6

    gcd1 6 6

        Base case (a == b), return 6.

So, gcd1 48 18 returns 6.

-}