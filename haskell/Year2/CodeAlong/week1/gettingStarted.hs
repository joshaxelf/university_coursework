{- 

Haskell is an declarative language.
Focus on telling the computer what to do and not how to do it 

public int sum(int n) {
            private int k, j;
            k = 0;
            j = 1;
            while ( j < n + 1){
                k = k + j;
                j = j + 1;
            }
            return k;
            }

-}

summ :: Int -> Int
summ 0 = 0
summ n = n + summ (n - 1)