cmake_minimum_required(VERSION 3.26)
project(QnA C)

set(CMAKE_C_STANDARD 17)

add_executable(QnA QnA.c
        questions.c)
