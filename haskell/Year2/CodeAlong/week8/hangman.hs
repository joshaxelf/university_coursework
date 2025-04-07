import System.IO

hangman :: IO ()
hangman = do putStrLn "Think of a word:"
             word <- sgetLine  --define version of get line that is silent and wont echo
             putStrLn "Try Guess it:"
             play word -- define play

match xs ys = [if x `elem` ys then x else '-' | x <- xs]

getCh = do hSetEcho stdin False 
           x <- getChar 
           hSetEcho stdin True
           return x 

sgetLine = do x <- getCh 
              if x == '\n'
                then do putChar x
                        return []
                else do putChar '-'
                        xs <- sgetLine 
                        return (x:xs)

play word = do putStr "?"
               guess <- getLine 
               if guess == word 
                    then do putStr "You got it!"
                            putChar '\n'
                    else do putStrLn (match word guess)
                            play word 
