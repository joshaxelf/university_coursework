nums = ["Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"]

checkString :: String -> String
checkString xs  | xs `elem` nums = "Correct Format"
                | otherwise = "Incorrect Format"

findPos :: String -> Int -> Int
findPos [] n = -1
findPos xs n | xs == nums !! n = n
             | otherwise = findPos xs (n + 1)

-- main = do putStr "Enter String"
--           putChar '\n'
--           string <- getLine
--           putStr (checkString string)
--           return (findPos string 0)

main = do putStr "Enter String"
          putChar '\n'
          string <- getLine
          if string `elem` nums
            then do putStr "Valid input"
                    putChar '\n'
                    return (findPos string 0)
            else do putStr "Invalid input"
                    putChar '\n'
                    return (-1)