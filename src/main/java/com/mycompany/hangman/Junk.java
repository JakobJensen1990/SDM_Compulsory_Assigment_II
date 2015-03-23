/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman;

/**
 *
 * @author Jacob
 */
public class Junk {
    
    
#!/bin/bash

words=(gulerod tennis tissemand stadion elefant)


function startGame(){
stillPlaying=true
attempts=0
remainingAttempts=7
echo ""
echo "Welcome to Hangman"
random=$((RANDOM%1-1))
answer="${words[$random]}"
size=${#answer}
}

function displayGuess(){
	echo "Your guess $1"
}

function createSecretWord(){
	for ((i=0;i<size;i++));do
		secret="${secret:0:$i}@${secret:$i+1}"
done
echo $secret
}

function testForWinner(){
	if [[ $1 == $answer ]] 
	then
	stillPlaying=false
	gameWon
	fi
	
	if [[ $attempts == 7 ]]
	then
	stillPlaying=false
	echo "You have used all available attempts"
	echo "please try again"
	newGame
	fi
}

function gameWon(){
echo "Congratulations!!"
echo "You guessed the word in $attempts "
newGame
}

function newGame(){
echo "Want to play a new game?"
echo "type 'y'"
read s
if [[ $s == "y" ]] 
	then
	echo ""
	theGame
	else
	echo ""
	echo "Thank you for playing"
	exit
fi
}

function testSecretWord(){
for ((i=0;i<size;i++));do
	testChar="${answer:$i:1}"
	if [[ $testChar == "$1" ]]
	then
	theWord="${secret:0:$i}$1${secret:$i+1}"
	secret=$theWord
	fi
done
usedLetters+=$1
echo "Used letters: $usedLetters"
attempts=$((attempts+1))
remainingAttempts=$((remainingAttempts-1))
testForWinner $secret
echo ""
echo "$remainingAttempts attempts left"
echo "$secret"
}

function theGame(){
startGame
createSecretWord
while $stillPlaying; do
    clear
    echo "Try to guess the word, you have $remainingAttempts attempts"
	echo "enter a letter"
	read -n 1 input
	echo ""
	testSecretWord $input
done
}
theGame

}
