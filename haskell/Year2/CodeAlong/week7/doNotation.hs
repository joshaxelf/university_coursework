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

getItDone x = getSigNum x >>= int2String >>= polishString

getItDone2 x = do   y <- getSigNum x 
                    z <- int2String y
                    polishString z