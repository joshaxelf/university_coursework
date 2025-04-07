lengthString :: String -> Int
lengthString [] = 0
lengthString (x:xs) = 1 + lengthString xs

lengthInt :: [Int] -> Int
lengthInt [] = 0
lengthInt (x:xs) = 1 + lengthInt xs


lengthFloat :: [Float] -> Int
lengthFloat [] = 0
lengthFloat (x:xs) = 1 + lengthFloat xs

lengthFunction :: [a] -> Int
lengthFunction [] = 0
lengthFunction (x:xs) = 1 + lengthFunction xs
