
{-CS260 Resit coursework
----------------------------
Attempt all questions, partial solutions may receive partial marks. You may not collaborate with other students or use generative AI, all work must be your own. Submit your solutions no later that Friday 18th of July at 17:00.
-}

{-1a) Define checkStrings which checks whether two supplied strings are the same. (1 mark)-}

checkStrings::String -> String -> Bool 
checkStrings x y = x == y 

{-1b) Define checkNum which returns True if a number is less than 10 and greater than 0. (2 marks) -} 

-- Function for checking if greater than 0, less than 10 with 0 = True included as per Alasdairs email 

checkNum::Int -> Bool 
checkNum 0 = True
checkNum x = (x > 0) && (x < 10)

{-1c) Define checkString which takes a number and a string. checkString should then return a string to let the user know if the string is less than the given number or if it is greater than or equal to the number given. (2 marks)-}

-- Returns True if String is equal or greater than Int 

checkString::Int -> String -> Bool 
checkString x y = x <= length y

{-1d) Define findAndDelete which removes every occurence of a given element in a list. (3 marks)-}

findAndDelete::Eq a => a -> [a] -> [a]
findAndDelete e [] = []
findAndDelete e (x:xs) | e == x = findAndDelete e xs
                       | otherwise = x : findAndDelete e xs

{-2) Define eitherMap which takes two functions and maps a list of Either type values to a new type. (3 marks) -}

eitherMap::(a -> c) -> (b -> d) -> [Either a b] -> [Either c d]
eitherMap f g [] = []
eitherMap f g (Left a:xs) = Left (f a) : eitherMap f g xs
eitherMap f g (Right b:xs) = Right  (g b) : eitherMap f g xs

{-3) A Die (singular of dice) when rolled takes a value between One and Six..-}

data Die = One | Two |Three | Four | Five | Six 
   deriving (Show, Eq, Ord) 

{-3a) Define the type synonym Dice which holeds a list of Die values. (1 mark)-}

type Dice = [Die]

{-3b) Define roll2Int which maps a Dice type to an Integer. (3 marks) -}

roll2Int:: Dice -> Int 
roll2Int [] = 0
roll2Int (One:xs) = 1 + roll2Int xs
roll2Int (Two:xs) = 2 + roll2Int xs
roll2Int (Three:xs) = 3 + roll2Int xs
roll2Int (Four:xs) = 4 + roll2Int xs
roll2Int (Five:xs) = 5 + roll2Int xs
roll2Int (Six:xs) = 6 + roll2Int xs


{-4)Consider the following type  -}

data MkType a b c = TypeA a (MkType a b c) | TypeB b (MkType a b c) | TypeC c (MkType a b c) | End 
 deriving Show 

{-4a) Define collect which transforms a MkType element to a tuple of lists. Hint: it may help to define a helper function which holds intermediate lists. (3 marks)-}

collect::MkType a b c -> ([a],[b],[c])
collect = undefined


{-5) Consider the following type MyList. -}

data MyList a = Elem a (MyList a) | Skip (MyList a) | Done 
    deriving Show 

{-5a) Define toList which maps a MyList type to a list type. You should assume that the Skip constructor means that the next element should not be moved to the new list. (4 marks)  -}

toList::MyList a -> [a] 
toList a = [] 


{-5b) Give a functor instance for the MyList type. Note that here you should leave the original structure of the MyList as you find it. (3 marks)  -}


{-6a) Using a foldl define myLength which returns the length of a list. (1 marks) -}

myLength::[a] -> Int 
myLength [] = 0
myLength xs = foldl (\length x -> length + 1)  0 xs 

{-6b) Define an IO function whichList which prompts the user to enter two strings, the function should then print a message to tell the user which of the two strings is longer. (4 marks)-}

whichList::IO()
whichList = do putStrLn "Enter first word:"
               word1 <- getLine
               putStrLn "Enter second word:"
               word2 <- getLine
               compareWords word1 word2

compareWords word1 word2 = do putStr "Comparing word length!"
                              putChar '\n'
                              if length word1 == length word2
                              then do putStr "Words are of equal length!"
                                      putChar '\n'
                              else if length word1 > length word2
                              then do putStr "Your first word is longer than your second!"
                                      putChar '\n'
                              else do putStr "Your second word is longer than your first!"
                                      putChar '\n'


{-7a) Maybe and Either can both be used to model failure. Define a combined type MayEither, this type should have 3 constructors - a version of left (MyLeft), right (MyRight) and nothing (MyNothing). (2 marks) -}



{-7b) Define a Monad instance for MayEither. You should use your MyRight constructor  for successful computations (3 marks)-}

