{-
Bind (>>=)

    Monad m => m a -> (a -> m b) -> m b

    In the context of maybe composition where results could fail returning nothing.
    Return the most significant digit of a number as string,
    results should be of the form "the most sig digit is: five"

    This should return nothing when given a negative number
-}

nums = ["Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"]

getSigNum :: Int -> Maybe Int
getSigNum x | x <= 0 = Nothing
            | x <= 9 = Just x
            | otherwise = getSigNum (div x  10)

int2String :: Int -> Maybe String
int2String x | x <= 0 || x > 9 = Nothing
             | otherwise = Just (nums !! x)

polishString :: String -> Maybe String
polishString xs | xs `elem` nums = Just ("The most sig digit is: " ++ xs)
                | otherwise = Nothing