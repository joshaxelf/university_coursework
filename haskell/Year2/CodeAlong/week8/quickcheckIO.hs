t1 = quickCheck q1Test
t2 = quickCheck (q2Test :: [Int] -> [Int] -> Bool)
t3 = quickCheck (q3Test :: (Int -> Char) -> Int -> [Int] -> Bool)
t4 = quickCheck (q3bTest :: (Int -> Char) -> [Int] -> Bool)

main = do   putStr "Which test would you like to run?"
            putChar '\n'
            x <- getLine
            case x of 
                "t1" -> t1
                "t2" -> t2
                "t3" -> t3
                "t4" -> t4
                "all" -> sequence [t1,t2,t3,t4]
                otherwise -> main