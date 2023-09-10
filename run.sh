#!/bin/bash

main_class="net.minecraft.client.main.Main"
game_args="--accessToken jhondoe --version 1.20.2"

java -cp $(find bin | tr '\n' ':')./client.jar $main_class $game_args
