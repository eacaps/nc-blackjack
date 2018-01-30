#!/bin/bash

./gradlew jar
java -cp build/libs/nc-blackjack-1.0-SNAPSHOT.jar pub.eacaps.blackjack.Main
