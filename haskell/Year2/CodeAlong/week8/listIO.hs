-- get a list from IO, print the largest value in the list

getList = do x <- getLine
             if x == "" then return []
                        else do xs <- getList
                                return (x:xs)

findVal = foldr (\x acc -> if length x > length acc then x else acc) []

main = do   putStr "Enter list of strings: "
            putChar '\n'
            xs <- getList
            return (findVal xs)